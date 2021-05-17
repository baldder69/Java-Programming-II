
import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    public String toString() {

        return history.toString();
    }

    public double maxValue() {

        if (history.isEmpty()) {
            return 0;
        } else {

            double maxValue = history.get(0);

            for (int i = 0; i < history.size(); i++) {

                if (maxValue < history.get(i)) {
                    maxValue = history.get(i);
                }
            }

            return maxValue;
        }

    }

    public double minValue() {

        if (history.isEmpty()) {
            return 0;
        } else {
            double minValue = history.get(0);

            for (int i = 0; i < history.size(); i++) {
                if (minValue > history.get(i)) {
                    minValue = history.get(i);
                }
            }

            return minValue;
        }

    }

    public double average() {

        if (history.isEmpty()) {
            return 0;
        }

        double averageAdd = 0;

        for (Double numbers : history) {
            averageAdd += numbers;
        }

        double average = averageAdd / history.size();

        return average;

    }

}
