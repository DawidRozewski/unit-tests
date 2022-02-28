package miniTesty.p7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {


    @ParameterizedTest
    @MethodSource("fibonacciParams")
    void fibonacci(int n, int expected) {
        // when
        int fibonacci = Fibonacci.fibonacci(n);
        // then
        assertThat(fibonacci).isEqualTo(expected);
    }

    static Stream<Arguments> fibonacciParams() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 1),
                Arguments.arguments(3, 2),
                Arguments.arguments(4, 3),
                Arguments.arguments(5, 5),
                Arguments.arguments(6, 8),
                Arguments.arguments(7, 13)
        );
    }
    //----------------------------------------------------------------------------------------------------
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5"
    })

    void fibonacciWithCSV(int n, int expected) {
        // when
        int fibonacci = Fibonacci.fibonacci(n);
        // then
        assertThat(fibonacci).isEqualTo(expected);
    }
}