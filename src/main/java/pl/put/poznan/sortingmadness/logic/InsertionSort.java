package pl.put.poznan.sortingmadness.logic;

public class InsertionSort extends SortingMadness {

    /**
     * InsertionSort class constructor
     * @param array array of type Object
     */
    public InsertionSort(Object[] array) {
        super(array);
    }

    /**
     * Sorting method
     * @return array of type Object
     */
    @Override
    public Object[] sort() {
        Object[] array = this.array.clone();
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            Object key = array[i];
            int j = i - 1;

            Comparable a = (Comparable) key;
            while (j >= 0 && a.compareTo(array[j]) < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}


