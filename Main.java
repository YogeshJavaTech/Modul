import java.util.ArrayList;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Main {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Student> userStudent = new ArrayList<Student>();

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            Menu();
            try {
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after the integer input

                switch (choice) {
                    case 1:
                        menuAdmin();
                        break;
                    case 2:
                        String nim = inputNim();
                        if (checkNim(nim)) {
                            menuStudent();
                        } else {
                            System.out.println("NIM not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("No input found. Exiting...");
                choice = 3; // Exit the loop
            }
        } while (choice != 3);

        scanner.close();
    }


    static void Menu() {
        System.out.println("=================================");
        System.out.println("Welcome to Library Management");
        System.out.println("=================================");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Student");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }


    static String inputNim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your NIM (input 9 untuk back) : ");
        String nim = scanner.nextLine();
        return nim;
    }

    static boolean checkNim(String nim) {
        // Panjang nim harus 10 karakter
        if (nim.length() != 10) {
            return false;
        }

        // Nim harus berisi angka, huruf, dan tidak boleh mengandung karakter khusus
        if (!nim.matches("^[A-Za-z0-9]*$")) {
            return false;
        }

        // Nim harus diawali dengan 2 huruf kode fakultas, diikuti dengan 6 angka yang mewakili tahun masuk, dan diakhiri dengan 2 huruf kode jurusan
        String[] parts = nim.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        if (parts.length != 3) {
            return false;
        }

        String fakultasKode = parts[0];
        String tahunMasuk = parts[1];
        String jurusanKode = parts[2];

        if (fakultasKode.length() != 2 || jurusanKode.length() != 2) {
            return false;
        }

        // Check if fakultasKode and jurusanKode contain only valid characters (assuming only uppercase letters are allowed)
        if (!fakultasKode.matches("^[A-Z]{2}$") || !jurusanKode.matches("^[A-Z]{2}$")) {
            return false;
        }

        // Check if tahunMasuk is a valid year (between 1900 and current year)
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int year = Integer.parseInt(tahunMasuk);
        if (year < 1900 || year > currentYear) {
            return false;
        }

        // Check if nim starts with 2 letters and ends with 2 letters
        if (!nim.matches("^[A-Za-z]{2}\\d{6}[A-Za-z]{2}$")) {
            return false;
        }

        return true;
    }


    static void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=================================");
            System.out.println("Admin Menu");
            System.out.println("=================================");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Update student information");
            System.out.println("4. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateStudentInfo();
                    break;
                case 4:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    static void addBook() {
        // Implementation to add a book
        // This is where you can prompt the admin to enter the book details and add it to the book list
        System.out.println("Adding a book...");
    }

    static void removeBook() {
        // Implementation to remove a book
        // This is where you can prompt the admin to enter the book details and remove it from the book list
        System.out.println("Removing a book...");
    }

    static void updateStudentInfo() {
        // Implementation to update student information
        // This is where you can prompt the admin to enter the student details and update it in the student list
        System.out.println("Updating student information...");
    }



    static void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=================================");
            System.out.println("Student Menu");
            System.out.println("=================================");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);

        scanner.close();
    }

    static void borrowBook() {
        // Implementation to borrow a book
        // This is where you can prompt the student to enter the book details they want to borrow
        System.out.println("Borrowing a book...");
    }

    static void returnBook() {
        // Implementation to return a book
        // This is where you can prompt the student to enter the book details they want to return
        System.out.println("Returning a book...");
    }


}
