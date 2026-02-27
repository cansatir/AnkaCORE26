package library.service;

import library.model.Book;
import library.model.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class FileService {

    // Verileri txt dosyasına ';' ayıracı ile kaydeder
    public static void saveBooks(String filename, ArrayList<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) { // Dosyaya yazar
            for (Book b : books) {
                writer.write("BOOK;" + b.getId() + ";" + b.getTitle() + ";" + b.getAuthor() + ";" +
                        b.getCategory() + ";" + b.isAvailable());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Kitaplar kaydedilemedi: " + e.getMessage());
        }
    }


    public static void saveMembers(String filename, HashMap<Integer, Member> members) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Member m : members.values()) {
                writer.write("MEMBER;" + m.getId() + ";" + m.getName() + ";" + m.getRegisterDate());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Üyeler kaydedilemedi: " + e.getMessage());
        }
    }

    // BufferedReader ile satır satır okuma yapar
    public static ArrayList<Book> loadBooks(String filename) {
        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equalsIgnoreCase("BOOK")) {
                    books.add(new Book(Integer.parseInt(parts[1]), parts[2], parts[3], parts[4],
                            Boolean.parseBoolean(parts[5])));
                }
            }
        } catch (IOException e) {
            System.out.println("Kitaplar yüklenemedi: " + e.getMessage());
        }
        return books;
    }

    public static HashMap<Integer, Member> loadMembers(String filename) {
        HashMap<Integer, Member> members = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equalsIgnoreCase("MEMBER")) {
                    members.put(Integer.parseInt(parts[1]), new Member(Integer.parseInt(parts[1]),
                            parts[2], LocalDate.parse(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Üyeler yüklenemedi: " + e.getMessage());
        }
        return members;
    }
}