package SpielDemo;

// Erste abgeleitete Klasse
public class Krieger extends Spielfigur {
    // Zusätzliche Attribute für den Krieger
    private int staerke;
    private String waffe;

    // Konstruktor mit super()-Aufruf
    public Krieger(String name, int lebenspunkte, int geschwindigkeit, int staerke, String waffe) {
        super(name, lebenspunkte, geschwindigkeit); // Aufruf des Konstruktors der Elternklasse
        this.staerke = staerke;
        this.waffe = waffe;
    }

    // Zusätzliche Methode für den Krieger
    public void angreifen(Spielfigur ziel) {
        int schaden = staerke * 2;
        System.out.println(name + " greift " + ziel.getName() + " mit " + waffe + " an und verursacht " + schaden + " Schaden!");
        ziel.nimmSchaden(schaden);
    }

    // Überschriebene Methode (Override)
    @Override
    public void bewegen() {
        System.out.println(name + " marschiert mit schwerer Rüstung mit Geschwindigkeit " + geschwindigkeit);
    }

    // Überschriebene getInfo()-Methode mit Erweiterung
    @Override
    public String getInfo() {
        return super.getInfo() +
                "\nKlasse: Krieger" +
                "\nStärke: " + staerke +
                "\nWaffe: " + waffe;
    }
}