import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[15];
        int exitCode = 1;
        char symbol = '$';

        for(int i = 0; i < nums.length; ++i){
            System.out.print("Enter your number at index [" + i + "]: ");
            while(true){
                try{
                    nums[i] = input.nextInt();
                    break;
                }
                catch(InputMismatchException err){
                    System.out.print("Incorrect data type! Try again: ");
                    input.nextLine();
                }
            }
            if(i == nums.length - 1) input.nextLine();
        }

        do{
            switch (userCommand(input, symbol)) {
                case "search", "srh" -> search(input, nums);
                case "exit", "null" -> exitCode = 0;
                case "sort", "srt" -> sort(input, nums);
                case "clear", "cls" -> clearTerminal();
                default -> System.out.println("Invalid command");
            }
        }while(exitCode != 0);
        input.close();
    }
    public static String userCommand(Scanner input, char symbol){
        System.out.print(symbol + " ");
        String toReturn = input.nextLine().trim().toLowerCase();
        return toReturn;
    }
    public static void search(Scanner input, int[] array){
        String[] options = {"1. Linear search", "2. Binary Search"};
        char symbol = '>';
        searchOptions(options);
        switch (userCommand(input, symbol)) {
            case "linear", "1" -> linearSearch(array, input);
            case "binary", "2" -> binarySearch(array, input);
            case "back", "0" -> System.out.println("Returning...");
            default -> System.out.println("Invalid option!");
        }
    }
    public static void searchOptions(String[] options){
        for(String option : options){
            System.out.println(option);
        }
    }
    public static void linearSearch(int[] array, Scanner input){
        while(true){
            System.out.print("? ");
            String line = input.nextLine();

            if(line.equalsIgnoreCase("quit")){
                System.out.println("Exiting search.");
                break;
            }
            try{
                int target = Integer.parseInt(line);
                boolean found = false;
                for(int i = 0; i < array.length; ++i){
                    if(array[i] == target){
                        System.out.println("Target found at index: " + i);
                        found = true;
                        break;
                    }
                }
                if(!found) System.out.println("Target not found!");
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid Data type try again");
            }
        }
    }
    public static void binarySearch(int[] array, Scanner input){
        bubbleSort(array);
        while(true){
            System.out.print("? ");
            String line = input.nextLine();

            if(line.equalsIgnoreCase("quit")){
                System.out.println("Exiting search.");
                break;
            }
            try{
                int target = Integer.parseInt(line);
                boolean found = false;
                int start = 0;
                int end = array.length - 1;
                while(start <= end){
                    int middle = start + (end - start) / 2;

                    if(array[middle] < target){
                        start = middle + 1;
                    }
                    else if(array[middle] > target){
                        end = middle - 1;
                    }
                    else{
                        found = true;
                        System.out.println("Target found at index: " + middle);
                        break;
                    }
                }
                if(!found) System.out.println("Target not found!");
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid Data type try again");
            }
        }
    }
    public static void clearTerminal() {
        try {
            if (isWindows()) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return os.contains("win");
    }
    public static void sort(Scanner input, int[] array){
        String[] options = {"1. Bubble sort", "2. Selection sort"};
        char symbol = '>';
        searchOptions(options);
        switch (userCommand(input, symbol)) {
            case "bubble", "1" -> bubbleSort(array);
            case "selection", "2" -> selectionSort(array);
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
}