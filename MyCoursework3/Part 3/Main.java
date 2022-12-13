import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main extends JFrame implements ActionListener {
    //creates a new instance of CLIMenu
    public static CLIMenu c = new CLIMenu(new ArrayList<>());

    //Instances of Buttons Labels and Text Fields
    JLabel welcome, out, invalidOutput, listTodoList, addTodoTitle, addTodoDue, addTodoCategory, addTodoImportance, addTodoTOutput,
            updateTodoText, updateTodoNumber, updateSubmitTitleOutput, updateSubmitDateOutput, categoryUpdateOutput, updateSubmitCategoryOutput,
            titleUpdateQuestion, completionUpdateOutput, updateSubmitCompletionOutput, importanceUpdateOutput, updateSubmitImportanceOutput,
            updateDueDateQuestion, categoryUpdateQuestion, deleteTodoNumber, deleteSubmitOutput;
    JTextField addTodoTitleInput, addTodoDueDateInput, updateTodoNumberInput, titleUpdateTitleInput, dueDateUpdateDateInput, deleteTodoNumberInput;
    JButton submit, updateSubmitDate, updateSubmitCategory, updateSubmitCompletion, updateSubmitImportance, updateSubmitTitle, deleteSubmit;

    Main() {
        //Creates the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1250, 500);
        this.setLayout(new FlowLayout());
        this.setLocation(250, 50);

        //new instance of JButton the buttons listTodos, addTodo, updateTodo, deleteTodo With the text inside the button
        JButton listTodos = new JButton("List Todos");
        JButton addTodo = new JButton("Add Todo");
        JButton updateTodo = new JButton("Update Todo");
        JButton deleteTodo = new JButton("Delete Todo");

        //makes a new instance of welcome with specified text for it to display
        welcome = new JLabel("Welcome To The GUI Todo");
        //adds welcome to the frame
        add(welcome);

        //add the addTodo, listTodos, updateTodo, deleteTodo buttons to the main frame
        add(addTodo);
        add(listTodos);
        add(updateTodo);
        add(deleteTodo);
        //makes a new instance of out with specified text for it to display
        out = new JLabel("Click The Button Of The Function You Want To Perform");
        //adds out to the frame
        add(out);
        //makes everything visible on that frame
        setVisible(true);

        //new instance for invalidOutput
        invalidOutput = new JLabel();

        //array with type String which contains all possible Categories
        String[] categoryStrings = {"red", "white", "blue", "purple", "yellow", "green"};
        //creates JComboBox for category and saves it to categoryOutput and categoryOutputUpdate
        JComboBox categoryOutput = new JComboBox(categoryStrings);
        JComboBox categoryOutputUpdate = new JComboBox(categoryStrings);

        //array with type String which contains all possible Importance
        String[] importanceStrings = {"low", "high", "normal"};
        //creates JComboBox for Importance and saves it to importanceOutput and importanceOutputUpdate
        JComboBox importanceOutput = new JComboBox(importanceStrings);
        JComboBox importanceOutputUpdate = new JComboBox(importanceStrings);


        //Creates a Frame if an invalid input occurs
        JFrame invalidFrame = new JFrame("Invalid Input");
        invalidFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        invalidFrame.setSize(1250, 500);
        invalidFrame.setLayout(new FlowLayout());
        invalidFrame.setLocation(250, 50);


        ////////////////////////////////////------------------------------- List Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel
        listTodoList = new JLabel();

        //Creates a new frame called listTodo
        JFrame listTodoFrame = new JFrame("List Todo");
        listTodoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listTodoFrame.setSize(1250, 500);
        listTodoFrame.setLayout(new FlowLayout());
        listTodoFrame.setLocation(250, 50);

        //creates an ActionListener for the button listTodos so when the button is pressed it can perform what it is meant to perform
        listTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //has a JLabel that would display the output of the function listTodos from CLIMenu
                listTodoList.setText(c.listTodos());
                //adds ListTodoList to the listTodoFrame
                listTodoFrame.add(listTodoList);
                //makes the output on the frame visible
                listTodoFrame.setVisible(true);
            }
        });
        ////////////////////////////////////------------------------------- Add Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        addTodoTitle = new JLabel();
        addTodoDue = new JLabel();
        addTodoCategory = new JLabel();
        addTodoImportance = new JLabel();
        addTodoTitleInput = new JTextField();
        addTodoDueDateInput = new JTextField();
        submit = new JButton();

        //Creates a new frame called addTodo
        JFrame addTodoFrame = new JFrame("Add Todo");
        addTodoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addTodoFrame.setSize(1250, 500);
        addTodoFrame.setLayout(new FlowLayout());
        addTodoFrame.setLocation(250, 50);

        //creates an ActionListener for the button addTodo so when the button is pressed it can perform what it is meant to perform
        addTodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Sets the Text for addTodoTitle
                addTodoTitle.setText("What is the title of the todo?");
                //adds the addTodoTitle to the addTodoFrame
                addTodoFrame.add(addTodoTitle);
                //sets the Columns for addTodoTitleInput Box
                addTodoTitleInput.setColumns(5);
                //sets up an actionListener for addTodoTitleInput
                addTodoTitleInput.addActionListener(this);
                //Adds the input box called addTodoTitleInput to the addTodoFrame
                addTodoFrame.add(addTodoTitleInput);

                //Sets the Text for addTodoDue
                addTodoDue.setText("What date is the todo due? (Submit in the form YYYY-MM-DDTHH:MM)");
                //Adds the JLabel called addTodoDue to the Frame addTodoFrame
                addTodoFrame.add(addTodoDue);

                //sets the Columns for addTodoDueDateInput Box
                addTodoDueDateInput.setColumns(10);
                //sets up an actionListener for addTodoDueDateInput
                addTodoDueDateInput.addActionListener(this);
                //Adds the input box called addTodoDueDateInput to the addTodoFrame
                addTodoFrame.add(addTodoDueDateInput);

                //Sets the Text for addTodoCategory
                addTodoCategory.setText("Please select the category of the todo");
                //Adds the JLabel called AddTodoCategory to the Frame addTodoFrame
                addTodoFrame.add(addTodoCategory);

                //sets up an actionListener for categoryOutput
                categoryOutput.addActionListener(this);
                //Adds the JComboBox called categoryOutput to the Frame addTodoFrame
                addTodoFrame.add(categoryOutput);

                //Sets the Text for addTodoImportance
                addTodoImportance.setText("Please select the importance of the todo");
                //Adds the text for addTodoImportance to addTodoFrame
                addTodoFrame.add(addTodoImportance);

                //sets up an actionListener for importanceOutput
                importanceOutput.addActionListener(this);
                //Adds the JComboBox called importanceOutput to the Frame addTodoFrame
                addTodoFrame.add(importanceOutput);

                //Sets the Text for submit
                submit.setText("Add The Todo");
                //Adds the JButton called submit to the Frame addTodoFrame
                addTodoFrame.add(submit);
                //sets up an actionListener for submit
                submit.addActionListener(this);
                //makes all buttons, labels, text fields visible on the addTodoFrame
                addTodoFrame.setVisible(true);
            }
        });

        //new instance of JLabel
        addTodoTOutput = new JLabel();

        //Creates a new frame called addTodoSubmitFrame
        JFrame addTodoSubmitFrame = new JFrame("Add Todo Output");
        addTodoSubmitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addTodoSubmitFrame.setSize(1250, 500);
        addTodoSubmitFrame.setLayout(new FlowLayout());
        addTodoSubmitFrame.setLocation(250, 50);

        //creates an ActionListener for the button submit so when the button is pressed it can perform what it is meant to perform
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closes AddTodoFrame
                addTodoFrame.dispose();
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Add The Todo")) {
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //String title is the inputted string in the input box by the user for the title of the todo
                        String title = addTodoTitleInput.getText();

                        //LocalDateTime localDate saves the inputted String in the input box by the user for the LocalDate by using LocalDateTime.parse(addTodoDueDateInput.getText())
                        //which obtains an instance of LocalDateTime from a text string which is in the format of YYYY-MM-DDTHH:MM
                        LocalDateTime localDate = LocalDateTime.parse(addTodoDueDateInput.getText());

                        //passes the (String)categoryOutput.getSelectedItem() is set to and returns an enum that matches the string and saves it to category which has a Type Category
                        Category category = Category.valueOf((String) categoryOutput.getSelectedItem());

                        //passes the (String)importanceOutput.getSelectedItem() is set to and returns an enum that matches the string and saves it to importance which has a Type Importance
                        Importance importance = Importance.valueOf((String) importanceOutput.getSelectedItem());

                        //passes the String pending and returns an enum that matches the string and saves it to completion which has a Type Status
                        Status completion = Status.valueOf("pending");

                        //new instance of todo with the User input of title, localDate, category, importance and completion
                        Todo t = new Todo(title, localDate, category, importance, completion);
                        //calls addTodo from CLIMenu with the todo to be added and sets the output of the function to the JLabel AddTodoTOutput
                        addTodoTOutput.setText(c.addTodo(t));
                        //add the addTodoTOutput to addTodoSubmitFrame
                        addTodoSubmitFrame.add(addTodoTOutput);
                        //makes all buttons, labels, text fields visible on the addTodoSubmitFrame
                        addTodoSubmitFrame.setVisible(true);
                    } catch (Exception e1) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Input Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                }
            }
        });


        ////////////////////////////////////------------------------------- Update Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        updateTodoNumber = new JLabel();
        updateTodoText = new JLabel();
        updateTodoNumberInput = new JTextField();
        JButton titleUpdate = new JButton();
        JButton dueDateUpdate = new JButton();
        JButton categoryUpdate = new JButton();
        JButton completionUpdate = new JButton();
        JButton importanceUpdate = new JButton();

        //Creates a new frame called updateTodoFrame
        JFrame updateTodoFrame = new JFrame("UpdateTodo");
        updateTodoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateTodoFrame.setSize(1250, 500);
        updateTodoFrame.setLayout(new FlowLayout());
        updateTodoFrame.setLocation(250, 50);

        //creates an ActionListener for the button updateTodo so when the button is pressed it can perform what it is meant to perform
        updateTodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //checks if the arraylist in CLIMenu is not empty
                if (c.todos.size() != 0) {
                    //Sets the Text for updateTodoNumber
                    updateTodoNumber.setText("Enter the Number Of The Todo You Want To Edit");
                    //adds updateTodoNumber to the updateTodoFrame
                    updateTodoFrame.add(updateTodoNumber);

                    //sets the Columns for updateTodoNumberInput Box
                    updateTodoNumberInput.setColumns(10);
                    //sets up an ActionListener for updateTodoNumberInput
                    updateTodoNumberInput.addActionListener(this);
                    //Adds the input box called updateTodoNumberInput to the updateTodoFrame
                    updateTodoFrame.add(updateTodoNumberInput);

                    //sets the text for the buttons titleUpdate, DueDateUpdate, categoryUpdate, importanceUpdate, completionUpdate
                    titleUpdate.setText("Title");
                    dueDateUpdate.setText("Due date");
                    categoryUpdate.setText("Category");
                    importanceUpdate.setText("Importance");
                    completionUpdate.setText("Completion");

                    //adds the buttons titleUpdate, dueDateUpdate, categoryUpdate, importanceUpdate, completionUpdate to the updateTodoFrame
                    updateTodoFrame.add(titleUpdate);
                    updateTodoFrame.add(dueDateUpdate);
                    updateTodoFrame.add(categoryUpdate);
                    updateTodoFrame.add(importanceUpdate);
                    updateTodoFrame.add(completionUpdate);

                    //sets the text for out
                    updateTodoText.setText("Press The Button On How You Want To Edit It");
                    //adds out to updateTodoFrame
                    updateTodoFrame.add(updateTodoText);
                }

                //has a JLabel that would display the output of the function listTodos from CLIMenu
                listTodoList.setText(c.listTodos());
                //adds listTodoList to updateTodoFrame
                updateTodoFrame.add(listTodoList);

                //makes all buttons, labels, text fields visible on the updateTodoFrame
                updateTodoFrame.setVisible(true);
            }
        });

        ////////////////////////////////////------------------------------- Title Update Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        titleUpdateQuestion = new JLabel();
        titleUpdateTitleInput = new JTextField();
        updateSubmitTitle = new JButton();

        //Creates a new frame called titleUpdateFrame
        JFrame titleUpdateFrame = new JFrame("Title Update");
        titleUpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        titleUpdateFrame.setSize(1250, 500);
        titleUpdateFrame.setLayout(new FlowLayout());
        titleUpdateFrame.setLocation(250, 50);

        //creates an ActionListener for the button titleUpdate so when the button is pressed it can perform what it is meant to perform
        titleUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                try {
                    //closes updateTodoFrame
                    updateTodoFrame.dispose();
                    //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                    int n = Integer.parseInt(updateTodoNumberInput.getText());
                    //checks whether n is a valid number
                    if (n > 0 && n <= c.todos.size()) {
                        //Sets the Text for titleUpdateQuestion
                        titleUpdateQuestion.setText("Type The New Title In The Box And Press The Button To Update It");
                        //Adds the JLabel called titleUpdateQuestion to the titleUpdateFrame
                        titleUpdateFrame.add(titleUpdateQuestion);
                        //sets the Columns for titleUpdateTitleInput Box
                        titleUpdateTitleInput.setColumns(10);
                        //sets up an ActionListener for titleUpdateTitleInput
                        titleUpdateTitleInput.addActionListener(this);
                        //Adds the input box called titleUpdateTitleInput to the titleUpdateFrame
                        titleUpdateFrame.add(titleUpdateTitleInput);

                        //Sets the Text for updateSubmitTitle
                        updateSubmitTitle.setText("Update The Title");
                        //sets up an actionListener for updateSubmitTitle
                        updateSubmitTitle.addActionListener(this);
                        //Adds the JButton called UpdateSubmitTitle to the Frame titleUpdateFrame
                        titleUpdateFrame.add(updateSubmitTitle);
                        //makes all buttons, labels, text fields visible on the titleUpdateFrame
                        titleUpdateFrame.setVisible(true);
                    }
                    //if n is not a valid input then it would tell the user that the number entered is invalid
                    else if (n <= 0 || n > c.todos.size()) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Number Entered Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                } catch (Exception e1) {
                    //sets text for invalidOutput
                    invalidOutput.setText("Invalid Input Entered Please Try Again");
                    //adds the invalidOutput to invalidFrame
                    invalidFrame.add(invalidOutput);
                    //makes all buttons, labels, text fields visible on the invalidFrame
                    invalidFrame.setVisible(true);
                }
            }
        });
        //new instance of JLabel, JTextField and JButton
        updateSubmitTitleOutput = new JLabel();

        //Creates a new frame called UpdateSubmitTitleFrame
        JFrame updateSubmitTitleFrame = new JFrame("Title Update Output");
        updateSubmitTitleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateSubmitTitleFrame.setSize(1250, 500);
        updateSubmitTitleFrame.setLayout(new FlowLayout());
        updateSubmitTitleFrame.setLocation(250, 50);

        //creates an ActionListener for the button updateSubmitTitle so when the button is pressed it can perform what it is meant to perform
        updateSubmitTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closes titleUpdateFrame
                titleUpdateFrame.dispose();
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Update The Title")) {
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                        int n = Integer.parseInt(updateTodoNumberInput.getText());
                        //String title is the inputted string in the input box by the user for the title of the todo
                        String title = titleUpdateTitleInput.getText();
                        //calls titleUpdate from CLIMenu with the number inputted by the user and the new title to be added and sets the output of the function to the JLabel updateSubmitTitleOutput
                        updateSubmitTitleOutput.setText(c.titleUpdate(n, title));
                        //Adds the JLabel called updateSubmitTitleOutput to the Frame updateSubmitTitleFrame
                        updateSubmitTitleFrame.add(updateSubmitTitleOutput);
                        //has a JLabel that would display the output of the function listTodos from CLIMenu
                        listTodoList.setText(c.listTodos());
                        //adds listTodoList to updateSubmitTitleFrame
                        updateSubmitTitleFrame.add(listTodoList);
                        //makes all buttons, labels, text fields visible on the updateSubmitTitleFrame
                        updateSubmitTitleFrame.setVisible(true);
                    } catch (Exception e1) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Title Entered Please Try Again ");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                }
            }
        });

        ////////////////////////////////////------------------------------- Due Date Update Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        dueDateUpdateDateInput = new JTextField();
        updateSubmitDate = new JButton();
        updateDueDateQuestion = new JLabel();

        //Creates a new frame called dueDateUpdateFrame
        JFrame dueDateUpdateFrame = new JFrame("Due Date Update");
        dueDateUpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dueDateUpdateFrame.setSize(1250, 500);
        dueDateUpdateFrame.setLayout(new FlowLayout());
        dueDateUpdateFrame.setLocation(250, 50);

        //creates an ActionListener for the button dueDateUpdate so when the button is pressed it can perform what it is meant to perform
        dueDateUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                try {
                    //closes UpdateTodoFrame
                    updateTodoFrame.dispose();
                    //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                    int n = Integer.parseInt(updateTodoNumberInput.getText());
                    //checks whether n is a valid number
                    if (n > 0 && n <= c.todos.size()) {
                        //sets the text for updateDueDateQuestion
                        updateDueDateQuestion.setText("What is the new due date for the todo? (Submit in the form YYYY-MM-DDTHH:MM");
                        //adds updateDueDateQuestion to the dueDateUpdateFrame
                        dueDateUpdateFrame.add(updateDueDateQuestion);

                        //sets the Columns for dueDateUpdateDateInput Box
                        dueDateUpdateDateInput.setColumns(10);
                        //sets up an ActionListener for dueDateUpdateDateInput
                        dueDateUpdateDateInput.addActionListener(this);
                        //Adds the input box called dueDateUpdateDateInput to the dueDateUpdateFrame
                        dueDateUpdateFrame.add(dueDateUpdateDateInput);

                        //Sets the Text for updateSubmitDate
                        updateSubmitDate.setText("Update The Due Date");
                        //sets up an actionListener for updateSubmitDate
                        updateSubmitDate.addActionListener(this);
                        //Adds the JButton called updateSubmitDate to the Frame dueDateUpdateFrame
                        dueDateUpdateFrame.add(updateSubmitDate);

                        //makes all buttons, labels, text fields visible on the dueDateUpdateFrame
                        dueDateUpdateFrame.setVisible(true);
                    }
                    //if n is not a valid input then it would tell the user that the number entered is invalid
                    else if (n <= 0 || n > c.todos.size()) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Number Entered Please Try Again");
                        //adds the invalidOutput to InvalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                } catch (Exception e1) {
                    //sets text for invalidOutput
                    invalidOutput.setText("Invalid Input Entered Please Try Again");
                    //adds the invalidOutput to invalidFrame
                    invalidFrame.add(invalidOutput);
                    //makes all buttons, labels, text fields visible on the invalidFrame
                    invalidFrame.setVisible(true);
                }
            }
        });

        //new instance of JLabel, JTextField and JButton
        updateSubmitDateOutput = new JLabel();
        //Creates a new frame called updateSubmitDateFrame
        JFrame updateSubmitDateFrame = new JFrame("Due Date Update Output");
        updateSubmitDateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateSubmitDateFrame.setSize(1250, 500);
        updateSubmitDateFrame.setLayout(new FlowLayout());
        updateSubmitDateFrame.setLocation(250, 50);

        //creates an ActionListener for the button updateSubmitDate so when the button is pressed it can perform what it is meant to perform
        updateSubmitDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closes dueDateUpdateFrame
                dueDateUpdateFrame.dispose();
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Update The Due Date")) {
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                        int n = Integer.parseInt(updateTodoNumberInput.getText());

                        //LocalDateTime localDate saves the inputted String in the input box by the user for the LocalDate by using LocalDateTime.parse(dueDateUpdateDateInput.getText())
                        //which obtains an instance of LocalDateTime from a text string which is in the format of YYYY-MM-DDTHH:MM
                        LocalDateTime newDueDate = LocalDateTime.parse(dueDateUpdateDateInput.getText());

                        //calls dueDateUpdate from CLIMenu with the number inputted by the user and the new Due Date to be added and sets the output of the function to the JLabel updateSubmitDateOutput
                        updateSubmitDateOutput.setText(c.dueDateUpdate(n, newDueDate));
                        //Adds updateSubmitDateOutput to updateSubmitDateFrame
                        updateSubmitDateFrame.add(updateSubmitDateOutput);

                        //has a JLabel that would display the output of the function listTodos from CLIMenu
                        listTodoList.setText(c.listTodos());
                        //adds ListTodoList to UpdateSubmitDateFrame
                        updateSubmitDateFrame.add(listTodoList);
                        //makes all buttons, labels, text fields visible on the updateSubmitDateFrame
                        updateSubmitDateFrame.setVisible(true);

                    } catch (Exception e1) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Due Date Entered");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                }
            }
        });

        ////////////////////////////////////------------------------------- Category Update Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        categoryUpdateOutput = new JLabel();
        categoryUpdateQuestion = new JLabel();
        updateSubmitCategory = new JButton();
        //Creates a new frame called categoryUpdateFrame
        JFrame categoryUpdateFrame = new JFrame("Category Update");
        categoryUpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        categoryUpdateFrame.setSize(1250, 500);
        categoryUpdateFrame.setLayout(new FlowLayout());
        categoryUpdateFrame.setLocation(250, 50);

        //creates an ActionListener for the button categoryUpdate so when the button is pressed it can perform what it is meant to perform
        categoryUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                try {
                    //closes updateTodoFrame
                    updateTodoFrame.dispose();
                    //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                    int n = Integer.parseInt(updateTodoNumberInput.getText());
                    //checks whether n is a valid number
                    if (n > 0 && n <= c.todos.size()) {

                        //Sets the Text for categoryUpdateQuestion
                        categoryUpdateQuestion.setText("Please Select The New Category For The Todo");
                        //adds categoryUpdateQuestion to categoryUpdateFrame
                        categoryUpdateFrame.add(categoryUpdateQuestion);

                        //Sets the Text for categoryUpdateOutput
                        categoryUpdateOutput.setText("Select The New Category ");
                        //adds categoryUpdateOutput to categoryUpdateFrame
                        categoryUpdateFrame.add(categoryUpdateOutput);

                        //sets up an actionListener for categoryOutputUpdate
                        categoryOutputUpdate.addActionListener(this);
                        //Adds the JComboBox called categoryOutputUpdate to the Frame categoryUpdateFrame
                        categoryUpdateFrame.add(categoryOutputUpdate);

                        //Sets the Text for updateSubmitCategory
                        updateSubmitCategory.setText("Update The Category");
                        //sets up an actionListener for updateSubmitCategory
                        updateSubmitCategory.addActionListener(this);
                        //Adds the JButton called updateSubmitCategory to the Frame categoryUpdateFrame
                        categoryUpdateFrame.add(updateSubmitCategory);

                        //makes all buttons, labels, text fields visible on the categoryUpdateFrame
                        categoryUpdateFrame.setVisible(true);
                    }
                    //if n is not a valid input then it would tell the user that the number entered is invalid
                    else if (n <= 0 || n > c.todos.size()) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Number Entered Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                } catch (Exception e1) {
                    //sets text for invalidOutput
                    invalidOutput.setText("Invalid Input Entered Please Try Again");
                    //adds the invalidOutput to invalidFrame
                    invalidFrame.add(invalidOutput);
                    //makes all buttons, labels, text fields visible on the invalidFrame
                    invalidFrame.setVisible(true);
                }
            }
        });

        //new instance of JLabel, JTextField and JButton
        updateSubmitCategoryOutput = new JLabel();
        //Creates a new frame called updateSubmitCategoryFrame
        JFrame updateSubmitCategoryFrame = new JFrame("Category Update Output");
        updateSubmitCategoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateSubmitCategoryFrame.setSize(1250, 500);
        updateSubmitCategoryFrame.setLayout(new FlowLayout());
        updateSubmitCategoryFrame.setLocation(250, 50);

        //creates an ActionListener for the button updateSubmitCategory so when the button is pressed it can perform what it is meant to perform
        updateSubmitCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Update The Category")) {
                    //closes categoryUpdateFrame
                    categoryUpdateFrame.dispose();
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                        int n = Integer.parseInt(updateTodoNumberInput.getText());
                        //passes the (String) categoryOutputUpdate.getSelectedItem() is set to and returns an enum that matches the string and saves it to newCategory which has a Type Category
                        Category newCategory = Category.valueOf((String) categoryOutputUpdate.getSelectedItem());
                        //calls categoryUpdate from CLIMenu with the number inputted by the user and the new Category to be added and sets the output of the function to the JLabel updateSubmitCategoryOutput
                        updateSubmitCategoryOutput.setText(c.categoryUpdate(n, newCategory));
                        //Adds updateSubmitCategoryOutput to updateSubmitCategoryFrame
                        updateSubmitCategoryFrame.add(updateSubmitCategoryOutput);
                        //has a JLabel that would display the output of the function Listtodos from CLIMenu
                        listTodoList.setText(c.listTodos());
                        //adds listTodoList to updateSubmitCategoryFrame
                        updateSubmitCategoryFrame.add(listTodoList);

                        //makes all buttons, labels, text fields visible on the updateSubmitCategoryFrame
                        updateSubmitCategoryFrame.setVisible(true);

                    } catch (Exception e1) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Category Entered Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                }
            }
        });

        ////////////////////////////////////------------------------------- Status/Completion Update Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        completionUpdateOutput = new JLabel();
        updateSubmitCompletion = new JButton();

        //array with type String which contains all possible Status/Completion
        String[] completionStrings = {"pending", "started", "partial", "completed"};
        //creates JComboBox for Status/Completion and saves it to completionOutputUpdate
        JComboBox completionOutputUpdate = new JComboBox(completionStrings);

        //Creates a new frame called completionUpdateFrame
        JFrame completionUpdateFrame = new JFrame("Completion Update");
        completionUpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        completionUpdateFrame.setSize(1250, 500);
        completionUpdateFrame.setLayout(new FlowLayout());
        completionUpdateFrame.setLocation(250, 50);

        //creates an ActionListener for the button completionUpdate so when the button is pressed it can perform what it is meant to perform
        completionUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                try {
                    //closes updateTodoFrame
                    updateTodoFrame.dispose();
                    //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                    int n = Integer.parseInt(updateTodoNumberInput.getText());
                    //checks whether n is a valid number
                    if (n > 0 && n <= c.todos.size()) {
                        //Sets the Text for CompletionUpdateOutput
                        completionUpdateOutput.setText("Select The New Status ");
                        //adds completionUpdateOutput to completionUpdateFrame
                        completionUpdateFrame.add(completionUpdateOutput);

                        //sets up an actionListener for completionOutputUpdate
                        completionOutputUpdate.addActionListener(this);
                        //Adds the JComboBox called completionOutputUpdate to the Frame completionUpdateFrame
                        completionUpdateFrame.add(completionOutputUpdate);

                        //Sets the Text for updateSubmitCompletion
                        updateSubmitCompletion.setText("Update The Importance");
                        //sets up an actionListener for updateSubmitCompletion
                        updateSubmitCompletion.addActionListener(this);
                        //Adds the JButton called updateSubmitCompletion to the Frame completionUpdateFrame
                        completionUpdateFrame.add(updateSubmitCompletion);

                        //makes all buttons, labels, text fields visible on the completionUpdateFrame
                        completionUpdateFrame.setVisible(true);

                    }
                    //if n is not a valid input then it would tell the user that the number entered is invalid
                    else if (n <= 0 || n > c.todos.size()) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Number Entered Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                } catch (Exception e1) {
                    //sets text for invalidOutput
                    invalidOutput.setText("Invalid Input Entered Please Try Again");
                    //adds the invalidOutput to invalidFrame
                    invalidFrame.add(invalidOutput);
                    //makes all buttons, labels, text fields visible on the invalidFrame
                    invalidFrame.setVisible(true);
                }
            }
        });

        //new instance of JLabel, JTextField and JButton
        updateSubmitCompletionOutput = new JLabel();

        //Creates a new frame called updateSubmitCompletionFrame
        JFrame updateSubmitCompletionFrame = new JFrame("Completion Update Output");
        updateSubmitCompletionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateSubmitCompletionFrame.setSize(1250, 500);
        updateSubmitCompletionFrame.setLayout(new FlowLayout());
        updateSubmitCompletionFrame.setLocation(250, 50);

        //creates an ActionListener for the button updateSubmitCompletion so when the button is pressed it can perform what it is meant to perform
        updateSubmitCompletion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closes completionUpdateFrame
                completionUpdateFrame.dispose();
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Update The Importance")) {
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                        int n = Integer.parseInt(updateTodoNumberInput.getText());
                        //passes the (String) completionOutputUpdate.getSelectedItem() is set to and returns an enum that matches the string and saves it to newStatus which has a Type Status
                        Status newStatus = Status.valueOf((String) completionOutputUpdate.getSelectedItem());
                        //calls statusUpdate from CLIMenu with the number inputted by the user and the new Status to be added and sets the output of the function to the JLabel updateSubmitCompletionOutput
                        updateSubmitCompletionOutput.setText(c.statusUpdate(n, newStatus));
                        //Adds UpdateSubmitCompletionOutput to UpdateSubmitCompletionFrame
                        updateSubmitCompletionFrame.add(updateSubmitCompletionOutput);

                        //has a JLabel that would display the output of the function listTodos from CLIMenu
                        listTodoList.setText(c.listTodos());
                        //adds listTodoList to updateSubmitCompletionFrame
                        updateSubmitCompletionFrame.add(listTodoList);

                        //makes all buttons, labels, text fields visible on the updateSubmitCompletionFrame
                        updateSubmitCompletionFrame.setVisible(true);

                    } catch (Exception e1) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Status Entered Please Try Again");
                        //adds the invalidOutput to InvalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);

                    }
                }

            }
        });

        ////////////////////////////////////------------------------------- Importance Update Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        importanceUpdateOutput = new JLabel();
        updateSubmitImportance = new JButton();

        //Creates a new frame called importanceUpdateFrame
        JFrame importanceUpdateFrame = new JFrame("Importance Update");
        importanceUpdateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        importanceUpdateFrame.setSize(1250, 500);
        importanceUpdateFrame.setLayout(new FlowLayout());
        importanceUpdateFrame.setLocation(250, 50);

        //creates an ActionListener for the button importanceUpdate so when the button is pressed it can perform what it is meant to perform
        importanceUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                try {
                    //closes updateTodoFrame
                    updateTodoFrame.dispose();
                    //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                    int n = Integer.parseInt(updateTodoNumberInput.getText());
                    //checks whether n is a valid number
                    if (n > 0 && n <= c.todos.size()) {

                        //Sets the Text for importanceUpdateOutput
                        importanceUpdateOutput.setText("Select The New Importance ");
                        //adds importanceUpdateOutput to importanceUpdateFrame
                        importanceUpdateFrame.add(importanceUpdateOutput);

                        //sets up an actionListener for importanceOutputUpdate
                        importanceOutputUpdate.addActionListener(this);
                        //Adds the JComboBox called importanceOutputUpdate to the Frame importanceUpdateFrame
                        importanceUpdateFrame.add(importanceOutputUpdate);

                        //Sets the Text for updateSubmitImportance
                        updateSubmitImportance.setText("Update The Importance");
                        //sets up an actionListener for updateSubmitImportance
                        updateSubmitImportance.addActionListener(this);
                        //Adds the JButton called updateSubmitImportance to the Frame importanceUpdateFrame
                        importanceUpdateFrame.add(updateSubmitImportance);

                        //makes all buttons, labels, text fields visible on the importanceUpdateFrame
                        importanceUpdateFrame.setVisible(true);
                    }
                    //if n is not a valid input then it would tell the user that the number entered is invalid
                    else if (n <= 0 || n > c.todos.size()) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Number Entered Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);

                    }
                } catch (Exception e1) {
                    //sets text for invalidOutput
                    invalidOutput.setText("Invalid Input Entered Please Try Again");
                    //adds the invalidOutput to invalidFrame
                    invalidFrame.add(invalidOutput);
                    //makes all buttons, labels, text fields visible on the invalidFrame
                    invalidFrame.setVisible(true);
                }
            }
        });

        //new instance of JLabel, JTextField and JButton
        updateSubmitImportanceOutput = new JLabel();
        //Creates a new frame called updateSubmitImportanceFrame
        JFrame updateSubmitImportanceFrame = new JFrame("Importance Update Output");
        updateSubmitImportanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updateSubmitImportanceFrame.setSize(1250, 500);
        updateSubmitImportanceFrame.setLayout(new FlowLayout());
        updateSubmitImportanceFrame.setLocation(250, 50);

        //creates an ActionListener for the button UpdateSubmitImportance so when the button is pressed it can perform what it is meant to perform
        updateSubmitImportance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closes importanceUpdateFrame
                importanceUpdateFrame.dispose();
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Update The Importance")) {
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //gets the number the user inputted for the todo they want to update then it parses a string and returns an integer and saves that integer to n
                        int n = Integer.parseInt(updateTodoNumberInput.getText());

                        //passes the (String) importanceOutputUpdate.getSelectedItem() is set to and returns an enum that matches the string and saves it to newImportance which has a Type Importance
                        Importance newImportance = Importance.valueOf((String) importanceOutputUpdate.getSelectedItem());

                        //calls importanceUpdate from CLIMenu with the number inputted by the user and the new Importance to be added and sets the output of the function to the JLabel updateSubmitImportanceOutput
                        updateSubmitImportanceOutput.setText(c.importanceUpdate(n, newImportance));
                        //Adds updateSubmitImportanceOutput to updateSubmitImportanceFrame
                        updateSubmitImportanceFrame.add(updateSubmitImportanceOutput);

                        //has a JLabel that would display the output of the function listTodos from CLIMenu
                        listTodoList.setText(c.listTodos());
                        //adds ListTodoList to updateSubmitImportanceFrame
                        updateSubmitImportanceFrame.add(listTodoList);

                        //makes all buttons, labels, text fields visible on the updateSubmitImportanceFrame
                        updateSubmitImportanceFrame.setVisible(true);

                    } catch (Exception e1) {
                        //sets text for invalidOutput
                        invalidOutput.setText("Invalid Importance Entered Please Try Again");
                        //adds the invalidOutput to invalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                }

            }
        });


        ////////////////////////////////////------------------------------- Delete Todos -----------------------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
        //new instance of JLabel, JTextField and JButton
        deleteTodoNumber = new JLabel();
        deleteTodoNumberInput = new JTextField();
        deleteSubmit = new JButton();

        //Creates a new frame called deleteTodoFrame
        JFrame deleteTodoFrame = new JFrame("Delete Todo");
        deleteTodoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteTodoFrame.setSize(1250, 500);
        deleteTodoFrame.setLayout(new FlowLayout());
        deleteTodoFrame.setLocation(250, 50);

        //creates an ActionListener for the button deleteTodo so when the button is pressed it can perform what it is meant to perform
        deleteTodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //checks if todo list is not empty
                if (c.todos.size() != 0) {

                    //Sets the Text for deleteTodoNumber
                    deleteTodoNumber.setText("Please enter the todos number that you want to delete");
                    //adds deleteTodoNumber to deleteTodoFrame
                    deleteTodoFrame.add(deleteTodoNumber);

                    //sets the Columns for deleteTodoNumberInput Box
                    deleteTodoNumberInput.setColumns(10);
                    //sets up an ActionListener for deleteTodoNumberInput
                    deleteTodoNumberInput.addActionListener(this);
                    //Adds the input box called deleteTodoNumberInput to the deleteTodoFrame
                    deleteTodoFrame.add(deleteTodoNumberInput);

                    //Sets the Text for deleteSubmit
                    deleteSubmit.setText("Delete The Todo");
                    //sets up an actionListener for deleteSubmit
                    deleteSubmit.addActionListener(this);
                    //Adds the JButton called deleteSubmit to the Frame deleteTodoFrame
                    deleteTodoFrame.add(deleteSubmit);

                    //makes all buttons, labels, text fields visible on the deleteTodoFrame
                    deleteTodoFrame.setVisible(true);

                }

                //has a JLabel that would display the output of the function listTodos from CLIMenu
                listTodoList.setText(c.listTodos());
                //adds ListTodoList to deleteTodoFrame
                deleteTodoFrame.add(listTodoList);

                //makes all buttons, labels, text fields visible on the deleteTodoFrame
                deleteTodoFrame.setVisible(true);
            }
        });

        //new instance of JLabel, JTextField and JButton
        deleteSubmitOutput = new JLabel();
        //Creates a new frame called deleteSubmitFrame
        JFrame deleteSubmitFrame = new JFrame("Delete Todo Output");
        deleteSubmitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteSubmitFrame.setSize(1250, 500);
        deleteSubmitFrame.setLayout(new FlowLayout());
        deleteSubmitFrame.setLocation(250, 50);

        //creates an ActionListener for the button deleteSubmit so when the button is pressed it can perform what it is meant to perform
        deleteSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //closes deleteTodoFrame
                deleteTodoFrame.dispose();
                //checks if the correct button is pressed
                if (e.getActionCommand().equals("Delete The Todo")) {
                    //try and catch to catch if there is any input error by the user and would tell the user that the input is incorrect
                    try {
                        //gets the number the user inputted for the todo they want to delete then saves it to the string TodoToDelete
                        String todoToDelete = deleteTodoNumberInput.getText();
                        //calls deleteTodo from CLIMenu with the number inputted by the user (by doing Integer.parseInt to the todoToDelete String to get the number inputted)
                        //of the todo to be deleted and deletes it and sets the output of the function to the JLabel deleteSubmitOutput
                        deleteSubmitOutput.setText(c.deleteTodo(Integer.parseInt(todoToDelete)));
                        //Adds deleteSubmitOutput to deleteSubmitFrame
                        deleteSubmitFrame.add(deleteSubmitOutput);

                        //makes all buttons, labels, text fields visible on the deleteSubmitFrame
                        deleteSubmitFrame.setVisible(true);
                    } catch (Exception e1) {
                        //sets text for deleteSubmitOutput
                        deleteSubmitOutput.setText("Invalid Input");
                        //adds the deleteSubmitOutput to deleteSubmitFrame
                        deleteSubmitFrame.add(deleteSubmitOutput);
                        //makes all buttons, labels, text fields visible on the deleteSubmitFrame
                        deleteSubmitFrame.setVisible(true);
                    }
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        //invoke later passes a new runnable object to it which creates a new Main() object and allows the GUI And App to run together
        SwingUtilities.invokeLater(() -> new Main());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
