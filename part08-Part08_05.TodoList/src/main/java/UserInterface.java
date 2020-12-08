import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoList list;
    
    
    public UserInterface(TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start(){
        while (true){
            System.out.println("Command: ");
            String command = scanner.nextLine();
            
            if (command.equals("add")){
                System.out.println("To add: ");
                String input = scanner.nextLine();
                list.add(input);
            }
            
            if (command.equals("list")){
                list.print();
            }
            
            if (command.equals("remove")){
                System.out.println("Which one is removed? ");
                int removed = scanner.nextInt();           
                list.remove(removed);
            }
            
            if (command.equals("stop")){
                break;
            }
            
            
        }
    }
    
}
