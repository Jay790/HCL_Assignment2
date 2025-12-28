package HCL_Assignment2;

import java.util.*;

class Students {
    String id, name, course;
    int marks;

    Students(String id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String toString() {
        return id + " | " + name + " | " + course + " | " + marks;
    }
}


interface StudentOperationss {
    void addStudent(Students s);
    void displayStudents();
    void searchStudent(String id);
    void removeStudent(String id);
}


public class UniversitySystem implements StudentOperationss {


    HashMap<String, Students> studentMap = new HashMap<>();


    ArrayList<Students> studentList = new ArrayList<>();
    Vector<Students> studentVector = new Vector<>();
    Stack<Students> studentStack = new Stack<>();
    Set<String> courseSet = new HashSet<>();


    public void addStudent(Students s) {
        if (studentMap.containsKey(s.id)) {
            System.out.println("Duplicate Student ID not allowed!");
            return;
        }
        studentMap.put(s.id, s);
        studentList.add(s);
        studentVector.add(s);
        studentStack.push(s);
        courseSet.add(s.course);
        System.out.println("Student Added Successfully");
    }


    public void displayStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (Students s : studentMap.values())
            System.out.println(s);
    }


    public void searchStudent(String id) {
        if (studentMap.containsKey(id))
            System.out.println(studentMap.get(id));
        else
            System.out.println("Student Not Found");
    }


    public void removeStudent(String id) {
        Students s = studentMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
            System.out.println("Student Removed");
        } else {
            System.out.println("Student Not Found");
        }
    }


    void sortByMarks() {
        List<Students> list = new ArrayList<>(studentMap.values());
        list.sort((a, b) -> b.marks - a.marks);
        list.forEach(System.out::println);
    }


    void convertToTreeMap() {
        TreeMap<String, Students> treeMap = new TreeMap<>(studentMap);
        for (Students s : treeMap.values())
            System.out.println(s);
    }


    void countCourseWise() {
        Hashtable<String, Integer> table = new Hashtable<>();
        for (Students s : studentMap.values())
            table.put(s.course, table.getOrDefault(s.course, 0) + 1);
        System.out.println(table);
    }


    void displayCourses() {
        for (String c : courseSet)
            System.out.println(c);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UniversitySystem us = new UniversitySystem();

        while (true) {
            System.out.println("\n1 Add 2 Display 3 Search 4 Remove 5 Sort 6 TreeMap 7 Count 8 Courses 9 Exit");
            try {
                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("ID (STU001): ");
                        String id = sc.nextLine();
                        if (!id.matches("STU\\d{3}")) {
                            System.out.println("Invalid ID Format");
                            break;
                        }

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Course: ");
                        String course = sc.nextLine();

                        System.out.print("Marks: ");
                        int marks = sc.nextInt();

                        us.addStudent(new Students(id, name, course, marks));
                        break;

                    case 2:
                        us.displayStudents();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        us.searchStudent(sc.nextLine());
                        break;

                    case 4:
                        System.out.print("ID: ");
                        us.removeStudent(sc.nextLine());
                        break;

                    case 5:
                        us.sortByMarks();
                        break;

                    case 6:
                        us.convertToTreeMap();
                        break;

                    case 7:
                        us.countCourseWise();
                        break;

                    case 8:
                        us.displayCourses();
                        break;

                    case 9:
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}
