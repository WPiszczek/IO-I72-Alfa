package pl.put.poznan.sortingmadness.rest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingmadness.logic.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


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
     * @throws JSONException
     */
    @RequestMapping(value="/result", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String result(@RequestBody Map<String, Object> payload) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, JSONException {

        String sortType = (String) payload.get("SortType");
        boolean reverse = (boolean) payload.get("Reverse");
        Object[] JSONarray = ((ArrayList<?>) payload.get("Array")).toArray(new Object[]{});
        String sortAttrib = (String) payload.get("SortAttrib");

        Object[] array;

        if (!sortAttrib.equals("Number") && !sortAttrib.equals("String")) {
            ArrayList<CustomObject> arr = new ArrayList<>();

            for (Object obj : JSONarray) {
                System.out.println(obj);
                System.out.println(obj.getClass());
                CustomObject cusObj = new CustomObject();
                cusObj.setJSONString(obj.toString());
                cusObj.setSortAttrib(sortAttrib);
                cusObj.setSortAttribValue();
                System.out.println(cusObj);
                arr.add(cusObj);
            }

            array = arr.toArray(new CustomObject[]{});
        } else {
            array = JSONarray;
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

        System.out.println(Arrays.toString(r));
        System.out.println(sorter.getTime());

        return "result";
    }

}


