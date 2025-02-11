package src.Q2.Klassen.Zoo;

public class Loewe extends Tier implements fuetterbar, trainierbar, zustand {

    public Loewe(String name, int energie, int gesundheit, int zufriedenheit) {
        super(name, energie, gesundheit, zufriedenheit);
    }

    @Override
    public String macheGeraeusche() {
        return "DerBrüll!";
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein ein Löwe! \n" + zustand(this);
    }

    @Override
    public String fuettern() {
        super.setEnergie(super.getEnergie() + 10);
        return "Der Löwe hat fertig gegessen!";
    }

    @Override
    public String trainieren() {
        super.setEnergie(super.getEnergie() + 10);
        super.setGesundheit(super.getGesundheit() - 10);
        return "Der Löwe ist fertig!";
    }

    public static void main(String[] args) {
        Loewe loewe = new Loewe("König", 20, 20, 20);

        System.out.println(loewe.trainieren());
        System.out.println(loewe.fuettern());
        System.out.println(loewe.macheGeraeusche());
        System.out.println(loewe.getBeschreibung());
    }

}