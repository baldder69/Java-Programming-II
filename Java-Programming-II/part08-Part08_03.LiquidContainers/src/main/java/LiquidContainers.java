
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;
        System.out.println("First: " + firstContainer + "/100");
        System.out.println("Second: " + secondContainer + "/100");

        while (true) {

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                if (amount >= 0) {
                    firstContainer += amount;
                }

                if (firstContainer >= 100) {
                    firstContainer = 100;
                }

                System.out.println("First: " + firstContainer + "/100");
                System.out.println("Second: " + secondContainer + "/100");
            }

            if (command.equals("move")) {

                if (amount > firstContainer){
                    secondContainer += firstContainer;
                    firstContainer = 0;
                }
                
                if (amount >= 0 && amount <= firstContainer){
                    secondContainer += amount;
                    firstContainer -= amount;
                }
                
                if (secondContainer > 100){
                    secondContainer = 100;
                }

                System.out.println("First: " + firstContainer + "/100");
                System.out.println("Second: " + secondContainer + "/100");

            }

            if (command.equals("remove")) {

                if (amount <= secondContainer && amount >= 0) {
                    secondContainer -= amount;
                }

                System.out.println("First: " + firstContainer + "/100");
                System.out.println("Second: " + secondContainer + "/100");

            }
        }
    }

}
