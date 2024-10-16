public class InsertionSort {

    public void print(int[] arr) {
        // for(int i=0; i<arr.length;i++){
        // System.out.print(arr[i] + " ");
        // }

        // Enhanced For loop
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void iSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 8, 3, 1, 2 };
        InsertionSort obj = new InsertionSort();
        obj.print(arr);
        obj.iSort(arr);
        obj.print(arr);
    }
}


// public void iSort(int[] arr){
// for(int i=1; i<arr.length; i++){
// int current = arr[i];
// int j=i-1;
// while (j >= 0 && current < arr[j]) {
// arr[j+1] = arr[j];
// j--;
// }
// arr[j+1]= current;
// }
// }