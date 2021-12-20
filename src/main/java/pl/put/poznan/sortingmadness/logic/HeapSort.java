package pl.put.poznan.sortingmadness.logic;

/**
 * HeapSort class - implements HeapSort
 */
public class HeapSort extends SortingMadness {

    /**
     * HeapSort class constructor
     * @param array array of type Object
     */
    public HeapSort(Object[] array) {
        super(array);
    }

    /**
     * Sorting method
     * @param reverse boolean - true if user wants to sort descending
     * @return array of type Object
     */
    @Override
    public Object[] sort(boolean reverse) {

        Object[] array = this.array.clone();

        int n = array.length;

        // building heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            if (reverse)
                reverseHeapify(array, n, i);
            else
                heapify(array, n, i);
        }


        // extracting root element from heap
        for (int i = n-1; i > 0; i--) {
            // moving current root to end of array
            Object tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            // calling heapify on reduced heap
            if (reverse)
                reverseHeapify(array, i, 0);
            else
                heapify(array, i, 0);
        }

        return array;
    }

    /**
     * Helper procedure for sorting method
     * @param array array of type Object
     * @param n size of the heap
     * @param i index of the starting element of a tree
     */
    private void heapify(Object[] array, int n, int i) {
        int largest = i; // initialize largest as root
        int left = 2 * i + 1; // left index
        int right = 2 * i + 2; // right index

        Comparable a = (Comparable) array[largest];

        // if left child is larger than root
        if (left < n && a.compareTo(array[left]) < 0) {
            largest = left;
        } else {
            largest = i;
        }

        a = (Comparable) array[largest];

        // if right child is larger than largest so far
        if (right < n && a.compareTo(array[right]) < 0) {
            largest = right;
        }

        // if largest is not root
        if (largest != i) {
            Object tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;

            // heapifying subtree recursively
            heapify (array, n, largest);
        }
    }

    /**
     * Helper procedure for reversed sorting method
     * @param array array of type Object
     * @param n size of the heap
     * @param i index of the starting element of a tree
     */
    private void reverseHeapify(Object[] array, int n, int i) {
        int smallest = i; // initialize smallest as root
        int left = 2 * i + 1; // left index
        int right = 2 * i + 2; // right index

        Comparable a = (Comparable) array[smallest];

        // if left child is smaller than root
        if (left < n && a.compareTo(array[left]) > 0) {
            smallest = left;
        } else {
            smallest = i;
        }

        a = (Comparable) array[smallest];

        // if right child is smaller than smallest so far
        if (right < n && a.compareTo(array[right]) > 0) {
            smallest = right;
        }

        // if smallest is not root
        if (smallest != i) {
            Object tmp = array[i];
            array[i] = array[smallest];
            array[smallest] = tmp;

            // heapifying subtree recursively
            reverseHeapify (array, n, smallest);
        }
    }
}
