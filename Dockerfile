## 빌드
# 베이스 이미지 설정
FROM amazoncorretto:17 AS build

# 작업 디렉터리 설정
WORKDIR /workspace/app

# 소스 코드 복사
COPY . .

# Gradle wrapper 실행 권한 설정 (Linux/Unix 환경에서 필요할 수 있음)
RUN chmod +x ./gradlew

# Spring Boot 빌드 (Kotlin)
RUN ./gradlew clean bootJar

## 실행
LABEL authors="boki"

# 런타임 이미지 준비
FROM amazoncorretto:17

# 라벨링
LABEL authors="boki"

# 작업 디렉터리 설정
WORKDIR /app

# 빌드 이미지로부터 JAR 파일 복사
COPY --from=build /workspace/app/build/libs/spring-docker.jar app.jar

# 포트 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java","-jar","/app/app.jar"]