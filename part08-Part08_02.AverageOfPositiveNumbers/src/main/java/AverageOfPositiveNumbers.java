
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double average = 0;
        double averageAdd = 0;
        double counter = 0;

        while (true) {

            double input = scanner.nextInt();

            if (input == 0) {
                if (average <= 0) {
                    System.out.println("Cannot calculate the average");
                } else {
                    System.out.println(average);
                }
                break;
            } else if (input > 0) {
                averageAdd += input;
                counter++;

                average = averageAdd / counter;
            }

        }

    }
}
