package linkedList;

import lombok.AllArgsConstructor;

public class Main {
    public static void main(String[] args) {
        var list = new LL();
        list.addAhead(new Node(1));
        list.addAhead(new Node(2));
        list.addAhead(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));

    }
}

/* custom double linked list with delimiter */

class LL {

    private final Node nil = new Node(0); // delimeter

    public Node first() {
        return nil.next;
    }

    public Node last() {
        return nil.prev;
    }

    public Node seek(Node node) {
        return seek(node, nil.next);
    }

    private Node seek(Node node, Node ptrNode) {
        if (ptrNode.id == node.id) return node;
        if (ptrNode.id == 0) return null;
        return seek(node, ptrNode.next);
    }

    public boolean isEmpty() {
        return nil.next == null;
    }

    public void addAheadFirstNode(Node newNode) {
        nil.next = newNode;
        newNode.prev = nil;
        nil.prev =  newNode;
        newNode.next = nil;
    }

    public void push(Node newNode) {
        if (nil.prev == null) {
            addAheadFirstNode(newNode);
            return;
        }
        Node nextNode = nil.prev;
        nil.prev = newNode;
        newNode.prev = nextNode;
        newNode.next = nil;
        nextNode.next = newNode;
    }
    public void addAhead(Node newNode) {
        if (nil.next == null) {
            addAheadFirstNode(newNode);
            return;
        }
        Node priorNode = nil.next;
        priorNode.prev = newNode;
        newNode.next = priorNode;
        nil.next = newNode;
        newNode.prev = nil;
    }
}


@AllArgsConstructor
class Node {

    public Node(int id) {
        this.id = id;
    }

    public int id;

    public Node next;
    public Node prev;
}