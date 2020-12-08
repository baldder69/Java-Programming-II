
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private ArrayList<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.stream()
                .forEach(p -> employees.add(p));
    }

    public void print() {

        Iterator<Person> iterator = employees.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public void print(Education education) {

        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()){
            
            Person employee = iterator.next();
            
            if (employee.getEducation().equals(education)){
                System.out.println(employee);
            }
        }

    }
    
    public void fire(Education education){
        
        Iterator<Person> iterator = employees.iterator();
        
        while (iterator.hasNext()){
            
            Person employee = iterator.next();
            
            if (employee.getEducation().equals(education)){
                iterator.remove();
            }
        }
        
    }

}
