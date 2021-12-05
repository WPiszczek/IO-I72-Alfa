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
//        return array;
        String[] arr = {"metoda","1"};
        return arr;
    }

    public Object[] exampleSort2(){
        java.util.Arrays.sort(this.array);
        String[] arr = {"metoda","2"};
        return arr;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}
