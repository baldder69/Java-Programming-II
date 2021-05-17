
public class Person {
    private String person;
    private String street;
    
    
    public Person(String person, String street){
        this.person = person;
        this.street = street;
    }
    
    public String toString(){
        return this.person + "\n  " + this.street;
    }
    
}
