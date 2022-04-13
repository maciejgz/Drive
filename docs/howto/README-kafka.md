### Install and instructions

#### Installation

##### Kafka

1. Download kafka
2. Setup kafka home directory log.dirs in: <br>
    <pre><code>\config\server.properties</code></pre>
3. Run Zookeper integrated with kafka: <br>
    <pre><code>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties</code></pre>
4. Run Kafka: <br>
    <pre><code>.\bin\windows\kafka-server-start.bat .\config\server.properties</code></pre>
5. Create topic <br>
    <pre><code>.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test</code></pre>
6. Check if topic exists:
   <pre><code>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list</code></pre>
7. test consumer and producers:<br>
   5.1 Connect to producer:<br>
   <pre><code>.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test</code></pre> <br>
   5.2 Connect to consumer: <br>
   <pre><code>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning</code></pre>
8. Shutdown. In case of invalid server closure, some <br>
   8.1 Kafka<br>
   <pre><code>.\bin\windows\kafka-server-stop.bat .\config\zookeeper.properties</code></pre>
   8.2 Zookeper<br>
   <pre><code>.\bin\windows\zookeeper-server-stop.bat</code></pre>






