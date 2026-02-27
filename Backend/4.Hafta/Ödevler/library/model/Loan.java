package library.model;

import java.time.LocalDate;


public class Loan {
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;


    // Constructor
    public Loan(Book book, Member member, LocalDate borrowDate, LocalDate returnDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;

    }

    public Book getBook() {
        return book;
    }
    public Member getMember() {
        return member;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }

    // Gecikme olup olmadığını kontrol eder
    public boolean isLate() {
        return LocalDate.now().isAfter(returnDate);
    }

    public long calculateLateDays() {
        // Kaç gün geciktiğini hesaplar.
        long diff = java.time.temporal.ChronoUnit.DAYS.between(returnDate, LocalDate.now());
        return Math.max(0, diff); // Negatif çıkarsa 0 döndürür
    }
}