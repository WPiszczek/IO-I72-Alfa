package pl.put.poznan.sortingmadness.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.sortingmadness.logic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Random;
import org.json.JSONObject;


@Service
public class SortingMadnessService {
    private SortingMadness sorter;
    private Object[] unsortedArray;
    private Object[] sortedArray;


    public void handleInput(LinkedHashMap<String, Object> input) {
        String dataType = (String) input.get("dataType");

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
            case "File":
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
        System.out.println(Arrays.toString(getUnsortedArray()));
    }


    public void handleSortType(LinkedHashMap<String, Object> input) {
        String sortType = (String) input.get("sortType");
        boolean reverse = (boolean) input.get("reverse");

        setSorter(sortType, getUnsortedArray());
        Object[] sortedArray = sorter.sortMeasurement(reverse);
        setSortedArray(sortedArray);
    }


    public LinkedHashMap<String, Object> generateRandomArray(LinkedHashMap<String, Object> input) {
        int arraySize = Integer.parseInt((String) input.get("arraySize"));
        Integer[] array = getRandomArray(arraySize);
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        setUnsortedArray(array);
        result.put("array", array);
        return result;
    }


    public LinkedHashMap<String, Object> getResult() {
        Long time = sorter.getTime();

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("sortedArray", getSortedArray());
        result.put("time", time);

        return result;
    }

    public Integer[] getRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }

    public Double[] convertArrayToDouble(Object[] array) {
        ArrayList<Double> arr = new ArrayList<>();
        for (Object obj : array) {
            arr.add(Double.valueOf(String.valueOf(obj)));
        }
        return arr.toArray(new Double[]{});
    }

    public CustomObject[] convertArrayToJSON(Object[] array, String sortAttrib) {
        ArrayList<CustomObject> arr = new ArrayList<>();

        for (Object obj : array) {
            LinkedHashMap map = (LinkedHashMap) obj;
//            System.out.println(obj);
//            System.out.println(obj.getClass());
            CustomObject cusObj = new CustomObject();

            Object sortAttribValue = map.get(sortAttrib);
            System.out.println(sortAttribValue);

            String jsonString = new JSONObject(map).toString();
            cusObj.setJSONString(jsonString);
            cusObj.setSortAttrib(sortAttrib);
            cusObj.setSortAttribValue((Comparable) sortAttribValue);
            arr.add(cusObj);
        }

        return arr.toArray(new CustomObject[]{});
    }

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

    public SortingMadness getSorter() {
        return this.sorter;
    }

    public Object[] getUnsortedArray() {
        return unsortedArray;
    }

    public void setUnsortedArray(Object[] array) {
        this.unsortedArray = array;
    }

    public Object[] getSortedArray() {
        return sortedArray;
    }

    public void setSortedArray(Object[] array) {
        this.sortedArray = array;
    }
}
