# maKneeTrack
Simple expense tracker.

# Project Documentation

## Overview

A lightweight, console‑based expense tracker written in Java. It uses SQLite for local data storage and provides a simple workflow: add, list, and delete expenses. Built to demonstrate clean separation between CLI, service logic, and database access.

## Features

* Add new expenses with date/time, category, and amount
* List all stored expenses in a formatted table
* Delete expenses by ID
* Local, file‑based SQLite storage (no external setup)

## Architecture

Three‑layer structure:

* **Main (CLI Layer):** User interaction, input validation, program flow
* **Services Layer:** Business logic and CRUD operations
* **Database Layer:** Connection handling, table creation, DB cleanup

Data flow:
**Console → Main → Services → SQLite → Services → Main → Console Output**

## Installation

Step-by-step instructions:

1. Prerequisites
2. Setup steps
3. Running the project

## Usage

After building the project with Maven, run:

```
java -cp target/expense-tracker.jar com.makneetrack.Main
```

Menu options displayed in the CLI:

1. Add expense
2. List all expenses
3. Delete expense
4. Exit


## Tech Stack

* Java (CLI + logic)
* Maven (build + dependency management)
* SQLite (file‑based database)
* JDBC (database interaction)


## Testing

Basic testing can be done by:

* Running through all menu options interactively
* Verifying entries in `expenses.db`
* Checking behavior with invalid inputs

## Roadmap

Future improvements or planned features.

* Planning to refactor this code for better improvements.
* Planning to add GUI using Java Swing.

## License

GPL 3

## Author

Aditya Chavan

* **Note: The code has two branches, Vanilla and main. (Vanilla contains project without use of Maven)

