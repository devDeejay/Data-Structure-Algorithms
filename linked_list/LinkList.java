package linked_list;

public class LinkList {

    Node startNode;

    LinkList() {
        this.startNode = null;
    }

    boolean isEmpty() {
        return this.startNode == null;
    }

    void appendNode(Node node) {
        if (this.isEmpty()) {
            this.startNode = node;
        } else {
            Node currentNode = startNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }
    }

    void insertFirst(Node node) {
        node.nextNode = this.startNode;
        this.startNode = node;
    }

    void deleteFirst() {
        this.startNode = startNode.nextNode;
    }

    void displayList() {
        Node currentNode = startNode;
        while (currentNode != null) {
            currentNode.display();
            currentNode = currentNode.nextNode;
        }
        System.out.println();
    }

    void insertBefore(String data, Node node) {
        Node currentNode = this.startNode;
        while(!currentNode.nextNode.data.equals(data)) {
            currentNode = currentNode.nextNode;
            if(currentNode == null) {
                return;
            }
        }
        node.nextNode = currentNode.nextNode;
        currentNode.nextNode = node;
    }

    void deleteNode(Node node) {
        Node currentNode = this.startNode;
        Node previousNode = currentNode;
        while(!currentNode.data.equals(node.data)) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
            if(currentNode == null) {
                return;
            }
        }
        previousNode.nextNode = currentNode.nextNode;
    }
}
