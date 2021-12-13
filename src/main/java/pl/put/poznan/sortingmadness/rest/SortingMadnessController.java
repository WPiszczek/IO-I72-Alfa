package pl.put.poznan.sortingmadness.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingmadness.logic.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.lang.reflect.Method;


/**
 * Rest controller for Sorting Madness
 */
@RestController
@RequestMapping("/{method}/{array}")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    /**
     *
     * @param array
     * @param method
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Object[] get(@PathVariable Object[] array, @PathVariable String method) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // log the parameters
        logger.debug(Arrays.toString(array));
        logger.debug("get");
        logger.debug(method);

//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.parseInt(String.valueOf(array[i]));
//        }

        // running logic
//        SortingMadness sorter = new SortingMadness(array);
//        Method m = Class.forName("pl.put.poznan.sortingmadness.logic.SortingMadness").getDeclaredMethod(method);
//        return (Object[])m.invoke(sorter);

        InsertionSort sorter = new InsertionSort(array);
        return sorter.sort();
    }

    /**
     *
     * @param array
     * @param method
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Object[] post(@PathVariable Object[] array, @PathVariable String method) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // log the parameters
        logger.debug(Arrays.toString(array));
        logger.debug("post");
        logger.debug(method);

        // running logic
//        SortingMadness sorter = new SortingMadness(array);
//        Method m = Class.forName("pl.put.poznan.sortingmadness.logic.SortingMadness").getDeclaredMethod(method);
//        return (Object[])m.invoke(sorter);
        return new Object[]{};
    }
}


