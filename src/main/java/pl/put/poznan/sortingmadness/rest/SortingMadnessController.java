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
    private final SortingMadnessService service;
    LinkedHashMap<String, Object> response;


    @Autowired
    public SortingMadnessController(SortingMadnessService service) {
        this.service = service;
        logger.debug("SortingMadnessController Constructor");
    }


    @GetMapping({"/", "/index"})
    public String index() {
        logger.debug("GET /index");
        return "index";
    }


    @PostMapping("/inputData/{dataType}")
    public String
    postInputData(@PathVariable String dataType,
            @RequestBody LinkedHashMap<String, Object> body) {
        logger.debug("POST /inputData/" + dataType);
        service.handleInput(body);
        return "input";
    }


    @GetMapping("/result/{dataType}/{sortType}")
    public LinkedHashMap<String, Object>
    result(@PathVariable("dataType") String dataType,
           @PathVariable("sortType") String sortType) {
        logger.debug(String.format("GET result/%s/%s", dataType, sortType));

        response = service.getResult();
        return response;
    }

}


