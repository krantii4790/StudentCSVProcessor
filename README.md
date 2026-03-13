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
Backend will start at: http://localhost:8080
```

3️⃣ Run the Frontend (React)

```
Open a new terminal:
cd csv-frontend
npm install
npm run dev
Frontend will start at:http://localhost:5173
```
---

## ⚠️ API URL Configuration

**If run the project locally, update the API URL in:**

csv-frontend/src/components/UploadCSV.jsx

Change this:

```
const response = await axios.post(
"https://opulent-broccoli-pjvp99v6rvjvf7r5g-8080.app.github.dev/api/csv/upload",
formData,
{ responseType: "blob" }
);
```

to:

```
const response = await axios.post(
"http://localhost:8080/api/csv/upload",
formData,
{ responseType: "blob" }
);
```

**For GitHub Codespaces**

If running in GitHub Codespaces, use the Codespaces backend URL:

https://<codespace-name>-8080.app.github.dev/api/csv/upload

Also make sure port 5173 and 8080 are set to Public.
