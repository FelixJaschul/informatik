public class Giraffe extends Tier implements fuetterbar, trainierbar {

    public Giraffe(int energie, int gesundheit, int zufriedenheit) {
        super(energie, gesundheit, zufriedenheit);
    }

    @Override
    public static String macheGeraeusche() {
        return "Geräusch!";
    }

    @Override
    public static String getBeschreibung() {
        return "Ich bin ein eine Giraffe!";
    }

    @Override
    public static String fuettern() {
        giraffe.setEnergie(elefant.energie + 10);
        return "Die Giraffe isst";
    }

    public static void main(String[] args) {
        Giraffe giraffe = new Giraffe(20, 20, 20);
        System.out.println(fuettern());
    }
}