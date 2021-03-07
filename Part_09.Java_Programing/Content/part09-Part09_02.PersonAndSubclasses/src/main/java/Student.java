
public class Student extends Person {
    
    private int studentCredits;
    
    public Student(String person, String street) {
        super(person, street);
        this.studentCredits = 0;
    } 
    
    public void study(){
        studentCredits++;
    }
    
    public int credits(){
        return this.studentCredits;
    }
    
    public String toString(){
        return super.toString() + "\n  Study credits " + this.studentCredits;
    }
    
}
