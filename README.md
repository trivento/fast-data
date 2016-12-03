# Trivento Fast-Data

This is a small proof-of-concept project, showing off a use case for fast-data using Lightbend's Fast-Data stack.

# Goals

Enable bi-modal ICT by providing a platform that enables agile fast-data development, with minimal intrusion on existing ICT infrastructure.

# Use case

An energy meter service that performs the following functions:
- Order Handler: Accepts and prepares orders to acquire information (separately fetched later on via Fetch Handler) 
- Sampler: Dispatches orders to downstream systems (responses separetely acquired via Sample Collector)
- Sample Collector: Logs measurement data and prepares it for later retrieval
- Fetch Handler: Retrieves prepared data logs

# Running

- Unit tests: sbt test
- Integration tests: sbt it:test

## Background / study materials

Lightbend Fast-Data stack consists of a large variety of (recommended) technologies, that compose well into solutions fit to solve fast-data problems.
[Lightbend's own website ](https://www.lightbend.com/products/spark) provides a good high-level overview, but we recommend the following sources for more detailed/dense information about its components:

### Mesos

Paper: [Mesos: A Platform for Fine-Grained Resource Sharing in the Data Center](https://people.eecs.berkeley.edu/~alig/papers/mesos.pdf)

### Hadoop

Paper: [The Hadoop Distributed File System](http://pages.cs.wisc.edu/~akella/CS838/F15/838-CloudPapers/hdfs.pdf)
Paper: [MapReduce: Simplified Data Processing on Large Clusters](https://static.googleusercontent.com/media/research.google.com/en//archive/mapreduce-osdi04.pdf)
Paper: [Apache Hadoop YARN: Yet Another Resource Negotiator](https://www.sics.se/~amir/id2221/papers/2013%20-%20Apache%20Hadoop%20YARN%20-%20Yet%20Another%20Resource%20Negotiator%20(SoCC).pdf)

### Spark

Paper: [Resilient Distributed Datasets: A Fault-Tolerant Abstraction for In-Memory Cluster Computing](http://www-bcf.usc.edu/~minlanyu/teach/csci599-fall12/papers/nsdi_spark.pdf)
Paper: [Discretized Streams: An Efficient and Fault-Tolerant Model for Stream Processing on Large Clusters](https://people.csail.mit.edu/matei/papers/2013/sosp_spark_streaming.pdf)
Paper: [Spark SQL: Relational Data Processing in Spark](https://amplab.cs.berkeley.edu/wp-content/uploads/2015/03/SparkSQLSigmod2015.pdf)

### Cassandra

Paper: [Cassandra - A Decentralized Structured Storage System](https://www.cs.cornell.edu/projects/ladis2009/papers/lakshman-ladis2009.pdf)

### Kafka

Paper: [http://www.longyu23.com/doc/Kafka.pdf](http://www.longyu23.com/doc/Kafka.pdf)

### Zookeeper

Zookeeper is a highly available service with a file-system-like API. This is not directly mentioned as a component of Lightbend's stack. However Mesos and Cassandra use it for leader-election and Kafka uses it for tracking/coordination between peers, as well as maintaining consumer data.

Paper: [ZooKeeper: Wait-free coordination for Internet-scale systems](http://static.cs.brown.edu/courses/csci2270/archives/2012/papers/replication/hunt.pdf)

### Actor model

Paper: [Actors: A model Of Concurrent Computation In Distributed System](http://www.cypherpunks.to/erights/history/actors/AITR-844.pdf)

### Reactive Streams

Github: [Introduction and specification v. 1.0.0](https://github.com/reactive-streams/reactive-streams-jvm/blob/v1.0.0/README.md)

