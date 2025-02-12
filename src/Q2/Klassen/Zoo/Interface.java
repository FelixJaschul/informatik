package src.Q2.Klassen.Zoo;

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
    default String zustand(Tier tier) {
        return  "Name: " + tier.getName() + "\nEnergie: " + tier.getEnergie() + "\nGesundheit: " + tier.getGesundheit() + "\nZufriedenheit: " + tier.getZufriedenheit() + "\n";
    };
}
