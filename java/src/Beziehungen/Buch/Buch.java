package Beziehungen.Buch;

public class Buch {
    String titel;
    String datum;

    // Konstruktor
    public Buch(String titel, String datum) {
        this.titel = titel;
        this.datum = datum;
    }

    // Non-static method um Buch Details darzustellen
    public void buchDetails() {
        System.out.println("Das Buch: " + titel + " wurde am " + datum + " veröffentlicht.");
    }

    public static void main(String[] args) {
        // Boch Obejekt erstellen
        Buch buch = new Buch("Dune", "14.01.2004");
        buch.buchDetails();

        // Autor Objekt erstellen
        Autor autor = new Autor("Frank Herbert", 65);
        autor.autorDetails();
    }
}