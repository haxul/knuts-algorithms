package redBlackTree;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static redBlackTree.Color.BLACK;
import static redBlackTree.Color.RED;


public class Main {
    public static void main(String[] args) {
        var tree = new RedBlackTree();
        tree.insert(new Node(50));
        tree.insert(new Node(150));
        System.out.println(tree);
    }
}

class RedBlackTree {
    public Node root;
    public Node nil;

    public RedBlackTree() {
        nil = new Node(0, BLACK, null);
        root = new Node(100, BLACK, nil);
    }

    public void insert(Node z) {
        Node y = nil;
        Node x = root;
        while (x != nil) {
            y = x;
            if (z.key  < x.key) x = x.left;
            else x = x.right;
        }
        z.p = y;
        if (y == nil) root = z;
        else if (z.key < y.key) y.left =z;
        else y.left = z;

        z.left = nil;
        z.right = nil;
        z.color = RED;
        insertFixup(z);
    }

    private void insertFixup(Node z) {
        while (z.p.color == RED) {
            if (z.p.equals(z.p.p.left)) {
                Node y = z.p.p.right;
                if (y.color == RED) {
                    z.p.color = BLACK;
                    y.color = BLACK;
                    z.p.p.color = RED;
                    z = z.p.p;
                } else if (z.equals(z.p.right)) {
                    z = z.p;
                    leftRotate(z);
                } else {
                    z.p.color = BLACK;
                    z.p.p.color = RED;
                    rightRotate(z);
                }
            }
        }
        root.color = BLACK;
    }

    public void rightRotate(Node x) {
        if (x.right == nil) throw new UnsupportedOperationException();
        Node y = x.left;
        x.left = y.right;
        if (y.right != nil) y.right.p = x;
        y.p = x.p;
        if (x.p == nil) root = y;
        else if (x.equals(x.p.right)) x.p.right = y;
        else x.p.left = y;
        y.right = x;
        x.p = y;
    }

    public void leftRotate(Node x) {
        if (x.right == nil) throw new UnsupportedOperationException();
        Node y = x.right;
        x.right = y.left;
        if (y.left != nil) y.left.p = x;
        y.p = x.p;
        if (x.p == nil) root = y;
        else if (x.equals(x.p.left)) x.p.left = y;
        else x.p.right = y;
        y.left = x;
        x.p = y;
    }


}

class Node implements Comparable<Node> {

    public Node(int key) {
        this.key = key;
    }

    public Node(int key, Color color, Node p) {
        this.key = key;
        this.color = color;
        this.p = p;
    }

    public Node left;
    public Node right;
    public Node p;
    public int key;
    public Color color;
    public int size; // subtree count

    @Override
    public int compareTo(@NotNull Node node) {
        if (this.key > node.key) return 1;
        else if (this.key < node.key) return -1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

enum Color {
    RED, BLACK
}
