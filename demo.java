import java.util.*;

public class demo{

    public static void main(String[] args) {
        int n=5;
        int num=1; //for Floyds pattern

        // logic for Pattern (Numbers)
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5
        
        /*
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        } 
        */


        // Inverted Half pyramid with numbers 
        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1 

        /*
        for(int i=n; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
        */


        // Floyds Triangle
        // 1
        // 2  3
        // 4  5  6
        // 7  8  9  10
        // 11 12 13 14 15

        /*
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print(num + " ");
                num++; 
            }
            System.out.println();
        }
        */

        // 0 - 1 Triangle
        // 1
        // 0 1
        // 1 0 1
        // 0 1 0 1
        // 1 0 1 0 1

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                int sum=i+j;
                if(sum % 2 == 0){
                    System.out.print("1 ");
                }else
                {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}