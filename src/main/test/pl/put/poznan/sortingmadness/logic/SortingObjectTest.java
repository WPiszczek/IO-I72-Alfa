package pl.put.poznan.sortingmadness.logic;
import java.util.LinkedHashMap;
import java.util.Random;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.ast.Selection;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SortingObjectTest {

    Random rand = new Random();

    Object[] array1 = new Object[400];
    Object[] array2 = new Object[20];
    Object[] array3 = new Object[1];
    Object[] array4 = new Object[0];


    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 400; i++) {
            int arg11 = rand.nextInt();
            String arg21 = generateRandomString(rand.ints(1, 20).findFirst().getAsInt());

            CustomObject cusObj1 = new CustomObject();
            LinkedHashMap<String, Object> map1 = new LinkedHashMap<>();
            map1.put("arg1", arg11);
            map1.put("arg2", arg21);
            cusObj1.setSortAttrib("arg1");
            cusObj1.setSortAttribValue(arg11);
            String jsonString1 = new JSONObject(map1).toString();
            cusObj1.setJSONString(jsonString1);

            array1[i] = cusObj1;
        }

        for (int i = 0; i < 20; i++) {
            int arg11 = rand.nextInt();
            String arg21 = generateRandomString(rand.ints(1, 40).findFirst().getAsInt());

            CustomObject cusObj1 = new CustomObject();
            LinkedHashMap<String, Object> map1 = new LinkedHashMap<>();
            map1.put("arg1", arg11);
            map1.put("arg2", arg21);
            cusObj1.setSortAttrib("arg1");
            cusObj1.setSortAttribValue(arg11);
            String jsonString1 = new JSONObject(map1).toString();
            cusObj1.setJSONString(jsonString1);

            array2[i] = cusObj1;
        }
        int arg11 = rand.nextInt();
        String arg21 = generateRandomString(rand.ints(1, 40).findFirst().getAsInt());

        CustomObject cusObj1 = new CustomObject();
        LinkedHashMap<String, Object> map1 = new LinkedHashMap<>();
        map1.put("arg1", arg11);
        map1.put("arg2", arg21);
        cusObj1.setSortAttrib("arg1");
        cusObj1.setSortAttribValue(arg11);
        String jsonString1 = new JSONObject(map1).toString();
        cusObj1.setJSONString(jsonString1);

        array3[0] = cusObj1;

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

    @AfterEach
    void tearDown() {
        array1 = null;
        array2 = null;
        array3 = null;
        array4 = null;
    }

    @Test
    void testBubbleSort(){
        Object[] array1Sorted = array1.clone();
        Object[] array2Sorted = array2.clone();
        Object[] array3Sorted = array3.clone();
        Object[] array4Sorted = array4.clone();

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
    void testHeapSort(){
        Object[] array1Sorted = array1.clone();
        Object[] array2Sorted = array2.clone();
        Object[] array3Sorted = array3.clone();
        Object[] array4Sorted = array4.clone();

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
    void testInsertionSort(){
        Object[] array1Sorted = array1.clone();
        Object[] array2Sorted = array2.clone();
        Object[] array3Sorted = array3.clone();
        Object[] array4Sorted = array4.clone();

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
    void testQuickSort(){
        Object[] array1Sorted = array1.clone();
        Object[] array2Sorted = array2.clone();
        Object[] array3Sorted = array3.clone();
        Object[] array4Sorted = array4.clone();

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
    void testSelectionSort(){
        Object[] array1Sorted = array1.clone();
        Object[] array2Sorted = array2.clone();
        Object[] array3Sorted = array3.clone();
        Object[] array4Sorted = array4.clone();

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
    void testShellSort(){
        Object[] array1Sorted = array1.clone();
        Object[] array2Sorted = array2.clone();
        Object[] array3Sorted = array3.clone();
        Object[] array4Sorted = array4.clone();

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