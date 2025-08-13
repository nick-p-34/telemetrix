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
- Java 17
- Spring Boot 3.5.4
- Spring for Apache Kafka
- Docker & Docker Compose
- Maven

---

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/nick-p-34/telemetrix.git
cd telemetrix
```

### 2. Start Kafka locally
```bash
docker compose up -d
```
This will start:

  Zookeeper (Port `2181`)
  
  Kafka broker (Port `9092`)

### 3. Run the application
```bash
mvn spring-boot:run
```
This will start the app on http://localhost:8080

---

## API Endpoints

### Publish A Telemetry Event
In a new terminal window, create an event and add some data. The following values can be edited to create your own telemetry event.
```bash
$json = '{"carId":"#34", \
          "driver":"Nick Parke", \
          "team":"Zenith Racing", \
          "lap":3, \
          "speed":198.4,\ 
          "rpm":12700, \
          "timestamp":"2025-08-09T10:12:00Z", \
          "gate":5, \
          "split_time":6.5, \
          "gear":6, \
          "throttle":1, \
          "brake":0, \
          "steering_deg":-5.75, \
          "fuel_l":98.674, \
          "tyre_wear":0.0395, \
          "race_time":233.35, \
          "position_m":992.042}'
```
Single-line version for convenience
```bash
$json = '{"carId":"#34","driver":"Nick Parke","team":"Zenith Racing","lap":3,"speed":198.4,"rpm":12700,"timestamp":"2025-08-09T10:12:00Z","gate":5,"split_time":6.5,"gear":6,"throttle":1,"brake":0,"steering_deg":-5.75,"fuel_l":98.674,"tyre_wear":0.0395,"race_time":233.35,"position_m":992.042}'
```

Then, POST the event

```bash
Invoke-RestMethod -Uri 'http://localhost:8080/api/telemetry' -Method Post -Body $json -ContentType 'application/json'
```

Response: `202 Accepted`

### Get Recent Telemetry Events
```bash
 Invoke-RestMethod -Uri 'http://localhost:8080/api/telemetry/recent?limit=5'
```
Returns JSON array of most recent events, 5 in this case.

The events can also be viewed at http://localhost:8080/api/telemetry/recent

---

## Finishing Up

### 1. Terminate the application
```bash
Ctrl + C
```
This will stop the Spring Boot application on http://localhost:8080

### 2. Terminate Kafka and Zookeeper
```bash
docker compose down -v
```
This terminates the Kafka (Port `9092`) and Zookeeper (Port `2181`) instances
