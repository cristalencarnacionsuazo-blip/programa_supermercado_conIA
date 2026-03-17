import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();

        while (true) {
            System.out.println("\n=== Login System ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Username: ");
                    String regUser = scanner.nextLine();
                    System.out.print("Password: ");
                    String regPass = scanner.nextLine();
                    if (db.registerUser(regUser, regPass)) {
                        System.out.println("User registered successfully!");
                    } else {
                        System.out.println("Registration failed (username exists?).");
                    }
                }
                case 2 -> {
                    System.out.print("Username: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPass = scanner.nextLine();
                    if (db.validateLogin(loginUser, loginPass)) {
                        System.out.println("Login successful! Welcome, " + loginUser + "!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                }
                case 3 -> {
                    System.out.println("Goodbye!");
                    db.close();
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}

