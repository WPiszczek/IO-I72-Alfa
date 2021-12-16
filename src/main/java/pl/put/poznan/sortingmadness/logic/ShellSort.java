package pl.put.poznan.sortingmadness.logic;

public class ShellSort extends SortingMadness {

    public ShellSort(Object[] array) {
        super(array);
    }

    @Override
    public Object[] sort(boolean reverse) {
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
}

