import java.util.*;
public class Management {
	private static ArrayList<Worker> workers = new ArrayList<>();
	private static ArrayList<SalaryHistory> history = new ArrayList<>();
	 
	public static int menu() {
		System.out.println();
		System.out.println("===== Worker Management =====");
		System.out.println("1. Add Worker");
		System.out.println("2. Up Salary");
		System.out.println("3. Down Salary");
		System.out.println("4. Display Information Salary");
		System.out.println("5. Exit");
		System.out.print("Please choice one option:");
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
	public static void upSalary() {
			System.out.println();
		    System.out.println("------ Up Salary------");
		    System.out.print("Enter code: ");
		    String id = Validate.checkInputString();
		    if(!Validate.checkIdExist(workers, id)) {
		    	 System.out.println("Worker with this ID already exists.");
			        return; 
		    }
		    System.out.print("Enter amount to increase: ");
		    double amount = Validate.checkInputSalary();
		    if (changeSalary(SalaryStatus.INCREASE, id, amount)) {
		        System.out.println("Salary increased successfully.");
		    } else {
		        System.out.println("Failed to increase salary.");
		    }
	}
	public static void downSalary() {
		System.out.println();
	    System.out.println("------ Down Salary------");
	    System.out.print("Enter code: ");
	    String id = Validate.checkInputString();
	    if(!Validate.checkIdExist(workers, id)) {
	    	 System.out.println("Worker with this ID already exists.");
		        return; 
	    }
	    System.out.print("Enter amount to decrease: ");
	    double amount = Validate.checkInputSalary();
	    if (changeSalary(SalaryStatus.DECREASE, id, amount)) {
	        System.out.println("Salary decreased successfully.");
	    } else {
	        System.out.println("Failed to decrease salary.");
	    }
	}
	
	public static void getInfomationSalary() {
	    System.out.printf("%-6s %-10s %-4s %-8s %-8s %-12s%n", 
	                      "Code", "Name", "Age", "Salary", "Status", "Date");
	    for (Worker worker : workers) {
	        SalaryHistory latestHistory = history.stream().filter(h -> h.getWorkerId().equals(worker.getId())).sorted((h1, h2) -> h2.getDate().compareTo(h1.getDate())).findFirst()
	            .orElse(null);
	        String status = (latestHistory != null) ? (latestHistory.getStatus() == SalaryStatus.INCREASE ? "UP" : "DOWN") : "NONE";
	        String formattedDate = (latestHistory != null) ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(latestHistory.getDate()) : "NONE";
	        System.out.printf("%-6s %-10s %-4d %-8.2f %-8s %-12s%n", worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), status, formattedDate);
	    }
	}
	
	
	// add Worker 
	private static boolean addWorker(Worker worker) {
	    if (!Validate.checkWorkerExist(workers, worker.getId(), worker.getName(), worker.getAge(), worker.getSalary(), worker.getWorkLocation())) {
	    	return false; 
	    }
	    workers.add(worker);
	    return true; 
	}
	// change up or down salary
	private static boolean changeSalary(SalaryStatus status, String code, double amount ){
		for(Worker worker : workers) {
			if(worker.getId().equals(code)) {
				if(amount <=0) return false;
				double newSalary = (status == SalaryStatus.INCREASE) ? worker.getSalary() + amount : worker.getSalary() - amount;
				if(newSalary <= 0) return false;
				worker.setSalary(newSalary);
				history.add(new SalaryHistory(code, amount , status));
				return true;
			}
		}
		return false;
	}
	
}
