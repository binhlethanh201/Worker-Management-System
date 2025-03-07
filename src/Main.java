//import java.util.*;
public class Main {
    public static void main(String[] args) {
        while (true) {
            int choice = Management.menu();
            switch (choice) {
                case 1:
                    Management.addWorkerToList();
                    break;
                case 2:
                    Management.upSalary();
                    break;
                case 3:
                    Management.downSalary();
                    break;
                case 4:
                    Management.getInfomationSalary();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
            }
        }
    }
}