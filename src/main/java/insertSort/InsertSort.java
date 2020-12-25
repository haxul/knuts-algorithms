package insertSort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] A = new int[]{10, 2, 9, 3, 1};
        insertSort(A);
        System.out.println(Arrays.toString(A));
    }

    public static void insertSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            int prevInx = i - 1;
            while (prevInx >= 0 && a[prevInx] > key) {
                a[prevInx + 1] = a[prevInx];
                prevInx--;
            }
            a[prevInx + 1] = key;
        }
    }
}
