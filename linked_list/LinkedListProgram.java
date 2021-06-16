package linked_list;

public class LinkedListProgram {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.appendNode(new Node("2"));
        linkList.insertFirst(new Node("1"));
        linkList.appendNode(new Node("3"));
        linkList.appendNode(new Node("4"));
        linkList.insertFirst(new Node("0"));
        linkList.insertFirst(new Node("-1"));
        linkList.insertFirst(new Node("-2"));
        linkList.insertBefore("3", new Node("data"));
        linkList.insertBefore("3", new Node("data"));
        linkList.deleteNode(new Node("data"));
        linkList.displayList();
        linkList.deleteNode(new Node("data"));
        linkList.displayList();
        linkList.deleteNode(new Node("3"));
        linkList.displayList();
    }
}
