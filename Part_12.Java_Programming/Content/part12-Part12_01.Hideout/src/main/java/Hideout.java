
import java.util.ArrayList;

public class Hideout<T> {

    private ArrayList<T> hideout;

    public Hideout() {
        this.hideout = new ArrayList<>();
    }

    public void putIntoHideout(T toHide) {

        if (hideout.isEmpty()) {
            hideout.add(toHide);
        } else {
           hideout.clear();
           hideout.add(toHide);
        }
    }

    public T takeFromHideout() {
        if (this.hideout.size() == 0) {
            return null;
        } else {
            T item = this.hideout.get(0);
            this.hideout.clear();
            return item;
        }
    }

    public boolean isInHideout() {
        if (this.hideout.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

}
