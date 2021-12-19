package pl.put.poznan.sortingmadness.rest;
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

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    @GetMapping("/")
    public String index() {
        logger.debug("index");
        return "index";
    }

    @RequestMapping(value="/result", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String result(@RequestBody Map<String, Object> payload) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String sortType = (String) payload.get("SortType");
        boolean reverse = (boolean) payload.get("Reverse");
        Object[] array = ((ArrayList<?>) payload.get("Array")).toArray(new Object[]{});

        // log the parameters
        logger.debug("POST");
        logger.debug(sortType);
        logger.debug(String.valueOf(reverse));
        logger.debug(Arrays.toString(array));

//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.parseInt(String.valueOf(array[i]));
//        }

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


