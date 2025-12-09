package Baumstrukturen;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private Knoten<T> root;

    /*
     * Interne Klasse Knoten
     */
    private class Knoten<T> {
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

    /*
     * Prüfmethode für leeren Baum
     */
    public boolean isEmpty() {
        return root == null;
    }

    /*
     * Getter und Setter für Wurzel und Teilbäume
     */
    public T getRootData() {
        return root != null ? root.data : null;
    }
    public void setRootData(T data) {
        if (root != null) root.data = data;
        else root = new Knoten<>(data);
    }
    public BinaryTree<T> getLeftSubtree() {
        BinaryTree<T> leftTree = new BinaryTree<>();
        if (root != null && root.left != null) leftTree.root = root.left;
        return leftTree;
    }
    public BinaryTree<T> getRightSubtree() {
        BinaryTree<T> rightTree = new BinaryTree<>();
        if (root != null && root.right != null) rightTree.root = root.right;
        return rightTree;
    }
    public void setLeftSubtree(BinaryTree<T> leftTree) {
        if (root != null) root.left = leftTree != null ? leftTree.root : null;
    }
    public void setRightSubtree(BinaryTree<T> rightTree) {
        if (root != null) root.right = rightTree != null ? rightTree.root : null;
    }

    /*
     * Prüfmethoden für Teilbäume
     */
    public boolean hasLeftSubtree() {
        return root != null && root.left != null;
    }
    public boolean hasRightSubtree() {
        return root != null && root.right != null;
    }

    /*
     * Baum-Operationen
     */
    public void clear() {
        root = null;
    }
    public void insertRoot(T rootData) {
        root = new Knoten<>(rootData);
    }

    /*
     * Traversierungsmethoden
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
    private void draw(Knoten<T> node, String prefix, boolean isRight) {
        if (node == null) return;

        draw(node.right, prefix + (isRight ? "│   " : "    "), false);
        System.out.println(prefix + (isRight ? "└── " : "┌── ") + node.data);
        draw(node.left, prefix + (isRight ? "    " : "│   "), true);
    }
}
