#!/usr/bin/env bash

# Create the base image for the docker
source scripts/build_docker.sh
buildDockerImage java-filebeat

# Build the individual application component docker-images (based of java-filebeat)

echo "============================"
echo "=== BUILDING APPLICATION ==="
echo "============================"
sbt docker:publishLocal