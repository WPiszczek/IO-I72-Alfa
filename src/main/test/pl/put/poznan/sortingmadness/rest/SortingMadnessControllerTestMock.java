package pl.put.poznan.sortingmadness.rest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.mockito.internal.matchers.Null;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.put.poznan.sortingmadness.logic.SortingMadness;
import pl.put.poznan.sortingmadness.service.SortingMadnessService;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

class SortingMadnessControllerTestMock {

    SortingMadnessController mockObject;
    SortingMadnessService service;

    @BeforeEach
    void setUp() {
        mockObject = mock(SortingMadnessController.class);
    }

    @AfterEach
    void tearDown() {
        mockObject = null;
        service = null;
    }

    @Test
    void index() {
        when(mockObject.index()).thenReturn("index");
    }

    @Test
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/inputData/Random")
    void randomArray() {
        LinkedHashMap<String, Object> body = new LinkedHashMap<>();
        when(mockObject.randomArray(body)).thenThrow(new NullPointerException());
    }

    @Test
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/inputData/{dataType}")
    void postInputData() {
        LinkedHashMap<String, Object> body = new LinkedHashMap<>();
//        when(mockObject.postInputData("Number", body)).thenReturn()
    }

    @Test
    void getSortType() {
    }

    @Test
    void postSortType() {
    }

    @Test
    void result() {
    }
}