package miniTesty.p7;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class EmptyStringTest {

    @ParameterizedTest()
    @ValueSource(strings = {"a", "  a", "     abc", "   a    ", "       "})
    void shouldCheckIfStringIsNotEmpty(String params) {
        // when
        boolean result = EmptyString.checkIfNotEmpty(params);
        // then
        assertThat(result).isTrue();
    }
}