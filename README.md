# Yoyo Furniture Sales Management System (Java OOP)

## Overview

The Yoyo Furniture Sales Management System is a window-based desktop application developed in Java using Swing. The system simulates the workflow of managing sales orders, invoicing, reports, and user accounts for a furniture company.

The system is built using object-oriented programming principles including encapsulation, inheritance, polymorphism, and abstraction.

It supports multiple user roles with different access privileges:

- Administrator
- Officer
- Salesperson
- Customer (conceptual role)

---

## System Purpose

The system was designed to:

- Manage sale orders
- Generate invoices
- Produce reports (Work Done & Approved/Closed Sales)
- Handle employee and personal profile management
- Implement role-based authentication and authorization

This project was developed as part of an Object-Oriented Java Programming group assignment :contentReference[oaicite:1]{index=1}.

---

## Architecture

The system follows an object-oriented layered structure:

### Core Entities

- `SaleOrder`
- `Product`
- `Invoice`
- `Report`
- `Officer`
- `Administrator`
- `Customer`

Each entity encapsulates its attributes and exposes controlled access via getters, setters, and service methods.

---

## User Roles & Functionalities

### Administrator

- Manage personal profile
- Manage worker profiles (Officers & Salespersons)
- Generate:
  - Work Done Report
  - Approved/Closed Sale Report
- Access system-level information

---

### Officer

- Create sale orders
- Modify sale orders
- Remove sale orders
- Search sale orders
- Approve / Close sale orders
- Submit for production
- Check product status
- Generate reports

---

### Salesperson

- Manage personal profile
- Create sale quotations
- Modify quotations
- Remove quotations
- Search quotations
- View personal sales orders
- View approved and disapproved sales

---

## Authentication & Authorization

The system includes a login mechanism that:

- Validates user credentials using stored data
- Redirects users to role-specific dashboards
- Restricts access based on user type
- Allows secure logout functionality

User types are differentiated and granted access according to predefined permissions :contentReference[oaicite:2]{index=2}.

---

## Reports Implemented

1. **Work Done Report**
   - Displays all processed sales

2. **Approved / Closed Sale Report**
   - Displays only approved sales entries

Reports are displayed using JTable with enhanced UI features.

---

## Object-Oriented Concepts Applied

### Encapsulation
- Private fields
- Controlled access via getters/setters
- Profile management abstraction

### Inheritance
- GUI classes extend `JFrame`
- Custom panels extend `JPanel`

### Polymorphism
- Overridden rendering methods (e.g., table rendering)
- Role-based behavioral differences

### Abstraction
- GUI initialization methods hide implementation details
- Business logic separated from UI rendering

---

## Additional UI Features

- Gradient background panels
- Styled buttons
- Alternating row colors in tables
- Dialog box timers
- Centered frame positioning
- Custom background images

---

## Technology Stack

- Java
- Java Swing (GUI framework)
- File-based persistence (.txt storage)
- Object-Oriented Design principles

---

## Limitations

As stated in the assignment documentation :contentReference[oaicite:3]{index=3}:

- Simulation only (not production-ready)
- File-based storage (no database integration)
- Limited scalability
- Basic validation
- Designed for academic purposes

---

## How to Run

1. Import project into Eclipse or IntelliJ as an existing Java project.
2. Ensure required `.txt` data files are present in the project directory.
3. Run the main class (e.g., `MainAdminFrame` or Login class).
4. Log in using predefined credentials.

---

## Academic Context

Module: Object Oriented Java Programming  
Technology Park Malaysia  
Handout Date: 1 December 2023  
Submission Date: 23 February 2024 :contentReference[oaicite:4]{index=4}  

---

## Conclusion

The system demonstrates applied object-oriented design in a GUI-based sales management simulation. It models real-world business workflows including order processing, invoicing, reporting, and role-based system access within a modular Java Swing architecture.
