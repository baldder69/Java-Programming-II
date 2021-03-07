
public class Teacher extends Person {
    
    private int teacherSalary;
 
    public Teacher(String person, String street, int teacherSalary) {
        super(person, street);
        this.teacherSalary = teacherSalary;
    }      
    
    public String toString(){
        return super.toString() + "\n  salary " + this.teacherSalary + " euro/month";
    }
    
}
