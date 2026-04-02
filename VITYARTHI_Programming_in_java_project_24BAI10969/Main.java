import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalDataStore db = new HospitalDataStore(); 
        TriageManager manager = new TriageManager(db);
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println(" Central Hospital Triage & Bed Manager   ");
        System.out.println("=========================================");

        while (true) {
            System.out.println("\n1. View Ward Capacity");
            System.out.println("2. Register New Patient");
            System.out.println("3. Process Triage/Admission");
            System.out.println("4. View Patient Record");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        manager.viewWardStatus();
                        break;
                    case "2":
                        System.out.print("Enter Patient ID (e.g., P1002): ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Severity (1-Low to 5-Critical): ");
                        int severity = Integer.parseInt(scanner.nextLine());
                        manager.registerPatient(id, name, severity);
                        break;
                    case "3":
                        System.out.print("Enter Patient ID to Admit: ");
                        String admitId = scanner.nextLine();
                        manager.processAdmission(admitId);
                        break;
                    case "4":
                        System.out.print("Enter Patient ID: ");
                        String searchId = scanner.nextLine();
                        manager.viewPatient(searchId);
                        break;
                    case "5":
                        System.out.println("Shutting down terminal. Goodbye.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("-> Invalid selection.");
                }
            } catch (Exception e) {
                System.out.println("-> Invalid Input. Please try again.");
            }
        }
    }
}