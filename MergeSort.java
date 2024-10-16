public class MergeSort {

    public static void conquer(int[] arr, int si, int mid, int ei) {

        int[] merged = new int[ei - si + 1];
        int l = si; // left array
        int r = mid + 1; // right array
        int k = 0; // merged array

        while (l <= mid && r <= ei) { // only run when both conditions true
            if (arr[l] <= arr[r]) {
                merged[k] = arr[l];
                k++;
                l++;
            } else {
                merged[k] = arr[r];
                k++;
                r++;
            }
        }

        while (l <= mid) { // any 1 loop will run from this two loops.
            merged[k] = arr[l];
            k++;
            l++;
        }

        while (r <= ei) {
            merged[k] = arr[r];
            k++;
            r++;
        }

        // this loop is for cpy elements of (merged) array into (original) array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }

    }

    public static void divide(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;  //this is important otherwise,throws runtime exception.
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);

    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        int len = arr.length - 1;
        divide(arr, 0, len);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }
}
