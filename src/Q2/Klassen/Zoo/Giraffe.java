package src.Q2.Klassen.Zoo;

public class Giraffe extends Tier implements fuetterbar, zustand {

    public Giraffe(String name, int energie, int gesundheit, int zufriedenheit) {
        super(name, energie, gesundheit, zufriedenheit);
    }

    @Override
    public String macheGeraeusche() {
        return "Die Giraffe macht Geräusche!";
    }

    @Override
    public String getBeschreibung() {
        return "Ich bin ein ein Giraffe! \n" + zustand(this);
    }

    @Override
    public String fuettern() {
        super.setEnergie(super.getEnergie() + 10);
        return "Die Giraffe ist super satt.";
    }

    public static void main(String[] args) {
        Giraffe giraffe = new Giraffe("Giraffe", 20, 20, 20);

        System.out.println(giraffe.fuettern());
        System.out.println(giraffe.getBeschreibung());
    }

}