package Klassen.Zoo;

public class Pinguin extends Tier implements streichelbar, schwimmfaehig, zustand {

    public Pinguin(String name) {
        super(name);
    }

    @Override
    public String macheGeraeusche() {
        return "Der Pinguin schreit!";
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein Pinguin! \n" + zustand(this);
    }

    @Override
    public String streicheln() {
        super.setZufriedenheit(super.getZufriedenheit() + 10);
        return "Dem Pinguin geht es super!";
    }


    @Override
    public String schwimmen() {
        setEnergie(getEnergie() - 10);
        setGesundheit(getGesundheit() + 10);
        return "Der Pinguin ist ein guter schwimmer! ";
    }

}