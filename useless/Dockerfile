FROM ubuntu:latest

# MySQL 설치
#RUN echo "mysql-server mysql-server/root_password password root" | debconf-set-selections
#RUN echo "mysql-server mysql-server/root_password_again password root" | debconf-set-selections
RUN apt-get update && apt-get install -y mysql-server

# Java 설치
RUN apt install -y openjdk-17-jdk

# JAR 파일 복사
COPY build/libs/*.jar /spring-base.jar

# MySQL 초기 설정 스크립트 (옵션)
COPY init.sql /init.sql

# 스크립트 실행 (MySQL 및 Spring Boot)
COPY start.sh /start.sh
RUN chmod +x /start.sh

CMD ["/start.sh"]
