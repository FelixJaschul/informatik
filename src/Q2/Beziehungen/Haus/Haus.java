package src.Q2.Beziehungen.Haus;

public class Haus {
    private String adresse;
    private Raum raum;

    // Konstruktor
    public Haus(String adresse, String name, int groesse) {
        this.adresse = adresse;
        // Raum Objekt erstellen
        this.raum = new Raum(String name, int groesse);
    }

    // Methode der Ausgabe der Haus- und Raumdetials
    public void hausDetails() {
        System.out.println("Adresse des Hauses: " + adresse);
        System.out.println(raum.raumDetails());
    }

    public static void main(String[] ars) {
        // Haus Objekt erstellen
        Haus haus = new Haus("Entenstraße 123", "Wohnzimmer", 25);

        // Ausgabe der Details des Hauses
        haus.hausDetails();
    }
}