public class Patient {
    private String patientId;
    private String name;
    private int severityLevel; 
    private Ward assignedWard;

    public Patient(String patientId, String name, int severityLevel) {
        this.patientId = patientId;
        this.name = name;
        this.severityLevel = severityLevel;
        this.assignedWard = null;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getSeverityLevel() { return severityLevel; }
    public Ward getAssignedWard() { return assignedWard; }

    public void assignWard(Ward ward) {
        this.assignedWard = ward;
    }

    public void printDetails() {
        System.out.println("\n--- Patient Record ---");
        System.out.println("ID: " + patientId + " | Name: " + name);
        System.out.println("Severity Level: " + severityLevel + "/5");
        if (assignedWard != null) {
            System.out.println("Status: Admitted to " + assignedWard.getWardName());
        } else {
            System.out.println("Status: Pending Admission");
        }
        System.out.println("----------------------");
    }
}