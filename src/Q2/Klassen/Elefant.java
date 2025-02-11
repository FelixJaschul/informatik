public class Elefant extends Tier implements fuetterbar {

    public Elefant(int energie, int gesundheit, int zufriedenheit) {
        super(energie, gesundheit, zufriedenheit);
    }

    @Override
    public static String macheGeraeusche() {
        return "Brüll!";
    }

    @Override
    public static String getBeschreibung() {
        return "Ich bin ein ein Elefant!";
    }

    @Override
    public static String fuettern() {
        elefant.setEnergie(elefant.energie + 10);
        return "Der Elefant trompetet";
    }

    public static void main(String[] args) {
        Elefant elefant = new Elefant("Benjamin", 20, 20, 20);
        System.out.println(fuettern());
    }
}