#### Startup zookeeper,broker,schema-registry:

```bash
$ docker-compose up
```

#### Sending Avro data to a topic using kafka-avro-console-producer

-- I cannot send avro data to a topic
The following

```bash
$ docker exec -i schema-registry /usr/bin/kafka-avro-console-producer --broker-list broker:9092 --topic raw-movies --property value.schema="$(< src/main/avro/input-movie-event.avsc)"
```

fails when sending data with 

```
[2019-08-15 21:59:43,728] WARN [Producer clientId=console-producer] Connection to node 1 (localhost/127.0.0.1:9092) could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)
```

Running the kafka-avro-console-producer from zip it works:

```bash
$ kafka-avro-console-producer --broker-list localhost:9092 --topic raw-movies --property value.schema="$(<src/main/avro/input-movie-event.avsc)"
```

#### Generate Java objects from Avro 

```bash
$ mvn generate-sources
```

error:  Missing required configuration "schema.registry.url" which has no default value.


#### Using kafkacat (https://github.com/edenhill/kafkacat)

```bash
$ kafkacat -b localhost:9092 -t raw-movies -p 0

```

#### [Conduktor](https://www.conduktor.io/)

#### Delete a topic

```bash
$ docker exec -it broker /usr/bin/kafka-topics --delete --bootstrap-server localhost:9092 --topic raw-movies
```


#### Older version, but good example using avro:

https://docs.confluent.io/3.0.0/quickstart.html


#### Kafka tutorial #4 - Avro and the Schema Registry

`https://aseigneurin.github.io/2018/08/02/kafka-tutorial-4-avro-and-schema-registry.html`
`kafka-console-consumer`
`kafka-avro-console-consumer`


#### Reference
https://medium.com/@sunilvb/spring-boot-kafka-schema-registry-c6e32485a7c8
https://www.confluent.io/blog/avro-kafka-data/  
https://kafka-tutorials.confluent.io/transform-a-stream-of-events/kafka.html

#### Check the IPs

```bash
docker exec -it schema-registry ip addr show eth0
docker exec -it broker ip addr show eth0
docker exec -it zookeeper ip addr show eth0
```







### [kafkacat](https://github.com/edenhill/kafkacat)

#### Install:

```bash
brew install kafkacat
```

#### Consumer:

In consumer mode `kafkacat` reads messages from a topic and partition and prints them to stdout using the configured message delimiter.

```bash
$ kafkacat -C -b localhost:9092 -t test
```

#### Producer:

In producer mode `kafkacat` reads messages from stdin, delimited with a configurable delimiter (-D, defaults to newline), and produces them to the provided Kafka cluster (-b), topic (-t) and partition (-p).

```bash
$ kafkacat -P -b localhost:9092 -t test
```

#### List topics

```bash
$ kafkacat -b localhost:9092 -L
``` 
Access it in a browser:
```bash
http://localhost:9021/
```

```bash
$ echo "haliho" | http post :8080/messages
```

