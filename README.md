# Customer CRUD Application

## Overview
This project is a CRUD application for managing customers, built using Spring Boot for the backend and HTML/CSS/JS for the frontend. It includes JWT authentication and a sync feature to fetch and update customer data from a remote API.

## Features
- Create, update, read, and delete customers
- JWT authentication
- Pagination, sorting, and searching for customers
- Sync customer data from a remote API

## Setup Instructions

### Backend
1. Clone the repository.
2. Navigate to the backend directory.
3. Update the `application.properties` file with your MySQL database credentials.
4. Run the application using `./mvnw spring-boot:run`.

### Frontend
1. Serve the HTML files using a web server or open them directly in a browser.

## API Endpoints
- `POST /api/customers`: Create a new customer.
- `PUT /api/customers/{id}`: Update an existing customer.
- `GET /api/customers`: Get a list of customers with pagination.
- `GET /api/customers/{id}`: Get a single customer by ID.
- `DELETE /api/customers/{id}`: Delete a customer by ID.

## Authentication
- Obtain a JWT token by logging in with valid credentials.
- Use the token to authenticate subsequent API calls.

## Sync Feature
- Use the "Sync" button on the customer list screen to fetch and update customer data from the remote API.
- Created Login Page for User
- ![LoginPage](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/f0bdfca6-2c34-447d-8f6e-3e8df80e8ce6)
- Created Register Page for User
- ![RegisterPage](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/994772fd-4412-435b-9305-cd8dc5bacf5b)
- Then Made Cusstomer List Page to show details of all Customers
- ![CustomerList1](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/2307cf8a-cc94-4361-b0df-5225b160b8bc)
- ![CusstomerList2](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/0f247113-80b8-40ae-b55b-7e50975864c9)
- Added the Search Functionality to the Customer List Page by Fisrt Name ,City,Email,Phone
- ![Search](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/178ff8e9-5cf4-4ece-b54f-82634a63736a)
- Added the Sync Functionality
- ![Sync](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/c33c6495-6d8f-4640-8f28-19aa07cecfbf)
- ![Sync1](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/c7c347a0-106d-4585-b674-9f062262b8fb)
- ![Sync2](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/44234aae-39a4-42b7-a2a2-f89def273703)
- Added a Add a New Customer Page
- ![NewCustomer](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/0ce1b57d-3d35-4bfb-a603-c006b31f597a)
- ![NewCus](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/f67bd16e-c5ef-4a7a-80d8-e0726f0deb5f)
- Added a Edit Customer Page
- ![Edit](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/98f4429a-bbd7-49da-b614-7671ae6cc644)
- Added a Delete button to delete Customer Details from the Backend
- ![delete](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/9d203c3d-1e0b-469c-b19f-4886a8b53133)
- ![CustomerDelete](https://github.com/Ananya-Kaushal/Sunbase-Customer-Assignment/assets/62956565/5602fa77-ba1f-491f-8c2c-20f92587677f)













