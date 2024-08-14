# Book Search Application

## Overview

This project demonstrates the use of **Data Access Objects (DAO)** in conjunction with **JDBC** to interact with a relational database. The application provides a **Graphical User Interface (GUI)** that allows users to search and view books based on various criteria such as author, publisher, or category.

## Features

- **Search Functionality**: Users can search for books by selecting an author, publisher, or category from a dropdown menu.
- **Dynamic Dropdown**: The GUI features a dropdown box that dynamically populates with a list of authors, allowing users to filter books authored by a selected individual.
- **Interactive GUI**: The results of the search are displayed directly within the GUI, providing an intuitive and user-friendly experience.
- **Database Integration**: The application connects to a database using the tables defined in the `henry.sql` file.

## Database

The project utilizes the following database tables provided in the `henry.sql` file:

- **Authors**: Contains information about the authors of the books.
- **Publishers**: Stores details about the publishers.
- **Categories**: Holds the different categories under which books are classified.
- **Books**: Lists the available books, including details like title, author, publisher, and category.

## Technologies Used

- **Java**: Core language for the application logic.
- **JDBC**: For database connectivity and operations.
- **DAO Pattern**: To abstract and encapsulate all access to the data source.
- **Swing**: For building the GUI.
- **SQL**: For database creation and manipulation (via `henry.sql`).

## Setup Instructions

1. **Database Setup**: Import the `henry.sql` file into your database management system.
2. **Project Configuration**: Ensure your database connection settings (e.g., URL, username, password) are correctly configured in the application's properties or source code.
3. **Run the Application**: Compile and run the application to launch the GUI.

## Usage

- Select an author from the dropdown to view all books authored by them.
- Search for books based on publisher or category using the respective search fields.
- The results will be displayed directly in the GUI.
