import java.util.*;
public class Management {
	private static ArrayList<Worker> workers = new ArrayList<>();
	 
	public static int menu() {
		System.out.println();
		System.out.println("===== Worker Management =====");
		System.out.println("1. Add Worker");
		System.out.println("2. Up Salary");
		System.out.println("3. Down Salary");
		System.out.println("4. Display Information Salary");
		System.out.println("5. Exit");
		int choice = Validate.checkInputLimit(1, 5);
		return choice;
	}
	
	public static void addWorkerToList() {
	    System.out.println();
	    System.out.println("------ Add Worker ------");
	    System.out.print("Enter code: ");
	    String id = Validate.checkInputString();
	    if (Validate.checkIdExist(workers, id)) {
	        System.out.println("Worker with this ID already exists.");
	        return; 
	    }
	    
	    System.out.print("Enter Name: ");
	    String name = Validate.checkInputString();
	    System.out.print("Enter Age: ");
	    int age = Validate.checkInputAge();
	    System.out.print("Enter Salary: ");
	    double salary = Validate.checkInputSalary();
	    System.out.print("Enter Work location: ");
	    String workLocation = Validate.checkInputString();
	    Worker worker = new Worker(id, name, age, salary, workLocation);
	    if(addWorker(worker)) {
	    	System.out.println("Worker added successfully.");
	    } else {
	    	 System.out.println("Failed to add worker. Worker may already exist.");
	    }
	}

	private static boolean addWorker(Worker worker) {
	    if (!Validate.checkWorkerExist(workers, worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation())) {
	    	return false; 
	    }
	    workers.add(worker);
	    return true; 
	}
	
	
	
}
