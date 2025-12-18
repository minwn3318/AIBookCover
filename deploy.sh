#!/bin/bash
set -e

APP_DIR=/home/ec2-user/app
cd $APP_DIR

echo "=== deploy.sh started ==="
echo "PWD: $(pwd)"
echo "Files in app dir:"
ls -l

JAR_FILE=$(ls *.jar | grep -v plain | head -n 1)

if [ -z "$JAR_FILE" ]; then
  echo "ERROR: executable jar not found"
  exit 1
fi

echo "Using jar: $JAR_FILE"

PID=$(pgrep -f "$JAR_FILE" || true)
if [ -n "$PID" ]; then
  echo "Killing existing PID: $PID"
  kill -15 $PID
  sleep 5
fi

nohup java -jar "$JAR_FILE" > app.log 2>&1 &

echo "Application started"


