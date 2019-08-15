
#### Somehow

-- I cannot send avro data to a topic
The following fails:

```bash
$ docker exec -i schema-registry /usr/bin/kafka-avro-console-producer --topic raw-movies --broker-list broker:9092 --property value.schema="$(< src/main/avro/input-movie-event.avsc)"
```

```
[2019-08-15 21:59:43,728] WARN [Producer clientId=console-producer] Connection to node 1 (localhost/127.0.0.1:9092) could not be established. Broker may not be available. (org.apache.kafka.clients.NetworkClient)
```

```bash
$ mvn generate-sources
```

error:  Missing required configuration "schema.registry.url" which has no default value.


Using kafkacat (https://github.com/edenhill/kafkacat)

```bash
$ kafkacat -b localhost:9092 -t raw-movies -p 0

```

Kafka UI: https://www.conduktor.io/


Delete a topic
```bash
$ docker exec -it broker /usr/bin/kafka-topics --delete --bootstrap-server localhost:9092 --topic movies
```

Older version, but good example using avro:
`https://docs.confluent.io/3.0.0/quickstart.html`


Kafka tutorial #4 - Avro and the Schema Registry

`https://aseigneurin.github.io/2018/08/02/kafka-tutorial-4-avro-and-schema-registry.html`
`kafka-console-consumer`
`kafka-avro-console-consumer`




# Reference
https://medium.com/@sunilvb/spring-boot-kafka-schema-registry-c6e32485a7c8
https://www.confluent.io/blog/avro-kafka-data/


```bash
docker exec -it schema-registry ip addr show eth0

11: eth0@if12: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default
    link/ether 02:42:ac:12:00:04 brd ff:ff:ff:ff:ff:ff
    inet 172.18.0.4/16 brd 172.18.255.255 scope global eth0
       valid_lft forever preferred_lft forever

docker exec -it broker ip addr show eth0

9: eth0@if10: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP group default
    link/ether 02:42:ac:12:00:03 brd ff:ff:ff:ff:ff:ff
    inet 172.18.0.3/16 brd 172.18.255.255 scope global eth0
       valid_lft forever preferred_lft forever
```