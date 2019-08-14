
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

