#  Real-Time Hospital Triage & Bed Management System

> **Course:** Programming in Java | **Student:** Akshath Sharma | **Roll Number:** 24BAI10969 

---

##  Project Overview

A real-time Java-based console application designed to solve the critical problem of **emergency room bottlenecks**. The system automates patient registration and dynamically allocates hospital beds across specific wards — **ICU vs. General** — based on a **1–5 medical severity scale**.

High-priority cases receive immediate attention while the system maintains a transparent, persistent record of all hospital resources.

---

##  Features

| Feature | Description |
|---|---|
|  **Automated Triage Routing** | Logic-based admission directing patients to ICU or General Ward depending on severity score |
|  **Real-Time Capacity Tracking** | Live updates of available beds in each ward as admissions occur |
|  **Data Persistence** | Built-in File I/O saves and loads patient records from `hospital_database.txt` |
|  **OOP Implementation** | Deep use of Abstraction, Inheritance, and Polymorphism throughout the codebase |

---

##  Technologies & Tools

- **Language:** Java (JDK 8 or higher)
- **Storage:** File-based persistence via Java `io` library
- **Design / Diagrams:** Mermaid.js for UML class & flow diagrams

---

##  Installation & Setup

### Prerequisites
- Java JDK 8 or higher installed
- `javac` and `java` available in your system PATH

### Steps

**1. Clone the Repository**
```bash
git clone https://github.com/akshath24bai10969/VITYARTHI_Programming_in_java_project_24BAI10969.git
```

**2. Navigate to the Project Directory**
```bash
cd VITYARTHI_Programming_in_java_project_24BAI10969
```

**3. Compile the Source Code**
```bash
javac *.java
```

**4. Run the Application**
```bash
java Main
```

---

##  Testing Instructions

Follow these test cases in sequence to verify full system functionality:

| Step | Menu Option | Action | Expected Result |
|---|---|---|---|
| 1 | `1` — View Capacity | Check initial ward counts | Pre-loaded ICU & General bed counts displayed |
| 2 | `2` — Register Patient | Enter ID: `P999`, Name: `TestUser`, Severity: `5` | Patient registered with critical severity |
| 3 | `3` — Process Admission | Enter ID: `P999` | Admission confirmed to **ICU Ward** |
| 4 | `5` — Exit, then restart | Select `4`, search for `P999` | Record persists from `hospital_database.txt` |

---

##  Project Structure

```
hospital-triage-system/
│
├── Main.java                  # Entry point & CLI menu
├── Patient.java               # Core Patient profile and record
├── Ward.java                  # Abstract base class for all wards
├── ICUWard.java               # Inherits Ward: ICU logic & pricing
├── GeneralWard.java           # Inherits Ward: General logic & pricing
├── HospitalDataStore.java     # File I/O database manager
├── TriageManager.java         # Controller handling admission routing
├── hospital_database.txt      # Runtime patient data store
└── README.md
```

---

##  OOP Concepts Applied

```
Ward (Abstract Base Class)
    ├── ICUWard           ← Tracks ICU bed availability and specialized cost
    └── GeneralWard       ← Tracks General bed availability and standard cost
```

- **Abstraction** — `Ward.java` defines the core framework and forces subclasses to implement `getDailyCost()`
- **Inheritance** — `ICUWard` and `GeneralWard` inherit from the base `Ward` class.
- **Encapsulation** — All patient records and ward capacities are kept strictly private and accessed via getters/setters.

---

##  License

This project was developed for academic purposes as part of the **Programming in Java** course at **VIT Bhopal**.

---