# Enterprise Microservices System (Spring Boot)

A scalable, resilient microservices architecture built with **Spring Boot** and **Gradle** that manages Employee and Department entities, supports secure inter-service communication, implements fault tolerance via **Resilience4j**, and integrates **Razorpay** for payment processing.

---

## Architecture & Key Features

* **Microservices Architecture:** Independent services for `Employee-Service`, `Department-Service`, and `Payment-Service`, orchestrated via an API Gateway and Service Discovery (Eureka/Consul).
* **Inter-Microservice Communication:** Synchronous REST communication implemented using **Spring Cloud OpenFeign** / **WebClient**.
* **Security & Authentication:** Role-Based Access Control (RBAC) and stateless authentication powered by **Spring Security** and **JWT (JSON Web Tokens)**.
* **Fault Tolerance (Circuit Breaker):** Resilient inter-service calls protected against cascading failures using **Resilience4j** (Circuit Breaker, Retry, and Fallback mechanisms).
* **Payment Gateway Integration:** Seamless order creation, payment verification, and webhook handling integrated with the **Razorpay Java SDK**.

---

## Tech Stack

* **Language:** Java 17 / 21
* **Framework:** Spring Boot 3.x, Spring Cloud
* **Build Tool:** Gradle (Gradle Wrapper included)
* **Security:** Spring Security, JJWT
* **Resilience:** Resilience4j (`org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j`)
* **Communication:** Spring Cloud OpenFeign / WebClient
* **Database:** MySQL / PostgreSQL (Spring Data JPA / Hibernate)
* **Payment Gateway:** Razorpay Java SDK (`com.razorpay:razorpay-java`)

---

## Microservices Overview

| Service Name | Port | Description |
| :--- | :--- | :--- |
| **API Gateway** | `8080` | Routes external requests, handles JWT validation, and enforces rate limiting. |
| **Service Registry** | `8761` | Netflix Eureka server for dynamic service discovery. |
| **Employee Service** | `8081` | Manages employee CRUD operations and fetches department details via Feign. |
| **Department Service** | `8082` | Manages department data and organizational hierarchies. |
| **Payment Service** | `8083` | Handles Razorpay order creation, signature verification, and transaction logs. |

---

## Prerequisites

Before running the project, ensure you have the following installed:
* JDK 17 or higher
* Gradle 8.x+ *(optional, as the `./gradlew` wrapper is included)*
* MySQL / PostgreSQL server
* A **Razorpay Developer Account** (for `KEY_ID` and `KEY_SECRET`)

---

## Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com
cd your-repo-name
```

### 2. Configure Environment Variables
Update the `application.yml` or `application.properties` in each respective service (or your centralized Config Server) with your database, JWT, and Razorpay credentials:

```yaml
# Database Configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/employee_db
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:password}

# JWT Security Configuration
jwt:
  secret: ${JWT_SECRET:your-256-bit-secret-key-here}
  expiration: 86400000

# Razorpay Configuration (Payment Service)
razorpay:
  key-id: ${RAZORPAY_KEY_ID:rzp_test_xxxxxxxxxxxx}
  key-secret: ${RAZORPAY_KEY_SECRET:xxxxxxxxxxxxxxxxxxxxxxxx}
```

### 3. Build the Project
Build all microservices (or individual modules) using the Gradle Wrapper:

```bash
# Build all services and skip tests (Linux/macOS)
./gradlew clean build -x test

# Windows
gradlew.bat clean build -x test
```

### 4. Run Services
Start the services in the following order:
1. `service-registry`
2. `api-gateway`
3. `department-service`
4. `employee-service`
5. `payment-service`

```bash
# Run an individual service using Gradle Wrapper
./gradlew :employee-service:bootRun

# Or navigate into a service directory and run
cd employee-service
./gradlew bootRun
```

---

## Resilience4j Configuration Example

The `Employee-Service` uses Resilience4j to prevent failures if the `Department-Service` becomes unresponsive:

```yaml
resilience4j:
  circuitbreaker:
    instances:
      departmentService:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        waitDurationInOpenState: 10s
        failureRateThreshold: 50
```

---

## Core API Endpoints

### Authentication (`/api/auth`)
* `POST /api/auth/register` – Register a new user
* `POST /api/auth/login` – Authenticate and receive a JWT token

### Employee & Department (`/api/employees`, `/api/departments`)
* `POST /api/departments` – Create a new department *(Requires `ADMIN` role)*
* `GET /api/departments/{id}` – Retrieve department details
* `POST /api/employees` – Create a new employee
* `GET /api/employees/{id}` – Fetch employee along with mapped department info *(Circuit Breaker enabled)*

### Payments (`/api/payments`)
* `POST /api/payments/create-order` – Generate a Razorpay Order ID
* `POST /api/payments/verify` – Verify Razorpay payment signature post-checkout

---

## Contributing

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
