# 🎓 Student Management System

A desktop-based **Student Management System** developed using **Java, JavaFX, MySQL, JDBC, and Maven**.

The system allows users to manage student information through a simple JavaFX graphical user interface.

## 🛠️ Technologies Used

* **Java 21**
* **JavaFX 21.0.6**
* **MySQL**
* **JDBC**
* **Maven**
* **Git & GitHub**
* **MVC-style architecture**

## ✨ Features

* 🔐 Admin Login
* ➕ Add Student
* 👥 View All Students
* ✏️ Update Student
* 🗑️ Delete Student
* 🔍 Check duplicate Student IDs
* ✅ Input validation
* 📧 Email validation
* 💾 Store student data in MySQL
* 🔄 Load student data from MySQL
* 🖥️ JavaFX graphical user interface

## 🏗️ Project Architecture

The project follows a simple separation of responsibilities:

```text
┌─────────────────────────────┐
│          JavaFX UI          │
│  Dashboard / Views / Login  │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│        DAO Layer            │
│        StudentDAO           │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│       Database Layer        │
│        DBConnection         │
└──────────────┬──────────────┘
               │ JDBC
               ▼
┌─────────────────────────────┐
│          MySQL              │
│     student_management      │
└─────────────────────────────┘
```

## 📁 Project Structure

```text
Student-Management-System/
│
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   │
│       │   └── com/pathum/sms/studentmanagementsystem/
│       │       ├── HelloApplication.java
│       │       ├── HelloController.java
│       │       ├── Launcher.java
│       │       │
│       │       ├── controller/
│       │       │   └── LoginController.java
│       │       │
│       │       ├── dao/
│       │       │   └── StudentDAO.java
│       │       │
│       │       ├── database/
│       │       │   ├── DBConnection.java
│       │       │   └── StudentDatabase.java
│       │       │
│       │       ├── model/
│       │       │   └── Student.java
│       │       │
│       │       └── view/
│       │           ├── AddStudentView.java
│       │           ├── Dashboard.java
│       │           ├── UpdateStudentView.java
│       │           └── ViewStudentsView.java
│       │
│       └── resources/
│           ├── com/pathum/sms/studentmanagementsystem/
│           │   └── hello-view.fxml
│           │
│           └── view/
│               └── login.fxml
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🗄️ Database

The application uses **MySQL**.

### Database

```text
student_management
```

### Main Table

```text
students
```

The student information includes:

| Field  | Description    |
| ------ | -------------- |
| ID     | Student ID     |
| Name   | Student name   |
| Age    | Student age    |
| Course | Student course |
| Email  | Student email  |

## 🔌 JDBC Connection

The application connects to MySQL using JDBC.

```text
JavaFX Application
       ↓
   StudentDAO
       ↓
   JDBC Connection
       ↓
      MySQL
```

`StudentDAO` handles database operations such as:

* `SELECT`
* `INSERT`
* `UPDATE`
* `DELETE`

## 🔐 Login

The application currently includes a simple admin login.

```text
Username: admin
Password: 1234
```

> ⚠️ These credentials are currently hard-coded for learning purposes. A production application should use secure authentication and store passwords safely.

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone <YOUR_REPOSITORY_URL>
```

### 2. Open the project

Open the project using **IntelliJ IDEA** or another Java IDE that supports Maven.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE student_management;
```

Create the `students` table:

```sql
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    course VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);
```

### 4. Configure database credentials

Update the database connection in:

```text
src/main/java/com/pathum/sms/studentmanagementsystem/database/DBConnection.java
```

Example:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/student_management";

private static final String USER = "root";

private static final String PASSWORD = "your_password";
```

### 5. Run the application

Using Maven:

```bash
mvn clean javafx:run
```

Or on Windows:

```cmd
mvnw.cmd clean javafx:run
```

## 📌 Application Flow

```text
Start Application
       ↓
     Login
       ↓
    Dashboard
       ↓
 ┌─────┴──────────────┐
 ↓                    ↓
Add Student       View Students
 ↓                    ↓
MySQL             Update / Delete
```

## 📚 What I Learned

This project helped me practice:

* Java programming
* Object-Oriented Programming
* JavaFX GUI development
* Event handling
* JavaFX TableView
* FXML basics
* MVC-style project organization
* JDBC
* MySQL database operations
* DAO pattern
* Maven
* Java modules
* Git and GitHub
* Input validation
* CRUD operations

## 🔄 CRUD Operations

The system supports the main database operations:

```text
C → Create → Add Student
R → Read   → View Students
U → Update → Update Student
D → Delete → Delete Student
```

## 👨‍💻 Author

**Pathum Nimesh Nimsara**

GitHub:
https://github.com/pathumnimsara

---

### ⭐ Project Status

**Learning Project / Academic Project**

Built to practice JavaFX, JDBC, MySQL, Maven, and software development fundamentals.

