package Beziehungen.Buch;

public class Autor {
    String name;
    int alter;

    // Constructor
    public Autor(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }

    // Non-static method for displaying author details
    public void autorDetails() {
        System.out.println("Der Autor " + name + " ist " + alter + " Jahre alt.");
    }
}