public class SelectionSort {

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void sSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 8, 3, 2, 1 };

        SelectionSort obj = new SelectionSort();
        obj.print(arr);
        obj.sSort(arr);
        obj.print(arr);
    }

}
