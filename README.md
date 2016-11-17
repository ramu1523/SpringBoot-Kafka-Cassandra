# Spring-Boot-Cassandra

This Spring Boot Application is integrated to the Kafka and Cassandra.
a ) You can insert the data into the Cassandra by passing the json data to the API through post request.
b) You can filter/fetch/delete the data from Cassandra DB using Get/PUT/DELETE Requests.
c) You can pass the Json Messages to the API from Kafka Consumer. It process those messages and insert into the Cassandra DB.

Spring Boot Version: 1.4.2
JDK Version: 1.8
Cassandra/Datastax : 2.2.8
Kafka Version: latest version

Download the datastax instance(dsc-cassandra-2.2.8-bin.tar.gz) from the below repo.
https://downloads.datastax.com/community/

Download and install the Kafka from the below site
https://kafka.apache.org/quickstart

Prerequisites to start the application.
1. Install Datastax 
2. Start the cassandra instance
3. Start the cql instance and create the keyspace applepi.


4. Start the Zookeper Server.
5. Start the Kafka Server.
6. Start the Kafka Producer.
7. Create a topic with the name applepi

Instructions to start the spring boot app.
1. Download the code fromt git repo.
2. Build the code using the below command
./gradlew clean build

3. Run the code using the below command.
   Go to the build/libs folder
   Run the jar using as below.
   java -jar SpringBoot_RestAPI-0.0.1-SNAPSHOT.jar



