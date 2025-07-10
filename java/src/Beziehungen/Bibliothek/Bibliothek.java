package Beziehungen.Bibliothek;

public class Bibliothek {
    private static String name;
    private static Regal regal;

    // Konstruktor
    public Bibliothek(String name, Regal regal) {
        Bibliothek.name = name;
        Bibliothek.regal = regal;
    }

    public String bibDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Bibliothek: ").append(name).append("\n");
        details.append("Bücher im Regal:\n");
        for (Buch buch : regal.getBuecher()) {
            details.append("- ").append(buch.getTitel())
                    .append(" (").append(buch.getDatum())
                    .append(") von ").append(buch.getAutor().getName())
                    .append("\n");
        }
        return details.toString();
    }

    // Main-Methode
    public static void main(String[] args) {
        // Regal erstellen
        Regal regal = new Regal();

        // Buch erstellen (Dune)
        Autor autor = new Autor("Maximilian Schmidt");
        Buch Dune = new Buch("Dune", "18.01.2025", autor);

        // Buch erstellen (Dune 2) - selber Autor
        Buch Dune2 = new Buch("Dune 2", "28.01.2025", autor);

        // Buch zum Regal hinzufügen
        regal.hinzufuegenBuecher(Dune);
        regal.hinzufuegenBuecher(Dune2);
        Bibliothek bib = new Bibliothek("Grand Bibliothek", regal);

        // Bibliotheksdetails ausgeben
        System.out.println(bib.bibDetails());
    }
}