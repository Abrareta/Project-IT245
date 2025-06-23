import java.util.*;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Stack;
import java.util.HashMap;
	class Patient {
	    int id;
	    String name;
	    int age;
	    String contact;
	    LinkedList<String> medicalHistory;
	    Patient next;

	    public Patient(int id, String name, int age, String contact) {
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.contact = contact;
	        this.medicalHistory = new LinkedList<>();
	        this.next = null;
	    }
	}

	class PatientRecords {
	    public Patient head;
	    public void addPatient(Patient newPatient) {
	        if (head == null) {
	            head = newPatient;
	        } else {
	            Patient current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newPatient;
	        }
	    }


	    public void addPatient(int id, String name, int age, String contact) {
	        Patient newPatient = new Patient(id, name, age, contact);
	        if (head == null) {
	            head = newPatient;
	        } else {
	            Patient current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newPatient;
	        }
	        
	    }

	    public void displayPatients() {
	        Patient current = head;
	        while (current != null) {
	   System.out.println("ID: "+ current.id +", Name: "+
	        current.name +", Age: "+ current.age +", Contact: "+ current.contact);
	            current = current.next;
	        }
	    }

	    public void removePatient(int id) {
	        if (head == null) return;
	        if (head.id == id) {
	            head = head.next;
	            return;
	        }
	        Patient current = head;
	        while (current.next != null && current.next.id != id) {
	            current = current.next;
	        }
	        if (current.next != null) {
	            current.next = current.next.next;
	        }
	    }

	    public void updatePatient(int id, String name, int age, String contact) {
	        Patient current = head;
	        while (current != null) {
	            if (current.id == id) {
	                current.name = name;
	                current.age = age;
	                current.contact = contact;
	                return;
	            }
	            current = current.next;
	        }
	    }
	}


class EmergencyPatient {
  String name;
  int priority; // 1 = High, 2 = Medium, 3 = Low

  public EmergencyPatient(String name, int priority) {
	    this.name = name;
	    this.priority = priority;
	    }
	}

class EmergencyQueue {
   PriorityQueue<EmergencyPatient> queue;

 public EmergencyQueue() {
  queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.priority));
	    }

 public void addPatient(String name, int priority) {
    EmergencyPatient patient = new EmergencyPatient(name, priority);
    queue.offer(patient);
	    }

 public void treatPatient() {
	    if (!queue.isEmpty()) {
	    EmergencyPatient patient = queue.poll();
	    System.out.println("Treating: " + patient.name + " (Priority: " + patient.priority + ")");
	      } else {
	         System.out.println("No patients in queue.");
	        }
	    }

  public void displayQueue() {
	    for (EmergencyPatient p : queue) {
	         System.out.println(p.name + " - Priority: " + p.priority);
	        }
	    }
	}
	
	class TreatmentHistory {
	    private Stack<String> treatments;

	    public TreatmentHistory() {
	        treatments = new Stack<>();
	    }

	    public void addTreatment(String treatment) {
	        treatments.push(treatment);
	    }

	    public void viewLastTreatment() {
	        if (!treatments.isEmpty()) {
	            System.out.println("Last Treatment: " + treatments.peek());
	        } else {
	            System.out.println("No treatment history available.");
	        }
	    }

	    public void displayAllTreatments() {
	        if (treatments.isEmpty()) {
	            System.out.println("No treatments available.");
	        } else {
	            System.out.println("Treatment History: " + treatments);
	        }
	    }
	}

	class Doctor {
	    int id;
	    String name;
	    String department;
	    String schedule;

	    public Doctor(int id, String name, String department, String schedule) {
	        this.id = id;
	        this.name = name;
	        this.department = department;
	        this.schedule = schedule;
	    }
	}

	class DoctorAssignments {
	    private HashMap<Integer, Doctor> doctors;

	    public DoctorAssignments() {
	        doctors = new HashMap<>();
	    }

	    public void addDoctor(int id, String name, String department, String schedule) {
	        Doctor doc = new Doctor(id, name, department, schedule);
	        doctors.put(id, doc);
	    }

	    public void getDoctor(int id) {
	        if (doctors.containsKey(id)) {
	            Doctor d = doctors.get(id);
	            System.out.println("Doctor: " + d.name + ", Dept: " 
	            + d.department + ", Schedule: " + d.schedule);
	        } else {
	            System.out.println("Doctor not found.");
	        }
	    }

	    public void listDoctors() {
	      for (Doctor d : doctors.values()) {
	         System.out.println("Doctor ID: " + d.id + ", Name: " 
	      + d.name + ", Department: " + d.department + ", Schedule: " + d.schedule);
	        }
	    }
	}
	public class Main {
	    public static void main(String[] args) {

	    	System.out.println("Testing Patient Records...");

	        PatientRecords patientRecords = new PatientRecords();

	        Patient p1 = new Patient(322, "Khalid Abdullah", 17, "0584833775");
	        Patient p2 = new Patient(323, "Dalal Ali", 37, "05552854398");

	        patientRecords.addPatient(p1);
	        patientRecords.addPatient(p2);

	        Patient current = patientRecords.head;
	        while (current != null) {
	        System.out.println("ID: "+ current.id +", Name: "+ current.name +
	        		", Age: "+ current.age +", Contact: "+ current.contact);
	        System.out.println("Medical History: " + current.medicalHistory);
	            current = current.next;
	        }

	        System.out.println("\nTesting Emergency Queue...");

	        EmergencyQueue emergencyQueue = new EmergencyQueue();

	        emergencyQueue.addPatient(p1.name, 3);
	        emergencyQueue.addPatient(p2.name, 1);   

	        emergencyQueue.treatPatient();
	        System.out.println();
	        
	        System.out.println("Testing Treatment History...");

	        TreatmentHistory history = new TreatmentHistory();

	        history.addTreatment("Surgery on 2025-10-05");
	        history.addTreatment("CT Scan of Abdomen");
	        history.addTreatment("MRI Scan of the Brain");

	        history.displayAllTreatments();
	        history.viewLastTreatment();
	        
	        System.out.println("\nTesting Doctor Assignments...");

	        DoctorAssignments doctorAssignments = new DoctorAssignments();

	        doctorAssignments.addDoctor(100, "Dr. Saleh Alotaibi", "Orthopedics", "8AM-4PM");
	        doctorAssignments.addDoctor(102, "Dr. Samar Yahya", "Radiology", "12PM-8PM");

	        doctorAssignments.listDoctors();

	    }
	    
	}



