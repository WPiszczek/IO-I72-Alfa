package pl.put.poznan.sortingmadness.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
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
    private final SortingMadnessService service;
    LinkedHashMap<String, Object> response;


    @Autowired
    public SortingMadnessController(SortingMadnessService service) {
        this.service = service;
        logger.debug("SortingMadnessController Constructor");
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping({"/", "/index"})
    public String index() {
        logger.debug("GET /index");
        return "index";
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/inputData/Random")
    public LinkedHashMap<String, Object> randomArray(@RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /inputData/Random");
        return service.generateRandomArray(body);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/inputData/{dataType}")
    public LinkedHashMap<String, Object> postInputData(@PathVariable String dataType,
                                                       @RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /inputData/" + dataType);
        service.handleInput(body, dataType);
        return body;
    }


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


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/sortType")
    public LinkedHashMap<String, Object> postSortType(@RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /sortType");
        service.handleSortType(body);
        return body;
    }


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


