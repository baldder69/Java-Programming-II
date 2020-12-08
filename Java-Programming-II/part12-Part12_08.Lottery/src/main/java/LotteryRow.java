
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;
    private Random number;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        this.number = new Random();

        int counter = 0;

        while (counter < 7) {
            int randomNumber = this.number.nextInt(40) + 1;
            
            if (!containsNumber(randomNumber)){
                this.numbers.add(randomNumber);
                counter++;
            } 
        }

    }

    public boolean containsNumber(int number) {
        
        for (int i = 0; i < numbers.size(); i++){
            
            if (numbers.get(i) == number){
                return true;
            }
            
        }
        
        return false;
        
    }
}
