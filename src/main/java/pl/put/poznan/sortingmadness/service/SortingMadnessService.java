package pl.put.poznan.sortingmadness.service;

import org.springframework.stereotype.Service;
import pl.put.poznan.sortingmadness.logic.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import org.json.JSONObject;


@Service
public class SortingMadnessService {
    private SortingMadness sorter;


    public void handleInput(LinkedHashMap<String, Object> input) {
        String sortType = (String) input.get("sortType");
        boolean reverse = (boolean) input.get("reverse");
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
                String sortAttrib = (String) input.get("sortAttrib");
                array = convertArrayToJSON(array, sortAttrib);
                break;
        }

        setSorter(sortType, array);
        Object[] sortedArray = sorter.sortMeasurement(reverse);
        sorter.setArray(sortedArray);
    }


    public LinkedHashMap<String, Object> getResult() {
        Object[] array = sorter.getArray();
        Long time = sorter.getTime();

        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("sortedArray", array);
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

}
