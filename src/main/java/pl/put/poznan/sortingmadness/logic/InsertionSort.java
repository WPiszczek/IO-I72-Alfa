package pl.put.poznan.sortingmadness.logic;
/**
 * InsertionSort class - implements InsertionSort
 */
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
    public Object[] sort(boolean reverse) {
        if(reverse) return sort_reverse();
        return sort_normal();
    }
    /**
     * Helper procedure for sorting method
     * @return array of type Object
     */
    public Object[] sort_normal() {
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
    /**
     * Helper procedure for sorting method
     * @return array of type Object
     */
    public Object[] sort_reverse() {
        Object[] array = this.array.clone();
        int n = array.length;

        for (int i = 1; i < n; ++i) {
            Object key = array[i];
            int j = i - 1;

            Comparable a = (Comparable) key;
            while (j >= 0 && a.compareTo(array[j]) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}


