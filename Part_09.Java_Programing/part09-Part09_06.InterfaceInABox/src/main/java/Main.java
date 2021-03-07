
public class Main {

    public static void main(String[] args) {

        Box box = new Box(10);

        box.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 9));
        box.add(new Book("Robert Martin", "Clean Code", 1));

        
        Box box2 = new Box(40);
        
        box2.add(box);
        box2.add(new Sugar(30));

        System.out.println(box2);

    }

}
