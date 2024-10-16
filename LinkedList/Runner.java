package LinkedList;


public class Runner {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insert(4);   // bydefalut at last 
        list.insert(5);
        list.insert(6);
        list.insertFirst(12);  
        list.insertAt(2, 9);
        list.show();
        list.deleteAt(2);
        list.show();

    }
}
