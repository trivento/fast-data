# Docker

Here we maintain scripts to build docker images for the basic components that constitute our solution.

- **Cassandra**: Our datastore, unmodified base image
- **Elastic**: Our index engine, used to index logs. Base image + Curator installation
- **Filebeat**: Java+Filebeat base image for all our components, enabling the push of logback logs to Elastic
- **Kafka**: Distributed message log, unmodified base image (includes Zookeeper, which needs to be factored out for production)
- **Kibana**: Elastic front-end, unmodified base image