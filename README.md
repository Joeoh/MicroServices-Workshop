# E-commerce Workshop

Welcome to the Workshop! This workshop aims to guide you through the process of building a microservices-based e-commerce system using Java, Spring Boot, Kafka, and Docker. By the end of this workshop, you will have a basic understanding of microservices architecture and hands-on experience in building and integrating multiple services.

## System Overview

The e-commerce system consists of the following microservices:

- **Product Service**: Manages product information, including CRUD operations for products.

- **Order Service**: Handles order creation and processing

- **Email Service**: Handles mock sending of emails


## Setup Instructions

Follow the steps below to set up the e-commerce system on your local machine:


### Prerequisites

Make sure you have the following prerequisites installed on your system:

1. Java Development Kit (JDK) 11 or later:
   - Download and install the JDK from the Oracle website or adopt OpenJDK.
   - Set up the `JAVA_HOME` environment variable to point to the JDK installation directory.

2. Apache Maven:
   - Download and install Maven from the Apache Maven website.
   - Add Maven to your system's PATH environment variable.

3. Docker:
   - Install Docker Desktop based on your operating system:
     - For Windows: [Docker Desktop for Windows](https://www.docker.com/products/docker-desktop)
     - For macOS: [Docker Desktop for Mac](https://www.docker.com/products/docker-desktop)
     - For Linux: Follow the appropriate instructions for your Linux distribution.

4. IntelliJ IDEA:
   - Download and install IntelliJ IDEA Community Edition from the [JetBrains website](https://www.jetbrains.com/idea/).
   - Follow the installation wizard instructions to complete the setup.

### Steps

Follow the steps below to set up the e-commerce system on your local machine:

1. Clone the repository:

   ```
   git clone https://github.com/Joeoh/MicroServices-Workshop.git
   ```
   ```
   cd MicroServices-Workshop
   ```

2. Set up the Kafka environment:

   `cd kafka`
   `docker-compose up -d`

3. Import the projects into IntelliJ IDEA:

   - Open IntelliJ IDEA and choose "Open" or "Import" from the welcome screen.
   - Navigate to the root directory of each microservice project (`product-service`, `order-service`, etc.) and select the respective `pom.xml` file.
   - Follow the prompts to import the projects and let IntelliJ IDEA download the necessary dependencies.

4. Build the microservices:

   - Open the Maven Projects tool window in IntelliJ IDEA.
   - Expand each microservice project and navigate to "Lifecycle" -> "install".
   - Click the "Execute Maven Goal" button to build each project.

5. Start the services from within Intellij:

   - Open the Application class for the service (`EmailServiceApplication`,`OrderServiceApplication`, `ServiceRegistrationService`)
   - Right click on the main method and run




6. Access the services:

   - Each microservice can be accessed using the following URLs:
     - Product Service: `http://localhost:2222`
     - Order Service: `http://localhost:2223`
     - Email Service: `http://localhost:2224`

   - Use a tool like cURL or Postman to interact with the services' REST APIs.


7. Accessing the services:

Here we're going to use cURL to access the services via the command line. You can also use tools such as Postman


### Product Service

- Create a new product:
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"name":"Product Name", "price": 10.99}' http://localhost:2222/products
  ```

- Get a product by ID:
  ```bash
  curl http://localhost:2222/products/{product-id}
  ```

- Update a product:
  ```bash
  curl -X PUT -H "Content-Type: application/json" -d '{"name":"Updated Product Name", "price": 19.99}' http://localhost:2222/products/{product-id}
  ```

- Delete a product:
  ```bash
  curl -X DELETE http://localhost:2222/products/{product-id}
  ```

### Order Service

- Create a new order:
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"orderId": "order-123", "customerId": 456, "productId": 1, "quantity": 2}' http://localhost:2223/orders
  ```

- Get an order by ID:
  ```bash
  curl http://localhost:2223/orders/{order-id}
  ```

- Update an order:
  ```bash
  curl -X PUT -H "Content-Type: application/json" -d '{"quantity": 3}' http://localhost:2223/orders/{order-id}
  ```

- Delete an order:
  ```bash
  curl -X DELETE http://localhost:2223/orders/{order-id}
  ```


Please replace `{product-id}`, `{order-id}`, and any other placeholders with the actual IDs or values you want to use in the commands.