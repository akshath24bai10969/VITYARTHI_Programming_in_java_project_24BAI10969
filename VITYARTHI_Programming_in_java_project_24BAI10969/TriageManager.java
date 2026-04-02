public class TriageManager {
    private HospitalDataStore db;

    public TriageManager(HospitalDataStore db) {
        this.db = db;
    }

    public void viewWardStatus() {
        System.out.println("\n=== Real-Time Ward Capacity ===");
        for (Ward ward : db.getWards().values()) {
            System.out.println(ward.toString());
        }
    }

    public void registerPatient(String id, String name, int severity) {
        if (db.getPatient(id) != null) {
            System.out.println("-> Error: Patient ID already exists.");
            return;
        }
        Patient newPatient = new Patient(id, name, severity);
        db.addPatient(newPatient);
        System.out.println("-> Patient " + name + " registered successfully.");
    }

    public void processAdmission(String patientId) {
        Patient patient = db.getPatient(patientId);
        if (patient == null) {
            System.out.println("-> Error: Patient not found.");
            return;
        }
        if (patient.getAssignedWard() != null) {
            System.out.println("-> Patient is already admitted to: " + patient.getAssignedWard().getWardName());
            return;
        }

        Ward targetWard = null;
        if (patient.getSeverityLevel() >= 4) {
            targetWard = db.getWards().get("W-ICU1");
        } else {
            targetWard = db.getWards().get("W-GEN1");
        }

        if (targetWard.allocateBed()) {
            patient.assignWard(targetWard);
            db.savePatientsToFile(); 
            System.out.println("-> URGENT: Patient " + patient.getName() + " admitted to " + targetWard.getWardName());
        } else {
            System.out.println("-> CRITICAL ALERT: No beds available in " + targetWard.getWardName() + " for Patient " + patient.getName());
        }
    }

    public void viewPatient(String patientId) {
        Patient p = db.getPatient(patientId);
        if (p != null) p.printDetails();
        else System.out.println("-> Error: Patient not found.");
    }
}