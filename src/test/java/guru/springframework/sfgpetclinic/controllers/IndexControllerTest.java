package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTests {

    private IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test Proper View Name is returned for index page")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertEquals("index", indexController.index(), () -> "wrong view returned");
    }

    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () ->
                indexController.oupsHandler());

    }

    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            Thread.sleep(100);
            System.out.println("I got here");
        });

    }

    @Test
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            Thread.sleep(100);
            System.out.println("I got here in prempt");
        });
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

}