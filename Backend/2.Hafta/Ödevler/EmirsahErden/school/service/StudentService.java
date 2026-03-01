package EmirsahErden.school.service;


import EmirsahErden.school.model.Student;

public class StudentService {


    Student[] students = new Student[100];
    int count = 0;

    // Öğrenci ekleme
    public void addStudent(Student s) {

        if (count < 100) {

            students[count] = s;
            count = count + 1;

            System.out.println("Öğrenci eklendi.");

        } else {

            System.out.println("Liste dolu, eklenemedi.");

        }
    }


    // Öğrencileri listeleme
    public void listStudents() {

        if (count == 0) {
            System.out.println("Hiç öğrenci yok.");
        } else {

            for (int i = 0; i < count; i++) {

                System.out.println("Ad: " + students[i].getName());
                System.out.println("Numara: " + students[i].getNumber());
                System.out.println("Ortalama: " + students[i].calculateAverage());
                System.out.println("Durum: " + students[i].getStatus());
                System.out.println("-------------------");
            }
        }
    }


    // En başarılı öğrenciyi bulma
    public void findBestStudent() {

        if (count == 0) {
            System.out.println("Hiç öğrenci yok.");
            return;
        }

        Student bestStudent = students[0];

        for (int i = 1; i < count; i++) {

            if (students[i].calculateAverage() > bestStudent.calculateAverage()) {

                bestStudent = students[i];

            }
        }

        System.out.println("En başarılı öğrenci:");
        System.out.println("Ad: " + bestStudent.getName());
        System.out.println("Ortalama: " + bestStudent.calculateAverage());
    }


    public void showMenu() {

        System.out.println("1 - Öğrenci Ekle");
        System.out.println("2 - Öğrencileri Listele");
        System.out.println("3 - En Başarılı Öğrenciyi Göster");
        System.out.println("4 - Çıkış");
    }


}
