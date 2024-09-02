package dev.redgamer6427a.utils.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTool<T> {

    private T[] array;

    /**
     * Constructor
     * @param array the Array to work with
     */
    public ArrayTool(T[] array) {
        this.array = array;
    }

    /**
     * @return the array of this instance
     */
    public T[] array() {
        return array;
    }

    /**
     * Adds an element to the instance's array
     * @param element the element to add
     * @return the instance
     */
    public ArrayTool<T> addElement(T element) {
        List<T> list = new ArrayList<>(Arrays.asList(array));
        list.add(element);
        array = list.toArray((T[]) Array.newInstance(array.getClass().getComponentType(), list.size()));
        return this;
    }

    /**
     * Reverses the instance's array
     * @return the instance
     */
    public ArrayTool<T> reverse() {
        List<T> l = Arrays.stream(array).toList();
        l.reversed();
        array = l.toArray((T[]) Array.newInstance(array.getClass().getComponentType(), l.size()));
        return this;
    }

}
