public class factorial {
    // Factorial example using recursion
    public static int calfactorial(int n){
        if(n==1 || n==0){
            return 1;
        }
        int fnm1 =calfactorial(n-1);
        int factn= n*fnm1;
        return factn;
    }
    
    public static void main(String[] args) {
        int n=5;
        int ans = calfactorial(n);
        System.out.println("Factorial of " + n + " is "+ans);
    }
}
