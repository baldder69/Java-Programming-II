
public class Book {
    
    private String book;
    private int age;
    
    public Book(String book, int age){
        this.book = book;
        this.age = age;
    }
    
    public String getBook(){
        return this.book;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String toString(){
        return this.book + " (recommended for " + this.age + " year-olds or older)";
    }
    
}
