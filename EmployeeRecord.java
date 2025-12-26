package HCL_Assignment2;
import java.util.*;
import java.util.regex.Pattern;


interface EmployeeOperations {
    void addEmployee();
    void displayEmployees();
    void searchEmployee(int id);
    void removeEmployee(int id);
}


class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}


class EmployeeManager implements EmployeeOperations {

    HashMap<Integer, Employee> hashMap = new HashMap<>();
    Hashtable<Integer, Employee> hashTable = new Hashtable<>();
    TreeMap<Integer, Employee> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            // REGEX validation (only alphabets)
            if (!Pattern.matches("[a-zA-Z ]+", name)) {
                System.out.println("Invalid Name!");
                return;
            }

            Employee e = new Employee(id, name);

            hashMap.put(id, e);
            hashTable.put(id, e);
            treeMap.put(id, e);

            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }

    public void displayEmployees() {
        System.out.println("\nHashMap Records:");
        System.out.println(hashMap);

        System.out.println("\nHashtable Records:");
        System.out.println(hashTable);

        System.out.println("\nTreeMap Records:");
        System.out.println(treeMap);
    }

    public void searchEmployee(int id) {
        if (hashMap.containsKey(id))
            System.out.println("Employee Found: " + hashMap.get(id));
        else
            System.out.println("Employee Not Found");
    }

    public void removeEmployee(int id) {
        if (hashMap.remove(id) != null) {
            hashTable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee Removed");
        } else {
            System.out.println("Employee Not Found");
        }
    }


    public void demonstrateNullSupport() {
        System.out.println("\n--- Null Support Demo ---");


        hashMap.put(null, null);
        System.out.println("HashMap allows null key and null value");


        try {
            hashTable.put(null, null);
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key or value");
        }


        try {
            treeMap.put(null, new Employee(0, "Test"));
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key");
        }
    }
}


public class EmployeeRecord {
    public static void main(String[] args) {

        EmployeeManager em = new EmployeeManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Null Support Demo");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        em.addEmployee();
                        break;
                    case 2:
                        em.displayEmployees();
                        break;
                    case 3:
                        System.out.print("Enter Employee ID: ");
                        em.searchEmployee(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Enter Employee ID: ");
                        em.removeEmployee(sc.nextInt());
                        break;
                    case 5:
                        em.demonstrateNullSupport();
                        break;
                    case 6:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }

            } catch (Exception e) {
                System.out.println("Enter Valid Input");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}

