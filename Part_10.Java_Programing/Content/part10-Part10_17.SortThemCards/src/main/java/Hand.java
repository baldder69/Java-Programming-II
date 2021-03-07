
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        cards.stream().forEach(card -> System.out.println(card));
    }

    public void sort() {

        Collections.sort(cards);

    }

    @Override
    public int compareTo(Hand hand) {
        int sum1 = this.cards.stream()
                .map(c -> c.getValue())
                .reduce(0, (previousSum, value) -> previousSum + value);

        int sum2 = hand.cards.stream()
                .map(c -> c.getValue())
                .reduce(0, (previousSum, value) -> previousSum + value);

        if (sum1 > sum2) {
            return 1;
        } else if (sum1 < sum2){
            return -1;
        } else {
            return 0;
        }

    }
    
    public void sortBySuit(){
        BySuitInValueOrder order = new BySuitInValueOrder();
        Collections.sort(cards, order);
        
    }

}
