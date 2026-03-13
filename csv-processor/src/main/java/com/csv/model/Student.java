package com.csv.model;

public class Student {

    private String name;
    private int total;
    private double percentage;
    private String[] subjects;

    public Student(String name, int total, double percentage, String[] subjects) {
        this.name = name;
        this.total = total;
        this.percentage = percentage;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public double getPercentage() {
        return percentage;
    }

    public String[] getSubjects() {
        return subjects;
    }
}