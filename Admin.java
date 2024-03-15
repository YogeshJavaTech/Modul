import java.util.ArrayList;

public class Admin {
    private ArrayList<Student> students;

    public Admin() {
        students = new ArrayList<Student>();
    }

    public void addStudent(String name, String nim, String faculty, String programStudy) {
        if (nim.length() != 15) {
            System.out.println("NIM tidak valid");
            return;
        }

        Student newStudent = new Student(name, nim, faculty, programStudy);
        students.add(newStudent);
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }


    public static class Student {
        private String name;
        private String nim;
        private String faculty;
        private String programStudy;

        public Student(String name, String nim, String faculty, String programStudy) {
            this.name = name;
            this.nim = nim;
            this.faculty = faculty;
            this.programStudy = programStudy;
        }

        }
    }
