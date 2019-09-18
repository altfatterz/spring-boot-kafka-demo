Startup:

```bash
$ docker-compose up
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








older:

Make sure at least 8GB memory is allocated to Docker Engine.

```bash
$ cd cp-docker-images/examples/cp-all-in-one
$ docker-compose up
Starting zookeeper ... done
Starting broker    ... done
Starting schema-registry ... done
Starting rest-proxy      ... done
Starting connect         ... done
Starting ksql-server     ... done
Starting control-center  ... done
Starting ksql-datagen    ... done
Starting ksql-cli        ... done
Attaching to zookeeper, broker, schema-registry, connect, rest-proxy, ksql-server, ksql-datagen, ksql-cli, control-center
```

Access it in a browser:
```bash
http://localhost:9021/
```

```bash
$ echo "haliho" | http post :8080/messages
```

