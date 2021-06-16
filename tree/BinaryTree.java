package tree;

public class BinaryTree {
    Node rootNode;

    Node find(int key) {
        // Starting from the root node
        Node current = rootNode;

        while (current.data != key) {
            if (key < current.data) {
                // Should we check the left subtree?
                current = current.leftNode;
            } else {
                // Should we check the right subtree?
                current = current.rightNode;
            }
            // If we have reached the leaf node, exit and return null
            if (current == null) {
                return null;
            }
        }
        // If the loop was broken, then the element was found, hence return the element
        return current;
    }

    void insert(int id, double data) {
        // Create the new node
        Node newNode = new Node(id, data);

        // Checking if parent exists
        if (rootNode == null) {
            // If not, our newNode becomes the parent
            rootNode = newNode;
        } else {
            // Else, we have to find the correct place.
            Node currentNode = rootNode;
            Node parentNode;
            while (true) {

                // Mark our current node as parent, as we will move towards its child and check there
                parentNode = currentNode;

                // Should we move to Left node?
                if (data < currentNode.data) {

                    // Updating our current node
                    currentNode = currentNode.leftNode;

                    // Checking if this node exists or not
                    if (currentNode == null) {
                        // If not, then our node fits here
                        parentNode.leftNode = newNode;
                        break;
                    }

                } else {

                    // Else, we move to the right node
                    currentNode = currentNode.rightNode;

                    // If node is null, our newNode fits here
                    if (currentNode == null) {
                        parentNode.rightNode = newNode;
                        break;
                    }
                }
            }
        }
    }

    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.leftNode);
            System.out.println(node.data);
            inOrderTraversal(node.rightNode);
        }
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrderTraversal(node.leftNode);
            preOrderTraversal(node.rightNode);
        }
    }

    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.leftNode);
            postOrderTraversal(node.rightNode);
            System.out.println(node.data);
        }
    }

    Node minimumElement() {
        Node currentNode = rootNode;
        Node lastNode = null;

        // We traverse the left subtree
        // Until we find a null at the left place
        // Then we just return the last not-null node
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.leftNode;
        }
        return lastNode;
    }

    Node maxElement() {
        Node currentNode = rootNode;
        Node lastNode = null;

        // We traverse the right subtree
        // Until we find a null at the right place
        // Then we just return the last not-null node
        while (currentNode != null) {
            lastNode = currentNode;
            currentNode = currentNode.rightNode;
        }
        return lastNode;
    }

    boolean delete(int data) {
        Node current = rootNode;
        Node parentNode = null;
        boolean isLeftChild = true;

        // First we find the node
        while (current.data != data) {
            parentNode = current;
            if (data < current.data) {
                isLeftChild = true;
                current = current.leftNode;
            } else {
                isLeftChild = false;
                current = current.rightNode;
            }

            if (current == null) {
                // If no matching node found
                return false;
            }
        }

                // If node was found then we check if it has no child - CASE 1
                if(current.leftNode == null && current.rightNode == null) {
                    if(current == rootNode) {
                        rootNode = null;
                    }
                    // If it is a left child, we disconnect the parent's left child from its parent
                    else if(isLeftChild) {
                        parentNode.leftNode = null;
                    } else {
                        // Else, we disconnect the right child from its parent
                        parentNode.rightNode = null;
                    }
                }
                // End of CASE 1

                // CASE 2 begins
                // If Left Child doesn't exist,
                // that means the current node's right child will replace it
                else if(current.leftNode == null) {
                    if(current == rootNode) {
                        rootNode = current.rightNode;
                    } else if(isLeftChild){
                        parentNode.leftNode = current.rightNode;
                    } else {
                        parentNode.rightNode = current.rightNode;
                    }
                }

                // Else, current node's left child will replace it
                else if(current.rightNode == null) {
                    if(current == rootNode) {
                        rootNode = current.leftNode;
                    } else if(isLeftChild){
                        parentNode.leftNode = current.leftNode;
                    } else {
                        parentNode.rightNode = current.leftNode;
                    }
                }

                // Both child nodes are not null - CASE 3
                else {
                    Node successor = findSuccessor(current); //55 //38
                    if(isLeftChild) {
                        parentNode.leftNode = successor;
                        successor.leftNode = current.leftNode;
                    } else {
                        parentNode.rightNode = successor;
                        successor.leftNode = current.leftNode;
                    }
                }

        return true;
    }

    Node findSuccessor(Node nodeToDelete) {
        Node currentNode = nodeToDelete.rightNode; //38
        Node successorNode = nodeToDelete; // 37
        Node parentNode = nodeToDelete; //37

        while(currentNode != null) {
            parentNode = successorNode; //37
            successorNode = currentNode;  //38
            currentNode =  currentNode.leftNode;  //null
        }

        if(successorNode != nodeToDelete.rightNode) {
            parentNode.leftNode = successorNode.rightNode;
            successorNode.rightNode = nodeToDelete.rightNode;
        } else {
            return  successorNode;
        }

        return  successorNode;
    }
}