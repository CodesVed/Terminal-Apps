import java.util.Scanner;

public final class UIUtil {

    private UIUtil() {}

    public static double[] inputArray(int n, Scanner sc){
        double[] arr = new double[n];

        try {
            System.out.print(ConsoleColors.WHITE_BOLD()+"Enter numbers for calculation: "+ConsoleColors.RESET());
            String input = sc.nextLine();
            String[] numbers = input.split(",");

            if (numbers.length != n) {
                throw new IllegalArgumentException(ConsoleColors.RED()+"Please enter exactly " + n + " numbers"+ConsoleColors.RESET());
            }

            for (int i=0; i < n; i++) {
                arr[i] = Double.parseDouble(numbers[i].trim());
            }
        } catch (Exception e){
            System.out.println(ConsoleColors.RED()+"Error!"+ConsoleColors.RESET());
            throw e;
        }
        return arr;
    }

    public static void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(ConsoleColors.RED_BOLD()+"ERROR: Process Interrupted!"+ConsoleColors.RESET());
        }
    }

    public static void showLoading(String s){
        System.out.print(s);
        System.out.flush();

        for (int i = 0; i < 3; i++) {
            pause(500);
            System.out.print(ConsoleColors.YELLOW()+"."+ConsoleColors.RESET());
            System.out.flush();
        }
        System.out.println();
    }
}
