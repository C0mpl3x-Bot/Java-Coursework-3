import java.time.LocalDateTime;
import java.util.ArrayList;

public class CLIMenu {

    //Creates an arraylist for Todo.
    ArrayList<Todo> todos;

    //constructor that would be used to allow todos to be inputted through main
    public CLIMenu(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    //checks the arraylist and if the arraylist is not empty it would print out all the todos.
    public String listTodos() {
        //empty string to store the todos that are going to be printed out
        String list = "";
        //checks if the arraylist is empty
        if (todos.size() == 0) {
            return "List Empty";
        }
        int j = 1;
        //loops over each element in the arraylist and gets the information for it and adds it to the empty string called List.
        for (int i = 0; i < todos.size(); i++) {

            //using html tags so the list can be printed out properly to the frame when list todos is called (prints out properly by using <br/>
            list += "<html>" + j + ")" + todos.get(i) + "<br/>";
            j++;
        }
        list += "</html>";
        //returns all the todos in the arraylist.
        return list;
    }

    //Allows user to Add a Todo to the arraylist.
    public String addTodo(Todo t) {
        //adds todo to the arraylist
        todos.add(t);
        //returns confirmation if todo is added
        return "The following Todo Has been Added " + t;
    }

    //allows user to update the title of a specific todo
    public String titleUpdate(int n, String s) {
        //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
        int indexN = n - 1;
        //gets the title of the todo and saves it to oldTitle
        String oldTitle = todos.get(indexN).getText();
        //sets s which is the inputted title to String title
        String title = s;
        //gets the todo from the arraylist and updates the Title for the todo the user selected by setting to title
        todos.get(indexN).setText(title);
        //returns a String that confirms the todo has been updated and shows which todo was updated and shows the previous title and the updated title
        return "The todo list with the title " + oldTitle + " at  index " + n + " has been updated with the new title: " + title;
    }

    //allows user to update the Due Date of a specific todo
    public String dueDateUpdate(int n, LocalDateTime s) {
        //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
        int indexN = n - 1;
        //gets the Due Date of the todo and saves it to oldDueDate
        LocalDateTime oldDueDate = todos.get(indexN).getDue();
        //sets s which is the inputted Due Date to LocalDateTime dueDate
        LocalDateTime dueDate = s;
        //gets the todo from the arraylist and updates the Due Date for the todo the user entered by setting it to dueDate
        todos.get(indexN).setDue(dueDate);
        //returns a String that confirms the todo has been updated and shows which todo was updated and shows the previous Due Date and the updated Due Date
        return "The todo list with the Due Date " + oldDueDate + " at  index " + n + " has been updated with the new Due Date: " + dueDate;
    }

    //allows user to update the category of a specific todo
    public String categoryUpdate(int n, Category s) {
        //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
        int indexN = n - 1;
        //gets the Category of the todo and saves it to oldCategory
        Category oldCategory = todos.get(indexN).getCat();
        //sets s which is the inputted Category to Category newCategory
        Category newCategory = s;
        //gets the todo from the arraylist and updates the Category for the todo the user selected by setting it to newCategory
        todos.get(indexN).setCat(newCategory);
        //returns a String that confirms the todo has been updated and shows which todo was updated and shows the previous Category and the updated Category
        return "The todo list with the Category  " + oldCategory + " at  index " + n + " has been updated with the new Category : " + newCategory;

    }

    //allows user to update the importance of a specific todo
    public String importanceUpdate(int n, Importance s) {
        //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
        int indexN = n - 1;
        //gets the Importance of the todo and saves it to oldImportance
        Importance oldImportance = todos.get(indexN).getImportance();
        //sets s which is the inputted Importance to Importance newImportance
        Importance newImportance = s;
        //gets the todo from the arraylist and updates the Importance for the todo the user selected by setting it to newImportance
        todos.get(indexN).setImportance(newImportance);
        //returns a String that confirms the todo has been updated and shows which todo was updated and shows the previous Importance and the updated Importance
        return "The todo list with the Importance  " + oldImportance + " at  index " + n + " has been updated with the new Importance : " + newImportance;
    }

    //allows user to update the status of a specific todo
    public String statusUpdate(int n, Status s) {
        //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
        int indexN = n - 1;
        //gets the Status of the todo and saves it to oldStatus
        Status oldStatus = todos.get(indexN).getCompletion();
        //sets s which is the inputted Status to Status newStatus
        Status newStatus = s;
        //gets the todo from the arraylist and updates the Status for the todo the user selected by setting it to newStatus
        todos.get(indexN).setCompletion(newStatus);
        //returns a String that confirms the todo has been updated and shows which todo was updated and shows the previous Status and the updated Status
        return "The todo list with the Status  " + oldStatus + " at  index " + n + " has been updated with the new Status : " + newStatus;

    }

    //allows user to delete a specific todo
    public String deleteTodo(int n) {
        //checks whether n is a valid number
        if (n > 0 && n <= todos.size()) {
            //indexN does n - 1 as arraylist begins from 0 and the List of todos begins from 1 so we would need to -1 from n to get the actual todo the user wants to delete from the arraylist
            int indexN = n - 1;
            //removes the todo at indexN
            todos.remove(indexN);
            //returns a string that confirms that the Todo has been deleted
            return "The todo list with the index " + n + " has been deleted";
        } else {
            //returns string if n is invalid
            return "The number entered does not have a todo";
        }
    }

}
