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
        entferneTier("Burt");

        for (Tier tier : tiere) {
            System.out.println(tier.getBeschreibung());
        }

        statistikDurchschnitt();
    }

    private static void hinzufuegenTier(Tier tier) {
        if (tiere.size() == 10) return;
        tiere.add(tier);
    }

    private static void fuetterAlle() {
        for (Tier tier : tiere) {
            if (tier instanceof fuetterbar) ((fuetterbar) tier).fuettern();
        }
    }

    private static void streichelAlle() {
        for (Tier tier : tiere) {
            if (tier instanceof streichelbar) ((streichelbar) tier).streicheln();
        }
    }

    private static void trainiereAlle() {
        for (Tier tier : tiere) {
            if (tier instanceof trainierbar) ((trainierbar) tier).trainieren();
        }
    }

    public static void statistikDurchschnitt() {
        int tempEnergie = 0, tempGesundheit = 0, tempZufriedenheit = 0, zaeler = 0;

        for (Tier tier : tiere) {
            if (tier instanceof zustand) {
                tempEnergie += tier.getEnergie();
                tempGesundheit += tier.getGesundheit();
                tempZufriedenheit += tier.getZufriedenheit();
                zaeler++;
            }
        }

        tempEnergie = tempEnergie / zaeler;
        tempGesundheit = tempGesundheit / zaeler;
        tempZufriedenheit = tempZufriedenheit / zaeler;

        System.out.println("Druchschitt aller Werte: " + "\nEnergie: " + tempEnergie + "\nGesundheit: " + tempGesundheit + "\nZufriedenheit: " + tempZufriedenheit);
    }

    public static void entferneTier(String nameTier) {
        for (Tier tier : tiere) {
            if (tier.getName() == nameTier) tiere.remove(nameTier);
        }
        
        System.out.println(nameTier + "wurde gelöscht");
    }
}
