package src.Q2.Klassen.Zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoomania {

    // Tiere-Zoo-Liste
    private static final List<Tier> tiere = new ArrayList<Tier>();

    // Main-Methode
    public static void main(String[] args) {

        // Fügt die Tiere in den Zoo ein
        hinzufuegenTier(new Elefant("Burt", 20, 20, 20));
        hinzufuegenTier(new Giraffe("Melman", 20, 20, 20));
        hinzufuegenTier(new Loewe("Alex", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Rico", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Skipper", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Private", 20, 20, 20));
        hinzufuegenTier(new Pinguin("Kowalski", 20, 20, 20));

        statistik();

        fuetterAlle();
        streichelAlle();
        trainiereAlle();
        
        entferneTier("Burt"); // entfernt Burt den Elefanten

        statistik();
        statistikDurchschnitt();
    }

    private static void statistik() {
        for (Tier tier : tiere) {
            System.out.println(tier.getBeschreibung()); // zeigt die Beschreibung aller Tiere
        }
    }

    private static void hinzufuegenTier(Tier tier) {
        if (tiere.size() == 10) return; // schaut ob bereits 10 Tiere in der Tiere-Zoo-Liste sind
        tiere.add(tier);
    }

    private static void fuetterAlle() {
        for (Tier tier : tiere) {
            if (tier instanceof fuetterbar) ((fuetterbar) tier).fuettern(); // schaut welche Tiere fuetterbar sind und führt die Methode für das tier dann aus
        }
    }

    private static void streichelAlle() {
        for (Tier tier : tiere) {
            if (tier instanceof streichelbar) ((streichelbar) tier).streicheln(); // schaut welche Tiere streichelbar sind und führt die Methode für das tier dann aus
        }
    }

    private static void trainiereAlle() {
        for (Tier tier : tiere) {
            if (tier instanceof trainierbar) ((trainierbar) tier).trainieren(); // schaut welche Tiere trainierbar sind und führt die Methode für das tier dann aus
        }
    }

    public static void statistikDurchschnitt() {
        int tempEnergie = 0, tempGesundheit = 0, tempZufriedenheit = 0;
        int anzahlTiere = tiere.size();

        for (Tier tier : tiere) {
            if (tier instanceof zustand) {
                tempEnergie += tier.getEnergie(); // fügt alle Werte der Tiere zu einem Wert zusammen
                tempGesundheit += tier.getGesundheit();
                tempZufriedenheit += tier.getZufriedenheit();
            }
        }

        tempEnergie = tempEnergie / anzahlTiere; // rechnet den Durchschitt aus, indem der schlussendliche Wert aller Tiere durch die Anzahl der Tiere geteilt wird
        tempGesundheit = tempGesundheit / anzahlTiere;
        tempZufriedenheit = tempZufriedenheit / anzahlTiere;

        System.out.println("Druchschitt aller Werte: " + "\nEnergie: " + tempEnergie + "\nGesundheit: " + tempGesundheit + "\nZufriedenheit: " + tempZufriedenheit);
    }

    public static void entferneTier(String nameTier) {
        var iterator = tiere.iterator();

        while (iterator.hasNext()) { // wird solang ausgeführt bis es keine Tiere mehr im Zoo gibt
            Tier tier = iterator.next(); // geht die Tier-Zoo-Liste durch
            if (tier.getName().equals(nameTier)) {
                iterator.remove(); // löscht das Tier rip
                System.out.println(nameTier + " wurde gelöscht\n");
                return; 
            }
        }

        System.out.println("\n" + nameTier + " wurde nicht gefunden\n");
    }
}
