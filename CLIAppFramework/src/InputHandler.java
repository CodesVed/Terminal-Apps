import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String prompt){
        while (true){
            System.out.println(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static String getString(String prompt){
        while (true){
            System.out.println(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }

    public static boolean yesNo(String prompt){
        while (true){
            System.out.println(prompt+" (y/n): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
        }
    }

    public static void pause(){
        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }
}
