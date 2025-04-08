package Baumstrukturen.QuadTree;

import java.util.ArrayList;
import java.util.List;

class Node {
    int x, y, value;

    Node(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

/* Using two points of Rectangular (Top,Left) & (Bottom , Right) */
class Boundry {
    public int getxMin() { return xMin; }

    public int getyMin() { return yMin; }

    public int getxMax() { return xMax; }

    public int getyMax() { return yMax; }

    public Boundry(int xMin, int yMin, int xMax, int yMax) {
        super();
         /* Storing two diagonal points */
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean inRange(int x, int y) {
        return (x >= this.getxMin() && x <= this.getxMax()
                && y >= this.getyMin() && y <= this.getyMax());
    }

    int xMin, yMin, xMax, yMax;

}

public class QuadTree {
    final int MAX_CAPACITY = 4;
    int level = 0;

    List<Node> nodes;
    QuadTree nw;
    QuadTree ne;
    QuadTree sw;
    QuadTree se;
    Boundry boundry;

    QuadTree(int level, Boundry boundry) {
        this.level = level;
        this.boundry = boundry;
        nodes = new ArrayList<Node>();
    }

    /* Traveling the Graph using Depth First Search */
    static void dfs(QuadTree tree) {
        if (tree == null) return;

        System.out.printf("\nLevel = %d [X1=%d Y1=%d] \t[X2=%d Y2=%d] ", tree.level, tree.boundry.getxMin(), tree.boundry.getyMin(), tree.boundry.getxMax(), tree.boundry.getyMax());

        for (Node node : tree.nodes) System.out.printf(" \n\t  x=%d y=%d", node.x, node.y);
        if (tree.nodes.isEmpty()) System.out.print(" \n\t  Leaf Node.");

        dfs(tree.nw);
        dfs(tree.ne);
        dfs(tree.sw);
        dfs(tree.se);

    }

    void split() {
        int xOffset = this.boundry.getxMin() + (this.boundry.getxMax() - this.boundry.getxMin()) / 2;
        int yOffset = this.boundry.getyMin() + (this.boundry.getyMax() - this.boundry.getyMin()) / 2;

        nw = new QuadTree(this.level + 1, new Boundry(this.boundry.getxMin(), this.boundry.getyMin(), xOffset, yOffset));
        ne = new QuadTree(this.level + 1, new Boundry(xOffset, this.boundry.getyMin(), xOffset, yOffset));
        sw = new QuadTree(this.level + 1, new Boundry(this.boundry.getxMin(), xOffset, xOffset, this.boundry.getyMax()));
        se = new QuadTree(this.level + 1, new Boundry(xOffset, yOffset, this.boundry.getxMax(), this.boundry.getyMax()));
    }

    void insert(int x, int y, int value) {
        if (!this.boundry.inRange(x, y)) return;

        Node node = new Node(x, y, value);
        if (nodes.size() < MAX_CAPACITY) {
            nodes.add(node);
            return;
        }
        // Exceeded the capacity so split it in FOUR
        if (nw == null) split();

        // Check coordinates belongs to which partition
        if (this.nw.boundry.inRange(x, y)) this.nw.insert(x, y, value);
        else if (this.ne.boundry.inRange(x, y)) this.ne.insert(x, y, value);
        else if (this.sw.boundry.inRange(x, y)) this.sw.insert(x, y, value);
        else if (this.se.boundry.inRange(x, y)) this.se.insert(x, y, value);
        else System.out.printf("ERROR : Unhandled partition %d %d", x, y);
    }
}
