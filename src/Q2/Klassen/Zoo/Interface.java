package src.Q2.Klassen.Zoo;

// Lager für alle Interfaces
interface fuetterbar {
    String fuettern();
}

interface streichelbar {
    String streicheln();
}

interface trainierbar {
    String trainieren();
}

interface zustand {
    default String zustand(Tier tier) { // setzt einen default Wert für zustand, der dann an die Beschreibung gehänggt wird um eine Allgemeine, kürzere Ausgabe der Tier-Statistiken zu haben
        return  "Name: " + tier.getName() + "\nEnergie: " + tier.getEnergie() + "\nGesundheit: " + tier.getGesundheit() + "\nZufriedenheit: " + tier.getZufriedenheit() + "\n";
    };
}
