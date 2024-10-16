import java.util.Scanner;

public class Recursionn {
    
    public static void printNumber(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNumber(n-1);
    }

    public static void nextNumber(int z){
        if(z==6){
            return;
        }
        System.out.println(z);
        nextNumber(z+1);
    }
    public static void main(String[] args) {
        int z=1;
        // System.out.print("Enter the number : ");
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // printNumber(n);
        nextNumber(z);
    }
}
