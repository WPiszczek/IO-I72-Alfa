package pl.put.poznan.sortingmadness.logic;

public class BubbleSort extends SortingMadness {

    public BubbleSort(Object[] array) {
        super(array);
    }

    @Override
    public Object[] sort(boolean reverse) {
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


}






