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
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class SortingMadnessControllerTestMock {

    SortingMadnessController mockObject;
    SortingMadnessService mockService;

    @BeforeEach
    void setUp() {
        mockObject = mock(SortingMadnessController.class);
        mockService = mock(SortingMadnessService.class);
    }

    @AfterEach
    void tearDown() {
        mockObject = null;
        mockService = null;
    }

    @Test
    void index() {
        when(mockObject.index()).thenReturn("index");
        assertEquals("index", mockObject.index());
    }

}