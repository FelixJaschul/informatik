package src.Q2.Klassen.Zoo;

public class Giraffe extends Tier implements fuetterbar, zustand {

    public Giraffe(String name, int energie, int gesundheit, int zufriedenheit) {
        super(name, energie, gesundheit, zufriedenheit);
    }

    @Override
    public String macheGeraeusche() { return "Die Giraffe macht Geräusche!"; }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein ein Giraffe! \n" + zustand(this);
    }

    @Override
    public String fuettern() {
        super.setEnergie(super.getEnergie() + 10);
        return "Die Giraffe ist super satt.";
    }

}