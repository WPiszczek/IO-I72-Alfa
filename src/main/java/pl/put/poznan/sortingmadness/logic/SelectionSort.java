package pl.put.poznan.sortingmadness.logic;
/**
 * SelectionSort class - implements SelectionSort
 */
public class SelectionSort extends SortingMadness {

    /**
     * SelectionSort class constructor
     * @param array array of type Object
     */
    public SelectionSort(Object[] array) {
        super(array);
    }

    /**
     * Sorting method
     * @param reverse - flag - true if user wants to sort descending
     * @return array of type Object
     */
    @Override
    public Object[] sort(boolean reverse) {
        if(reverse == false) return sort_normal();
        return sort_reverse();
    }
    /**
     * Helper procedure for sorting method used in not reversed sorting
     * @return array of type Object
     */
    public Object[] sort_normal() {
        Object[] array = this.array.clone();

        int n = array.length;
        for (int i = 0; i < n; i++) {
            Object min = array[i];
            int minimIndex = i;
            for (int j = i+1; j < array.length; j++) {
                Comparable a = (Comparable) array[j];
                // array[j] < min
                if (a.compareTo(min) < 0) {
                    min = array[j];
                    minimIndex = j;
                }
            }

            Object temp = array[i];
            array[i] = min;
            array[minimIndex] = temp;
        }
        return array;
    }
    /**
     * Helper procedure for sorting method used in reversed sorting
     * @return array of type Object
     */
    public Object[] sort_reverse() {
        Object[] array = this.array.clone();

        int n = array.length;
        for (int i = 0; i < n; i++) {
            Object min = array[i];
            int minimIndex = i;
            for (int j = i+1; j < array.length; j++) {
                Comparable a = (Comparable) array[j];
                if (a.compareTo(min) > 0) {
                    min = array[j];
                    minimIndex = j;
                }
            }

            Object temp = array[i];
            array[i] = min;
            array[minimIndex] = temp;
        }
        return array;
    }
}


