import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] array = rand.ints(size, 0, 100000).toArray();

            // Bubblesort
            int[] array1 = Arrays.copyOf(array, array.length);
            long startTime = System.nanoTime();
            bubbleSort(array1);
            long endTime = System.nanoTime();
            System.out.println("BubbleSort (" + size + " numbers): " + (endTime - startTime) + " ns");

            // Selectionsort
            int[] array2 = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            selectionSort(array2);
            endTime = System.nanoTime();
            System.out.println("SelectionSort (" + size + " numbers): " + (endTime - startTime) + " ns");

            // Quicksort
            int[] array3 = Arrays.copyOf(array, array.length);
            startTime = System.nanoTime();
            quickSort(array3, 0, array3.length - 1);
            endTime = System.nanoTime();
            System.out.println("QuickSort (" + size + " numbers): " + (endTime - startTime) + " ns");
        }
    }

    // Bubble Sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
