package pl.nullpointerexception.p7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

class FibonacciTest {


    @ParameterizedTest
    @MethodSource("fibonacciParams")
    void fibonacci(int n, int expected) {
        // when
        int result = Fibonacci.fibonacci(n);
        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> fibonacciParams() {
        return Stream.of(
                arguments(0, 0),
                arguments(1, 1),
                arguments(2, 1),
                arguments(3, 2),
                arguments(4, 3),
                arguments(5, 5),
                arguments(6, 8),
                arguments(7, 13)
        );
    }


    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
    })
    void fibonacciV2(int n, int expected) {
        // when
        int result = Fibonacci.fibonacci(n);
        // then
        assertThat(result).isEqualTo(expected);
    }


}