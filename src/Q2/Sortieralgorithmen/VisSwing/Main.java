package Q2.Sortieralgorithmen.VisSwing;

import javax.swing.*;

// Main class to start the application
class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortVisualizer(40, new Radix()));
    }
}
