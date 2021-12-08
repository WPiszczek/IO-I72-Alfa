package pl.put.poznan.sortingmadness.logic;

import java.util.Arrays.*;

/**
 * Sorting Madness Class
 */
public abstract class SortingMadness {

    protected Object[] array;

    /**
     *
     * @param array
     */
    public SortingMadness(Object[] array){
        this.array = array;
    }

    public abstract Object[] sort();

    /**
     *
     * @return
     */
    public Object[] getArray() {
        return array;
    }

    /**
     *
     * @param array
     */
    public void setArray(Object[] array) {
        this.array = array;
    }
}
