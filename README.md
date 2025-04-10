# Real-Time Notification System 🚀

A real-time notification system built using **Spring Boot**, **Apache Kafka**, **WebSocket**, and **Docker**.

This project demonstrates how to deliver real-time alerts across services with high reliability, minimal delay, and scalable design.

---

## ⚙️ Tech Stack

- **Spring Boot** (Web, Kafka, WebSocket)
- **Apache Kafka** (Messaging)
- **Zookeeper** (Kafka dependency)
- **Docker + Docker Compose**
- **Maven** (Build Tool)

---

## 📌 Features

- Event-driven architecture
- Real-time WebSocket updates
- Kafka producer-consumer model
- Fault-tolerance via retries
- Dockerized Kafka + Zookeeper setup
- Easily extendable for user preferences or persistence

---

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ShekharBajetha/notification-system.git
cd notification-system
```

### 2. Start Kafka and Zookeeper with Docker

```bash
docker compose up -d
```

This will start:
- **Kafka** (on `localhost:9092`)
- **Zookeeper** (on `localhost:2181`)

### 3. Run the Spring Boot application

```bash
mvn spring-boot:run
```

---

## 🧪 Test the System

### Send a notification:

```http
POST http://localhost:8080/api/notifications/send?userId=adam&message=Welcome+to+Kafka
```

### Open WebSocket client

Access `http://localhost:8080/index.html`

You'll receive real-time messages if the `userId` matches.

---

## 📂 Project Structure

```
📦 src/main/java/com/example/notification_system
 ┣ 📂 config
 ┣ 📂 controller
 ┣ 📂 model
 ┣ 📂 kafka
 ┣ 📂 websocket
 ┗ 📜 NotificationSystemApplication.java
```

---
✅ Recent Updates:
Added persistent storage of notifications in a relational database.

Each notification now includes a message field and is saved upon creation.

Notifications are still delivered in real-time via WebSockets.



## 🧼 Future Improvements

- User notification preferences
- Retry/Dead-letter topics for failed messages
- Frontend notification UI

---
