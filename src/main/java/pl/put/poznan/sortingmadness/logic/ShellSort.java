package pl.put.poznan.sortingmadness.logic;

public class ShellSort extends SortingMadness {

    /**
     * ShellSort class constructor
     * @param array array of type Object
     */
    public ShellSort(Object[] array) {
        super(array);
    }

    /**
     * Sorting method
     * @return array of type Object
     */
    @Override
    public Object[] sort(boolean reverse) {
        if(reverse) return sort_reverse();
        else return sort_normal();

    }
    /**
     * Helper procedure for sorting method
     */
    public Object[] sort_normal() {
        Object[] array = this.array.clone();
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Object key = array[i];
                int j = i;
                Comparable a = (Comparable) key;
                while (j >= gap && a.compareTo(array[j - gap]) < 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }
        return array;
    }
    /**
     * Helper procedure for sorting method
     */
    public Object[] sort_reverse() {
        Object[] array = this.array.clone();
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Object key = array[i];
                int j = i;
                Comparable a = (Comparable) key;
                while (j >= gap && a.compareTo(array[j - gap]) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
        }
        return array;
    }
}

