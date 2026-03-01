package library;

import library.model.Book;
import library.model.Member;
import library.service.LibraryService;
import library.service.FileService;
import library.exception.BookNotAvailableException;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner sc = new Scanner(System.in);

        // Başlangıçta eski verileri yükle
        library.getBooks().addAll(FileService.loadBooks("books.txt"));
        library.getMembers().putAll(FileService.loadMembers("members.txt"));

        int choice;
        do {
            System.out.println("\n1-Kitap Ekle\n2-Üye Ekle\n3-Kitap Ödünç Ver\n4-Kitap İade Al" +
                    "\n5-Kitapları Listele\n6-Rapor Oluştur\n7-Dosyaya Kaydet\n8-Dosyadan Yükle\n9-Çıkış");
            System.out.print("Seçiminiz: ");
            choice = sc.nextInt();
            sc.nextLine();

            // Kullanıcı Menüsü
            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Başlık: "); String title = sc.nextLine();
                    System.out.print("Yazar: "); String author = sc.nextLine();
                    System.out.print("Kategori: "); String category = sc.nextLine();
                    library.addBook(new Book(id, title, author, category, true));
                }
                case 2 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("İsim: "); String name = sc.nextLine();
                    library.addMember(new Member(id, name, LocalDate.now()));
                }
                case 3 -> {
                    System.out.print("Kitap ID: "); int bookId = sc.nextInt();
                    System.out.print("Üye ID: "); int memberId = sc.nextInt();
                    try {
                        library.borrowBook(bookId, memberId);
                    } catch (BookNotAvailableException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("Ödünç verme işlemi tamamlandı.");
                    }
                }
                case 4 -> {
                    System.out.print("Kitap ID: "); int bookId = sc.nextInt();
                    library.returnBook(bookId);
                }
                case 5 -> library.listBooks();
                case 6 -> System.out.println(library.generateReport());
                case 7 -> {
                    FileService.saveBooks("books.txt", library.getBooks());
                    FileService.saveMembers("members.txt", library.getMembers());
                    System.out.println("Dosyaya kaydedildi.");
                }
                case 8 -> {
                    library.getBooks().clear();
                    library.getMembers().clear();
                    library.getBooks().addAll(FileService.loadBooks("books.txt"));
                    library.getMembers().putAll(FileService.loadMembers("members.txt"));
                    System.out.println("Dosyadan yüklendi.");
                }
                case 9 -> System.out.println("Çıkış yapılıyor...");
                default -> System.out.println("Geçersiz seçim!");
            }
        } while (choice != 9);
    }
}