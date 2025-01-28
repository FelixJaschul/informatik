// Felix Jaschul
// 23.01.2025
// Lösung zum 8-Damen-Problem

package src.Q2.Rekursion.DamenProblem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DamenSpiel {
    // Konstante für die Größe des Grids
    private static final int groesseGrid = 8;

    // GUI-Komponenten
    private static JFrame frame;
    private static JPanel gridPanel;
    private static JLabel[][] cells;  // 2D-Array für die Zellen des Grids

    // Liste aller Lösungen des 8-Damen-Problems
    private static final List<int[][]> loesungen = new ArrayList<>();
    private static int aktuelleLoesungIndex = 0;

    // Einstiegspunkt des Programms
    public static void main(String[] args) {
        int[][] board = new int[groesseGrid][groesseGrid];
        loeseAlleBoards(board, 0); // Startet die Rekursion // Lösungen generieren
        starteSpiel();
    }

    // Startet das Spiel
    public static void starteSpiel() {
        if (aktuelleLoesungIndex == 91) {
            System.out.println("92 Lösungen gefunden");
        }

        if (frame != null) {
            frame.dispose(); // Schließt das bestehende Fenster
        }

        if (loesungen.isEmpty()) {
            System.out.println("Keine Lösungen gefunden.");
            return;
        }

        int[][] board = loesungen.get(aktuelleLoesungIndex); // Aktuelle Lösung laden
        starteGUI(board); // Erstellt die GUI und zeigt das Board an
    }

    // Rekursive Methode zur Generierung aller Lösungen
    public static void loeseAlleBoards(int[][] board, int reihe) {
        if (reihe >= groesseGrid) {
            // Lösung gefunden, speichere sie in der Liste
            int[][] kopieBoard = new int[groesseGrid][groesseGrid];
            for (int i = 0; i < groesseGrid; i++) {
                System.arraycopy(board[i], 0, kopieBoard[i], 0, groesseGrid);
            }
            loesungen.add(kopieBoard);
            return;
        }

        for (int spalte = 0; spalte < groesseGrid; spalte++) {
            if (istValideNummer(board, reihe, spalte)) {
                board[reihe][spalte] = 1; // Setze eine Dame
                loeseAlleBoards(board, reihe + 1); // Rekursiver Aufruf für die nächste Reihe
                board[reihe][spalte] = 0; // Backtracking: Entferne die Dame
            }
        }
    }

    // Erstellt und zeigt die GUI
    public static void starteGUI(int[][] board) {
        int width = 800;
        int height = 800;

        frame = new JFrame("8 Damen Problem");
        Font font = new Font("Arial", Font.PLAIN, 24); // Font bearbeiten

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Anwendung beenden, wenn Fenster geschlossen wird
        frame.setSize(width, height);  // Größe des Fensters setzen

        gridPanel = new JPanel(new GridLayout(groesseGrid, groesseGrid)); // Rasterlayout für das Sudoku-Grid
        frame.add(gridPanel, BorderLayout.CENTER); // Hinzufügen des Grids in die Mitte des Fensters

        cells = new JLabel[groesseGrid][groesseGrid]; // Zellen-Array initialisieren

        // Erstellen der einzelnen Zellen des Damen-Boards
        for (int reihe = 0; reihe < groesseGrid; reihe++) {
            for (int spalte = 0; spalte < groesseGrid; spalte++) {
                cells[reihe][spalte] = new JLabel(
                        board[reihe][spalte] == 0 ? "" : "D", // "D" für Dame, leere Zellen bleiben leer
                        SwingConstants.CENTER // Text zentrieren
                );

                cells[reihe][spalte].setFont(font);

                if ((reihe + spalte) % 2 == 0) {
                    cells[reihe][spalte].setBackground(Color.LIGHT_GRAY);
                    cells[reihe][spalte].setOpaque(true);
                }

                cells[reihe][spalte].setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Rahmen für jede Zelle

                gridPanel.add(cells[reihe][spalte]);
            }
        }

        // Button zum Anzeigen des nächsten Problems
        JButton nextButton = new JButton("Nächste Lösung");
        nextButton.addActionListener(e -> {
            aktuelleLoesungIndex = (aktuelleLoesungIndex + 1) % loesungen.size(); // Nächste Lösung
            starteSpiel(); // Neues Board anzeigen
        }); nextButton.setBackground(Color.WHITE);

        frame.add(nextButton, BorderLayout.NORTH); // Button anordnen

        frame.setVisible(true); // Fenster sichtbar machen
    }

    // Prüft, ob bereits eine Dame in der Diagonalen / Spalte steht. (keine Reihe, da nach setzten der Dame, eh die Reihe gewechselt wird)
    public static boolean istValideNummer(int[][] board, int reihe, int spalte) {
        for (int i = 0; i < reihe; i++) { // Spalte
            if (board[i][spalte] == 1) {
                return false;
            }
        }

        for (int i = reihe, j = spalte; i >= 0 && j >= 0; i--, j--) { // Diagonale
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = reihe, j = spalte; i >= 0 && j < groesseGrid; i--, j++) { // Diagonale
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
