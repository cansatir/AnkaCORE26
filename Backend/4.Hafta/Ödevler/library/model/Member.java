package library.model;

import java.time.LocalDate;

public class Member {
    private int id;
    private String name;
    private LocalDate registerDate;

    public Member(int id, String name, LocalDate registerDate) {
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return id + " - " + name + " | Kayıt Tarihi: " + registerDate;
    }
}