package HCL_Assignment2;

    interface Bank {
        void deposit(int amount);
        void withdraw(int amount) throws Exception;
    }

    interface Customer {
        void setDetails(int id, String name);
        void showDetails();
    }

    class Account implements Bank, Customer {

        int id;
        String name;
        int balance = 0;

        public void setDetails(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void showDetails() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
        }

        public void deposit(int amount) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        }

        public void withdraw(int amount) throws Exception {
            if (amount > balance) {
                throw new Exception("No enough balance");
            }
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public class BankOperations {

        public static void main(String[] args) {

            Account a = new Account();

            a.setDetails(1, "Jay");
            a.showDetails();

            a.deposit(1000);

            try {
                a.withdraw(500);
                a.withdraw(700); // Exception
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


