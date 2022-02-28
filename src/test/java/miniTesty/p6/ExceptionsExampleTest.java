package miniTesty.p6;

import org.junit.jupiter.api.Test;

import static miniTesty.p6.ExceptionsExample.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ExceptionsExampleTest {

    private ExceptionsExample exceptionsExample = new ExceptionsExample();

    @Test
    void shouldReturnStringFromNumberIfNumberIsLessThanDefault() {
        // given
        int number = 1;
        // when
        String s = exceptionsExample.doSomething(number);
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
    void shouldThrownExceptionIfNumberIsGreaterThanDefault() {
        // given
        int i = DEFAULT_NUMBER + 1;
        // when
        assertThatThrownBy(() -> exceptionsExample.doSomething(i))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Parametr jest większy od 5");
    }

}