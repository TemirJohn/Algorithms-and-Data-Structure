import java.util.Random;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = new int[1000000];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(999);
        }

        int[] arr2 = arr.clone();

        long startTime = System.currentTimeMillis();
        mergeSort(arr2, 0, arr2.length - 1);
        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime;
        System.out.println("Merge sort time: " + timeTaken + " milliseconds");
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < rightSize; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
}