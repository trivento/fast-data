#!/bin/bash

# === IMPORTS ===
source scripts/host_ip.sh
source scripts/wait_port.sh

# === Script execution ===

# kill all previously running docker containers
echo "[DOCKER] Removing all containers"
docker rm -f $(docker ps -aq) 2> /dev/null

# Start all docker containers (as a subshell to pass HOST_IP)
echo "[DOCKER] Launching containers using HOST_IP=$HOST_IP"
docker-compose up -d

# Wait for all docker containers to launch
wait 9300 "Elastic HTTP"
wait 9200 "Elastic Cluster"
wait 5601 "Kibana"
wait 2181 "Zookeeper"
wait 9092 "Kafka"
wait 9042 "Cassandra"

# open http://localhost:5601/

 #docker-compose logs -f