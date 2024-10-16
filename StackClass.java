public class StackClass {

    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data= data;
            next=null;
        }
    }

    public class Stack{
        public static Node head;

        // function to check stack is empty or not
        public boolean isEmpty(){
            System.out.println("Stack is empty.");
            return head == null;
        }

        // function to add element at the top.
        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;            
        }

        //function to delete the element from top.
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // function to read data of top element.
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]){
        StackClass st = new StackClass();
        Stack s = st.new Stack();
        s.push(2);
        s.push(4);
        s.push(6);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }  
}

 

