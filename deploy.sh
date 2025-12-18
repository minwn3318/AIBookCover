#!/bin/bash
set -e

APP_DIR=/home/ec2-user/app
cd $APP_DIR

echo "=== deploy.sh started ==="
echo "Time: $(date)"

# 실행 가능한 jar 선택
JAR_FILE=$(ls *.jar | grep -v plain | head -n 1)

if [ -z "$JAR_FILE" ]; then
  echo "ERROR: executable jar not found"
  exit 1
fi

echo "Using jar: $JAR_FILE"

# 기존 서버 종료 (있다면)
PID=$(pgrep -f "$JAR_FILE" || true)

if [ -n "$PID" ]; then
  echo "Existing server found. PID=$PID"
  echo "Sending SIGTERM for graceful shutdown"
  kill -15 $PID

  echo "Waiting for process to terminate..."
  for i in {1..30}; do
    if ps -p $PID > /dev/null; then
      sleep 1
    else
      echo "Process terminated"
      break
    fi
  done

  # 아직 살아 있으면 강제 종료
  if ps -p $PID > /dev/null; then
    echo "Process still alive, force killing"
    kill -9 $PID
  fi
else
  echo "No existing server process"
fi

# 새 서버 기동
echo "Starting new server..."
nohup java -jar "$JAR_FILE" > app.log 2>&1 &

echo "Server restart completed"


