package Baumstrukturen.Binärbaum;

import java.util.List;

/**
 * Interface for tree data structures
 * @param <T> Type of elements stored in the tree
 */
public interface Tree<T> {
    /**
     * Checks if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Clears the tree
     */
    void clear();

    /**
     * Checks if the tree contains a value
     * @param value the value to check
     * @return true if the tree contains the value, false otherwise
     */
    boolean contains(T value);

    /**
     * Gets the depth of the tree
     * @return the depth of the tree
     */
    int getDepth();

    /**
     * Draws the tree structure
     */
    void draw();

    /**
     * Traverses the tree in preorder
     * @return a list of elements in preorder
     */
    List<T> preorderTraversal();

    /**
     * Traverses the tree in inorder
     * @return a list of elements in inorder
     */
    List<T> inorderTraversal();

    /**
     * Traverses the tree in postorder
     * @return a list of elements in postorder
     */
    List<T> postorderTraversal();

    /**
     * Checks if the tree has a left subtree
     * @return true if the tree has a left subtree, false otherwise
     */
    boolean hasLeftSubtree();

    /**
     * Checks if the tree has a right subtree
     * @return true if the tree has a right subtree, false otherwise
     */
    boolean hasRightSubtree();

    /**
     * Gets the left subtree
     * @return the left subtree
     */
    Tree<T> getLeftSubtree();

    /**
     * Gets the right subtree
     * @return the right subtree
     */
    Tree<T> getRightSubtree();

    /**
     * Sets the left subtree
     * @param leftTree the left subtree to set
     */
    void setLeftSubtree(Tree<T> leftTree);

    /**
     * Sets the right subtree
     * @param rightTree the right subtree to set
     */
    void setRightSubtree(Tree<T> rightTree);

    /**
     * Checks if the tree has a left subtree (alias for hasLeftSubtree)
     * @return true if the tree has a left subtree, false otherwise
     */
    default boolean isLeftSubtree() {
        return hasLeftSubtree();
    }

    /**
     * Checks if the tree has a right subtree (alias for hasRightSubtree)
     * @return true if the tree has a right subtree, false otherwise
     */
    default boolean isRightSubtree() {
        return hasRightSubtree();
    }
}
