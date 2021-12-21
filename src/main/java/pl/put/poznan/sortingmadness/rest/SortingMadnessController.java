package pl.put.poznan.sortingmadness.rest;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingmadness.logic.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * Rest controller for Sorting Madness
 */
@Controller
public class SortingMadnessController {

    /**
     * Logger field
     */
    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    /**
     * default site, opened for path "/"
     * @return html filename
     */
    @GetMapping("/")
    public String index() {
        logger.debug("index");
        return "index";
    }

    /**
     * Function for getting data and sorting
     * @param payload - data send from javascript
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @PostMapping(value="/result", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> result(@RequestBody Map<String, Object> payload) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String sortType = (String) payload.get("SortType");
        boolean reverse = (boolean) payload.get("Reverse");
        Object[] JSONarray = ((ArrayList<?>) payload.get("Array")).toArray(new Object[]{});
        String sortAttrib = (String) payload.get("SortAttrib");

        Object[] array;

        if (sortAttrib.equals("Number")) {
            ArrayList<Double> arr = new ArrayList<>();
            for (Object obj : JSONarray) {
                arr.add(Double.valueOf(String.valueOf(obj)));
            }
            array = arr.toArray(new Double[]{});

        } else if (sortAttrib.equals("String")) {
            array = JSONarray;
        } else {
            ArrayList<CustomObject> arr = new ArrayList<>();

            for (Object obj : JSONarray) {
                LinkedHashMap map = (LinkedHashMap) obj;
                System.out.println(obj);
                System.out.println(obj.getClass());
                CustomObject cusObj = new CustomObject();

                Object sortAttribValue = map.get(sortAttrib);
                System.out.println(sortAttribValue);

                String jsonString = new JSONObject(map).toString();
                cusObj.setJSONString(jsonString);
//                cusObj.setJSONString(obj.toString());
                cusObj.setSortAttrib(sortAttrib);
                cusObj.setSortAttribValue((Comparable) sortAttribValue);
                System.out.println(cusObj);
                arr.add(cusObj);
            }

            array = arr.toArray(new CustomObject[]{});
        }


        // log the parameters
        logger.debug("POST");
        logger.debug(sortType);
        logger.debug(String.valueOf(reverse));
        logger.debug(Arrays.toString(array));
        logger.debug(sortAttrib);


        // running logic
        logger.debug("pl.put.poznan.sortingmadness.logic."+sortType);

        Class<?> sortingClass = Class.forName("pl.put.poznan.sortingmadness.logic." + sortType);
        Constructor<?> ctor = sortingClass.getConstructor(Object[].class);
        SortingMadness sorter = (SortingMadness) ctor.newInstance(new Object[] {array});

        Object[] r = sorter.sortMeasurement(reverse);
        Long t = sorter.getTime();

        for (Object o : r) {
            CustomObject co = (CustomObject) o;
            System.out.println(co.getJSONString());
        }
//        System.out.println(r.getClass());
        System.out.println(Arrays.toString(r));
        System.out.println(sorter.getTime());

        HashMap<String, Object> map = new HashMap<>();
        map.put("ResultArray", r);
        map.put("Time", t);
        return map;
    }

}


