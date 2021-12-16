package pl.put.poznan.sortingmadness.logic;

import java.util.Arrays.*;

/**
 * Sorting Madness Class
 */
public abstract class SortingMadness {

    protected Object[] array;

    /**
     * class constructor
     * @param array
     */
    public SortingMadness(Object[] array){
        this.array = array;
    }

    /**
     * abstract method
     * @param reverse - flag - true if user wants to sort descending
     * @return sorted array of Objects
     */
    public abstract Object[] sort(boolean reverse);

    /**
     * getter
     * @return
     */
    public Object[] getArray() {
        return array;
    }

    /**
     * setter
     * @param array
     */
    public void setArray(Object[] array) {
        this.array = array;
    }
}
