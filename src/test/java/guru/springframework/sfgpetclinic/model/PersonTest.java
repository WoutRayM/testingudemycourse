package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

    @Test
    void groupedAssertion() {
        //given
        Person person = new Person(11L, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe"),
                () -> assertEquals(person.getLastName(), "Buck"));
    }

    @Test
    void groupedAssertionMsgs() {
        //given
        Person person = new Person(11L, "Joe", "Buck");
        //then
        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Joe", "first name failed"),
                () -> assertEquals(person.getLastName(), "Buck", "Last name failed"));
    }

}