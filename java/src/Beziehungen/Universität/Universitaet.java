package Beziehungen.Universität;

public class Universitaet {
    String name;
    Professor professor;

    // Konstruktor
    public Universitaet(String name, Professor professor) {
        this.name = name;
        this.professor = professor;
    }

    // Ausgabe der Universitätsdetails
    public void universitaetDetails() {
        System.out.print("Universität: " + name);
        if (professor != null) {
            System.out.println("Professor: " + Professor.getName() + ", Fachgebiet: " + Professor.getFachgebiet());
        } else {
            System.out.println("Diese Universität hat derzeit keine*n Professor*in.");
        }
    }

    public static void main(String[] args) {
        // Professor Objekt erstellen
        Professor prof = new Professor("Dr. Müller", "Physik");

        // Universitätsobjekt erstellen
        Universitaet uni = new Universitaet("TU Berlin", prof);

        // Details der Universität abrufen
        uni.universitaetDetails();
    }
}
