package HCL_Assignment2;
import java.util.Scanner;
import java.util.regex.Pattern;
public class SimpleRegexDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Validate Mobile Number");
            System.out.println("2. Validate Email ID");
            System.out.println("3. Validate Username");
            System.out.println("4. Validate Password");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        if (Pattern.matches("[6-9][0-9]{9}", mobile))
                            System.out.println("Welcome! Valid Mobile Number");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();
                        if (Pattern.matches(".+@.+\\..+", email))
                            System.out.println("Welcome! Valid Email ID");
                        else
                            System.out.println("Invalid Email ID");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String user = sc.nextLine();
                        if (Pattern.matches("[a-zA-Z0-9_]{5,10}", user))
                            System.out.println("Welcome " + user);
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4:
                        System.out.print("Enter Password: ");
                        String pass = sc.nextLine();
                        if (Pattern.matches(".{6,}", pass))
                            System.out.println("Welcome! Password Accepted");
                        else
                            System.out.println("Invalid Password");
                        break;

                    case 5:
                        System.out.println("Exit");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Please enter correct input");
                sc.nextLine();
                choice = 0;
            }

        } while (choice != 5);

    }
}
