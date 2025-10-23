import java.util.Scanner;

public class SearchHandler {
    public static void search(Scanner input, int[] array){
        String[] options = {"1. Linear search", "2. Binary Search"};
        char symbol = '>';
        CommandHandler.searchOptions(options);
        switch (CommandHandler.userCommand(input, symbol)) {
            case "linear", "1" -> linearSearch(array, input);
            case "binary", "2" -> binarySearch(array, input);
            case "back", "0" -> System.out.println("Returning...");
            default -> System.out.println("Invalid option!");
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
        SortHandler.bubbleSort(array);
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
}
