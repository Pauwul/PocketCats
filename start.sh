#!/bin/bash
docker compose up &
cd cat-classificator
python catdetector.py &
cd ..
cd frontend
npm run dev &
cd ..
cd backend
./mvnw spring-boot:run

