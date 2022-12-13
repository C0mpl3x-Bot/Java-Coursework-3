import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class CLIMenu {

    //Creates an arraylist for Todo.
    ArrayList<Todo> todos;

    //constructor that would be used to allow todos to be inputted through main
    public CLIMenu(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    //checks the arraylist and if the arraylist is not empty it would print out all the todos.
    public void listTodos() {
        //empty string to store the todos that are going to be printed out
        String list = "";
        //checks if the arraylist is empty
        if (todos.size() == 0) {
            System.out.println("Nothing is currently in the list");
        }
        int j = 1;
        //loops over each element in the arraylist and gets the information for it and adds it to the empty string called list.
        for (int i = 0; i < todos.size(); i++) {

            list += j + ")" + todos.get(i) + '\n';
            j++;
        }
        //prints all the todos in the arraylist.
        System.out.println(list);
    }

    //Allows user to Add a Todo to the arraylist.
    public void addTodo() {
        //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect and take them back to the main menu
        try {
            //creates a new Scanner instance.
            Scanner in = new Scanner(System.in);
            System.out.println("What is the title of the todo?");
            //String title is the inputted string by the user for the title of the todo
            String title = in.nextLine();

            System.out.println("What date is the todo due? (Submit in the form YYYY-MM-DDTHH:MM)");
            //LocalDateTime localDate saves the inputted String by the user for the LocalDate by using LocalDateTime.parse(in.next())
            //which obtains an instance of LocalDateTime from a text string which is in the format of YYYY-MM-DDTHH:MM
            LocalDateTime localDate = LocalDateTime.parse(in.next());


            String categoryOutput = "What category does the todo belong to? " + '\n' + "Select an item between 1 and 6 and press enter" + '\n';
            int i = 1;
            //gets all the Categories available in the enum class and adds it to categoryOutput String.
            for (Category cat : Category.values()) {
                categoryOutput += i + ")" + cat + '\n';
                i++;
            }
            //Empty String
            String categoryString = " ";
            System.out.println(categoryOutput);
            //categoryInput is empty so it can take inputted information from terminal.
            char categoryInput = ' ';
            categoryInput = (char) System.in.read();
            System.in.read();

            //switch statement
            switch (categoryInput) {

                case '1':
                    //If User Presses 1 then it would set categoryString to red
                    categoryString = "red";
                    break;//stops code from executing;
                case '2':
                    //If User Presses 2 then it would set categoryString to white
                    categoryString = "white";
                    break;//stops code from executing
                case '3':
                    //If User Presses 3 then it would set categoryString to blue
                    categoryString = "blue";
                    break;//stops code from executing
                case '4':
                    //If User Presses 4 then it would set categoryString to purple
                    categoryString = "purple";
                    break;//stops code from executing
                case '5':
                    //If User Presses 5 then it would set categoryString to yellow
                    categoryString = "yellow";
                    break;//stops code from executing
                case '6':
                    //If User Presses 6 then it would set categoryString to green
                    categoryString = "green";
                    break;//stops code from executing
            }
            //passes the String categoryString is set to and returns an enum that matches the string and saves it to category which has a Type Category
            Category category = Category.valueOf(categoryString);

            String importanceOutput = "What is the priority of the todo?  " + '\n' + "Select an item between 1 and 3 and press enter" + '\n';
            int j = 1;
            //gets all the Importance available in the enum class and adds it to importanceOutput String.
            for (Importance imp : Importance.values()) {
                importanceOutput += j + ")" + imp + '\n';
                j++;
            }

            //Empty String
            String importanceString = " ";
            System.out.println(importanceOutput);
            //importanceInput is empty so it can take inputted information from terminal.
            char importanceInput = ' ';

            importanceInput = (char) System.in.read();
            System.in.read();

            //switch statement
            switch (importanceInput) {
                case '1':
                    //If User Presses 1 then it would set importanceString to low
                    importanceString = "low";
                    break;//stops code from executing
                case '2':
                    //If User Presses 2 then it would set importanceString to normal
                    importanceString = "normal";
                    break;//stops code from executing
                case '3':
                    //If User Presses 3 then it would set importanceString to high
                    importanceString = "high";
                    break;//stops code from executing
            }
            //passes the String importanceString is set to and returns an enum that matches the string and saves it to importance which has a Type Importance
            Importance importance = Importance.valueOf(importanceString);

            //passes the String pending and returns an enum that matches the string and saves it to completion which has a Type Status
            Status completion = Status.valueOf("pending");

            //new instance of todo with the User input of title, localDate, category, importance and completion
            Todo t = new Todo(title, localDate, category, importance, completion);
            todos.add(t);  //adds the todo t to the arraylist
        } catch (Exception e) {
            System.out.println("Invalid Input, Please Enter A Valid Input");
        }
    }

    //updateTodo allows users to modify a todo from the arraylist todos
    public void updateTodo() throws IOException {
        //calls listTodos and prints out all the todos in the arraylist if the arraylist is not empty
        listTodos();

        //if the arraylist is not empty it would execute the code in the if statement
        if (todos.size() != 0) {
            System.out.println("Please select the Todo You want to update from the list above");

            //creates a new Scanner instance.
            Scanner in = new Scanner(System.in);

            //does not allow user to continue until user has entered a number
            while (!in.hasNextInt()) {
                System.out.println("please enter a valid number");
                in.next();
            }

            //saves the inputted integer as n
            int n = in.nextInt();
            //checks whether n is a valid number
            if (n > 0 && n <= todos.size()) {
                //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to do -1 from n to get the actual todo the user wants to delete from the arraylist
                int indexN = n - 1;
                System.out.println("what do you want to update select from the list below");
                //ch is empty so it can take inputted information from terminal.
                char ch = ' ';

                    //prints out the update menu.
                    System.out.println("1) Title");
                    System.out.println("2) Due date");
                    System.out.println("3) Category");
                    System.out.println("4) Importance ");
                    System.out.println("5) completion");
                    ch = (char) System.in.read();
                    in.nextLine();
                    System.in.read();

                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect and take them back to the update menu
                    try {
                        //switch statement
                        switch (ch) {

                            case '1':
                                //If User Presses 1 then it would allow user to type in the new title and save it as a String called title
                                //then it would get the todo from the arraylist and update the Title for the todo the user selected
                                System.out.println("What is the new title of the todo");
                                String title = in.nextLine();
                                todos.get(indexN).setText(title);
                                System.out.println("The New Title Is: " + title);
                                //prints out the updated list of todos
                                listTodos();
                                break;//stops code from executing

                            case '2':
                                //If User Presses 2 then it would allow user to type in the new Due Date and save it as LocalDateTime called localDate by using LocalDateTime.parse(due)
                                //which obtains an instance of LocalDateTime from a text string which is in the format of YYYY-MM-DDTHH:MM and then it would save it as localDate
                                //then it would get the todo from the arraylist and update the Due Date for the todo the user selected
                                System.out.println("What date is the new todo due");
                                String due = in.next();
                                LocalDateTime localDate = LocalDateTime.parse(due);
                                todos.get(indexN).setDue(localDate);
                                System.out.println("The New Due Date Is: " + localDate);
                                //prints out the updated list of todos
                                listTodos();
                                break;//stops code from executing
                            case '3':
                                //If user presses 3 it would allow the user to update the category of the todo.
                                String categoryOutput = "What is the new category of the todo? " + '\n' + "Select an item between 1 and 6 and press enter" + '\n';
                                int i = 1;
                                //gets all the Categories available in the enum class and adds it to categoryOutput String.
                                for (Category cat : Category.values()) {
                                    categoryOutput += i + ")" + cat + '\n';
                                    i++;
                                }
                                //Empty String
                                String categoryString = " ";
                                System.out.println(categoryOutput);
                                //categoryInput is empty so it can take inputted information from terminal.
                                char categoryInput = ' ';
                                categoryInput = (char) System.in.read();
                                System.in.read();

                                //switch statement
                                switch (categoryInput) {

                                    case '1':
                                        //If User Presses 1 then it would set categoryString to red
                                        categoryString = "red";
                                        break;//stops code from executing;
                                    case '2':
                                        //If User Presses 2 then it would set categoryString to white
                                        categoryString = "white";
                                        break;//stops code from executing
                                    case '3':
                                        //If User Presses 3 then it would set categoryString to blue
                                        categoryString = "blue";
                                        break;//stops code from executing
                                    case '4':
                                        //If User Presses 4 then it would set categoryString to purple
                                        categoryString = "purple";
                                        break;//stops code from executing
                                    case '5':
                                        //If User Presses 5 then it would set categoryString to yellow
                                        categoryString = "yellow";
                                        break;//stops code from executing
                                    case '6':
                                        //If User Presses 6 then it would set categoryString to green
                                        categoryString = "green";
                                        break;//stops code from executing
                                }
                                //passes the String categoryString is set to and returns an enum that matches the string and saves it to category which has a Type Category
                                Category category = Category.valueOf(categoryString);

                                //Gets the todo from the arraylist and updates the category for the todo the user selected
                                todos.get(indexN).setCat(category);
                                System.out.println("The New Category Is: " + category);
                                //prints out the updated list of todos
                                listTodos();
                                break;//stops code from executing

                            case '4':
                                //If User Presses 4 then it would allow user to update the importance of the todo
                                String importanceOutput = "What is the new priority of the todo?  " + '\n' + "Select an item between 1 and 3 and press enter" + '\n';
                                int j = 1;
                                //gets all the Importance available in the enum class and adds it to importanceOutput String.
                                for (Importance imp : Importance.values()) {
                                    importanceOutput += j + ")" + imp + '\n';
                                    j++;
                                }

                                //Empty String
                                String importanceString = " ";
                                System.out.println(importanceOutput);
                                //importanceInput is empty so it can take inputted information from terminal.
                                char importanceInput = ' ';

                                importanceInput = (char) System.in.read();
                                System.in.read();

                                //switch statement
                                switch (importanceInput) {
                                    case '1':
                                        //If User Presses 1 then it would set importanceString to low
                                        importanceString = "low";
                                        break;//stops code from executing
                                    case '2':
                                        //If User Presses 2 then it would set importanceString to normal
                                        importanceString = "normal";
                                        break;//stops code from executing
                                    case '3':
                                        //If User Presses 3 then it would set importanceString to high
                                        importanceString = "high";
                                        break;//stops code from executing
                                }
                                //passes the String importanceString is set to and returns an enum that matches the string and saves it to importance which has a Type Importance
                                Importance importance = Importance.valueOf(importanceString);

                                //Gets the todo from the arraylist and updates the importance for the todo the user selected
                                todos.get(indexN).setImportance(importance);
                                System.out.println("The New Importance Is: " + importance);
                                //prints out the updated list of todos
                                listTodos();
                                break;//stops code from executing

                            case '5':
                                String completionOutput = "What is the new status of the todo?  " + '\n' + "Select an item between 1 and 4 and press enter" + '\n';
                                int k = 1;
                                //gets all the Status available in the enum class and adds it to completionOutput String.
                                for (Status sta : Status.values()) {
                                    completionOutput += k + ")" + sta + '\n';
                                    k++;
                                }

                                //Empty String
                                String completionString = " ";
                                System.out.println(completionOutput);
                                //completionInput is empty so it can take inputted information from terminal.
                                char completionInput = ' ';

                                completionInput = (char) System.in.read();
                                System.in.read();

                                //switch statement
                                switch (completionInput) {
                                    case '1':
                                        //If User Presses 1 then it would set completionString to pending
                                        completionString = "pending";
                                        break;//stops code from executing
                                    case '2':
                                        //If User Presses 2 then it would set completionString to started
                                        completionString = "started";
                                        break;//stops code from executing
                                    case '3':
                                        //If User Presses 3 then it would set completionString to partial
                                        completionString = "partial";
                                        break;//stops code from executing
                                    case '4':
                                        //If User Presses 4 then it would set completionString to completed
                                        completionString = "completed";
                                        break;//stops code from executing
                                }

                                //passes the String completionString is set to and returns an enum that matches the string and saves it to completion which has a Type Status
                                Status completion = Status.valueOf(completionString);

                                //Gets the todo from the arraylist and updates the Status for the todo the user selected
                                todos.get(indexN).setCompletion(completion);
                                System.out.println("The New Status Is: " + completion);
                                //prints out the updated list of todos
                                listTodos();
                                break;//stops code from executing
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid Input Please Try Again");
                    }
            }
            //if n is not a valid input then it would tell the user that the number entered is invalid
            else if (n <= 0 || n > todos.size()) {
                System.out.println("The number entered does is invalid");
            }
        }
    }


    //deleteTodo allows user to select a Todo form the arraylist and delete it.
    public void deleteTodo() {
        //creates a new Scanner instance.
        Scanner in = new Scanner(System.in);
        //prints out all the todos in the arraylist if the arraylist is not empty
        listTodos();
        //if arraylist is not empty it would execute the code within the if statement
        if (todos.size() != 0) {
            System.out.println("Please enter the todos number that you want to delete");
            //would not let user to continue until they have entered an integer
            while (!in.hasNextInt()) {
                System.out.println("please enter a valid number");
                in.next();
            }
            //saves the inputted integer as n
            int n = in.nextInt();
            //checks whether n is a valid number
            if (n > 0 && n <= todos.size()) {
                //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
                int indexN = n - 1;
                //checks whether a todo exists at index indexN from the arraylist todos
                if (todos.get(indexN) != null) {
                    //removes the todo at index n from the arraylist todos
                    todos.remove(indexN);
                    //prints a confirmation that n has been deleted
                    System.out.println("The todo with the index " + n + " has been deleted");
                }
            }
            //if n is not a valid input then it would tell the user that the number entered is invalid
            else if (n <= 0 || n > todos.size()) {
                System.out.println("The number entered does not have a todo");
            }
        }
    }
}