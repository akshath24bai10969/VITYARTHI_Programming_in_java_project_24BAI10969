# Problem Statement
- In high-pressure medical environments like Emergency Rooms (ER), the manual process of assessing patient severity (triage) and checking for available bed space is slow and prone to human error. Delays in identifying critical patients or mismanaging ward capacities can lead to life-threatening consequences. There is a clear need for an automated, real-time system that prioritizes patients based on medical urgency and manages specialized ward resources efficiently.

# Scope of the Project

- Patient Registration: Capturing unique patient identifiers and clinical severity levels.

- Automated Triage Logic: Implementing a priority-based routing system that separates critical cases (ICU) from non-critical cases (General Ward).

- Resource Management: Real-time tracking of available bed counts across different ward types.

- Data Persistence: Storing patient records and admission statuses in a local file-based database to ensure data is preserved across system restarts.

# Target Users
- ER Nurses & Triage Officers: For rapid registration and categorization of incoming patients.

- Hospital Administrators: To monitor real-time bed occupancy and ward efficiency.

- Medical Staff: To access patient status and admission details instantly.

# High-Level Features
- Dynamic Ward Capacity Monitoring: Provides a live view of available beds in specialized units (ICU vs. General).

- Severity-Based Auto-Admission: A decision-support module that routes patients to the correct facility based on a 1-5 severity scale.

- Patient Record Management: A module to search and retrieve existing patient details and admission logs.

- Persistent File Storage: Automatic backup of all system states to a local text file using Java File I/O.