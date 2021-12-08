package pl.put.poznan.sortingmadness.logic;

public class HeapSort extends SortingMadness {

    public HeapSort(Object[] array) {
        super(array);
    }

    @Override
    public Object[] sort() {
        return this.array;
    }
}
