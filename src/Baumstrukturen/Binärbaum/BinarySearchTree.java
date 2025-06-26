package Baumstrukturen.Binärbaum;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
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
     * Konstruktor
     */
    public BinarySearchTree() {
        root = null;
    }

    /*
     * Insert- Methode
     */
    public void insert(T value) {
        root = insert(root, value);
    }
    private Knoten<T> insert(Knoten<T> node, T value) {
        if (node == null) return new Knoten<>(value);
        else if (node.data.compareTo(value) > 0) node.left = insert(node.left, value);
        else if (node.data.compareTo(value) < 0) node.right = insert(node.right, value);
        return node;
    }

    /*
     * Lösch- Methode
     */
    public void delete(T value) {
        root = delete(root, value);
    }
    private Knoten<T> delete(Knoten<T> node, T value) {
        if (node == null) return null;

        if (node.data.compareTo(value) > 0) node.left = delete(node.left, value);
        else if (node.data.compareTo(value) < 0) node.right = delete(node.right, value);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            node.data = min(node.right);
            node.right = delete(node.right, min(node.right));
        }
        return node;
    }

    /*
     * FindMin- Methode
     */
    public T min() {
        return min(root);
    }
    private T min(Knoten<T> node) {
        if (node == null) return null;
        if (node.left == null) return node.data;
        return min(node.left);
    }

    /*
     * FindMax- Methode
     */
    public T max() {
        return max(root);
    }
    private T max(Knoten<T> node) {
        if (node == null) return null;
        if (node.right == null) return node.data;
        return max(node.right);
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
