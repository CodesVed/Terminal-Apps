import java.util.Random;
import java.util.Scanner;

public class Methods {
    static Scanner sc = new Scanner(System.in);

    private static int randomNumberGenerator(int min, int max){
        Random random = new Random();
        return random.nextInt(max-min+1) + min;
    }

    public static void guessNumber(int min, int max, int attempt){
        int target = randomNumberGenerator(min, max);

        int guess = -1;

        while (attempt > 0){
            System.out.print("Your Guess: ");
            try {
                guess = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Enter valid input.");
                sc.nextLine();
                continue;
            }

            if(guess == target){
                System.out.println("Great Job! You guessed it.");
                return;
            } else {
                attempt--;
                if (attempt>0){
                    System.out.println("Try Again! Attempts left: "+attempt);
                }
            }
        }

        System.out.println("Out of Attempts! The number was: "+target);
    }

    public static void highLow(int attempt){
        int target = randomNumberGenerator(1, 15);

        int guess = -1;

        System.out.println("Guess a number between 1 and 15.");
        while (attempt > 0){
            System.out.print("Your Guess: ");
            try{
                guess = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Invalid Input.");
                sc.nextLine();
                continue;
            }

            if (guess == target){
                System.out.println("Correct! You win.");
                return;
            } else if (guess > target) {
                System.out.println("Lower");
            } else {
                System.out.println("Higher");
            }

            attempt--;
            if (attempt > 0){
                System.out.println("Attempts left: "+attempt);
            }
        }

        System.out.println("You've ran out of attempts. The number was: "+target);
    }
}
