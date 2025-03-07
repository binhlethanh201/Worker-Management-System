import java.util.*;
public class Validate {
	private static final Scanner sc = new Scanner(System.in);
	
	public static int checkInputLimit(int min, int max) {
		while(true) {
			try {
				int in = Integer.parseInt(sc.nextLine());
				if(in < min || in >max) {
					throw new NumberFormatException();
				}
				return in;
			} catch(NumberFormatException e) {
				System.out.println("Please input in the range " +min+ " to " +max);
				System.out.print("Input again:");
			}
		}
	}
	
	public static String checkInputString() {
		while(true) {
			String in = sc.nextLine().trim();
			if(in.isEmpty()) {
				System.out.println("Can not empty!");
				System.out.print("Input again:");
			} else {
				return in;
			}
			
		}
	}
	public static int checkInputAge() {
		while(true) {
			try {
				int in = Integer.parseInt(sc.nextLine().trim());
			if( in < 18 || in > 50) {
				throw new Exception();
			}
			return in;
			} catch(Exception e) {
				System.out.println("Age must be in range 18 to 50");
				System.out.print("Input again:");
			}
			
		}
	}
	public static double checkInputSalary() {
		while(true) {
			try {
				double in = Double.parseDouble(sc.nextLine());
				if(in < 0) throw new NumberFormatException();
				return in;
			} catch(NumberFormatException e) {
				System.out.println("Salary must be greater than 0!");
				System.out.print("Input again:");
			}
		}
	}
	public static boolean checkIdExist(ArrayList<Worker> w, String id) {
		for(Worker worker : w) {
			if(id.equalsIgnoreCase(worker.getId())) {
				return true;
			}
		}
		return false;
	}
	public static boolean checkWorkerExist(ArrayList<Worker> w, String id, String name, int age, double salary, String workLocation) {
		for(Worker worker : w) {
			if(id.equalsIgnoreCase(worker.getId()) && name.equalsIgnoreCase(worker.getName()) && age == worker.getAge() && salary == worker.getSalary() && workLocation.equalsIgnoreCase(worker.getWorkLocation())) {
				return false;
			}
		}
		return true;
	}
}
