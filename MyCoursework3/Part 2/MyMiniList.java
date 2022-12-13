import java.util.Objects;

//MyMiniList class inherits MiniList with generic type T
public class MyMiniList<T> implements MiniList<T> {
    //initialising new array called objectStore which takes type T and has an initial size of 10.
    T[] objectStore = (T[]) new Object[10];
    int size = 0;

    //adds new element to end of the array objectStore if array has space if not it would create a new array twice the size,
    //copy the existing elements and replace the existing objectStore with this new array
    public void add(T element) {
        //checks if the array has space
        if(objectStore.length > size) {
            //loops over the length of the array
            for (int i = size; i < objectStore.length; i++) {
                //looks for the next available position within the array (if available it would be null)
                if (objectStore[i] == null) {
                    //sets the element to position that was available in the array.
                    objectStore[i] = element;
                    break;//stops loop from going on
                }
            }
            //increment size after a new element has been added
            size++;
        } else {
            //if array size is the same as size then the array has no space so it would call the resize function which would create a new array twice the size,
            //it would copy the existing elements and replace the existing objectStore with this new array and it copies all elements from one array to another by using system.arraycopy
            if (objectStore.length == size) {
                //resizes objectStore and copies all elements added in the resized array
                objectStore = resize();
            }
            //loops over the new length of the array beginning from size because all indexes before size have a element already
            for (int j = size; j < objectStore.length; j++) {
                //looks for the next available position within the array (if available it would be null)
                if (objectStore[j] == null) {
                    //sets the element to position that was available in the array.
                    objectStore[j] = element;
                    break;//stops loop from going on
                }
            }
            //increment size after a new element has been added
            size++;
        }
    }

    //resize() would create a new array twice the size, copy the existing elements and replace the existing object store with this new array
    //and it copies all elements from one array to another by using system.arraycopy then it returns the new Array called objectStoreNew
    public T[] resize() {
        T[] objectStoreNew = (T[]) new Object[objectStore.length * 2];
        System.arraycopy(objectStore, 0, objectStoreNew, 0, objectStore.length);

        return objectStoreNew;
    }

    //Checks that the index given is within the required bounds
    public T get(int index) {
        //if index is invalid this would cause an error so try and catch is used to see whether index is invalid and if it is then the catch code would be executed
        try {
            //Checks if the index is within the bounds of the range from 0 (inclusive) to objectStore.length (exclusive) and then it saves it to valid
            int valid = Objects.checkIndex(index, objectStore.length);

            //returns the item at the index if valid
            return objectStore[valid];
        }
        //if index is invalid then catch would return Invalid Index
        catch (Exception e) {
            return (T) "Invalid Index";
        }
    }

    //searches through the list for the first occurrence of the element given as an argument and if found it would return the index else it would return -1
    public int getIndex(T element) {
        //loops over the array
        for (int i = 0; i < objectStore.length; i++) {
            //compares each element at each index with the element that was given as an argument if element is found it would return i
            if (objectStore[i] == element) {
                return i;
            }
        }
        //if element that was being searched for is not found then it would return -1
        return -1;
    }

    //Check if the index is valid. If so it would set the value at the index to be the element given in the second parameter.
    public void set(int index, T element) {
        //checks if index is valid
        if (objectStore.length > index && index >= 0) {
            //sets the element at index to the new element
            objectStore[index] = element;
        }
        else{
            //prints a statement saying that the index is out of bounds and the element cannot be set to tha index
            System.out.println("Index " + index +" Is Out Of Bounds Hence Cannot Set Element " + element + " At Index");
        }
    }

    //returns the size of the list
    public int size() {
        return size;
    }


    //If index is valid it would then remove the element at that index and return it.
    public T remove(int index) {
          //checks if index is valid
          if (objectStore.length > index && index >= 0) {
              //checks if the index is populated if it is not equal to null then there is an element there.
              if (objectStore[index] != null) {
                  //sets removedIndex to be the element that is going to be removed
                  T removedIndex = objectStore[index];
                  //for loop that loops from the index to the length of the array and removes the element at the index by replacing its values with the elements next to it
                  //so there is no gap and the element is removed
                  for (int i = index; i < objectStore.length - 1; i++) {
                      objectStore[i] = objectStore[i + 1];
                  }
                  //after element is removed decrement size by 1
                  size--;
                  System.out.println("The Element " + removedIndex + " At The Index " + index + " Has Been Removed From The Array");
                  //returns the element that was removed
                  return removedIndex;
              }
              else {
                  //prints a statement saying the index does not have a element to delete as it is equal to null
                  System.out.println("Index " + index +" Does Not Contain An Element");
              }
          }
          else{
              //prints a statement saying that the index is out of bounds.
              System.out.println("Index Out Of Bounds For Index : " + index);
          }
          //returns null if nothing is deleted.
          return null;
    }

    //Removes an element from the array and shifts array so there are no gaps
    public boolean remove(T element) {
        //checks if the element is in the array and would save the output of the method getIndex(element) to index
        int index = getIndex(element);

        //if index does not equal to -1 then the element exists in the array and index would be the index of the element in the array
        if(index != -1) {
                //for loop that would loop from the position of the element to the end of the array
                for (int j = index; j < objectStore.length - 1; j++) {
                    //removes element by replacing the value of the array with the element that is next to it and then it would shift all the other elements so there is no gaps in the array
                    objectStore[j] = objectStore[j + 1];
                }
                //decrement the size after the element has been removed
                size--;
                //prints a statement confirming the element has been removed from the array
                System.out.println("The Element " + element + " Has Been Removed From The Array");
                //return true to indicate that the element has been removed
                return true;
            }
        //prints a statement saying the element does not exist in the array
        System.out.println("The Element " + element + " Does Not Exist In The Array");
        //return false to indicate that the element has not been removed as it did not exist in the array
        return false;
    }

    //Empties the list and resets size to 0.
    public void clear() {
        //sets the size of the array to 10 (which is its original size) by creating a new instance of it with the size being 10 which would cause the array to be empty
        objectStore = (T[]) new Object[10];
        //sets size to 0 as well
        size = 0;
    }

}
