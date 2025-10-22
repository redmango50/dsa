import java.util.Scanner;
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
                default -> System.out.println("Invalid command");
            }
        }while(exitCode != 0);
        input.close();
    }
    public static String userCommand(Scanner input, char symbol){
        System.out.print(symbol + " ");
        String toReturn = input.nextLine().toLowerCase();
        return toReturn;
    }
    public static void search(Scanner input, int[] array){
        String[] options = {"1. Linear search", "2. Binary Search"};
        char symbol = '>';
        searchOptions(options);
        switch (userCommand(input, symbol)) {
            case "linear", "1" -> linearSearch(array, input);
        }
    }
    public static void searchOptions(String[] options){
        for(String option : options){
            System.out.println(option);
        }
    }
    public static void linearSearch(int[] array, Scanner input){
        int target = Integer.parseInt(userCommand(input, '?'));
        for(int i = 0; i < array.length; ++i){
            if(array[i] == target){
                System.out.println("Target found at index: " + i);
                break;
            }
        }
    }
}