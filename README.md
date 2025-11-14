### Project Title: FunFit – Fitness Batch & Participant Management System

## 📝 Project Overview
FunFit is a web-based Fitness Management System developed using Java Servlets, JSP, JSTL, and MySQL.
The application helps manage fitness class batches and participant details in an organized and user-friendly way.
The system follows the MVC architecture, ensuring clean separation of concerns and scalable code structure.
It is deployed on Apache Tomcat 10 and uses JDBC for database operations.

## 🎯 Objectives
•	To develop a dynamic web application using Java EE (Jakarta Servlets & JSP)
•	To perform CRUD operations on Batches and Participants
•	To integrate MySQL database using JDBC
•	To use JSTL for clean data rendering in JSP pages
•	To design a maintainable structure using DAO pattern and MVC

## 🚀 Key Features
## Batch Management
•	Add new fitness batches
•	View all batches
•	Edit existing batch details
•	Delete batches
## Participant Management
•	Register participants
•	View participant list
•	Edit participant details
•	Delete participants
## System Features
•	Form validation
•	JDBC-based database connectivity
•	Clean and reusable JSP pages
•	Centralized DB connection using DBUtil.java
•	Easy navigation between modules

### 🏗️ Technology Stack
Frontend
•	JSP
•	HTML
•	JSTL (Jakarta Taglibs)
Backend
•	Java Servlets (Jakarta EE)
•	MVC Architecture
•	DAO Pattern for database operations
Database
•	MySQL
•	JDBC connectivity
Server
•	Apache Tomcat 10

### 🧪 How to Run the Project
1.	Install Tomcat 10
2.	Install MySQL and create database funfit_db
3.	Import project into Eclipse/IntelliJ
4.	Add required JARs to WEB-INF/lib:
      o	MySQL Connector/J
      o	JSTL (Jakarta EE version)
5.	Configure database in DBUtil.java
6.	Start Tomcat server
7.	Run application at:
    http://localhost:8080/FunFit

