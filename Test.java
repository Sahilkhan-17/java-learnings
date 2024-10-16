
class Parent{
    int number;
    String text;
}

public class Test extends Parent {
    
        public static void main(String[] args) {
        // String str = "Hello";
        // String abc = str.concat("World");
        // String fgh = str.toLowerCase();
        // System.out.println(str+ " " + abc + " " + fgh);

        // Object obj = new int[]{1,2,3};
        // if(obj instanceof int[]){
        //     System.out.println("Array");
        // }else{
        //     System.out.println("Not an Array");
        // }

        Parent parent = new Parent();
        System.out.println("number:" + parent.number);
        System.out.println("Text:" + parent.text);
    }
}

          