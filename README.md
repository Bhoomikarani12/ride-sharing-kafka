# ride-sharing-kafka
**RideSharingKafka** is a project that uses Apache Kafka to simulate real-time location updates for drivers in a ride-sharing application. The project leverages Docker for running Kafka services and IntelliJ IDEA for development.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Kafka Setup](#kafka-setup)



## Introduction
RideSharingKafka demonstrates the use of **Apache Kafka** for processing and streaming driver location updates in a ride-sharing application. This project serves as an educational tool for learning Kafka integration and message-based architectures.

## Features
- Real-time driver location updates using Kafka topics.
- Dockerized Kafka setup for easy deployment.
- Multiple partitions and replication for scalable message distribution.

## Tech Stack
- **Apache Kafka**: A distributed streaming platform.
- **Docker**: For containerized deployment of Kafka services.
- **Java**: Core application logic.
- **IntelliJ IDEA**: IDE for Java development.

 
 ## Kafka Setup
### Step 1: Start Kafka with Docker
To start the Kafka service using Docker, you need to use the following command:
docker-compose up -d

### Step 2: Create Kafka Topics
Once Kafka is running, create the required topics for the ride-sharing app:
docker exec -it <kafka-container-id> kafka-topics --create --topic driver-locations --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1

Contributing
We welcome contributions to improve the project! Please feel free to submit issues or pull requests.





