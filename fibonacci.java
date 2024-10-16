import java.util.Scanner;

public class fibonacci {
    
    public static void calfib(int a, int b , int n){
        if(n==0){
            return;
        }
        int c = a+b;
        System.out.println(c);
        calfib(b, c, n-1);
    }
    
    public static void main(String[] args) {
     int a = 0, b = 1;
     System.out.print("Enter Nth term : ");
     
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     
     System.out.println(a);  
     System.out.println(b);
     
     calfib(a, b, n-2); 
    }
}
