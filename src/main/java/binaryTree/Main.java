package binaryTree;

public class Main {
    public static void main(String[] args) {
        var binTree = new BinaryTree();
        binTree.add(new Node(50));
        binTree.add(new Node(25));
        binTree.add(new Node(51));
        binTree.add(new Node(101));
        System.out.println(binTree.search(new Node(23)));
    }
}


// binary tree

class BinaryTree {
    private final Node root = new Node(100);

    public Node search(Node sNode) {
        return search(sNode, root);
    }

    private Node search(Node sNode, Node curNode) {
        if (curNode == null ) return null;
        if (curNode.id == sNode.id) return curNode;
        if ( sNode.id < curNode.id) return search(sNode, curNode.left);
        else return search(sNode, curNode.right);
    }

    public void inorderTreeWalk() {
        inorderTreeWalk(root);
    }

    private void inorderTreeWalk(Node node) {
        if (node != null) {
            inorderTreeWalk(node.left);
            System.out.println("Node (" + node.id + ")");
            inorderTreeWalk(node.right);
        }
    }


    public Node add(Node node) {
        return add(node, root);
    }

    private Node add(Node newNode, Node curNode) {
        if (curNode.left == null && curNode.right == null) {
            if (newNode.id >= curNode.id) curNode.right = newNode;
            else curNode.left = newNode;
            return newNode;
        }
        if (newNode.id >= curNode.id) {
            if (curNode.right == null) {
                curNode.right = newNode;
                return newNode;
            } else return add(newNode, curNode.right);
        } else {
            if (curNode.left == null) {
                curNode.left = newNode;
                return newNode;
            } else return add(newNode, curNode.left);
        }
    }
}


class Node {

    public Node(int id) {
        this.id = id;
    }

    public int id;
    public Node left;
    public Node right;
}