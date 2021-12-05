package pl.put.poznan.sortingmadness.logic;

import java.util.Arrays.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class SortingMadness {

    private Object[] array;

    /**
     *
     * @param array
     */
    public SortingMadness(Object[] array){
        this.array = array;
    }

    /**
     *
     * @return
     */
    public Object[] exampleSort1(){
        java.util.Arrays.sort(this.array);
        return array;
    }

    /**
     *
     * @return
     */
    public Object[] bubbleSort(){
        //TO DO
        return array;
    }

    /**
     *
     * @return
     */
    public Object[] selectionSort(){
        //TO DO
        return array;
    }

    /**
     *
     * @return
     */
    public Object[] insertionSort(){
        //TO DO
        return array;
    }

    /**
     *
     * @return
     */
    public Object[] shellSort(){
        //TO DO
        return array;
    }

    /**
     *
     * @return
     */
    public Object[] heapSort(){
        //TO DO
        return array;
    }

    /**
     *
     * @return
     */
    public Object[] quickSort(){
        //TO DO
        return array;
    }

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
