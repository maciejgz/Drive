### Install and instructions
#### Installation
##### Kafka
1. Download kafka
2. Setup kafka home directory log.dirs in: <br>
    `\config\server.properties`
3. Run Zookeper integrated with kafka: <br>
    `.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`
4. Run Kafka: <br>
    `.\bin\windows\kafka-server-start.bat .\config\server.properties`
5. Create topic <br>
    `.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test`
6. Check if topic exists:
    `.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list`
7. test consumer and producers:<br>
    5.1 Connect to producer:<br>
    `.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test` <br>
    5.2 Connect to consumer: <br>
    `.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning`
8. Shutdown. In case of invalid server closure, some <br>
    8.1 Kafka<br>
    `.\bin\windows\kafka-server-stop.bat .\config\zookeeper.properties`
    8.2 Zookeper<br>
    `.\bin\windows\zookeeper-server-stop.bat`






