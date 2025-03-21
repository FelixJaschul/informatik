package src.Q2.Beziehungen.Bibliothek;

public class Buch {
    private String titel;
    private String datum;
    private Autor autor;

    // Konstruktor
    public Buch(String titel, String datum, Autor autor) {
        this.titel = titel;
        this.datum = datum;
        this.autor = autor;
    }

    // Getter
    public String getDatum() {
        return datum;
    }

    public String getTitel() {
        return titel;
    }

    public Autor getAutor() {
        return autor;
    }
}