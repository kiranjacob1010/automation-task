# README #

This README would explain the necessary to run the automation test cases.

### What is this repository for? ###

* This is an automation testing framework for a website https://www.studydrive.net/. It is implemented based on Page Object Model. 
* It starts from Home Page , then Search Page and continuous...

### Prerequisites ###

* Java 8
* Maven
* Google Chrome as web browser(right now only compatible with Google Chrome)

### How to run ###

* Run the below command from the project root directory  
#### mvn clean test ####
* OR
* Run the below command from the project root directory for running test and generating html report
#### mvn surefire-report:report ####
* We can see the report in the location : /target/site/surefire-report.html

### TestCases covered in Automation ###

* verify search tab
* enter the keyword("mathematics") in search box and search using the icon
* verify the results(Documents, Courses, Flashcards)
* Verify the extra filters( Verify the available exams for that testing keyword("mathematics"))