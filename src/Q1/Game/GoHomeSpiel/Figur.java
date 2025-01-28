package src.Q1.Game.GoHomeSpiel;// Felix, Darek, Titus
// Spiel "Go Home" programmieren
// Klasse Figur programmieren

public class Figur {
    // Attribute für Figur festlegen
    private String farbe;
    private int x;
    private int y;

    public String getFarbe() {
        return farbe;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // geschlossener Konstruktor für Figur
    public Figur(String farbe, int x, int y) {
        this.farbe = farbe;
        this.x = x;
        this.y = y;
    }

    // bestimmen wie eine Figur gewinnt
    protected boolean gewonnen() {
        if (x == 2 && y == 2) {
            return true;
        } else {
            return false;
        }
    }

    // Bewegung der Figuren
    protected void gehe(int richtung) {
        //Richtungen oben, unten, links, rechts
        if (richtung == 0) {
            y--;
        }
        if (richtung == 1) {
            x--;
        }
        if (richtung == 2) {
            y++;
        }
        if (richtung == 3) {
            x++;
        }

        //  Wenn Spielfeldrand übertreten wird die Figur auf die andere Seite gesetzt
        if (x < 0) {
            x = 4;
        }
        if (x > 4) {
            x = 0;
        }
        if (y < 0) {
            y = 4;
        }
        if (y > 4) {
            y = 0;
        }
    }
}