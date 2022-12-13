//creating the Category enum which stores the enumeration constants for Category.
public enum Category {
    //list of colours in ASCII form
    red("\033[0;31m"), white("\033[0;37m"), blue("\033[0;34m"), purple("\033[0;35m"), yellow("\033[0;33m"), green("\033[0;32m");

    //private instance
    private String colour;

    //constructor to set the initial value of the colour
    Category(String c) {
        colour = c;
    }

    //get method which gets the colour and returns it.
    public String getColour() {
        return colour;
    }
}
