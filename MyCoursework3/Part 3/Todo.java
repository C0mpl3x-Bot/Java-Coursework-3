import java.awt.*;
import java.time.LocalDateTime;

//Todo Class
public class Todo {
    private String text;
    private LocalDateTime due;
    private Category cat;
    private Importance importance;
    private Status completion;

    //constructor for the todo
    //Used to populate todos arraylist with the todos the user adds.
    public Todo(String text, LocalDateTime due, Category cat, Importance importance, Status completion) {
        this.text = text;
        this.due = due;
        this.cat = cat;
        this.importance = importance;
        this.completion = completion;
    }

    //getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public Status getCompletion() {
        return completion;
    }

    public void setCompletion(Status completion) {
        this.completion = completion;
    }

    //overriding the toString method so when it is called it can return get all the information for the todo and display it.
    @Override
    public String toString() {
        return cat.getColour() + "Todo{" + " Title: " +getText() + ", Due Date: "+ getDue()+ ", Importance Of The Todo: " + getImportance()+ ", Status Of The Todo: " + getCompletion() + "}\033[0m";
    }
}
