#!/bin/bash

# MySQL 서비스 시작
service mysql start

# MySQL root 암호 설정
mysql -u root -e "ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';"

# MySQL 초기화 (옵션)
mysql -u root < /init.sql

# Spring Boot 애플리케이션 시작
java -jar /spring-base.jar
