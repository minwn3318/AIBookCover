#!/bin/bash

APP_DIR=/home/ec2-user/app

JAR_FILE=$(ls $APP_DIR/*.jar | grep -v plain | head -n 1)

if [ -z "$JAR_FILE" ]; then
  echo "No executable jar found"
  exit 1
fi

PID=$(pgrep -f "$JAR_FILE")
if [ -n "$PID" ]; then
  kill -15 $PID
  sleep 5
fi

nohup java -jar "$JAR_FILE" > app.log 2>&1 &

