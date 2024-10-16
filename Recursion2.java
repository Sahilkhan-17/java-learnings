import java.util.Scanner;

public class Recursion2 {

    public static void revString(String str, int idx){
        if(idx == 0){
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx)+ " " );
        revString(str, idx-1);
    }

    public static void main(String[] args) {
        System.out.print("Enter the string to Reverse : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //String str = "abcd";
        revString(str,str.length()-1);
    }
}
