package SpielDemo;

// Zweite abgeleitete Klasse
public class Magier extends Spielfigur {
    // Zusätzliche Attribute für den Magier
    private int magiePunkte;
    private String zaubertyp;

    // Konstruktor mit super()-Aufruf
    public Magier(String name, int lebenspunkte, int geschwindigkeit, int magiePunkte, String zaubertyp) {
        super(name, lebenspunkte, geschwindigkeit);
        this.magiePunkte = magiePunkte;
        this.zaubertyp = zaubertyp;
    }

    // Zusätzliche Methode für den Magier
    public void zaubern(Spielfigur ziel) {
        if (magiePunkte >= 10) {
            int schaden = magiePunkte / 2;
            System.out.println(name + " wirkt einen " + zaubertyp + "-Zauber auf " + ziel.getName() + " und verursacht " + schaden + " Schaden!");
            ziel.nimmSchaden(schaden);
            magiePunkte -= 10;
        } else {
            System.out.println(name + " hat nicht genug Magiepunkte zum Zaubern!");
        }
    }

    // Methode zum Aufladen der Magiepunkte
    public void magiePunkteAufladen(int punkte) {
        magiePunkte += punkte;
        System.out.println(name + " lädt " + punkte + " Magiepunkte auf und hat jetzt " + magiePunkte + " Magiepunkte.");
    }

    // Überschriebene Methode (Override)
    @Override
    public void bewegen() {
        System.out.println(name + " schwebt mystisch mit Geschwindigkeit " + geschwindigkeit);
    }

    // Überschriebene getInfo()-Methode mit Erweiterung
    @Override
    public String getInfo() {
        return super.getInfo() +
                "\nKlasse: Magier" +
                "\nMagiepunkte: " + magiePunkte +
                "\nZaubertyp: " + zaubertyp;
    }
}
