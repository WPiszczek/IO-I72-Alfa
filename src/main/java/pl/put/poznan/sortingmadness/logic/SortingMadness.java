package pl.put.poznan.sortingmadness.logic;

/**
 * SortingMadness Class
 */
public abstract class SortingMadness {

    /**
     * array to sort
     */
    protected Object[] array;
    /**
     * variable for time measurement
     */
    protected long time;

    /**
     * default constructor
     */
    public SortingMadness(){}

    /**
     * class constructor
     * @param array - the array passed to sort
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
    public Object[] sortMeasurement(boolean reverse){
        long start = System.nanoTime();
        Object[] ret = this.sort(reverse);
        this.time = System.nanoTime() - start;
        return ret;
    }

    /**
     * getter
     * @return measured time of sorting
     */
    public long getTime() {
        return time;
    }

    /**
     * getter
     * @return array of Objects
     */
    public Object[] getArray() {
        return array;
    }

    /**
     * setter
     * @param array - sets array of Objects
     */
    public void setArray(Object[] array) {
        this.array = array;
    }
}
