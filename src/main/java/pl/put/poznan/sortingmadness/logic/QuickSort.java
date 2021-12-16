package pl.put.poznan.sortingmadness.logic;

public class QuickSort extends SortingMadness {

    public QuickSort(Object[] array) {
        super(array);
    }


    @Override
    public Object[] sort(boolean reverse) {
        quickSort(this.array, 0, array.length - 1);
        return array;
    }

    public void quickSort(Object[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }

    int partition(int begin, int end) {
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
        Object temp = this.array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }
}


