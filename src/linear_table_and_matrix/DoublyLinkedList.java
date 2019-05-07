package linear_table_and_matrix;

public class DoublyLinkedList {

    public static void main(String[] args) {

        Node node = new Node(1);
        addHead(node, new Node(2));
        addTail(node, new Node(3));
        addBefor(node, new Node(4));
        addAfter(node, new Node(5));

        deleteHead(node);
        deleteTail(node);
        node = deleteNode(node);

        Node p = getHead(node);
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }

        System.out.println(length(node));
    }

    public static class Node {
        public int value;
        public Node next;
        public Node last;

        public Node(int value) {
            this.value = value;
            next = null;
            last = null;
        }
    }

    public static void addHead(Node node1, Node node2) {
        Node head = getHead(node1);
        node2.next = head;
        head.last = node2;
    }

    public static void addTail(Node node1, Node node2) {
        Node tail = node1;
        while (tail.next != null) tail = tail.next;
        node2.last = tail;
        tail.next = node2;
    }

    public static void addBefor(Node node1, Node node2) {
        if (node1.last == null) {
            node2.next = node1;
            node1.last = node2;
        } else {
            node1.last.next = node2;
            node2.last = node1.last;
            node2.next = node1;
            node1.last = node2;
        }
    }

    public static void addAfter(Node node1, Node node2) {
        if (node1.next == null) {
            node2.last = node1;
            node1.next = node2;
        } else {
            node1.next.last = node2;
            node2.next = node1.next;
            node2.last = node1;
            node1.next = node2;
        }
    }

    public static Node deleteNode(Node node) {
        Node head = getHead(node);
        if (node.last == null) {
            head = node.next;
            node.next.last = null;
            node.next = null;
        } else if (node.next == null) {
            node.last.next = null;
            node.last = null;
        } else {
            node.last.next = node.next;
            node.next.last = node.last;
            node.next = null;
            node.last = null;
        }
        return head;
    }

    public static Node deleteHead(Node node) {
        return deleteNode(getHead(node));
    }

    public static Node deleteTail(Node node) {
        return deleteNode(getTail(node));
    }

    public static Node getHead(Node node) {
        Node head = node;
        while (head.last != null) head = head.last;
        return head;
    }

    public static Node getTail(Node node) {
        Node tail = node;
        while (tail.next != null) tail = tail.next;
        return tail;
    }

    public static int length(Node node) {
        Node head = getHead(node);
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
