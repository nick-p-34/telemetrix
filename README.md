# Telemetrix

**Telemetrix** is a minimal demo application that combines **Spring Boot** and **Apache Kafka** to simulate real-time racing telemetry.  
It was built as a learning project and portfolio piece to demonstrate building a producer–consumer pipeline with Kafka, containerised for easy local development.

## Features
- REST endpoint to **publish telemetry events** (car speed, lap, RPM, driver info).
- Kafka **producer** sends events to the `telemetry` topic.
- Kafka **consumer** listens for telemetry events and keeps the most recent ones in memory.
- REST endpoint to **retrieve recent telemetry events**.
- **Docker Compose** setup for running Kafka locally in seconds.

---

## Example Use Case
Imagine you’re tracking live racing data:
1. A car crosses a checkpoint → telemetry event is generated.
2. This event is sent via REST to Telemetrix → published to Kafka.
3. A consumer processes the event and makes it available through an API endpoint.
4. Another system or UI could visualise these events in real-time.

---

## Tech Stack
- Java 17+
- Spring Boot 3.x
- Spring for Apache Kafka
- Docker & Docker Compose
- Maven

---

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/your-username/telemetrix.git
cd telemetrix
```

### 2. Start Kafka locally
```bash
docker compose up -d
```
This will start:
  ookeeper (Port `2181`)
  Kafka broker (Port `9092`)

### 3. Run the application
```bash
./mvnw spring-boot:run
```
This will start the app on http://localhost:8080

---

## API Endpoints

### Publish A Telemetry Event
```bash
curl -X POST http://localhost:8080/api/telemetry \
  -H "Content-Type: application/json" \
  -d '{
    "carId": "#22",
    "driver": "Jane Doe",
    "team": "Apex Racing",
    "lap": 3,
    "speed": 198.4,
    "rpm": 12700,
    "timestamp": "2025-08-09T10:12:00Z"
  }'
```
Response: `202 Accepted`

### Get Recent Telemetry Events
```bash
curl http://localhost:8080/api/telemetry/recent?limit=5
```
Returns JSON array of most recent events.
