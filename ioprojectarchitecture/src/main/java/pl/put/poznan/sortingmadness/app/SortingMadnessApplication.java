package pl.put.poznan.sortingmadness.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Application Class
 */
@SpringBootApplication(scanBasePackages = {"pl.put.poznan.sortingmadness.rest"})
public class SortingMadnessApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SortingMadnessApplication.class, args);
    }
}
