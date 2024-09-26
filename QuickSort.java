import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(999);
        }

        int[] arr2 = arr.clone();

        long startTime = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime;

        System.out.println("Quick sort time: " + timeTaken + " milliseconds");
    }
    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);

    }
    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }

}
