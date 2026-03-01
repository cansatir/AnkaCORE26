package EmirsahErden.school.model;

import java.util.Scanner;

public class Student {

    private String name;
    private int number;
    private double note1;
    private double note2;
    private double note3;


    public Student(String name, int number, double note1, double note2, double note3) {
        this.name = name;
        this.number = number;
        this.note1 = note1;
        this.note2 = note2;
        this.note3 = note3;

    }
    // ortalama Hesaplama
    public double calculateAverage() {

        double result = (note1 + note2 + note3) / 3;

        return result;

    }
    //  Geçti kaldı durumu
    public String getStatus() {


        return calculateAverage() >= 50 ? "Geçti" : "Kaldı";

    }

    // Getter Metodları
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getNote1() {
        return note1;
    }

    public double getNote2() {
        return note2;
    }

    public double getNote3() {
        return note3;
    }


}


