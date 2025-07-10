package Beziehungen.Universität;

public class Professor {
    private static String name;
    private static String fachgebiet;

    // Konstruktor
    public Professor(String name, String fachgebiet) {
        Professor.name = name;
        Professor.fachgebiet = fachgebiet;
    }

    // Getter für Name
    public static String getName() {
        return name;
    }

    // Getter für Fachgebiet
    public static String getFachgebiet() {
        return fachgebiet;
    }
}