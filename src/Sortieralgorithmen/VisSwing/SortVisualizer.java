package Sortieralgorithmen.VisSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class SortVisualizer extends JFrame {

    private final int[] array;
    private final SortAlgorithm algorithm;
    private final JPanel chartPanel;
    private int currentStep = 0;
    private final Timer timer;
    private boolean isRunning = false;

    public SortVisualizer(int size, SortAlgorithm algorithm) {
        // Create and shuffle array
        array = createShuffledArray(size);
        this.algorithm = algorithm;

        // Set up the frame
        setTitle(algorithm.getName() + " Visualization");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Create chart panel with original white background
        chartPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawChart(g);

                // Draw the green circle if isRunning is true
                if (isRunning) drawCircle(g);
            }
        };
        chartPanel.setBackground(Color.WHITE);

        // Add mouse listener to chart panel for click events
        chartPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleScreenClick();
            }
        });

        // No status labels needed

        // Add chart panel to frame (no status panel)
        add(chartPanel, BorderLayout.CENTER);

        // Set up timer for animation
        // milliseconds between micro-steps
        int DELAY = 20;
        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performMicroStep();
            }
        });

        // Initialize
        algorithm.resetForNewStep(array, currentStep);

        // Show the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleScreenClick() {
        // If sorting is complete, restart
        if (isSorted()) {
            resetVisualization();
            timer.start();
            isRunning = true;
            return;
        }

        // Otherwise toggle between running and paused
        if (!isRunning) {
            // Start the visualization
            timer.start();
            isRunning = true;
        } else {
            // Stop the visualization
            timer.stop();
            isRunning = false;
        }
        chartPanel.repaint();
    }

    private void drawCircle(Graphics g) {
        int radius = 5;
        int x = 10; // chartPanel.getWidth() - radius - 10 => put this if top right
        int y = 10; // chartPanel.getHeight() - radius - 10 ==> put both if bottom right

        g.setColor(Color.GREEN);
        g.fillOval(x, y, radius * 2, radius * 2);
    }

    private void performMicroStep() {
        boolean stepCompleted = algorithm.microStep(array);

        if (stepCompleted) {
            currentStep++;
            if (isSorted()) {
                timer.stop();
                isRunning = false;
            } else {
                algorithm.resetForNewStep(array, currentStep);
            }
        }

        chartPanel.repaint();
    }

    private void resetVisualization() {
        timer.stop();
        isRunning = false;
        currentStep = 0;

        // Reset array
        int[] newArray = createShuffledArray(array.length);
        System.arraycopy(newArray, 0, array, 0, array.length);

        // Reset algorithm
        algorithm.resetForNewStep(array, currentStep);

        chartPanel.repaint();
    }

    private void drawChart(Graphics g) {
        int[] sums = Chart.getSums(array);
        int[] percentages = Chart.getPercentages(sums);

        int width = chartPanel.getWidth();
        int height = chartPanel.getHeight();
        int barWidth = width / sums.length;

        // Draw bars with original color
        for (int i = 0; i < percentages.length; i++) {
            int barHeight = (percentages[i] * height) / 100;
            g.setColor(new Color(163, 191, 213));
            g.fillRect(i * barWidth, height - barHeight, barWidth - 1, barHeight);
        }
    }

    private boolean isSorted() {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }

    private int[] createShuffledArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = i + 1; // Values from 1 to size

        // Shuffle the array (Fisher-Yates algorithm)
        java.util.Random rnd = new java.util.Random();
        for (int i = size - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Swap
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
