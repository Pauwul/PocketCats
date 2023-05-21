#!/bin/bash
cd cat-classificator
python catdetector.py &
cd ..
cd frontend
npm run dev