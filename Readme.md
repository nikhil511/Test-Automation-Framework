
#  Java-Based Test Automation Framework

## Overview

This is a Java-based test automation framework designed to facilitate efficient and scalable testing.

## Author

- I am Nikhil Narkedamilli with 10 years of experience in Automation testing.

## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](linkedin.com/in/nikhil-narkedamilli-41b82458/)


## Features
- **Java 11**: Core programming language.
- **TestNG**: Testing framework for running tests.
- **Data-Driven Testing**: Utilizes OpenCSV, Gson, and Apache POI for handling test data.
- **Fake Data Creation**: Uses the Faker library to generate mock data.
- **Cloud Testing**: Integrates with LambdaTest for running tests on the cloud.
- **Headless Mode**: Supports headless browser testing.
- **Reporting**: Generates detailed reports using Extent Reports.
- **Logging**: Logs test execution details using Log4j.
- **CI/CD Integration**: Integrated with GitHub Actions for continuous integration and deployment.

## Prerequisites
- Java 11
- Maven
- Git

## Installation

1. **Clone the Repository**
   ```sh
   git clone https://github.com/nikhil511/Test-Automation-Framework
   cd Test-Automation-Framework

2. **Install Dependencies**
    ```sh 
   mvn clean install
    
## Running Tests

**Command Line Interface (CLI)**
You can run the tests from the CLI using Maven Surefire Plugin. The following parameters can be passed:

Browser: Specify the browser to run tests (e.g., chrome, firefox).
isLambda: Set to true to run tests on LambdaTest.
isHeadless: Set to true to run tests in headless mode.

Example command:
mvn test -Dbrowser=chrome -DisLambda=true -DisHeadless=true


## Reports and Logs
Reports: Generated in reports/reports.html

Logs: Stored in logs/.
