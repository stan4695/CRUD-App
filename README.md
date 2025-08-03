# CRUD-App

## Overview

This project is a JavaFX-based application that performs CRUD (Create, Read, Update, Delete) operations on a MySQL database. The app manages a database with a Many-to-Many (M:N) relationship between two main tables: `abonati` (subscribers) and `companii_telefonie` (telecommunication companies), connected through an intermediate table `abonamente` (subscriptions).

<p align="center">
  <img src="https://github.com/user-attachments/assets/d2278ea7-4fa8-44f8-bc63-d108c9714532" alt="gui-1" />
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/410c389a-d1b4-4b20-8055-de2981dae1c6" alt="gui-2" />
</p>

## Features

- **View Data**: Displays records from the database tables.
- **Add Records**: Allows users to add new subscribers, companies, and subscriptions.
- **Update Records**: Enables modification of existing records.
- **Delete Records**: Supports deletion of records from any table.
- **MySQL Integration**: Utilizes MySQL as the database management system.
- **JavaFX Interface**: Provides an intuitive and interactive GUI for database management.

## Technologies Used

- **JavaFX**: For creating the graphical user interface.
- **MySQL**: As the relational database management system.
- **FXML**: For defining the layout of the application views.
- **Scene Builder**: For visually designing the UI.

## Database Structure

![erd](https://github.com/user-attachments/assets/69259108-1fad-4891-b84f-7fa7f3079d58)


The database contains three main tables:

- **abonati (subscribers)**:
  - `idAbonat` (Primary Key)
  - `nume` (Name)
  - `prenume` (Surname)
  - `cnp` (Personal ID)
  - `adresa` (Address)

- **companie_telefonie (telecommunication companies)**:
  - `idCompanieTelefonie` (Primary Key)
  - `nume` (Company Name)
  - `adresaSediu` (Headquarter Address)
  - `telefonContact` (Contact Phone)
  - `emailContact` (Contact Email)

- **abonamente (subscriptions)**:
  - `idAbonament` (Primary Key)
  - `idAbonat` (Foreign Key referencing `abonati`)
  - `idCompanieTelefonie` (Foreign Key referencing `companie_telefonie`)

## Project Structure

- `DBOperations.java`: Handles all database-related operations (CRUD) and manages the connection with MySQL.
- `ProiectController.java`: Controls the behavior of the UI components and interacts with the database operations.
- `Abonat.java`, `CompanieTelefonie.java`, `Abonamente.java`: Represent the data models for the corresponding database tables, implementing getter and setter methods.
- `FXML Files`: Define the structure of the application's UI for adding, updating, and displaying data.

## How to Run the Project

1. **Database Setup**:
   - Ensure you have MySQL installed.
   - Create the necessary database schema using the provided SQL scripts.
   - Update the connection details (database URL, user, password) in `DBOperations.java`.

2. **Java Setup**:
   - Install JDK 8 or later.
   - Use a suitable IDE (e.g., IntelliJ IDEA, Eclipse) that supports JavaFX.

3. **Run the Application**:
   - Execute the `ProiectController.java` class to launch the JavaFX application.
   - Use the application interface to manage database records.

## Conclusion

This project demonstrates the integration of JavaFX with a MySQL database to perform standard CRUD operations. It also showcases how a Many-to-Many relationship can be implemented and managed in a database with the help of a linking table.
