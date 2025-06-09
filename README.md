# Microservices Setup

This repository contains a set of microservices including Admission, Doctor, Patient, and Province Name services. The services are managed by Eureka for service discovery and routed through a Gateway server.

## Prerequisites

- Docker (for containerizing the services, if applicable)
- Java (for running Spring Boot applications or any required framework)
- Maven (if the project is built using Maven)
- Docker Compose (optional, for easier multi-container setup)
- JDK 11+ (or required version depending on your project)
- A terminal/command prompt for executing commands

## Microservices Overview

1. **Admission Service**  
   Runs on port: `8081`
   
2. **Doctor Service**  
   Runs on port: `8082`
   
3. **Patients Service**  
   Runs on port: `8083`
   
4. **Province Names Service**  
   Runs on port: `8084`

5. **Eureka Server**  
   This is a service registry and should be started first.  
   Runs on port: `8761` (default Eureka port)

6. **Gateway Server**  
   A central entry point for all microservices.  
   Runs on port: `8080`

---

## Getting Started

Follow these steps to get the microservices up and running on your local machine:

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repository.git
cd your-repository
