package pl.put.poznan.sortingmadness.logic;

public class InsertionSort extends SortingMadness {

    public InsertionSort(Object[] array) {
        super(array);
    }

    @Override
    public Object[] sort() {
        return this.array;
    }
}

