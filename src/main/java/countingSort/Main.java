package countingSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] xs = new int[]{2, 5, 3, 0, 2, 3, 0, 3, 4};
        countSort(xs);

        String[] dates = new String[]{"2002-11-31", "2010-01-11", "2000-10-16"};
        for (int i = dates.length - 1; i >= 0; i--) {
            countDateSort(dates, i);
        }
        System.out.println(Arrays.toString(dates));
    }

    static public void countDateSort(String[] dates, int radix) {
        Map<Integer, String> map = new HashMap<>();
        int[] arr = new int[dates.length];
        for (int i = 0; i < dates.length; i++) {
            int key = Integer.parseInt(dates[i].split("-")[radix]);
            map.put(key, dates[i]);
            arr[i] = key;
        }
        countSort(arr);
        int count = 0;
        for (int i : arr) {
            dates[count] = map.get(i);
            count++;
        }
    }

    static public void countSort(int[] arr) {
        int n = arr.length;

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[2560];
        for (int i = 0; i < 2560; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; ++i)
            count[arr[i]] = count[arr[i]] + 1;

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 2559; ++i)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]] = count[arr[i]] - 1;
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }
}
