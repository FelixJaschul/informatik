package Klassen.Zoo;

public class Giraffe extends Tier implements fuetterbar, zustand {

    public Giraffe(String name) {
        super(name);
    }

    @Override
    public String macheGeraeusche() { 
        return "Die Giraffe macht Geräusche!"; 
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein Giraffe! \n" + zustand(this);
    }

    @Override
    public String fuettern(String futter) {
        super.setEnergie(super.getEnergie() + 10);
        return "Die Giraffe ist super satt.";
    }

}