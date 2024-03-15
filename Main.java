
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Student> userStudent = new ArrayList<Student>();

    public static void main(String[] args) {


        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            Menu();
            choice = scanner.nextInt();

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
        System.out.print("Choose your role : ");
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

        // Nim harus berisi angka dan huruf
        if (!nim.matches("^[A-Za-z0-9]+$")) {
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

        if (!tahunMasuk.matches("^\\d{6}$")) {
            return false;
        }

        return true;
    }


    static void menuAdmin() {

    }

    static void menuStudent() {

    }
}




