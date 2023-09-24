# <h1 align="center">Job Search Portal </h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
  </a>
  <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
  </a>
   <img alt = "GPL v3" src="https://img.shields.io/badge/License-GPLv3-blue.svg" />
</p>

---

<p align="left">

## Overview

The Job Search Portal is a web application that provides a platform for users to browse and interact with job listings. Users can perform various operations such as adding job listings, updating job details, deleting job listings, and searching for jobs based on different criteria. This project is built using the Spring Boot framework and uses the H2 database to store and retrieve job-related data.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

## Project Structure


The project is structured into the following main components:

### Controller: 
The controller package (com.projectRaj.JobSearchPortal.controller) contains classes responsible for handling incoming HTTP requests and directing them to the appropriate service methods.

### Model: 
The model package (com.projectRaj.JobSearchPortal.model) defines the data model for the project. The central entity is the Job class, which represents a job listing. It includes fields such as title, description, location, salary, and more.

### Service: 
The service package (com.projectRaj.JobSearchPortal.service) contains the business logic of the application. It includes methods for adding, retrieving, updating, and deleting job listings. Additionally, custom finder and query methods are implemented to search for jobs based on various criteria.

### Repository: 
The repository package (com.projectRaj.JobSearchPortal.repo) contains the Spring Data JPA repositories that interface with the H2 database. These repositories provide CRUD (Create, Read, Update, Delete) operations for job listings.

### Database: 
The project uses the H2 database, an in-memory database, to store job data. The schema and tables are managed using Spring Data JPA. While H2 is used for development and testing, you can configure the application to use a different database for production.

## Data Flow
The data flow in the Job Search Portal project can be summarized as follows:

### HTTP Requests:
Users interact with the application by sending HTTP requests to the server. These requests are handled by the controllers.

### Controller: 
The controller classes receive incoming requests and extract relevant data from the request parameters and request bodies. They perform validation using annotations like @Valid and route the requests to the appropriate service methods.

### Service: 
The service classes contain the core business logic of the application. They perform actions such as adding, retrieving, updating, or deleting job listings based on the request. Service methods interact with the repositories to perform CRUD operations and custom queries.

### Repository: 
The repositories are responsible for communicating with the H2 database. They use Spring Data JPA to execute database operations such as saving, querying, updating, and deleting job listings. The H2 database stores job-related information, including job titles, descriptions, salaries, and more.

### H2 Database: 
The H2 database is an in-memory database that stores job listings in structured tables. The schema and tables are created and managed by Spring Data JPA. While H2 is used for development and testing, you can configure the application to use a different database for production.

### HTTP Responses: 
After processing the requests, the controllers return HTTP responses to the client, which may include JSON data or status codes. Clients can retrieve job details or confirmation messages based on the type of request.

# Usage
To use the Job Search Portal, follow these steps:

1. **Run the Application:** Deploy the Spring Boot application on a web server or run it locally.

2. **Database Configuration:** The application is configured to use the H2 database by default. You can customize the database settings in the application.properties or application.yml file. For production use, consider switching to a different database like MySQL or PostgreSQL.

3. **API Endpoints:
**Response:**** Access the application's API endpoints using tools like Postman or by integrating them into your frontend application.

4. **Perform CRUD Operations:** Use the API endpoints to perform CRUD operations on job listings. You can add new jobs, retrieve job details, update job information, and delete job listings.

5. **Search for Jobs:** Utilize the custom finder and query methods to search for jobs based on job type, salary, title, and other criteria.

6. **Explore Documentation:** Consider generating API documentation using tools like Swagger to provide clear documentation for your API endpoints and their usage.

## Service Methods in JobService
**1. addJobs(List<Job> jobs)**

-  **Description:** This method is responsible for adding multiple job listings to the database.
-  **Parameters:**
   1. jobs: A list of Job objects representing the job listings to be added.
-  **Logic:** It utilizes the jobRepository to save all the job listings in the provided list to the database.
-  **Return Value:** A string message indicating the number of jobs added to the repository.

**2. getJob(Long jobId)**

-  **Description:** This method retrieves a specific job listing by its ID.
-  **Parameters:**
    1. jobId: The unique identifier of the job listing to be retrieved.
-  **Logic:** It uses the jobRepository to find a job listing by its ID. If found, it returns the job; otherwise, it returns an error message.
-  **Return Value:** Either the retrieved job or an error message indicating that the job with the given ID was not found.

**3. updateJob(Long jobId, Job newJobData)**

-  **Description:** This method updates the details of a specific job listing.
-  **Parameters:**
   1. jobId: The unique identifier of the job listing to be updated.
   2. newJobData: An updated Job object containing the new job details.
-  **Logic:** It first checks if a job with the specified ID exists in the database using the jobRepository. If the job is found, it updates the job data with the new data provided and saves it to the database.
-  **Return Value:** A message indicating that the job data has been updated, or an error message if the job with the given ID was not found.


**4. deleteJob(Long jobId)**

-  **Description:** This method deletes a specific job listing by its ID.
-  **Parameters:**
   1. jobId: The unique identifier of the job listing to be deleted.
-  **Logic:** It attempts to find the job with the specified ID in the database using the jobRepository. If the job is found, it is deleted from the database.
-  **Return Value:** A message indicating that the job data has been deleted, or an error message if the job with the given ID was not found.


**5. getAllJobsByType(Type jobType)**

-  **Description:** This method retrieves all job listings of a specific job type.
-  **Parameters:**
   1. jobType: The type of job listings to be retrieved (e.g., Full-Time, Part-Time).
-  **Logic:** It uses the jobRepository to find and return a list of job listings that match the specified job type.
-  **Return Value:** A list of job listings of the specified job type.

**6. getAllJobsByJobTypeAndSalaryGreaterThan(Type jobType, Double salary)**

-  **Description:** This method retrieves job listings of a specific job type with a salary greater than or equal to the specified amount.
-  **Parameters:**
   1. jobType: The type of job listings to be retrieved.
   2. salary: The minimum salary threshold for job listings.
-  **Logic:** It uses the jobRepository to find and return a list of job listings that match both the job type and the salary criteria.
-  **Return Value:** A list of job listings that meet the specified job type and salary criteria.

**7. getByTitleAndSalary(String jobTitle, Double salary)**

-  **Description:** This method retrieves job listings with a specific title and a salary greater than or equal to the specified amount.
-  **Parameters:**
   1. jobTitle: The job title to be searched for.  
   2. salary: The minimum salary threshold for job listings.
-  **Logic:** It uses the jobRepository to find and return a list of job listings that match both the title and salary criteria.
-  **Return Value:** A list of job listings that meet the specified title and salary criteria.

**8. getAllCompanyNamesAppliedBeforeDate(String date)**

-  **Description:** This method retrieves the names of companies for which job applications were submitted before the specified date.
-  **Parameters:**
   1. date: The date in "yyyy-MM-dd" format, used as the cutoff for application submission.
-  **Logic:** It retrieves a list of job listings with application dates earlier than the provided date, extracts the company names, and returns them as a list.
-  **Return Value:** A list of company names that had applications submitted before the specified date.

**9. updateSalaryByJobType(Type type, Float incPercentage)**

-  **Description:** This method updates the salaries of job listings of a specific job type by applying a percentage increase.
-  **Parameters:**
   1. type: The type of job listings to be updated.  
   2. incPercentage: The percentage increase to apply to the salaries.
-  **Logic:** It uses the jobRepository to update the salaries of job listings with the specified job type by the provided percentage increase.
-  **Return Value:** A message indicating that salaries have been updated for the specified job type.


**10. deleteByJobId(Long jobId)**

-  **Description:** This method deletes a specific job listing by its ID.
-  **Parameters:**
   1. jobId: The unique identifier of the job listing to be deleted.
-  **Logic:** It attempts to find the job with the specified ID in the database using the jobRepository. If the job is found, it is deleted from the database.
-  **Return Value:** A message indicating that the job data has been deleted, or an error message if the job with the given ID was not found.

**11. getByTitleOrDescription(String jobTitle, String description)**

-  **Description:** This method retrieves job listings with a specific title strings and a description content from the request params.
-  **Parameters:**
   1. jobTitle: The job title to be searched for.  
   2. description: Some contents for job listings.
-  **Logic:** It uses the jobRepository to find and return a list of job listings that match both the title or description criteria.
-  **Return Value:** A list of job listings that meet the specified title or description criteria.


These service methods provide the core functionality for managing job listings within the Job Search Portal application. They interact with the repository and database to perform the necessary operations based on user requests and search criteria.


## Controller Methods in JobController
In the Job Search Portal project, the controllers define several API endpoints that allow clients to interact with the application. Here's an explanation of each API endpoint defined in the JobController class:

### Add Jobs

**Endpoint:**

```
POST http://localhost:8080http://localhost:8080/api/jobs
```
**Description:**
This endpoint allows clients to add multiple job listings to the database.
Request Body: A JSON array containing job listings (List<Job>).


**Response:**
A message indicating the number of jobs added to the repository.

### Get Job by ID

**Endpoint:**

``` 
GET http://localhost:8080/api/job/id/{jobId}
```
**Description:**
- Clients can retrieve a specific job listing by providing its unique ID.
- Path Variable: jobId (Long) - The unique identifier of the job listing.


**Response:**
Either the retrieved job as JSON or an error message if the job with the given ID was not found.

### Update Job by ID

**Endpoint:**
```
 PUT http://localhost:8080/api/job/id/{jobId}
```
**Description:**
- This endpoint allows clients to update the details of a specific job listing by providing its unique ID.
- Path Variable: jobId (Long) - The unique identifier of the job listing to be updated.
- Request Body: A JSON object representing the updated job details (Job).

**Response:**
A message indicating that the job data has been updated, or an error message if the job with the given ID was not found.

### Delete Job by ID

**Endpoint:**
``` 
DELETE http://localhost:8080/api/job/id/{jobId}
```
**Description:**
- Clients can delete a specific job listing by providing its unique ID.
- Path Variable: jobId (Long) - The unique identifier of the job listing to be deleted.

**Response:**
A message indicating that the job data has been deleted, or an error message if the job with the given ID was not found.

### Get Jobs by Type

**Endpoint:**
```
 GET http://localhost:8080/api/custumFinder/jobsByType/{jobType}
```
**Description:**
- Clients can retrieve all job listings of a specific job type.
- Path Variable: jobType (Enum Type) - The type of job listings to be retrieved (e.g., Full-Time, Part-Time).

**Response:**
A JSON array containing job listings of the specified type.

### Get Jobs by Type and Salary

**Endpoint:**
``` 
GET http://localhost:8080/api/custumFinder/type/jobsBySalary/{salary}
```
**Description:**
- Clients can retrieve job listings of a specific job type with a salary greater than or equal to the specified amount.
- Path Variable: salary (Double) - The minimum salary threshold for job listings.
- Request Parameter: jobType (Enum Type) - The type of job listings to be retrieved.

**Response:**
A JSON array containing job listings that meet the specified job type and salary criteria.


### Get Jobs by Title and Salary

**Endpoint:**
``` 
GET http://localhost:8080/api/custumFinder/jobsByTitle/{jobTitle}/salary/{salary}
```
**Description:**
- Clients can retrieve job listings with a specific title and a salary greater than or equal to the specified amount.
- Path Variables:
  1. jobTitle (String) - The job title to be searched for.
  2. salary (Double) - The minimum salary threshold for job listings.

**Response:**
A JSON array containing job listings that meet the specified title and salary criteria.

### Get Company Names Applied Before Date

**Endpoint:**
``` 
GET http://localhost:8080/api/custumFinder/companyByAppliedDate/{date}
```
**Description:**
-  can retrieve the names of companies for which job applications were submitted before the specified date.
- Path Variable: date (String) - The date in "yyyy-MM-dd" format, used as the cutoff for application submission.

**Response:**
A JSON array containing the names of companies that had applications submitted before the specified date.

### Update Salary by Job Type

**Endpoint:**
```
PUT http://localhost:8080/api/custumQuery/job/type/hike/{incPercentage}
```
**Description:**
This endpoint allows clients to update the salaries of job listings of a specific job type by applying a percentage increase.
- Request Parameter: type (Enum Type) - The type of job listings to be updated.
- Path Variable: incPercentage (Float) - The percentage increase to apply to the salaries.

**Response:**
A message indicating that salaries have been updated for the specified job type.

### Delete Job by ID

**Endpoint:**
``` 
DELETE /api/custumQuery/job/id/{jobId}
```
**Description:**
- Clients can delete a specific job listing by providing its unique ID using a custom query.
- Path Variable: jobId (Long) - The unique identifier of the job listing to be deleted.

**Response:**
A message indicating that the job data has been deleted, or an error message if the job with the given ID was not found.

### Get Jobs by title or Description

**Endpoint:**
``` 
GET http://localhost:8080api/custumQuery/job/title/description
```
**Description:**
- Clients can retrieve job listings of a specific job title with jobs contains the title or descriptions.
- Request Parameter: jobTitle (Strings) - The type of job listings .
- Request Parameter: description (Strings) - The type of job listings to be retrieved.

**Response:**
A JSON array containing job listings that meet the specified job title or description criteria.

These API endpoints define the functionality and operations that clients can perform when interacting with the Job Search Portal application. Clients can use these endpoints to add, retrieve, update, and delete job listings, as well as perform custom searches and updates based on various criteria.


## Sample data
```
[
  {
    "id": 1,
    "title": "Software Developer",
    "description": "Developing software applications",
    "location": "New York",
    "salary": 75000.0,
    "companyEmail": "dev@example.com",
    "companyName": "TechCo",
    "employerName": "John Doe",
    "jobType": "IT",
    "appliedDate": "2023-09-24"
  },
  {
    "id": 2,
    "title": "HR Specialist",
    "description": "Managing HR operations",
    "location": "Los Angeles",
    "salary": 60000.0,
    "companyEmail": "hr@example.com",
    "companyName": "HR Solutions",
    "employerName": "Jane Smith",
    "jobType": "HR",
    "appliedDate": "2023-09-23"
  },
  {
    "id": 3,
    "title": "Sales Representative",
    "description": "Selling products and services",
    "location": "Chicago",
    "salary": 55000.0,
    "companyEmail": "sales@example.com",
    "companyName": "SalesTech",
    "employerName": "Mike Johnson",
    "jobType": "SALES",
    "appliedDate": "2023-09-22"
  }
]
```
## Database

The Job Search Portal project uses the H2 database, an in-memory database, to store and manage job-related data during development and testing phases. H2 provides a lightweight and efficient database solution suitable for development purposes. However, it's important to note that for production use, you may want to configure the application to use a different relational database like MySQL, PostgreSQL, or others.

### Configuration

To configure the database settings, you can edit the `application.properties` or `application.yml` file in the project's resources directory. You can customize properties such as the database URL, username, and password according to your requirements. Here's an example configuration for H2:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=your-username
spring.datasource.password=your-password
```
#### Swagger Configuration
```
http://localhost:8080/swagger-ui/index.html#/
```
## Contact Information

If you have any questions, issues, or need further assistance related to the Job Search Portal project, feel free to contact us. We are here to help!

- **Raj Anand**
  - Email: rajanandxxxx@example.com
  - LinkedIn: [Raj Anand's LinkedIn Profile]()
  - GitHub: [Raj Anand's GitHub Profile]()


Please don't hesitate to reach out if you have any inquiries or need assistance with any aspect of the project. Your feedback and questions are important to us.




