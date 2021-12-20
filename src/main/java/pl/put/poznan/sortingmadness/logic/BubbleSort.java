package pl.put.poznan.sortingmadness.logic;
/**
 * BubbleSort class - implements BubbleSort
 */
public class BubbleSort extends SortingMadness {

    /**
     * BubbleSort class constructor
     * @param array - the array passed to sort
     */
    public BubbleSort(Object[] array) {
        super(array);
    }

    /**
     * Sorting method
     * @param reverse - flag - true if user wants to sort descending
     * @return array of type Object
     */
    @Override
    public Object[] sort(boolean reverse) {
        if(reverse) return sort_reverse();
        else return sort_normal();
    }
    /**
     * Helper procedure for sorting method used in not reversed sorting
     * @return array of type Object
     */
    public Object[] sort_normal() {
        Object[] array = this.array.clone();
        int n = array.length;

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n-i-1; j++) {
                Object b = array[j+1];
                Comparable a = (Comparable) array[j];
                if (a.compareTo(b) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    Object temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
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

        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n-i-1; j++) {
                Object b = array[j+1];
                Comparable a = (Comparable) array[j];
                if (a.compareTo(b) < 0)
                {
                    // swap arr[j+1] and arr[j]
                    Object temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
