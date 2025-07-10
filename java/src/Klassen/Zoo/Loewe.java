package Klassen.Zoo;

public class Loewe extends Tier implements fuetterbar, trainierbar, schwimmfaehig, zustand {

    public Loewe(String name) {
        super(name);
    }

    @Override
    public String macheGeraeusche() {
        return "Der Löwe brüllt!";
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein Löwe! \n" + zustand(this);
    }

    @Override
    public String fuettern(String futter) {
        super.setEnergie(getEnergie() + 10);
        return "Der Löwe hat fertig gegessen!";
    }

    @Override
    public String trainieren() {
        setEnergie(getEnergie() - 10);
        setGesundheit(getGesundheit() - 10);
        setZufriedenheit(getZufriedenheit() + 10);
        return "Der Löwe ist fertig!";
    }

    @Override
    public String schwimmen() {
        setEnergie(getEnergie() - 10);
        setGesundheit(getGesundheit() + 10);
        return "Der Löwe ist ein guter schwimmer! ";
    }

}