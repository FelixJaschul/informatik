package Baumstrukturen.Binärbaum;

/*
 * Zentrale Main-Klasse für die Demonstration der Baumstrukturen
 */
public class TreeMain {
    /*
     * Hauptmethode zur Demonstration der Baumstrukturen
     */
    public static void main(String[] args) {
        System.out.println("=== Demonstration der Baumstrukturen ===");

        // Demonstration des BinaryTree
        demonstrateBinaryTree();

        // Demonstration des BinarySearchTree
        demonstrateBinarySearchTree();
    }

    /*
     * Demonstriert die Funktionalität des BinaryTree
     */
    private static void demonstrateBinaryTree() {
        System.out.println("\n=== BinaryTree Demonstration ===");

        // Erstelle Hauptbaum mit Wurzel "A"
        BinaryTree<String> tree = new BinaryTree<>("A");

        // Erstelle linken und rechten Teilbaum
        BinaryTree<String> rightTree = new BinaryTree<>("B");
        BinaryTree<String> leftTree = new BinaryTree<>("C");

        // Füge Teilbäume zum A hinzu
        tree.setLeftSubtree(rightTree);
        tree.setRightSubtree(leftTree);

        // Füge weitere Konten zum C Teilbaum hinzu
        BinaryTree<String> leftLeft = new BinaryTree<>("F");
        BinaryTree<String> leftRight = new BinaryTree<>("G");
        leftTree.setLeftSubtree(leftLeft);
        leftTree.setRightSubtree(leftRight);

        // Füge weitere Knoten zum B Teilbaum hinzu
        BinaryTree<String> rightLeft = new BinaryTree<>("D");
        BinaryTree<String> rightRight = new BinaryTree<>("E");
        rightTree.setLeftSubtree(rightLeft);
        rightTree.setRightSubtree(rightRight);

        // Füge weitere Knoten für F hinzu
        BinaryTree<String> leftLeftLeft = new BinaryTree<>("H");
        BinaryTree<String> leftLeftRight = new BinaryTree<>("I");
        leftLeft.setLeftSubtree(leftLeftLeft);
        leftLeft.setRightSubtree(leftLeftRight);

        // Füge weitere Knoten für G hinzu
        BinaryTree<String> leftRightLeft = new BinaryTree<>("J");
        BinaryTree<String> leftRightRight = new BinaryTree<>("K");
        leftRight.setLeftSubtree(leftRightLeft);
        leftRight.setRightSubtree(leftRightRight);

        // Füge weitere Knoten für D hinzu
        BinaryTree<String> rightLeftLeft = new BinaryTree<>("L");
        BinaryTree<String> rightLeftRight = new BinaryTree<>("M");
        rightLeft.setLeftSubtree(rightLeftLeft);
        rightLeft.setRightSubtree(rightLeftRight);

        // Füge weitere Knoten für E hinzu
        BinaryTree<String> rightRightLeft = new BinaryTree<>("N");
        BinaryTree<String> rightRightRight = new BinaryTree<>("O");
        rightRight.setLeftSubtree(rightRightLeft);
        rightRight.setRightSubtree(rightRightRight);

        // Zeichne den Baum
        System.out.println("\nBaumstruktur:");
        tree.draw();

        // Zeige Traversierungen
        System.out.println("\nPreorder Traversierung: " + tree.preorderTraversal());
        System.out.println("Inorder Traversierung: " + tree.inorderTraversal());
        System.out.println("Postorder Traversierung: " + tree.postorderTraversal());

        // Zeige weitere Informationen
        System.out.println("\nTiefe des Baums: " + tree.getDepth());
        System.out.println("Enthält 'A': " + tree.contains("A"));
        System.out.println("Enthält 'Z': " + tree.contains("Z"));
    }

    /*
     * Demonstriert die Funktionalität des BinarySearchTree
     */
    private static void demonstrateBinarySearchTree() {
        System.out.println("\n=== BinarySearchTree Demonstration ===");

        // Erstelle einen binären Suchbaum
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Füge Elemente hinzu
        System.out.println("\nFüge Elemente hinzu: 50, 30, 70, 20, 40, 60, 80");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Zeichne den Baum
        System.out.println("\nBaumstruktur:");
        bst.draw();

        // Zeige Traversierungen
        System.out.println("\nPreorder Traversierung: " + bst.preorderTraversal());
        System.out.println("Inorder Traversierung: " + bst.inorderTraversal());
        System.out.println("Postorder Traversierung: " + bst.postorderTraversal());

        // Zeige weitere Informationen
        System.out.println("\nTiefe des Baums: " + bst.getDepth());
        System.out.println("Enthält 40: " + bst.contains(40));
        System.out.println("Enthält 90: " + bst.contains(90));

        // Zeige Minimum und Maximum
        System.out.println("\nMinimum im Baum: " + bst.getMinValue());
        System.out.println("Maximum im Baum: " + bst.getMaxValue());

        // Demonstriere Löschen
        System.out.println("\n=== Löschen von Knoten ===");

        // Fall 1: Löschen eines Blattknotens (20)
        System.out.println("\nLösche Blattknoten 20:");
        bst.delete(20);
        bst.draw();

        // Fall 2: Löschen eines Knotens mit einem Kind (60)
        System.out.println("\nLösche Knoten 60 mit einem Kind:");
        bst.insert(55);  // Füge ein Kind zu 60 hinzu
        bst.draw();
        bst.delete(60);
        bst.draw();

        // Fall 3: Löschen eines Knotens mit zwei Kindern (30)
        System.out.println("\nLösche Knoten 30 mit zwei Kindern:");
        bst.delete(30);
        bst.draw();

        // Fall 4: Löschen der Wurzel
        System.out.println("\nLösche Wurzelknoten 50:");
        bst.delete(50);
        bst.draw();

        // Zeige Traversierungen nach dem Löschen
        System.out.println("\nInorder Traversierung nach dem Löschen: " + bst.inorderTraversal());
    }
}
