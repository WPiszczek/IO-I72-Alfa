package pl.put.poznan.sortingmadness.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingmadness.logic.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Rest controller for Sorting Madness
 */
@RestController
@RequestMapping("/{sortType}/{array}")
public class SortingMadnessController {

    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    /**
     *
     * @param array
     * @param sortType
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Object[] get(@PathVariable Object[] array, @PathVariable String sortType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        // log the parameters
        logger.debug(Arrays.toString(array));
        logger.debug("get");
        logger.debug(sortType);

//        for (int i = 0; i < array.length; i++) {
//            array[i] = Integer.parseInt(String.valueOf(array[i]));
//        }

        // running logic
//        SortingMadness sorter = new SortingMadness(array);
//        Method m = Class.forName("pl.put.poznan.sortingmadness.logic.SortingMadness").getDeclaredMethod(method);
//        return (Object[])m.invoke(sorter);

//        Class sortingClass = Class.forName("pl.put.poznan.sortingmadness.logic." + sortType);
//        Object sorter = sortingClass.newInstance();
//        logger.debug("pl.put.poznan.sortingmadness.logic."+sortType);
//        SortingMadness sorter = sortingClass;

//        Class sortingClass = Class.forName("pl.put.poznan.sortingmadness.logic." + sortType);
//        SortingMadness sorter = (SortingMadness) sortingClass.newInstance();
//        sorter.setArray(array);
        HeapSort sorter = new HeapSort(array);
        return sorter.sort(false);
    }

    /**
     *
     * @param array
     * @param sortType
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Object[] post(@PathVariable Object[] array, @PathVariable String sortType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // log the parameters
        logger.debug(Arrays.toString(array));
        logger.debug("post");
        logger.debug(sortType);

        // running logic
//        SortingMadness sorter = new SortingMadness(array);
//        Method m = Class.forName("pl.put.poznan.sortingmadness.logic.SortingMadness").getDeclaredMethod(class);
//        return (Object[])m.invoke(sorter);
        return new Object[]{};
    }
}


