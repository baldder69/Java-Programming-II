package dictionary;

public class Main {

    public static void main(String[] args) {
        SaveableDictionary s = new SaveableDictionary("words.txt");
        System.out.println(s.load());
    }
}
