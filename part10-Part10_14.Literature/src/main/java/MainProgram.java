import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {

            System.out.print("Input the name of the book, empty stops: ");

            String book = scanner.nextLine();

            if (book.equals("")) {
                break;
            }

            System.out.print("Input the age recommendation: ");
            String age = scanner.nextLine();
            books.add(new Book(book, Integer.valueOf(age)));

        }
        
        System.out.println("\n" + books.size() + " books in total.\n");
        
        Comparator<Book> comparator = Comparator
                .comparing(Book::getAge)
                .thenComparing(Book::getBook);
        
        Collections.sort(books, comparator);

        System.out.println("Books: ");

        books.stream()
                .forEach(b -> System.out.println(b));
    }

}
