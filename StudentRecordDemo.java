package HCL_Assignment2;
import java.util.*;
import java.util.regex.Pattern;


interface StudentOperations {
    void addStudent();
    void displayStudents();
    void removeStudent(int roll);
    void searchStudent(int roll);
}


class Student {
    int roll;
    String name;

    Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public String toString() {
        return roll + " - " + name;
    }
}


class StudentManager implements StudentOperations {

    List<Student> list = new ArrayList<>();   // List
    Vector<Student> vector = new Vector<>();  // Vector
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            // REGEX validation
            if (!Pattern.matches("[a-zA-Z ]+", name)) {
                System.out.println("Invalid Name!");
                return;
            }

            Student s = new Student(roll, name);
            list.add(s);
            vector.add(s);

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }

    public void displayStudents() {
        if (list.isEmpty()) {
            System.out.println("No Records Found");
            return;
        }
        System.out.println("Student Records:");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public void removeStudent(int roll) {
        boolean found = false;
        for (Student s : list) {
            if (s.roll == roll) {
                list.remove(s);
                vector.remove(s);
                found = true;
                break;
            }
        }
        if (found)
            System.out.println("Student Removed");
        else
            System.out.println("Student Not Found");
    }

    public void searchStudent(int roll) {
        for (Student s : list) {
            if (s.roll == roll) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student Not Found");
    }
}

public class StudentRecordDemo {
    public static void main(String[] args) {

        StudentManager sm = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student by Roll No");
            System.out.println("4. Search Student by Roll No");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        sm.addStudent();
                        break;
                    case 2:
                        sm.displayStudents();
                        break;
                    case 3:
                        System.out.print("Enter Roll No: ");
                        sm.removeStudent(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Enter Roll No: ");
                        sm.searchStudent(sc.nextInt());
                        break;
                    case 5:
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

        } while (choice != 5);

        sc.close();
    }
}
