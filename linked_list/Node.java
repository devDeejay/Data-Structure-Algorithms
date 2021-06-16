package linked_list;

public class Node {
    String data;
    Node nextNode;

    Node(String data) {
        this.data = data;
    }

    void setNext(Node node) {
        this.nextNode = node;
    }

    void display() {
        System.out.print("[" + data + "] --> ");
    }
}
