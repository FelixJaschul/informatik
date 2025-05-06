package Baumstrukturen.Binärbaum;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
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
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /*
     * Prüfmethode für linken Teilbaum
     */
    @Override
    public boolean isLeftSubtree() {
        return root != null && root.left != null;
    }

    /*
     * Prüfmethode für rechten Teilbaum
     */
    @Override
    public boolean isRightSubtree() {
        return root != null && root.right != null;
    }

    /*
     * Getter und Setter für linken Teilbaum
     */
    @Override
    public Tree<T> getLeftSubtree() {
        BinarySearchTree<T> leftTree = new BinarySearchTree<>();
        if (root != null && root.left != null) leftTree.root = root.left;
        return leftTree;
    }

    @Override
    public void setLeftSubtree(Tree<T> leftTree) {
        if (root != null && leftTree instanceof BinarySearchTree) {
            root.left = ((BinarySearchTree<T>) leftTree).getRoot();
        }
    }

    /*
     * Getter und Setter für rechten Teilbaum
     */
    @Override
    public Tree<T> getRightSubtree() {
        BinarySearchTree<T> rightTree = new BinarySearchTree<>();
        if (root != null && root.right != null) rightTree.root = root.right;
        return rightTree;
    }

    @Override
    public void setRightSubtree(Tree<T> rightTree) {
        if (root != null && rightTree instanceof BinarySearchTree) {
            root.right = ((BinarySearchTree<T>) rightTree).getRoot();
        }
    }

    /*
     * Prüfmethode für linken Teilbaum
     */
    @Override
    public boolean hasLeftSubtree() {
        return isLeftSubtree();
    }

    /*
     * Prüfmethode für rechten Teilbaum
     */
    @Override
    public boolean hasRightSubtree() {
        return isRightSubtree();
    }

    /*
     * Löscht den Baum
     */
    @Override
    public void clear() {
        root = null;
    }

    /*
     * Sortiermethoden mit Helfern um den Baum anzuzeigen
     */
    @Override
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

    @Override
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

    @Override
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
     * In den Baum einfügen
     */
    public void insert(T value) {
        if (root == null) { root = new Knoten<>(value); return; }
        insert(root, value);
    }

    private void insert(Knoten<T> node, T value) {
        if (value.equals(node.data)) return; // Wert bereits vorhanden

        if (value.compareTo(node.data) < 0) {
            // Wert ist kleiner, gehe nach links
            if (node.left == null) node.left = new Knoten<>(value);
            else insert(node.left, value);
        } else {
            // Wert ist größer, gehe nach rechts
            if (node.right == null) node.right = new Knoten<>(value);
            else insert(node.right, value);
        }
    }

    /*
     * Baum durchsuchen
     */
    @Override
    public boolean contains(T value) {
        return search(value) != null;
    }

    /*
     * Sucht nach einem Knoten mit dem angegebenen Wert
     */
    private Knoten<T> search(T value) {
        return search(root, value);
    }

    private Knoten<T> search(Knoten<T> node, T value) {
        if (node == null || value.equals(node.data)) return node;

        if (value.compareTo(node.data) < 0) return search(node.left, value);
        else return search(node.right, value);
    }

    /*
     * Findet den Knoten mit dem kleinsten Wert im Baum
     */
    private Knoten<T> getMinNode() {
        return getMinNode(root);
    }

    private Knoten<T> getMinNode(Knoten<T> node) {
        if (node == null) return null;

        while (node.left != null) node = node.left;
        return node;
    }

    /*
     * Findet den kleinsten Wert im Baum
     */
    public T getMinValue() {
        Knoten<T> minNode = getMinNode();
        return minNode != null ? minNode.data : null;
    }

    /*
     * Findet den Knoten mit dem größten Wert im Baum
     */
    private Knoten<T> getMaxNode() {
        return getMaxNode(root);
    }
    private Knoten<T> getMaxNode(Knoten<T> node) {
        if (node == null) return null;

        while (node.right != null) node = node.right;
        return node;
    }

    /*
     * Findet den größten Wert im Baum
     */
    public T getMaxValue() {
        Knoten<T> maxNode = getMaxNode();
        return maxNode != null ? maxNode.data : null;
    }

    /*
     * Löscht einen Knoten mit dem angegebenen Wert aus dem Baum
     */
    public boolean delete(T value) {
        // Speichern des ursprünglichen Wurzelknotens
        Knoten<T> originalRoot = root;

        // Löschen des Knotens
        root = delete(root, value);

        // Überprüfen, ob sich der Baum geändert hat
        return originalRoot != root || contains(value) == false;
    }

    private Knoten<T> delete(Knoten<T> node, T value) {
        if (node == null) return null;

        // Suche den zu löschenden Knoten
        if (value.compareTo(node.data) < 0) node.left = delete(node.left, value);
        else if (value.compareTo(node.data) > 0) node.right = delete(node.right, value);
        else {
            // Fall 1: keine Kinder
            if (node.left == null && node.right == null) return null;

            // Fall 2: Nur ein Kind
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Fall 3: Zwei Kinder
            // Finde den kleinsten Knoten im rechten Teilbaum (Inorder-Nachfolger)
            Knoten<T> successor = getMinNode(node.right);

            // Kopiere den Nachfolger-Wert in diesen Knoten
            node.data = successor.data;

            // Lösche den Nachfolger
            node.right = delete(node.right, successor.data);
        }

        return node;
    }

    /*
     * Tiefe berechnen
     */
    @Override
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
    @Override
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
