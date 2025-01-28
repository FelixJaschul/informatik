// Felix Jaschul
// 20.01.2025
// Lösung zum Sudoku-Rätsel

package src.Q2.Rekursion;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SudokuSpiel {
    // Konstante für die Größe des Grids
    private static final int groesseGrid = 9;

    // GUI-Komponenten
    private static JFrame frame;
    private static JPanel gridPanel;
    private static JLabel[][] cells; // 2D-Array für die Zellen des Grids

    // Einstiegspunkt des Programms
    public static void main(String[] args) {
        starteSpiel();
    }

    // Startet das Spiel
    public static void starteSpiel() {
        // Startet das Spiel
        if (frame != null) {
            frame.dispose(); // Schließt das bestehende Fenster
        }

        int[][] board = new int[groesseGrid][groesseGrid]; // Leeres Sudoku-Board erstellen
        setzteRandomBoard(board, "Einfach"); // Einfach, Mittel, Schwer
        starteGUI(board); // Erstellt die GUI und zeigt das Board an
    }

    // Löst das Sudoku-Board
    private static boolean loeseBoard(int[][] board, boolean start) {
        Random random = new Random();

        for (int reihe = 0; reihe < groesseGrid; reihe++) {
            for (int spalte = 0; spalte < groesseGrid; spalte++) {
                if (board[reihe][spalte] == 0) { // Leere Zelle gefunden
                    for (int nummer = 1; nummer <= groesseGrid; nummer++) { // Zahlen 1 bis 9 testen
                        if (istValideNummer(board, nummer, reihe, spalte)) { // Prüfen, ob Zahl gültig ist
                            if (reihe == 0 && spalte == 0 && start) {
                                board[reihe][spalte] = random.nextInt(8) + 2;
                            } else {
                                board[reihe][spalte] = nummer; // Zahl setzen
                            }
                            updateBoard(board); // GUI aktualisieren

                            if (loeseBoard(board, false)) { // Rekursiver Aufruf
                                return true; // Lösung gefunden
                            }

                            board[reihe][spalte] = 0; // Rücknahme der Zahl
                            updateBoard(board); // GUI aktualisieren
                        }
                    }
                    return false; // Keine gültige Zahl gefunden
                }
            }
        }
        return true; // Board vollständig gelöst
    }

    // Aktualisiert das Sudoku-Board in der GUI
    private static void updateBoard(int[][] board) {
        SwingUtilities.invokeLater(() -> { // Änderungen im Event-Dispatch-Thread ausführen
            for (int reihe = 0; reihe < groesseGrid; reihe++) {
                for (int spalte = 0; spalte < groesseGrid; spalte++) {
                    if (cells != null) {
                        cells[reihe][spalte].setText(board[reihe][spalte] == 0 ? "" : String.valueOf(board[reihe][spalte])); // Zahlen anzeigen
                    }
                }
            }
        });
    }

    // Erstellt und zeigt die GUI
    public static void starteGUI(int[][] board) {
        int width = 800;
        int height = 800;

        frame = new JFrame("Sudoku");
        Font font = new Font("Arial", Font.PLAIN, 24); // Font bearbeiten

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Anwendung beenden, wenn Fenster geschlossen wird
        frame.setSize(width, height); // Größe des Fensters setzen

        gridPanel = new JPanel(new GridLayout(groesseGrid, groesseGrid)); // Rasterlayout für das Sudoku-Grid
        frame.add(gridPanel, BorderLayout.CENTER); // Hinzufügen des Grids in die Mitte des Fensters

        cells = new JLabel[groesseGrid][groesseGrid]; // Zellen-Array initialisieren

        // Erstellen der einzelnen Zellen des Sudoku-Boards
        for (int reihe = 0; reihe < groesseGrid; reihe++) {
            for (int spalte = 0; spalte < groesseGrid; spalte++) {
                cells[reihe][spalte] = new JLabel(
                        board[reihe][spalte] == 0 ? "" : String.valueOf(board[reihe][spalte]), // Leere Zellen bleiben leer und 1er werden in cells eingetragen
                        SwingConstants.CENTER // Text zentrieren
                );

                cells[reihe][spalte].setFont(font);

                cells[reihe][spalte].setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Rahmen für jede Zelle

                // Farbige Hervorhebung der 3x3-Blöcke
                if ((reihe / 3 + spalte / 3) % 2 == 0) { // Ungerade Blöcke werden grau gefärbt
                    cells[reihe][spalte].setBackground(Color.LIGHT_GRAY); // Abwechselnde Blöcke hellgrau färben
                    cells[reihe][spalte].setOpaque(true);// Hintergrund sichtbar machen
                }

                gridPanel.add(cells[reihe][spalte]); // Zelle zum Grid-Panel hinzufügen
            }
        }

        // Button zum Starten der Animation
        JButton startButton = new JButton("Löse Board");
        startButton.addActionListener(e -> new Thread(() -> loeseBoard(board, false)).start()); // Animation in separatem Thread starten
        startButton.setBackground(Color.WHITE);

        // Button zum resetten der Animation
        JButton resetButton = new JButton("Neues Board");
        resetButton.addActionListener(e -> starteSpiel());
        resetButton.setBackground(Color.WHITE);

        frame.add(resetButton, BorderLayout.NORTH); // Button anordnen
        frame.add(startButton, BorderLayout.SOUTH); // Button anordnen

        frame.setVisible(true); // Fenster sichtbar machen
    }

    // Generiert ein zufälliges Sudoku-Board
    public static void setzteRandomBoard(int[][] board, String schwierigkeit) {
        Random random = new Random();

        // Anzahl der vorgegebenen Zahlen basierend auf der Schwierigkeit
        int nummerSchwierigkeit = switch (schwierigkeit.toLowerCase()) {
            case "einfach" -> 40;
            case "mittel" -> 25;
            case "schwer" -> 15;
            default -> 25; // Standardwert
        };

        loeseBoard(board, true);

        // Entferne zufällige Zahlen basierend auf der Schwierigkeit
        for (int i = 0; i < groesseGrid * groesseGrid - nummerSchwierigkeit; i++) {
            int reihe = random.nextInt(9);
            int spalte = random.nextInt(9);
            board[reihe][spalte] = 0;
        }
    }

    // Prüft, ob eine Zahl an einer bestimmten Position gültig ist
    // Zusammenfassung der vorherigen istNummerInReihe, istNummerInSpalte und istNummerInBox
    private static boolean istValideNummer(int[][] board, int nummer, int reihe, int spalte) {
        for (int i = 0; i < groesseGrid; i++) {
            if (board[reihe][i] == nummer || board[i][spalte] == nummer) { // Überprüft Zeile und Spalte
                return false;
            }
        }

        // Überprüft 3x3-Block
        int boxRowStart = reihe - reihe % 3;
        int boxColStart = spalte - spalte % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == nummer) {
                    return false;
                }
            }
        }
        return true; // Zahl ist gültig
    }
}
