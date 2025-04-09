# Selenium-Cucumber-Java
This repository contains a sample project(selenium-dev) . The projects showcase automation script development and utilize various reporters such as Allure, HTML, and Extent Report. 
Additionally, it offers the ability to capture screenshots for tests and generate error shots for failed test cases.

Note: Framewrok is developed to handle below features
	-  Run in chrome/edge browser either locally or remote (Sauce labs / selenium grid) . This feature is handled in config properries file under 'Config' folder
  -  Separate Selenium Utilities is created to handle all selenium methods
  -  Page Object Manager is used as a page repo which is used to handle all pages that are created in the application
  -  Driver Manager is used as an abstract class to implement the chrome and Edge driver managers
  -  Log file is added to the framework so that we can view the console to know the status of the test

![image](https://github.com/user-attachments/assets/5ffa5321-6dc0-4d1d-9423-67586121bdb5)


# Installation & Prerequisites
- JDK 1.8+ (Ensure that the Java class path is properly set)
- Maven (Ensure that the .m2 class path is properly set)
- Eclipse IDE
## Required Eclipse Plugins:
- Maven
- Cucumber
- Allure windows to run/generate to allure report
- Browser driver (Ensure that you have the appropriate browser driver for your desired browser and that the class path is correctly configured)

# Framework Setup
To set up the framework, you can either fork or clone the repository , or download the ZIP file and set it up in your local workspace

# Run the Project
- Clone the project and download all maven dependencies 
- Right click on project and select run as 'Maven Test'
![image](https://github.com/user-attachments/assets/22af317a-b9c1-4735-93df-ec85e9175b3f)


# Reporters
Once you have run your tests, you can generate 2 types of reports. 
Extent-Report - This report will be availabe under test-output/SparkReport/Spark.html
Allure Report - This report will be availabe under target folder 

Note: To run allure report - Download Allure for windows and unzip it and add bin to environment variable .Use the command "allure serve "<<path of allure-results>>"

# Reporting

Allure Report 

![image](https://github.com/user-attachments/assets/01fddd8e-c627-4bce-9418-2d05a90b7882)


Extent Report

![image](https://github.com/user-attachments/assets/ea495fb9-eb8e-4fd3-a432-6027aa7d5ddd)

![image](https://github.com/user-attachments/assets/ef8f54db-6104-490f-ba30-244106030e8b)


