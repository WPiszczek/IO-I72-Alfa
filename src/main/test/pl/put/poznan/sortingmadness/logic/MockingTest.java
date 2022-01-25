package pl.put.poznan.sortingmadness.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.sortingmadness.service.SortingMadnessService;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;import static org.mockito.Mockito.*;

class MockingTest {

    SortingMadnessService mockService;


    @BeforeEach
    void setUp() {
        mockService = mock(SortingMadnessService.class);
    }

    @AfterEach
    void tearDown() {
        mockService = null;
    }

    @Test
    void testBubbleSort() {
        Integer[] array1 = {2,4,6,7,12,34,388};
        Integer[] array2 = {12,2,388,4,34,6,7};
        BubbleSort b1;
        b1 = new BubbleSort(array2);
        when(mockService.getSortedArray()).thenReturn(array1);
        assertArrayEquals(b1.sort(false), array1);
    }

    @Test
    void testHeapSort() {
        Integer[] array1 = {2,4,6,7,12,34,388};
        Integer[] array2 = {12,2,388,4,34,6,7};
        HeapSort b1;
        b1 = new HeapSort(array2);
        when(mockService.getSortedArray()).thenReturn(array1);
        assertArrayEquals(b1.sort(false), array1);
    }

    @Test
    void testInsertionSort() {
        Integer[] array1 = {2,4,6,7,12,34,388};
        Integer[] array2 = {12,2,388,4,34,6,7};
        InsertionSort b1;
        b1 = new InsertionSort(array2);
        when(mockService.getSortedArray()).thenReturn(array1);
        assertArrayEquals(b1.sort(false), array1);
    }

    @Test
    void testQuickSort() {
        Integer[] array1 = {2,4,6,7,12,34,388};
        Integer[] array2 = {12,2,388,4,34,6,7};
        QuickSort b1;
        b1 = new QuickSort(array2);
        when(mockService.getSortedArray()).thenReturn(array1);
        assertArrayEquals(b1.sort(false), array1);
    }

    @Test
    void testSelectionSort() {
        Integer[] array1 = {2,4,6,7,12,34,388};
        Integer[] array2 = {12,2,388,4,34,6,7};
        SelectionSort b1;
        b1 = new SelectionSort(array2);
        when(mockService.getSortedArray()).thenReturn(array1);
        assertArrayEquals(b1.sort(false), array1);
    }

    @Test
    void testShellSort() {
        Integer[] array1 = {2,4,6,7,12,34,388};
        Integer[] array2 = {12,2,388,4,34,6,7};
        ShellSort b1;
        b1 = new ShellSort(array2);
        when(mockService.getSortedArray()).thenReturn(array1);
        assertArrayEquals(b1.sort(false), array1);
    }
}