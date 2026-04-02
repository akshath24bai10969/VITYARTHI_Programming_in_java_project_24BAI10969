import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HospitalDataStore {
    private Map<String, Ward> wards = new HashMap<>();
    private Map<String, Patient> patients = new HashMap<>();
    private final String FILE_NAME = "hospital_database.txt"; 

    public HospitalDataStore() {
        wards.put("W-GEN1", new GeneralWard("W-GEN1", "General Observation", 10));
        wards.put("W-ICU1", new ICUWard("W-ICU1", "Trauma ICU", 2, true));
        loadPatientsFromFile(); 
    }

    public Map<String, Ward> getWards() { return wards; }
    public Patient getPatient(String id) { return patients.get(id.toUpperCase()); }
    
    public void addPatient(Patient p) {
        patients.put(p.getPatientId().toUpperCase(), p);
        savePatientsToFile(); 
    }

    public void savePatientsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Patient p : patients.values()) {
                String wardId = (p.getAssignedWard() != null) ? p.getAssignedWard().getWardId() : "NONE";
                writer.println(p.getPatientId() + "," + p.getName() + "," + p.getSeverityLevel() + "," + wardId);
            }
        } catch (IOException e) {
            System.out.println("-> File Save Error: " + e.getMessage());
        }
    }

    private void loadPatientsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    Patient p = new Patient(data[0], data[1], Integer.parseInt(data[2]));
                    if (data.length == 4 && !data[3].equals("NONE")) {
                        Ward w = wards.get(data[3]);
                        if (w != null) {
                            p.assignWard(w);
                            w.allocateBed(); 
                        }
                    }
                    patients.put(p.getPatientId(), p);
                }
            }
        } catch (IOException e) {
            System.out.println("-> File Load Error: " + e.getMessage());
        }
    }
}