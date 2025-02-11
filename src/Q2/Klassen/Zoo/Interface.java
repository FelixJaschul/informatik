package src.Q2.Klassen.Zoo;

interface fuetterbar { String fuettern(); }

interface streichelbar { String streicheln(); }

interface trainierbar { String trainieren(); }

interface zustand {
    default String zustand(Tier tier) {
        return "Energie: " + tier.getEnergie() + "\n" + "Gesundheit: " + tier.getGesundheit() + "\n" + "Zufriedenheit: " + tier.getZufriedenheit();
    };
}
