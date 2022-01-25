package pl.put.poznan.sortingmadness.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingStringTest {
    Random rand = new Random();
    String[] array1 = new String[0];
    String[] array2 = new String[1];
    String[] array3 = new String[20];
    String[] array4 = new String[400];

    @BeforeEach
    void setUp() {

        array2[0] = generateRandomString(rand.ints(1, 20).findFirst().getAsInt());

        for(int i=0; i<20; i++) {
            String str3 = generateRandomString(rand.ints(1, 20).findFirst().getAsInt());
            array3[i] = str3;
        }

        for(int i=0; i<400; i++) {
            String str4 = generateRandomString(rand.ints(1, 20).findFirst().getAsInt());
            array4[i] = str4;
        }
    }

    @AfterEach
    void tearDown() {
        array1 = null;
        array2 = null;
        array3 = null;
    }

    String generateRandomString (int length) {
        int min = 97;
        int max = 122;

        String randomString = rand.ints(min, max + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return randomString;
    }

    @Test
    void testBubbleSort() {
        String[] array1Sorted = array1.clone();
        String[] array2Sorted = array2.clone();
        String[] array3Sorted = array3.clone();
        String[] array4Sorted = array4.clone();

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
        String[] array1Sorted = array1.clone();
        String[] array2Sorted = array2.clone();
        String[] array3Sorted = array3.clone();
        String[] array4Sorted = array4.clone();

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
        String[] array1Sorted = array1.clone();
        String[] array2Sorted = array2.clone();
        String[] array3Sorted = array3.clone();
        String[] array4Sorted = array4.clone();

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
        String[] array1Sorted = array1.clone();
        String[] array2Sorted = array2.clone();
        String[] array3Sorted = array3.clone();
        String[] array4Sorted = array4.clone();

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
        String[] array1Sorted = array1.clone();
        String[] array2Sorted = array2.clone();
        String[] array3Sorted = array3.clone();
        String[] array4Sorted = array4.clone();

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
        String[] array1Sorted = array1.clone();
        String[] array2Sorted = array2.clone();
        String[] array3Sorted = array3.clone();
        String[] array4Sorted = array4.clone();

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

//
//    @Test
//    void testSort() {
//        String[] array1Sorted = array1.clone();
//        String[] array2Sorted = array2.clone();
//        String[] array3Sorted = array3.clone();
//
//        Arrays.sort(array1Sorted);
//        Arrays.sort(array2Sorted);
//        Arrays.sort(array3Sorted);
//
//        BubbleSort bubble1 = new BubbleSort(array1);
//        assertArrayEquals(bubble1.sort(false), array1Sorted);
//        bubble1.setArray(array2);
//        assertArrayEquals(bubble1.sort(false), array2Sorted);
//        bubble1.setArray(array3);
//        assertArrayEquals(bubble1.sort(false), array3Sorted);
//
//        HeapSort heap1 = new HeapSort(array1);
//        assertArrayEquals(heap1.sort(false), array1Sorted);
//        heap1.setArray(array2);
//        assertArrayEquals(heap1.sort(false), array2Sorted);
//        heap1.setArray(array3);
//        assertArrayEquals(heap1.sort(false), array3Sorted);
//
//        InsertionSort insertion1 = new InsertionSort(array1);
//        assertArrayEquals(insertion1.sort(false), array1Sorted);
//        insertion1.setArray(array2);
//        assertArrayEquals(insertion1.sort(false), array2Sorted);
//        insertion1.setArray(array3);
//        assertArrayEquals(insertion1.sort(false), array3Sorted);
//
//        QuickSort quick1 = new QuickSort(array1);
//        assertArrayEquals(quick1.sort(false), array1Sorted);
//        quick1.setArray(array2);
//        assertArrayEquals(quick1.sort(false), array2Sorted);
//        quick1.setArray(array3);
//        assertArrayEquals(quick1.sort(false), array3Sorted);
//
//        SelectionSort selecion1 = new SelectionSort(array1);
//        assertArrayEquals(selecion1.sort(false), array1Sorted);
//        selecion1.setArray(array2);
//        assertArrayEquals(selecion1.sort(false), array2Sorted);
//        selecion1.setArray(array3);
//        assertArrayEquals(selecion1.sort(false), array3Sorted);
//
//        ShellSort shell1 = new ShellSort(array1);
//        assertArrayEquals(shell1.sort(false), array1Sorted);
//        shell1.setArray(array2);
//        assertArrayEquals(shell1.sort(false), array2Sorted);
//        shell1.setArray(array3);
//        assertArrayEquals(shell1.sort(false), array3Sorted);
//    }
}