import java.util.Arrays;
import java.util.Scanner;

public class SortHandler {
    public static void sort(Scanner input, int[] array){
        String[] options = {"1. Bubble sort", "2. Selection sort", "3. Insertion sort"};
        char symbol = '>';
        CommandHandler.searchOptions(options);
        switch (CommandHandler.userCommand(input, symbol)) {
            case "bubble", "1" -> bubbleSort(array);
            case "selection", "2" -> selectionSort(array);
            case "insertion", "3" -> insertionSort(array);
            case "back", "0" -> System.out.println("Returning...");
            default -> System.out.println("Invalid option!");
        }
    }
     public static void bubbleSort(int[] array){
        System.out.println("Array: " + Arrays.toString(array));
        for(int i = 0; i < array.length - 1; ++i){
            for(int j = 0; j < array.length - i - 1; ++j){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted! (bubble sort)");
        System.out.println("New array: " +Arrays.toString(array));
    }
    public static void selectionSort(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[maxIndex];
            array[maxIndex] = temp;
        }

        System.out.println("Array sorted! (selection sort)");
        System.out.println("New array: " + Arrays.toString(array));
    }
    public static void insertionSort(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
        System.out.println("Array sorted! (insertion sort)");
        System.out.println("New array: " + Arrays.toString(array));
    }
}
