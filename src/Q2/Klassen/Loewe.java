public class Loewe extends Tier implements fuetterbar, trainierbar {

    public Loewe(int energie, int gesundheit, int zufriedenheit) {
        super(energie, gesundheit, zufriedenheit);
    }

    @Override
    public static String macheGeraeusche() {
        return "Brüll!";
    }

    @Override
    public static String getBeschreibung() {
        return "Ich bin ein ein Löwe!";
    }

    @Override
    public static String fuettern() {
        loewe.setEnergie(this.energie + 10);
        return "Der Löwe trompetet";
    }

    public static void main(String[] args) {
        Loewe loewe = new Loewe("König", 20, 20, 20);
        System.out.println(fuettern());
    }
}