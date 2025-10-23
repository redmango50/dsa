import java.util.Scanner;
public class CommandHandler {
    public static String userCommand(Scanner input, char symbol){
        System.out.print(symbol + " ");
        String toReturn = input.nextLine().trim().toLowerCase();
        return toReturn;
    }
    public static void searchOptions(String[] options){
        for(String option : options){
            System.out.println(option);
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
}
