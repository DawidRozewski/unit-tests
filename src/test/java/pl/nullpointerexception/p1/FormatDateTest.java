package pl.nullpointerexception.p1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FormatDateTest {

    @Test
    void shouldFormatDateToYearMonthString() {
        // given
        LocalDate date = LocalDate.of(2022, 2, 1);
        // when
        String formatDate = FormatDate.formatDate(date);
        // then
        assertEquals("2022-02", formatDate);
    }
}