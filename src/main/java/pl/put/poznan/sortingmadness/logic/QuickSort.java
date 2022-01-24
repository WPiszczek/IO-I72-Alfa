package pl.put.poznan.sortingmadness.logic;
/**
 * QuickSort class - implements QuickSort
 */
public class QuickSort extends SortingMadness {
    /**
     * QuickSort class constructor
     * @param array - the array passed to sort
     */
    public QuickSort(Object[] array) {
        super(array);
    }

    /**
     * Sorting method
     * @param reverse - flag - true if user wants to sort descending
     * @return array of type Object
     */
    @Override
    public Object[] sort(boolean reverse) {
        Object[] array = this.array.clone();
        if(!reverse) quickSort(array, 0, array.length - 1);
        else quickSort_reverse(array, 0, array.length - 1);
        return array;
    }
    /**
     * Helper procedure for sorting method used in ascending sorting
     * @param array - array passed to be sorted
     * @param begin - index of first element to be sorted
     * @param end - index of last element to be sorted
     */
    public void quickSort(Object[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
    /**
     * Helper procedure for sorting method used in ascending sorting
     * @param array - array passed to be sorted
     * @param begin - index of first element to compare
     * @param end - index of last element to compare
     */
    int partition(Object[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            Comparable a = (Comparable) array[pivot];
            if (a.compareTo(array[i]) > 0) {
                Object temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        Object temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }


    /**
     * Helper procedure for reversed sorting method
     * @param array - array passed to be sorted
     * @param begin - index of first element to be sorted
     * @param end - index of last element to be sorted
     */
    public void quickSort_reverse(Object[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition_reverse(array, begin, end);
        quickSort_reverse(array, begin, pivot-1);
        quickSort_reverse(array, pivot+1, end);
    }
    /**
     * Helper procedure for reversed sorting method
     * @param array - array passed to be sorted
     * @param begin - index of first element to compare
     * @param end - index of last element to compare
     */
    int partition_reverse(Object[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            Comparable a = (Comparable) array[pivot];
            if (a.compareTo(array[i]) < 0) {
                Object temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        Object temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }
}


