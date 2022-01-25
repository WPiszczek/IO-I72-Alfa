package pl.put.poznan.sortingmadness.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingIntTest {

    Random rand = new Random();

    Integer[] array1 = new Integer[0];
    Integer[] array2 = new Integer[20];
    Integer[] array3 = new Integer[300];
    Integer[] array4 = new Integer[1];

    @BeforeEach
    void setUp() {
        for(int i=0; i<20; i++) {
            int int2 = rand.nextInt();
            array2[i] = int2;
        }

        for(int i=0; i<300; i++) {
            int int3 = rand.nextInt();
            array3[i] = int3;
        }

        array4[0] = rand.nextInt();
    }

    @AfterEach
    void tearDown() {
        array1 = null;
        array2 = null;
        array3 = null;
    }

    @Test
    void testBubbleSort() {
        Integer[] array1Sorted = array1.clone();
        Integer[] array2Sorted = array2.clone();
        Integer[] array3Sorted = array3.clone();
        Integer[] array4Sorted = array4.clone();

        Arrays.sort(array1Sorted);
        Arrays.sort(array2Sorted);
        Arrays.sort(array3Sorted);
        Arrays.sort(array4Sorted);

        BubbleSort bubble1 = new BubbleSort(array1);
        assertArrayEquals(bubble1.sort(false), array1Sorted);
        bubble1.setArray(array2);
        assertArrayEquals(bubble1.sort(false), array2Sorted);
        bubble1.setArray(array3);
        assertArrayEquals(bubble1.sort(false), array3Sorted);
        bubble1.setArray(array4);
        assertArrayEquals(bubble1.sort(false), array4Sorted);
    }

    @Test
    void testHeapSort() {
        Integer[] array1Sorted = array1.clone();
        Integer[] array2Sorted = array2.clone();
        Integer[] array3Sorted = array3.clone();
        Integer[] array4Sorted = array4.clone();

        Arrays.sort(array1Sorted);
        Arrays.sort(array2Sorted);
        Arrays.sort(array3Sorted);
        Arrays.sort(array4Sorted);

        HeapSort heap1 = new HeapSort(array1);
        assertArrayEquals(heap1.sort(false), array1Sorted);
        heap1.setArray(array2);
        assertArrayEquals(heap1.sort(false), array2Sorted);
        heap1.setArray(array3);
        assertArrayEquals(heap1.sort(false), array3Sorted);
        heap1.setArray(array4);
        assertArrayEquals(heap1.sort(false), array4Sorted);

    }

    @Test
    void testInsertionSort() {
        Integer[] array1Sorted = array1.clone();
        Integer[] array2Sorted = array2.clone();
        Integer[] array3Sorted = array3.clone();
        Integer[] array4Sorted = array4.clone();

        Arrays.sort(array1Sorted);
        Arrays.sort(array2Sorted);
        Arrays.sort(array3Sorted);
        Arrays.sort(array4Sorted);

        InsertionSort insertion1 = new InsertionSort(array1);
        assertArrayEquals(insertion1.sort(false), array1Sorted);
        insertion1.setArray(array2);
        assertArrayEquals(insertion1.sort(false), array2Sorted);
        insertion1.setArray(array3);
        assertArrayEquals(insertion1.sort(false), array3Sorted);
        insertion1.setArray(array4);
        assertArrayEquals(insertion1.sort(false), array4Sorted);
    }

    @Test
    void testQuickSort() {
        Integer[] array1Sorted = array1.clone();
        Integer[] array2Sorted = array2.clone();
        Integer[] array3Sorted = array3.clone();
        Integer[] array4Sorted = array4.clone();

        Arrays.sort(array1Sorted);
        Arrays.sort(array2Sorted);
        Arrays.sort(array3Sorted);
        Arrays.sort(array4Sorted);

        QuickSort quick1 = new QuickSort(array1);
        assertArrayEquals(quick1.sort(false), array1Sorted);
        quick1.setArray(array2);
        assertArrayEquals(quick1.sort(false), array2Sorted);
        quick1.setArray(array3);
        assertArrayEquals(quick1.sort(false), array3Sorted);
        quick1.setArray(array4);
        assertArrayEquals(quick1.sort(false), array4Sorted);
    }

    @Test
    void testSelectionSort() {
        Integer[] array1Sorted = array1.clone();
        Integer[] array2Sorted = array2.clone();
        Integer[] array3Sorted = array3.clone();
        Integer[] array4Sorted = array4.clone();

        Arrays.sort(array1Sorted);
        Arrays.sort(array2Sorted);
        Arrays.sort(array3Sorted);
        Arrays.sort(array4Sorted);

        SelectionSort selecion1 = new SelectionSort(array1);
        assertArrayEquals(selecion1.sort(false), array1Sorted);
        selecion1.setArray(array2);
        assertArrayEquals(selecion1.sort(false), array2Sorted);
        selecion1.setArray(array3);
        assertArrayEquals(selecion1.sort(false), array3Sorted);
        selecion1.setArray(array4);
        assertArrayEquals(selecion1.sort(false), array4Sorted);
    }

    @Test
    void testShellSort() {
        Integer[] array1Sorted = array1.clone();
        Integer[] array2Sorted = array2.clone();
        Integer[] array3Sorted = array3.clone();
        Integer[] array4Sorted = array4.clone();

        Arrays.sort(array1Sorted);
        Arrays.sort(array2Sorted);
        Arrays.sort(array3Sorted);
        Arrays.sort(array4Sorted);

        ShellSort shell1 = new ShellSort(array1);
        assertArrayEquals(shell1.sort(false), array1Sorted);
        shell1.setArray(array2);
        assertArrayEquals(shell1.sort(false), array2Sorted);
        shell1.setArray(array3);
        assertArrayEquals(shell1.sort(false), array3Sorted);
        shell1.setArray(array4);
        assertArrayEquals(shell1.sort(false), array4Sorted);
    }

}