package Sortieralgorithmen.VisSwing;

import Sortieralgorithmen.VisSwing.Sort.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SortVisualizer extends JFrame {

    private final int[] array;
    private SortAlgorithm algorithm;
    private final JPanel chartPanel;
    private int currentStep = 0;
    private final Timer timer;
    private boolean isRunning = false;
    private final int arraySize;
    private JPopupMenu popupMenu;
    private Color barColor = new Color(163, 191, 213);
    private Color highlightColor = barColor;

    public SortVisualizer(int size, SortAlgorithm algorithm) {
        // Create and shuffle array
        arraySize = size;
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

        // Create popup menu
        createPopupMenu();

        // Add mouse listener to chart panel for right-click events
        chartPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopupMenu(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopupMenu(e);
                }
            }
        });

        // Add chart panel to frame
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

    private void createPopupMenu() {
        // Creates Pop Up Menu for Settings, ...
        popupMenu = new JPopupMenu() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // white background
                g2d.setColor(new Color(255, 255, 255));
                g2d.fillRect(0, 0, getWidth(), getHeight());

                // Add a subtle border
                g2d.setColor(new Color(220, 220, 220));
                g2d.drawRect(0, 0, getWidth()-1, getHeight()-1);

                g2d.dispose();
            }

            // Override to ensure the popup doesn't paint outside our rounded rectangle
            @Override
            public void show(Component invoker, int x, int y) {
                // Set the popup menu to be non-opaque
                setOpaque(false);

                // Make all components in the popup non-opaque
                for (Component component : getComponents()) {
                    if (component instanceof JComponent) {
                        ((JComponent) component).setOpaque(false);
                    }
                }

                super.show(invoker, x, y);
            }
        };

        // Set border to create padding inside the rounded rectangle
        popupMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JMenu settingsMenu = createStyledMenu("Settings"); // Settings submenu
        JMenu colorMenu = createStyledMenu("Colors"); // Color settings submenu

        // Bar color options
        JMenuItem blueBarItem = createStyledMenuItem("Blue Bars");
        blueBarItem.addActionListener(e -> {
            barColor = new Color(163, 191, 213);
            highlightColor = barColor;
            // Force menu recreation to update highlight colors
            createPopupMenu();
            chartPanel.repaint();
        });

        JMenuItem greenBarItem = createStyledMenuItem("Green Bars");
        greenBarItem.addActionListener(e -> {
            barColor = new Color(144, 203, 144);
            highlightColor = barColor;
            // Force menu recreation to update highlight colors
            createPopupMenu();
            chartPanel.repaint();
        });

        JMenuItem redBarItem = createStyledMenuItem("Red Bars");
        redBarItem.addActionListener(e -> {
            barColor = new Color(203, 144, 144);
            highlightColor = barColor;
            // Force menu recreation to update highlight colors
            createPopupMenu();
            chartPanel.repaint();
        });

        // Add color options to color menu
        colorMenu.add(blueBarItem);
        colorMenu.add(greenBarItem);
        colorMenu.add(redBarItem);
        // Add color menu to settings menu
        settingsMenu.add(colorMenu);

        // Sorting Algorithms submenu
        JMenu algorithmsMenu = createStyledMenu("Sorting Algorithms");

        // Add all available sorting algorithms
        addAlgorithmMenuItem(algorithmsMenu, "Bubble Sort", new Bubble());
        addAlgorithmMenuItem(algorithmsMenu, "Heap Sort", new Heap());
        addAlgorithmMenuItem(algorithmsMenu, "Quick Sort", new Quick());
        addAlgorithmMenuItem(algorithmsMenu, "Merge Sort", new Merge());
        addAlgorithmMenuItem(algorithmsMenu, "Selection Sort", new Selection());
        addAlgorithmMenuItem(algorithmsMenu, "Bogo Sort", new Bogo());
        addAlgorithmMenuItem(algorithmsMenu, "Radix Sort", new Radix());

        // Restart menu item
        JMenuItem restartItem = createStyledMenuItem("Restart");
        restartItem.addActionListener(e -> {
            resetVisualization();
            timer.start();
            isRunning = true;
            chartPanel.repaint();
        });

        // Start/Pause menu item (dynamic text based on current state)
        JMenuItem startPauseItem = createStyledMenuItem(isRunning ? "Pause" : "Start");
        startPauseItem.addActionListener(e -> {
            toggleRunning();
            popupMenu.setVisible(false);
        });

        // Add all items to the popup menu
        popupMenu.add(settingsMenu);
        popupMenu.add(algorithmsMenu);

        // Custom separator with Apple-like styling
        popupMenu.add(createStyledSeparator());

        popupMenu.add(restartItem);
        popupMenu.add(startPauseItem);
    }

    // Helper method to create styled menu items
    private JMenuItem createStyledMenuItem(String text) {
        JMenuItem item = new JMenuItem(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Check if the item is selected (hovered)
                if (getModel().isArmed()) {
                    // Highlight color when hovered
                    g2d.setColor(highlightColor);
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                }

                // Draw text
                g2d.setColor(new Color(50, 50, 50));
                FontMetrics fm = g2d.getFontMetrics();
                int x = 10;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2d.drawString(getText(), x, y);

                g2d.dispose();
            }
        };

        // Set foreground color (not used in paintComponent but helps with UI manager)
        item.setForeground(new Color(50, 50, 50));

        // Remove default background and border
        item.setOpaque(false);
        item.setBorderPainted(false);
        item.setContentAreaFilled(false);

        // Add some padding
        item.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        return item;
    }

    // Helper method to create styled menus
    private JMenu createStyledMenu(String text) {
        JMenu menu = new JMenu(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Check if the menu is selected (hovered)
                if (getModel().isArmed() || getModel().isSelected()) {
                    // Highlight color when hovered (Apple-like light blue highlight)
                    g2d.setColor(highlightColor);
                    g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                }

                // Draw text
                g2d.setColor(new Color(50, 50, 50));
                FontMetrics fm = g2d.getFontMetrics();
                int x = 10;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g2d.drawString(getText(), x, y);

                g2d.dispose();
            }
        };

        // Set foreground color
        menu.setForeground(new Color(50, 50, 50));

        // Remove default background and border
        menu.setOpaque(false);
        menu.setBorderPainted(false);
        menu.setContentAreaFilled(false);

        // Add some padding
        menu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Style the popup menu that appears when clicking this menu
        JPopupMenu subMenu = menu.getPopupMenu();
        subMenu.setOpaque(false);
        subMenu.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Apply Apple-like styling to the submenu
        subMenu.setUI(new javax.swing.plaf.basic.BasicPopupMenuUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // white background
                g2d.setColor(new Color(255, 255, 255, 240));
                g2d.fillRect(0, 0, c.getWidth(), c.getHeight());

                // Add a subtle border
                g2d.setColor(new Color(220, 220, 220));
                g2d.drawRect(0, 0, c.getWidth()-1, c.getHeight()-1);

                g2d.dispose();

                // Paint the menu items
                super.paint(g, c);
            }
        });

        return menu;
    }

    // Helper method to create a styled separator
    private JSeparator createStyledSeparator() {
        JSeparator separator = new JSeparator() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw a subtle line
                g2d.setColor(new Color(200, 200, 200));
                g2d.drawLine(10, getHeight() / 2, getWidth() - 10, getHeight() / 2);

                g2d.dispose();
            }
        };

        // Set height for the separator
        separator.setPreferredSize(new Dimension(0, 10));
        separator.setOpaque(false);

        return separator;
    }

    private void addAlgorithmMenuItem(JMenu menu, String name, SortAlgorithm alg) {
        JMenuItem item = createStyledMenuItem(name);
        item.addActionListener(e -> {
            // Change the algorithm
            changeAlgorithm(alg);
        });
        menu.add(item);
    }

    private void changeAlgorithm(SortAlgorithm newAlgorithm) {
        // Stop current visualization
        timer.stop();
        isRunning = false;

        // Change algorithm
        algorithm = newAlgorithm;

        // Reset visualization with new algorithm
        resetVisualization();

        // Update title
        setTitle(algorithm.getName() + " Visualization");

        // Repaint
        chartPanel.repaint();
    }

    private void showPopupMenu(MouseEvent e) {
        // Recreate the popup menu to ensure it's updated with current state
        createPopupMenu();

        // Show the popup menu at the mouse position
        popupMenu.show(e.getComponent(), e.getX(), e.getY());
    }

    private void toggleRunning() {
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

        // Draw bars with current bar color
        for (int i = 0; i < percentages.length; i++) {
            int barHeight = (percentages[i] * height) / 100;
            g.setColor(barColor);
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
