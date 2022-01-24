package pl.put.poznan.sortingmadness.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.sortingmadness.logic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Random;
import org.json.JSONObject;

/**
 * Service for SortingMadness controller
 */
@Service
public class SortingMadnessService {
    /**
     * Sorter field
     */
    private SortingMadness sorter;

    /**
     * unsorted array field
     */
    private Object[] unsortedArray;
    /**
     * sorted array field
     */
    private Object[] sortedArray;

    /**
     * processes input from request
     * @param input request body
     * @param dataType type of data, might be Number, String or JSON
     */
    public void handleInput(LinkedHashMap<String, Object> input, String dataType) {

        Object[] array;
        if (input.get("array") != null) {
            System.out.println(input.get("array"));
            array = ((ArrayList<?>) input.get("array")).toArray(new Object[]{});
        }
        else {
            array = new Object[]{};
        }
        switch (dataType) {
            case "Number":
                array = convertArrayToDouble(array);
                break;
            case "Random":
                int size = (int) input.get("arraySize");
                array = getRandomArray(size);
                break;
            case "JSON":
                String sortAttrib = (String) input.get("sortAttrib");
                array = convertArrayToJSON(array, sortAttrib);
                break;
        }

        sorter = new SortingMadness() {
            @Override
            public Object[] sort(boolean reverse) {
                return new Object[0];
            }
        };

        setUnsortedArray(array);
    }

    /**
     * sets up sorter and performs sorting operation
     * @param input sort type and reverse sort flag
     */
    public void handleSortType(LinkedHashMap<String, Object> input) {
        String sortType = (String) input.get("sortType");
        boolean reverse = (boolean) input.get("reverse");

        setSorter(sortType, getUnsortedArray());
        Object[] sortedArray = sorter.sortMeasurement(reverse);
        setSortedArray(sortedArray);
    }

    /**
     * returns sort result
     * @param sortType sort type
     * @return sort type, unsorted and sorted arrays, sorting time
     */
    public LinkedHashMap<String, Object> getResult(String sortType) {
        Long time = sorter.getTime();

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("sortType", sortType);
        result.put("unsortedArray", getJSONStringArray(getUnsortedArray()));
        result.put("sortedArray", getJSONStringArray(getSortedArray()));
        result.put("time", time);

        return result;
    }

    /**
     * generates random array from array size
     * @param input array size
     * @return generated array of integers
     */
    public LinkedHashMap<String, Object> generateRandomArray(LinkedHashMap<String, Object> input) {
        int arraySize = Integer.parseInt(String.valueOf(input.get("arraySize")));
        Integer[] array = getRandomArray(arraySize);
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        setUnsortedArray(array);
        result.put("array", array);
        return result;
    }

    /**
     * creates random array of given size
     * @param size array size
     * @return array
     */
    public Integer[] getRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }

    /**
     * converts array of strings into array of doubles
     * @param array array of strings
     * @return array of doubles
     */
    public Double[] convertArrayToDouble(Object[] array) {
        ArrayList<Double> arr = new ArrayList<>();
        for (Object obj : array) {
            arr.add(Double.valueOf(String.valueOf(obj)));
        }
        return arr.toArray(new Double[]{});
    }

    /**
     * converts array of JSON objects into array of CustomObject type
     * @param array array of JSON objects
     * @param sortAttrib sorting attribute of a JSON object
     * @return array of CustomObject type
     */
    public CustomObject[] convertArrayToJSON(Object[] array, String sortAttrib) {
        ArrayList<CustomObject> arr = new ArrayList<>();

        for (Object obj : array) {
            LinkedHashMap map = (LinkedHashMap) obj;

            CustomObject cusObj = new CustomObject();

            Object sortAttribValue = map.get(sortAttrib);

            String jsonString = new JSONObject(map).toString();

            cusObj.setJSONString(jsonString);
            cusObj.setSortAttrib(sortAttrib);
            cusObj.setSortAttribValue((Comparable) sortAttribValue);
            arr.add(cusObj);
        }
        return arr.toArray(new CustomObject[]{});
    }

    /**
     * invokes appropriate sorter from sort type and array
     * @param sortType sort type
     * @param array array to be sorted
     */
    public void setSorter(String sortType, Object[] array) {
        switch (sortType) {
            case "BubbleSort": {
                sorter = new BubbleSort(array);
                break;
            }
            case "HeapSort": {
                sorter = new HeapSort(array);
                break;
            }
            case "InsertionSort": {
                sorter = new InsertionSort(array);
                break;
            }
            case "QuickSort": {
                sorter = new QuickSort(array);
                break;
            }
            case "SelectionSort": {
                sorter = new SelectionSort(array);
                break;
            }
            case "ShellSort": {
                sorter = new ShellSort(array);
                break;
            }
        }
    }

    /**
     * converts array of JSON objects into array of strings
     * @param array array of JSON objects
     * @return array of strings
     */
    public String[] getJSONStringArray(Object[] array) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Object element : array) {
            arrayList.add(element.toString());
        }
        return arrayList.toArray(new String[]{});
    }

    /**
     * getter
     * @return sorter object
     */
    public SortingMadness getSorter() {
        return this.sorter;
    }

    /**
     * getter
     * @return unsorted array
     */
    public Object[] getUnsortedArray() {
        return unsortedArray;
    }

    /**
     * setter
     * @param array unsorted array
     */
    public void setUnsortedArray(Object[] array) {
        this.unsortedArray = array;
    }

    /**
     * getter
     * @return sorted array
     */
    public Object[] getSortedArray() {
        return sortedArray;
    }

    /**
     * setter
     * @param array sorted array
     */
    public void setSortedArray(Object[] array) {
        this.sortedArray = array;
    }
}
