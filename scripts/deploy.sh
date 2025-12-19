#!/bin/bash
set -e

APP_DIR=/home/ubuntu/app
mkdir -p "$APP_DIR"

pkill -f 'java -jar' || true

JAR=$(ls -1 $APP_DIR/*.jar | head -n 1)
nohup java -jar "$JAR" > $APP_DIR/app.log 2>&1 &
