package miniTesty.p1;

import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FormatDateTest {


    @Test
    void shouldFormatDateToYearMonthString() {
        // given
        LocalDate today = LocalDate.of(2022,2,28);
        // when
        String formatDate = FormatDate.formatDate(today);
        // then
        assertThat(formatDate).isEqualTo("2022-02");
    }
}