package pl.put.poznan.sortingmadness.logic;

import java.util.Arrays.*;

/**
 * Sorting Madness Class
 */
public abstract class SortingMadness {

    protected Object[] array;
    protected long time;

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
     * method to measure sorting time
     * @param reverse - flag - true if user wants to sort descending
     * @return sorted array of Objects
     */
    public Object[] sortMeasurment(boolean reverse){
        long start = System.nanoTime();
        Object[] ret = this.sort(reverse);
        this.time = System.nanoTime() - start;
        return ret;
    }

    /**
     * getter
     * @return
     */
    public long getTime() {
        return time;
    }

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
