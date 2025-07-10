package Klassen.Zoo;

public class Gorilla extends Tier implements fuetterbar, trainierbar, zustand {

    public Gorilla(String name) {
        super(name);
    }

    @Override
    public String macheGeraeusche() { 
        return "Der Gorilla brüllt!";
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein Gorilla! \n" + zustand(this);
    }

    @Override
    public String fuettern(String futter) {
        super.setEnergie(super.getEnergie() + 10);
        return "Der Gorilla ist satt.";
    }

    @Override
    public String trainieren() {
        setEnergie(getEnergie() - 10);
        setGesundheit(getGesundheit() - 10);
        setZufriedenheit(getZufriedenheit() + 10);
        return "Der Gorilla ist fertig mit trainieren!";
    }

}