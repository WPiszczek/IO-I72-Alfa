package pl.put.poznan.sortingmadness.logic;

import java.util.Arrays.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class SortingMadness {

    private Object[] array;

    public SortingMadness(Object[] array){
        this.array = array;
    }

    public Object[] exampleSort1(){
        java.util.Arrays.sort(this.array);
        return array;
    }

    public Object[] exampleSort2(){
        java.util.Arrays.sort(this.array);
        return array;
    }

    public Object[] bubbleSort(){
        //TO DO
        return array;
    }

    public Object[] selectionSort(){
        //TO DO
        return array;
    }

    public Object[] insertionSort(){
        //TO DO
        return array;
    }

    public Object[] shellSort(){
        //TO DO
        return array;
    }

    public Object[] heapSort(){
        //TO DO
        return array;
    }

    public Object[] quickSort(){
        //TO DO
        return array;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}
