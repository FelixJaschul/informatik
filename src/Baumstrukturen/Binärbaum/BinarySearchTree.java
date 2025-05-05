package Baumstrukturen.Binärbaum;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private Knoten<T> root;

    /*
     * Interne Klasse Knoten
     */
    private static class Knoten<T> {
        T data;
        Knoten<T> left;
        Knoten<T> right;

        public Knoten(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*
     * Konstruktoren
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /*
     * Getter und Setter für die Wurzel
     */
    public Knoten<T> getRoot() {
        return root;
    }

    public void setRoot(Knoten<T> root) {
        this.root = root;
    }

    /*
     * Prüfmethode für leeren Baum
     */
    public boolean isEmpty() {
        return root == null;
    }

    /*
     * Prüfmethode für linken Teilbaum
     */
    public boolean isLeftSubtree() {
        return root != null && root.left != null;
    }

    /*
     * Prüfmethode für rechten Teilbaum
     */
    public boolean isRightSubtree() {
        return root != null && root.right != null;
    }

    /*
     * Getter und Setter für linken Teilbaum
     */
    public BinarySearchTree<T> getLeftSubtree() {
        BinarySearchTree<T> leftTree = new BinarySearchTree<>();
        if (root != null && root.left != null) leftTree.root = root.left;
        return leftTree;
    }

    public void setLeftSubtree(BinarySearchTree<T> leftTree) {
        if (root != null) root.left = leftTree.root;
    }

    /*
     * Getter und Setter für rechten Teilbaum
     */
    public BinarySearchTree<T> getRightSubtree() {
        BinarySearchTree<T> rightTree = new BinarySearchTree<>();
        if (root != null && root.right != null) rightTree.root = root.right;
        return rightTree;
    }

    public void setRightSubtree(BinarySearchTree<T> rightTree) {
        if (root != null) root.right = rightTree.root;
    }

    /*
     * Prüfmethode für linken Teilbaum
     */
    public boolean hasLeftSubtree() {
        return isLeftSubtree();
    }

    /*
     * Prüfmethode für rechten Teilbaum
     */
    public boolean hasRightSubtree() {
        return isRightSubtree();
    }

    /*
     * Löscht den Baum
     */
    public void clear() {
        root = null;
    }

    /*
     * Sortiermethoden mit Helfern um den Baum anzuzeigen
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }
    private void preorderTraversal(Knoten<T> node, List<T> result) {
        if (node != null) {
            result.add(node.data);
            preorderTraversal(node.left, result);
            preorderTraversal(node.right, result);
        }
    }

    public List<T> inorderTraversal() {
        List<T> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }
    private void inorderTraversal(Knoten<T> node, List<T> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.data);
            inorderTraversal(node.right, result);
        }
    }

    public List<T> postorderTraversal() {
        List<T> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }
    private void postorderTraversal(Knoten<T> node, List<T> result) {
        if (node != null) {
            postorderTraversal(node.left, result);
            postorderTraversal(node.right, result);
            result.add(node.data);
        }
    }

    /*
     * Baum durchsuchen
     */
    public boolean contains(T value) {
        return contains(root, value);
    }
    private boolean contains(Knoten<T> node, T value) {
        if (node == null) return false;

        int compareResult = value.compareTo(node.data);

        if (compareResult == 0) return true;
        else if (compareResult < 0) return contains(node.left, value);
        else return contains(node.right, value);
    }

    /*
     * Element einfügen
     */
    public void insert(T value) {
        root = insert(root, value);
    }
    private Knoten<T> insert(Knoten<T> node, T value) {
        if (node == null) return new Knoten<>(value);

        int compareResult = value.compareTo(node.data);

        return node;
    }

    /*
     * Element löschen
     */
    public void delete(T value) {
        root = delete(root, value);
    }
    private Knoten<T> delete(Knoten<T> node, T value) {
        if (node == null) return null;

        int compareResult = value.compareTo(node.data);

        return node;
    }

    /*
     * Tiefe berechnen
     */
    public int getDepth() {
        return getDepth(root);
    }
    private int getDepth(Knoten<T> node) {
        if (node == null) return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    /*
     * Zeichne den Baum
     */
    public void draw() {
        draw(root, "", true);
    }
    private void draw(Knoten<T> node, String prefix, boolean isRight) {
        if (node == null) return;

        draw(node.right, prefix + (isRight ? "│   " : "    "), false);
        System.out.println(prefix + (isRight ? "└── " : "┌── ") + node.data);
        draw(node.left, prefix + (isRight ? "    " : "│   "), true);
    }
}

class BSTMain {
    public static void main() {
        // Erstelle einen leeren Suchbaum
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Füge Elemente ein
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

        // Traversiere den Baum
        System.out.println("\nInorder Traversal:");
        List<Integer> inorder = bst.inorderTraversal();
        for (Integer value : inorder) {
            System.out.print(value + " ");
        }

        // Suche nach Elementen
        System.out.println("\n\nSuche nach 40: " + bst.contains(40));
        System.out.println("Suche nach 90: " + bst.contains(90));

        // Lösche ein Element
        System.out.println("\nLösche 30:");
        bst.delete(30);
        bst.draw();
    }
}
