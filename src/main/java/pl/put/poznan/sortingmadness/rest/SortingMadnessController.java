package pl.put.poznan.sortingmadness.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sortingmadness.service.SortingMadnessService;

import java.util.*;


/**
 * Rest controller for Sorting Madness
 */
@RestController
public class SortingMadnessController {

    /**
     * Logger field
     */
    private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

    /**
     * Service class
     */
    private final SortingMadnessService service;

    /**
     * Response returned by controller
     */
    LinkedHashMap<String, Object> response;

    /**
     * Constructor for Controller
     * @param service service class
     */
    @Autowired
    public SortingMadnessController(SortingMadnessService service) {
        this.service = service;
        logger.debug("SortingMadnessController Constructor");
    }

    /**
     * Renders default response from request
     * @return String index
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping({"/", "/index"})
    public String index() {
        logger.debug("GET /index");
        return "index";
    }

    /**
     * Renders random input data from request
     * @param body request body
     * @return generated random array of integers
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/inputData/Random")
    public LinkedHashMap<String, Object> randomArray(@RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /inputData/Random");
        return service.generateRandomArray(body);
    }

    /**
     * Processes input data from request
     * @param dataType type of requested data, might be Number, String or JSON
     * @param body request body
     * @return request body
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/inputData/{dataType}")
    public LinkedHashMap<String, Object> postInputData(@PathVariable String dataType,
                                                       @RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /inputData/" + dataType);
        service.handleInput(body, dataType);
        return body;
    }

    /**
     * returns unsorted array from api to client
     * @return unsorted array
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sortType")
    public LinkedHashMap<String, Object> getSortType() {
        logger.debug("GET /sortType");
        response = new LinkedHashMap<>();
        Object[] unsortedArray = service.getUnsortedArray();
        System.out.println(Arrays.toString(unsortedArray));
        response.put("unsortedArray", unsortedArray);
        return response;
    }

    /**
     * gets sort type from request
     * @param body request body
     * @return request body
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/sortType")
    public LinkedHashMap<String, Object> postSortType(@RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /sortType");
        service.handleSortType(body);
        return body;
    }

    /**
     * returns sorting result from api to client
     * @param sortType sort type
     * @return sorted and unsorted array, sorting time
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/result/{sortType}")
    public LinkedHashMap<String, Object>
    result(@PathVariable("sortType") String sortType) {
        logger.debug(String.format("GET result/%s", sortType));

        response = service.getResult(sortType);
        System.out.println(response);
        return response;
    }

}


