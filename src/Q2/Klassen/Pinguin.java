public class Pinguin extends Tier implements fuetterbar, streichelbar {

    public Pinguin(int energie, int gesundheit, int zufriedenheit) {
        super(energie, gesundheit, zufriedenheit);
    }

    @Override
    public static String macheGeraeusche() {
        return "Schrei!";
    }

    @Override
    public static String getBeschreibung() {
        return "Ich bin ein ein Pinguin!";
    }

    @Override
    public static String fuettern() {
        pinguin.setEnergie(pinguin.energie + 10);
        return "Der Pinguin schreit";
    }

    public static void main(String[] args) {
        Pinguin pinguin = new Pinguin("Skipper", 20, 20, 20);
        System.out.println(fuettern());
    }
}