package List;

import java.util.Arrays;

public class MyArrayList<E> {

    private static final int INIT_CAPACITY = 10;
    private E[] theData;
    private int size = 0;
    private int capacity = INIT_CAPACITY;

    public MyArrayList() {
        theData = (E[]) new Object[INIT_CAPACITY];


    }

    public void add(int index, E anEntry) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException(index);

        if (size >= capacity)
            reallocation();

        for (int i = size - 1; i >= index; i--)
            theData[i + 1] = theData[i];
        theData[index] = anEntry;

    }

    public int size() {
        return size;
    }

    public int indexOf(E anEntry) {
        for (int i = 0; i < size; i++)
            if (theData[i].equals(anEntry))
                return i;
        return -1;

    }

    public void add(E enEntry) {

        add(size, enEntry);

    }


    private void reallocation() {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

    public static void main(String[] args) {

    }
}
