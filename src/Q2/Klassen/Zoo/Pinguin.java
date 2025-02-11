package src.Q2.Klassen.Zoo;

public class Pinguin extends Tier implements streichelbar, zustand {

    public Pinguin(String name, int energie, int gesundheit, int zufriedenheit) {
        super(name, energie, gesundheit, zufriedenheit);
    }

    @Override
    public String macheGeraeusche() {
        return "Schrei!";
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein ein Pinguin! \n" + zustand(this);
    }

    @Override
    public String streicheln() {
        super.setZufriedenheit(super.getZufriedenheit() + 10);
        return "Dem Pinguin geht es super!";
    }

    public static void main(String[] args) {
        Pinguin pinguin = new Pinguin("Skipper", 20, 20, 20);

        System.out.println(pinguin.streicheln());
        System.out.println(pinguin.getBeschreibung());
    }

}