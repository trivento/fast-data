#!/usr/bin/env bash

source scripts/build_docker.sh

# Build the base docker for functional logging
pushd docker
buildDockerImage cassandra
buildDockerImage elastic
buildDockerImage kafka
buildDockerImage kibana
buildDockerImage zookeeper
popd