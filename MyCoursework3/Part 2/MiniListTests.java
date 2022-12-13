public class MiniListTests {

    //add elements to the array
    public static void main(String[] args) {

        //Creates a arraylist called ml which has a new instance of MyMiniList
        MyMiniList<String> ml = new MyMiniList<String>();

        //adds new elements
        ml.add("aliceblue");
        ml.add("antiquewhite");
        ml.add("aqua");
        ml.add("aquamarine");
        ml.add("azure");
        ml.add("beige");
        ml.add("bisque");
        ml.add("black");
        ml.add("blanchedalmond");
        ml.add("blue");
        ml.add("blueviolet");
        ml.add("brown");
        ml.add("burlywood");
        ml.add("cadetblue");
        ml.add("chartreuse");
        ml.add("chocolate");
        ml.add("coral");
        ml.add("cornflowerblue");
        ml.add("cornsilk");
        ml.add("crimson");
        ml.add("cyan");
        ml.add("darkblue");
        ml.add("darkcyan");
        ml.add("darkgoldenrod");
        ml.add("darkgray");
        ml.add("darkgreen");
        ml.add("darkgrey");
        ml.add("darkkhaki");
        ml.add("darkmagenta");
        ml.add("darkolivegreen");
        ml.add("coral");

        //gets element at index 23
        String atIndex = ml.get(23);
        System.out.println("At the 23rd Location is " + atIndex);

        //gets first occurrence of coral
        int n = ml.getIndex("coral");
        System.out.println("coral is at " + n);

        //sets value at index 9 to testUpdate and sets value at index 23 to testUpdate2
        ml.set(9, "testUpdate");
        ml.set(23, "testUpdate2");

        //remove by object (Crimson)
        ml.remove("crimson");
        //remove by index (7)
        ml.remove(7);

        //prints out each element in the array does not print out empty spaces in the array
        for(int i = 0; i< ml.size(); i++){
            System.out.println(ml.get(i));
        }

        //clear the array
        ml.clear();
        System.out.println("the size of ml is " + ml.size());

    }

}
