## Student CSV Processor

A full-stack web application that processes student mark records from a CSV file.
---

## Features

Upload CSV file

Dynamic subject handling

Total and percentage calculation

Sorting by highest percentage

Download processed CSV

---

## Tech Stack

Frontend: React, Axios, CSS

Backend: Spring Boot, Apache Commons CSV

Build Tool: Maven

Runtime: Java 17+

---

## Project Structure

```
StudentCSVProcessor
│
├── csv-frontend     # React frontend
└── csv-processor    # Spring Boot backend

```
---

## How to Run the Project

1️⃣ Clone the Repository

git clone https://github.com/krantii4790/StudentCSVProcessor.git

cd StudentCSVProcessor

2️⃣ Run the Backend (Spring Boot)
```
cd csv-processor
./mvnw spring-boot:run
Backend will start at:
http://localhost:8080
```

3️⃣ Run the Frontend (React)
```
Open a new terminal:
cd csv-frontend
npm install
npm run dev
Frontend will start at:
http://localhost:5173
```
