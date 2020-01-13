### Install and instructions
#### Installation
##### Kafka
1. Download kafka
2. Run Zookeper integrated with kafka: <br>
    `.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties`
3. Run Kafka: <br>
    `.\bin\windows\kafka-server-start.bat .\config\server.properties`
4. Create topic <br>
    `.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test`
5. Check if topis exists:
    `.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list`
5. test consumer and producers:<br>
    5.1 Connect to to producer:<br>
    `.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test` <br>
    5.2 Connect to consumer: <br>
    `.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning`






