package pl.nullpointerexception.p6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static pl.nullpointerexception.p6.ExceptionsExample.DEFAULT_NUMBER;

class ExceptionsExampleTest {

    private ExceptionsExample exceptionsExample = new ExceptionsExample();

    @Test
    void shouldReturnStringFromNumberIfNumberIsLessThanDefault() {
        // given
        int i = 1;
        // when
        String s = exceptionsExample.doSomething(i);
        // then
        assertThat(s).isEqualTo("1");
    }

    @Test
    void shouldReturnStringFromNumberIfNumberIsEqualDefault() {
        // given
        // when
        String s = exceptionsExample.doSomething(DEFAULT_NUMBER);
        // then
        assertThat(s).isEqualTo(String.valueOf(DEFAULT_NUMBER));
    }


    @Test
    void shouldThrowExceptionIfNumberIsGreaterThanDefault() {
        // given
        int i = 10;
        // when
        assertThrows(IllegalArgumentException.class,
                     () -> exceptionsExample.doSomething(i),
                     "Parametr jest większy od 5");
    }



}