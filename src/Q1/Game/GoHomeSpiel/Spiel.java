// Felix, Darek, Titus
// Spiel "Go Home" programmieren
// Klasse "Spiel" programmieren

package src.Q1.Game.GoHomeSpiel;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Spiel {
    private Figur f1;
    private Figur f2;

    private Figur aktuelleFigur1;
    private Figur aktuelleFigur2;
    private Figur aktuellerSpieler;

    // Bewegungsrichtungen
    private final String[] bewegung = {"oben", "unten", "rechts", "links"};

    // Ablauf des Spiels
    public void mainSpiel() {
        spiel();
        druckeGewinner();
        System.out.println("Danke fürs spielen");
    }

    // Methode "spiel" bestimmt wie eine Runde abläuft
    private void spiel() {
        this.f1 = new Figur("blau", 0, 0);
        this.f2 = new Figur("rot", 4, 4);

        // Solange wiederholen bis es einen gewinner gibt
        while (spielIstFertig()) {
            druckeSpielfeld();
            neuenZugVorbereiten();
            druckeAktuellenSpieler();
            druckeAktuelleFiguren();
            richtungAuswahl();
        }
    }

    // ausgeben des Gewinners
    private void druckeGewinner() {
        // Darek
        if (f1.gewonnen()) {
            System.out.println("Der Spieler mit der Farbe " + f1.getFarbe() + " hat gewonnen.");
        }
        if (f2.gewonnen()) {
            System.out.println("Der Spieler mit der Farbe " + f2.getFarbe() + " hat gewonnen.");
        } else {
            System.out.println("Es gibt keinen Gewinner.");
        }
    }

    // Aktuellen spieler ausgeben
    private void druckeAktuellenSpieler() {
        // Felix
        if (aktuellerSpieler != null) {
            System.out.println("Am Zug ist " + aktuellerSpieler.getFarbe());
        }
    }

    // Aktuelle Figuren ausgeben
    private void druckeAktuelleFiguren() {
        // Felix
        System.out.println("Bewege " + aktuelleFigur1.getFarbe() + " und " + aktuelleFigur2.getFarbe());
    }


    private void druckeSpielfeld() {
        // Felix
        // Spielfeld festlegen, durch doppelte for-schleife, die zuerst die Y-Achse durchgeht und dann die X-Achse
        for (int y = 0; y <= 4; y++) {
            for (int x = 0; x <= 4; x++) {
                if (x == 2 && y == 2 && spielIstFertig()) {
                    System.out.print("X ");

                } else if (f1.getX() == x && f1.getY() == y && f2.getX() == x && f2.getY() == y) { // B und R stehen auf dem selben Feld
                    System.out.print("BR ");

                } else if (f1.getX() == x && f1.getY() == y) { // Ausgabe für das Feld von B
                    System.out.print("B ");

                } else if (f2.getX() == x && f2.getY() == y) { // Ausgabe für das Feld von R
                    System.out.print("R ");

                } else { // Restliche Felder
                    System.out.print(". ");
                }

                if (x == 4) { // erstellt den Zeilenumbruch
                    System.out.println();
                }
            }
        }
    }

    // Bewegen der Figuren durch die nummern 0, 1, 2, 3 die in der Klasse Figur festgelegt wurden.
    private void nachObenBewegen(Figur spieler) {
        // Darek
        spieler.gehe(0);
    }

    private void nachLinksBewegen(Figur spieler) {
        // Darek
        spieler.gehe(1);
    }

    private void nachUntenBewegen(Figur spieler) {
        // Darek
        spieler.gehe(2);
    }

    private void nachRechtsBewegen(Figur spieler) {
        // Darek
        spieler.gehe(3);
    }

    // Figuren durch Zufall auslosen
    private void muenzenWerfen() {
        // Titus
        Random random = new Random();
        int i = random.nextInt(2); //gibt entweder 0 oder 1 aus

        if (i == 0) {
            aktuelleFigur1 = f1;
        } else {
            aktuelleFigur1 = f2;
        }

        int j = random.nextInt(2); //zweiter Münzen wurf

        if (j == 0) {
            aktuelleFigur2 = f1;
        } else {
            aktuelleFigur2 = f2;
        }
    }

    // Überprüft, ob einer der Spieler auf dem Home-Feld steht
    private boolean spielIstFertig() {
        // Felix
        return !f1.gewonnen() && !f2.gewonnen();
    }

    // Wechselt den aktuellen Spieler
    private void setzeNeuenSpieler() {
        // Darek
        if (aktuellerSpieler == f1) {
            aktuellerSpieler = f2;
        } else {
            aktuellerSpieler = f1;
        }
    }

    // Nächster Zug wird ausgeführt
    private void neuenZugVorbereiten() {
        // Titus
        muenzenWerfen();
        setzeNeuenSpieler();
    }

    // Ausführen der Bewegung der Figur, durch Eingabe des Spielers
    private void richtungFiguren(Figur spieler, String richtung) {
        // Team
        switch (richtung) {
            case "oben" -> nachObenBewegen(spieler);
            case "unten" -> nachUntenBewegen(spieler);
            case "rechts" -> nachRechtsBewegen(spieler);
            case "links" -> nachLinksBewegen(spieler);
            default -> System.out.println();
        }
    }

    // Schaut sich die Eingabe des Spielers an und führt die Bewegung aus
    private void richtungAuswahl() {
        // Team
        Scanner scanner = new Scanner (System.in);
        System.out.println("Schreibe in welche Richtung die Figuren gehen sollen, verwende Links, Rechts, Oben, Unten.");
        String richtung = scanner.nextLine().toLowerCase(); // nimmt die Eingabe auf

        if (Arrays.asList(bewegung).contains(richtung)) { // wird bei korrekter Eingabe ausgeführt
            richtungFiguren(aktuelleFigur1, richtung);
            richtungFiguren(aktuelleFigur2, richtung);
        } else {
            System.out.println("Bitte richtigen Wert eintragen."); // wird bei falscher Eingabe ausgegeben
        }
    }
}