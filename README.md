# StaffAvail

Real-Time Staff Availability and Occupancy Tracking System

StaffAvail is an IoT-powered staffroom monitoring and availability management system designed to provide real-time visibility into staff presence. The system combines RFID authentication, ESP32-based edge devices, a Java Vert.x backend, MongoDB storage, and smart visual indicators to create a seamless staff check-in/check-out experience.

The platform enables real-time occupancy tracking, availability monitoring, timestamped attendance events, and future dashboard integration for analytics and reporting.

## Features

* RFID-Based Staff Check-In / Check-Out
* Real-Time Staff Availability Tracking
* Live Occupancy Monitoring
* ESP32 WiFi Connectivity
* Java Vert.x Backend
* MongoDB Integration
* LCD Status Display
* WS2812 Smart Notification Ring
* NTP Time Synchronization
* REST API Communication
* Custom 3D Printable Enclosure
* Low-Cost IoT Deployment Architecture

## System Architecture

RFID Card
→ ESP32 + RC522 RFID Reader
→ WiFi Network
→ Vert.x Backend API
→ MongoDB Database
→ Availability Dashboard & Analytics

## Hardware Components

* ESP32 Development Board
* MFRC522 RFID Reader
* RFID Cards / Tags
* LCD1602 I2C Display
* WS2812 RGB LED Ring
* Active Buzzer
* Custom 3D Printed Enclosure

## Software Stack

### Firmware

* Arduino Framework
* ESP32
* WiFi
* HTTP Client
* MFRC522 Library
* Adafruit NeoPixel

### Backend

* Java
* Vert.x
* Maven
* MongoDB
* REST APIs



## Project Status

Current Version: v1.0

Developed as an IoT-based Smart Staff Availability and Occupancy Tracking Solution for academic environments.
