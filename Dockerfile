# Frontend build stage
FROM node:latest AS frontend-build

WORKDIR /workspace/app/frontend

COPY frontend/package*.json ./

RUN yarn install

COPY frontend/ .

RUN yarn build

## 빌드
# 베이스 이미지 설정
FROM amazoncorretto:17 AS backend-build

# 작업 디렉터리 설정
WORKDIR /workspace/app

# 소스 코드 복사
COPY . .

# Gradle wrapper 실행 권한 설정 (Linux/Unix 환경에서 필요할 수 있음)
RUN chmod +x ./gradlew

# Spring Boot 빌드 (Kotlin)
RUN ./gradlew clean bootJar

### Mysql Server
## 베이스 이미지 설정
#FROM mysql:latest
#
## 라벨링
#LABEL authors="boki"
#
## SQL 초기화 파일 복사
#ADD ./script/init.sql /docker-entrypoint-initdb.d
#
## 포트 노출 ==> docker-compose.yaml로 대체 가능
#EXPOSE 3306
#
## MySQL 서버 실행
#CMD ["mysqld"]

FROM nginx:alpine as production-stage

WORKDIR /workspace/app/frontend

COPY --from=frontend-build /workspace/app/frontend/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]

# 런타임 이미지 준비
FROM amazoncorretto:17

# 라벨링
LABEL authors="boki"

# 작업 디렉터리 설정
WORKDIR /app

# 빌드 이미지로부터 JAR 파일 복사
COPY --from=backend-build /workspace/app/build/libs/spring-docker.jar app.jar
RUN chmod +x app.jar

# 빌드 이미지로부터 wait-for-it.sh 파일 복사
COPY backend/script/wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh

# 포트 노출 ==> docker-compose.yaml로 대체 가능
#EXPOSE 8080

# 애플리케이션 실행
#ENTRYPOINT ["java","-jar","/app/app.jar"]