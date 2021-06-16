package tree;

public class Node {
    int id;
    double data;
    Node leftNode;
    Node rightNode;

    public Node(int id, double data) {
        this.id = id;
        this.data = data;
    }
}