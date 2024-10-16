package LinkedList;

public class LinkedList {
    Node head;

    // insert at last
    public void insert(int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = null;
        if (head == null) {
            head = newnode;
        } else {
            // creating temp node to traverse till null value(i.e. last element of list).
            Node n = head; // initially point to head (first element of list).

            while (n.next != null) {
                n = n.next; // shifting to next node(element).
            }
            n.next = newnode; // linking new node to last element in list.
        }
    }

    // insert at start
    public void insertFirst(int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = null; // optional by default its null.

        newnode.next = head;
        head = newnode;

    }

    // insert at any location(index).
    public void insertAt(int index, int data) {
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = null;

        if (index == 0) {
            insertFirst(data);
        } else {
            Node n = head; // temp node to traverse till index.
            for (int i = 0; i < index - 1; i++) {
                n = n.next; // jumps to next element in list.
            }
            newnode.next = n.next;
            n.next = newnode;
        }

    }

    // Delete element at index
    public void deleteAt(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node n = head; // temp onj
            Node n1 = null; // temp obj
            for (int i = 0; i < index - 1; i++) {
                n = n.next;
            }
            n1 = n.next;
            n.next = n1.next;
            n1 = null; // optional,now this obj will go to garbage collection.
        }

    }

    public void show() {
        // same, creating temp node and traverse whole list using loop and printing
        // data.
        Node n = head;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data); // loop is till null(last element won't get printed, hence this will print last
                                    // element).

    }
}
