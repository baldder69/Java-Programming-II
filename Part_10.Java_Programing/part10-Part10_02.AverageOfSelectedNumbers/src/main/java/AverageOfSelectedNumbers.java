
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> inputsPositive = new ArrayList<>();
        List<String> inputsNegative = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop");
        while (true) {

            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            } else {
                if (Integer.valueOf(input) >= 0){
                    inputsPositive.add(input);
                } else {
                    inputsNegative.add(input);
                }
            }

        }



        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");

        String input = scanner.nextLine();

        if (input.equals("n")) {
            double averageNegative = inputsNegative.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + averageNegative);

        } else if (input.equals("p")) {
            double averagePositive = inputsPositive.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .average()
                    .getAsDouble();
            System.out.println("average of the numbers: " + averagePositive);
        }

    }
}
