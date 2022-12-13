import java.io.IOException;
import java.util.ArrayList;

public class Main {
    //creates a new instance of CLIMenu
    public static CLIMenu c = new CLIMenu(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        char ch = ' ';
        do {
            //main menu always printed after every switch/input
            System.out.println("1) List todos");
            System.out.println("2) Add todo");
            System.out.println("3) Update todo");
            System.out.println("4) Delete todo ");
            System.out.println("5) Quit");
            ch = (char) System.in.read();
            System.in.read();

            //switch statement
            switch (ch) {
                //if user enters 1 then it would call the listTodos() function in CLIMenu class
                case '1':
                    c.listTodos();
                    break;//stops code from executing
                //if user enters 2 then it would call the addTodo() function in CLIMenu class
                case '2':
                    c.addTodo();
                    break;//stops code from executing
                //if user enters 3 then it would call the updateTodo() function in CLIMenu class
                case '3':
                    c.updateTodo();
                    break;//stops code from executing
                //if user enters 4 then it would call the deleteTodo() function in CLIMenu class
                case '4':
                    c.deleteTodo();
                    break;//stops code from executing
                //if user enters 5 then it would exit the app
                case '5':
                    System.out.println("GoodBye");
                    break;//stops code from executing
                //if any number that is greater than 5 and less than 1  is pressed or if any key is pressed then default case would be triggered to print the message saying invalid key pressed
                default:
                    System.out.println("Invalid Key Pressed");
                    break;//stops code from executing
            }

        } while (ch != '5');//stops do while loop with the switch statements from taking anymore input so it stops the program from running if 5 is pressed.

    }
}
