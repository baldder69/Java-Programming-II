
import java.util.Scanner;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        List<Integer> myList = new List<>();
        myList.add(2);
        myList.add(3);
        myList.add(5);
        myList.add(6);
        myList.add(7);

        System.out.println(myList);
        System.out.println(myList.size());

        myList.remove(7);

        System.out.println(myList);

        System.out.println(myList.size());

    }

}
