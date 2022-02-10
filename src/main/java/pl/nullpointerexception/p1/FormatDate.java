package pl.nullpointerexception.p1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter
            .ofPattern("yyyy-MM");

    public static String formatDate(LocalDate date) {
        return date.format(dateTimeFormatter);
    }
}
