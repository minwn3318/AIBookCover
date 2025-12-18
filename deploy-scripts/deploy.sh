#!/bin/bash

APP_DIR=/home/ec2-user/app
JAR_FILE=$(ls $APP_DIR/*.jar | head -n 1)

# 기존 실행 중인 Spring Boot 프로세스 종료
PID=$(pgrep -f $JAR_FILE)
if [ -n "$PID" ]; then
  kill -15 $PID
  sleep 5
fi

# Spring Boot 서버 실행
nohup java -jar $JAR_FILE > app.log 2>&1 &
