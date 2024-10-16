import java.util.Scanner;

public class Recursion3 {
    // Q. find the first & last occurence of ana element in String 
    // String "abaacdaefaah" element 'a'.

    public static int first = -1;  // static variables first & last 
    public static int last = -1;

    public static void findOccurence(String str, int idx, char element){
        if(idx==str.length()){
            System.out.println("First occtrance of a element "+ element +" is "+first);
            System.out.println("Last occtrance of a element "+ element +" is "+last);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar == element){
            if(first == -1){
                first = idx;
            }else{
                last = idx;
            }
        }
        findOccurence(str, idx+1, element);
    }

    public static void main(String[] args) {
        System.out.print("Enter a String : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print("Enter the Character : ");
        char element = sc.next().charAt(0);
        // String str = "abaacdaefaah";
        findOccurence(str, 0, element);
    }
}
