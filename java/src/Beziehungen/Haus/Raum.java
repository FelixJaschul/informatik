package Beziehungen.Haus;

public class Raum {
    private String name;
    private final int groesse;

    public Raum(String name, int groesse) {
        this.name = name;
        this.groesse = groesse;
    }

    public String raumDetails() {
        return "Raum: " + name + ", Größe: " + groesse + " m²";
    }
}