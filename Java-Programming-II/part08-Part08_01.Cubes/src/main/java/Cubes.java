
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            } else {

                int number = Integer.valueOf(input);

                int product = number * number * number;

                System.out.println(product);

            }

        }

    }
}
