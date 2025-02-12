package src.Q2.Klassen.Zoo;

public class Elefant extends Tier implements fuetterbar, zustand {

    public Elefant(String name, int energie, int gesundheit, int zufriedenheit) {
        super(name, energie, gesundheit, zufriedenheit);
    }

    @Override
    public String macheGeraeusche() { return "Der Elefant brüllt!"; }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein ein Elefant! \n" + zustand(this);
    }

    @Override
    public String fuettern() {
        super.setEnergie(super.getEnergie() + 10);
        return "Der Elefant pack kein Blatt mehr.";
    }

}