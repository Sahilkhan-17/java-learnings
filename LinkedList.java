public  class LinkedList {
    public class Node {
        int data;
        Node next;
    }

    public class Llist {

        static Node head; // refers to first node.

        public static void insert(int data) {
            // to insert data, first create a node(i.e. consist data & next.)
            Node node = new Node();

            node.data = data;
            node.next = null;

            // checking list is empty or not, then insert operation is performed.

            if (head == null) { // if list is empty, then the first node is itself head.
                head = node;
            } else {
                // to traverse, we are using temporary node n.
                Node n = head; // temp node, initially refers to head node.
                while (n.next != null) {
                    n = n.next; // jumps to next node.
                }
                n.next = node; //new node which we are adding in list.
            }

        }

        public static void show() {

        }
    }

    public static void main(String[] args) {
        Llist list = new Llist();

        list.insert(5);

    }
}
