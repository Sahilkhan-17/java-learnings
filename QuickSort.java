public class QuickSort {

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i]=pivot;
        arr[high]=temp;

        return i; //index of pivot element. 
    }

    public void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pindex = partition(arr, low, high);

            qSort(arr, low, pindex - 1);
            qSort(arr, pindex + 1, high);
        }
    }

    public void print(int[] arr){
        // foreach loop / Enhanced for loop
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 8, 3, 1 };
        int n = arr.length-1;

        QuickSort obj = new QuickSort();
        obj.print(arr);
        obj.qSort(arr, 0, n);
        obj.print(arr);
    }
}
