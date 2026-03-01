import EmirsahErden.school.model.Student;
import EmirsahErden.school.service.StudentService;

void main() {


//    Student s = new Student("Ali", 123, 70, 10, 20);
//
//    System.out.println(s.getName());
//    System.out.println(s.getNumber());
//    System.out.println(s.calculateAverage());
//    System.out.println(s.getStatus());


    Scanner input = new Scanner(System.in);
    StudentService service = new StudentService();

    int choice;

    do {
        service.showMenu();
        choice = input.nextInt();
        input.nextLine(); // buffer temizleme

        switch (choice) {

            case 1:
                System.out.print("İsim: ");
                String name = input.nextLine();

                System.out.print("Numara: ");
                int number = input.nextInt();

                System.out.print("Not 1: ");
                double n1 = input.nextDouble();

                System.out.print("Not 2: ");
                double n2 = input.nextDouble();

                System.out.print("Not 3: ");
                double n3 = input.nextDouble();
                input.nextLine();

                Student s = new Student(name, number, n1, n2, n3);
                service.addStudent(s);
                break;

            case 2:
                service.listStudents();
                break;

            case 3:
                service.findBestStudent();
                break;

            case 4:
                System.out.println("Çıkış yapılıyor...");
                break;

            default:
                System.out.println("Geçersiz seçim!");
        }

    } while (choice != 4);

    input.close();

}
