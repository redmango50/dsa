import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
    public static void main(String[] args){
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
            switch (CommandHandler.userCommand(input, symbol)) {
                case "search", "srh" -> SearchHandler.search(input, nums);
                case "exit", "null" -> exitCode = 0;
                case "sort", "srt" -> SortHandler.sort(input, nums);
                case "clear", "cls" -> CommandHandler.clearTerminal();
                default -> System.out.println("Invalid command");
            }
        }while(exitCode != 0);
        System.out.println("Exit successful with exit code 0");
        input.close();
    }
}