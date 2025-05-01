package Baumstrukturen.Binärbaum;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
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
    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T rootData) {
        this.root = new Knoten<>(rootData);
    }

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        this.root = new Knoten<>(rootData);
        if (leftTree != null && !leftTree.isEmpty()) this.root.left = leftTree.root;
        if (rightTree != null && !rightTree.isEmpty()) this.root.right = rightTree.root;
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
     * Prüfmethode für linken Subbaum
     */
    public boolean isLeftSubtree() {
        return root != null && root.left != null;
    }

    /*
     * Prüfmethode für rechten Subbaum
     */
    public boolean isRightSubtree() {
        return root != null && root.right != null;
    }

    /*
     * Getter und Setter für linken Subbaum
     */
    public BinaryTree<T> getLeftSubtree() {
        BinaryTree<T> leftTree = new BinaryTree<>();
        if (root != null && root.left != null) leftTree.root = root.left;
        return leftTree;
    }

    public void setLeftSubtree(BinaryTree<T> leftTree) {
        if (root != null) root.left = leftTree.root;
    }

    /*
     * Getter und Setter für rechten Subbaum
     */
    public BinaryTree<T> getRightSubtree() {
        BinaryTree<T> rightTree = new BinaryTree<>();
        if (root != null && root.right != null) rightTree.root = root.right;
        return rightTree;
    }

    public void setRightSubtree(BinaryTree<T> rightTree) {
        if (root != null) root.right = rightTree.root;
    }

    /*
     * Prüfmethode für linken Subbaum
     */
    public boolean hasLeftSubtree() {
        return isLeftSubtree();
    }

    /*
     * Prüfmethode für rechten Subbaum
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
     * Fügt Wurzelknoten in leeren Baum ein
     */
    public void insertRoot(T data) {
        root = new Knoten<>(data);
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
        if (node.data.equals(value)) return true;
        return contains(node.left, value) || contains(node.right, value);
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
    private void draw(Knoten<T> node, String prefix, boolean isLeft) {
        if (node == null) return;

        draw(node.right, prefix + (isLeft ? "│   " : "    "), false); // -- chatgpt...
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.data);
        draw(node.left, prefix + (isLeft ? "    " : "│   "), true);
    }
}

class Main {
    public static void main(String[] args) {
        // Erstelle Hauptbaum mit Wurzel "A"
        BinaryTree<String> tree = new BinaryTree<>("A");

        // Erstelle linken und rechten Teilbaum
        BinaryTree<String> leftSubtree = new BinaryTree<>("B");
        BinaryTree<String> rightSubtree = new BinaryTree<>("C");

        // Füge Teilbäume zum Hauptbaum hinzu
        tree.setLeftSubtree(leftSubtree);
        tree.setRightSubtree(rightSubtree);

        // Füge weitere Knoten zum linken Teilbaum hinzu
        BinaryTree<String> leftLeft = new BinaryTree<>("D");
        BinaryTree<String> leftRight = new BinaryTree<>("E");
        leftSubtree.setLeftSubtree(leftLeft);
        leftSubtree.setRightSubtree(leftRight);

        // Zeichne den Baum
        System.out.println("\nBaumstruktur:");
        tree.draw();
    }
}
