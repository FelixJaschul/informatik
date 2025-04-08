package SpielDemo;

public class Heiler extends Spielfigur {
    // zusätzliche Attribute
    private int heilkraft;
    private int manaPoints;

    // Konstruktor mit super-Befehl
    public Heiler(String name, int lebenspunkte, int geschwindigkeit, int heilkraft, int manaPoints) {
        super(name, lebenspunkte, geschwindigkeit);
        this.heilkraft = heilkraft;
        this.manaPoints = manaPoints;
    }

    // Heilen-Methode
    public void heilen(Spielfigur ziel) {
        // Der Heiler heilt eine andere Figur um den Wert seiner Heilkraft
        if (manaPoints >= 10) {
            ziel.lebenspunkte = ziel.lebenspunkte + heilkraft;
            System.out.println(this.getName() + " hat " + ziel.getName() + " um " + this.heilkraft + " geheilt!");
        } else {
            System.out.println(this.getName() + " hat nicht mehr genug manaPoints!");
        } // end of if-else
        this.manaPoints = this.manaPoints - 10;
    }

    // Meditations-Methode zum Aufbau der manaPoints
    public void meditieren() {
        manaPoints += 10;
        System.out.println(this.getName() + " hat meditiert und 10 Manapunkte dazugewonnen.Er hat nun " + this.manaPoints + " ManaPoints.");
    }

    // Überschreiben der bewegen-Methode
    @Override
    public void bewegen() {
        System.out.println(name + " rennt heilend mit einer Geschwindigkeit von " + this.geschwindigkeit + " durch die Gegend.");
    }

    // Überschreiben der getInfo-Methode
    @Override
    public String getInfo() {
        return super.getInfo() +
                "\nKlasse: Heiler" +
                "\nHeilkraft: " + heilkraft +
                "\nmanaPoints: " + manaPoints;
    }
}
