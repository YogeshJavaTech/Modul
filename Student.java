
import java.util.ArrayList;

public class Student {
    private String name;
    private String nim;
    private String faculty;
    private String programStudy;
    private ArrayList<Book> books;

    public Student(String name, String nim, String faculty, String programStudy) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.programStudy = programStudy;
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("List of books for " + name + ":");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }


    public void logout() {
        System.out.println("Logging out of student account...");
        // code to log out of the program
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nim='" + nim + '\'' +
                ", faculty='" + faculty + '\'' +
                ", programStudy='" + programStudy + '\'' +
                '}';
    }
}

class Book {
    String id_buku;
    String judul;
    String author;
    int stok_buku;

    public Book(String id_buku, String judul, String author, int stok_buku) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.author = author;
        this.stok_buku = stok_buku;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id_buku='" + id_buku + '\'' +
                ", judul='" + judul + '\'' +
                ", author='" + author + '\'' +
                ", stok_buku=" + stok_buku +
                '}';
    }
}
