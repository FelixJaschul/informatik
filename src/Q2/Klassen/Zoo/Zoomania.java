package src.Q2.Klassen.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoomania {

    private static final List<Tier> tiere = new ArrayList<Tier>();

    // Main-Methode
    public static void main(String[] args) {

        hinzufuegenTier(new Elefant("Burt", 20, 20, 20));
        hinzufuegenTier(new Giraffe("Melman", 20, 20, 20));
        hinzufuegenTier(new Loewe("Alex", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Rico", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Skipper", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Private", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Kowalski", 20, 20, 20));

        fuetterAlle();
        streichelAlle();
        trainiereAlle();

        for (Tier tier : tiere) {
            System.out.println(tier.getBeschreibung());
        }
    }

    private static void hinzufuegenTier(Tier tier) {
        if (tiere.size() == 10) return;
        tiere.add(tier);
    }

    private static void fuetterAlle() {
        // TODO Lehrer ist Lost
        for (Tier tier : tiere) {
            if (tier instanceof Elefant) ((Elefant) tier).fuettern();
            if (tier instanceof Giraffe) ((Giraffe) tier).fuettern();
            if (tier instanceof Loewe) ((Loewe) tier).fuettern();
        }
    }
    private static void streichelAlle() {
        // TODO Lehrer ist Lost
        for (Tier tier : tiere) {
            if (tier instanceof Pinguin) ((Pinguin) tier).streicheln();
        }
    }
    private static void trainiereAlle() {
        // TODO Lehrer ist Lost
        for (Tier tier : tiere) {
            if (tier instanceof Loewe) ((Loewe) tier).trainieren();
        }
    }
}
