package library.service;

import library.model.Book;
import library.model.Loan;
import library.model.Member;
import library.exception.BookNotAvailableException;

import java.time.LocalDate;
import java.util.*;

public class LibraryService {
    private ArrayList<Book> books = new ArrayList<>(); // Tüm kitapları tutar
    private HashMap<Integer, Member> members = new HashMap<>(); // Üyeleri ID’ye göre saklar.
    private ArrayList<Loan> loans = new ArrayList<>(); // ödünç işlemleri
    private HashSet<String> categories = new HashSet<>(); // Tekrar etmeyen kategori listesi

    // Kitap ekleme metotu
    public void addBook(Book book) {
        books.add(book);
        categories.add(book.getCategory());
    }

    // Üye ekleme metotu
    public void addMember(Member member) {
        members.put(member.getId(), member);
    }

    // Kitabı ID ile bulur bulamazsa exception fırlatır ödünçteyse exception fırlatır
    public void borrowBook(int bookId, int memberId) throws BookNotAvailableException {
        Book book = null;
        for (Book b : books) {
            if (b.getId() == bookId) {
                book = b;
                break;
            }
        }
        if (book == null) throw new BookNotAvailableException("Kitap bulunamadı!");
        if (!book.isAvailable()) throw new BookNotAvailableException("Kitap zaten ödünçte!");

        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Üye bulunamadı!");
            return;
        }

        book.setAvailable(false);
        loans.add(new Loan(book, member, LocalDate.now(), LocalDate.now().plusDays(14)));
        System.out.println("Kitap ödünç verildi: " + book.getTitle());
    }

    // Loan listesini gezer
    public void returnBook(int bookId) {
        Iterator<Loan> it = loans.iterator();
        while (it.hasNext()) {
            Loan loan = it.next();
            if (loan.getBook().getId() == bookId) {
                loan.getBook().setAvailable(true);

                long lateDays = loan.calculateLateDays();

                // math kullanımı: Ceza hesaplama ve Yuvarlama
                // Eğer gecikme varsa 2.5 ile çarp, yoksa 0.0 çıkar.
                double rawFee = lateDays * 2.5;
                double finalFee = Math.ceil(rawFee); // Math sınıfı: Yukarı yuvarla (Örn: 12.5 -> 13.0)

                it.remove();
                System.out.println("Kitap iade alındı.");
                if (lateDays > 0) {
                    System.out.println("Gecikme: " + lateDays + " gün | Ceza: " + finalFee + " TL");
                } else {
                    System.out.println("Zamanında iade edildi. Teşekkürler!");
                }
                return;
            }
        }
        System.out.println("Bu ID ile ödünç verilmiş bir kitap bulunamadı.");
    }


    // Tüm kitapları yazdırır
    public void listBooks() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // İstatistiksel rapor oluşturma
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Toplam Kitap: ").append(books.size()).append("\n");
        long borrowed = books.stream().filter(b -> !b.isAvailable()).count();
        sb.append("Ödünç Verilen Kitap: ").append(borrowed).append("\n");

        Map<String, Long> categoryCount = new HashMap<>();
        Map<String, Integer> borrowCategoryCount = new HashMap<>();

        for (Loan loan : loans) {
            String category = loan.getBook().getCategory().trim();
            borrowCategoryCount.put(category,
                    borrowCategoryCount.getOrDefault(category, 0) + 1);
        }

        String popularCategory = "Yok";

        if (!borrowCategoryCount.isEmpty()) {
            popularCategory = Collections.max(
                    borrowCategoryCount.entrySet(),
                    Map.Entry.comparingByValue()
            ).getKey();
        }

        sb.append("En Çok Ödünç Alınan Kategori: ")
                .append(popularCategory)
                .append("\n");
        sb.append("En Popüler Kategori: ").append(popularCategory).append("\n");
        sb.append("Toplam Üye: ").append(members.size()).append("\n");
        return sb.toString();
    }

    // Getter
    public ArrayList<Book> getBooks() {
        return books;
    }
    public HashMap<Integer, Member> getMembers() {
        return members;
    }
}