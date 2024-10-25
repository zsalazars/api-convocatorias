package com.convocatorias.apiconvocatorias.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private DateUtils() {
        throw new UnsupportedOperationException("Esta clase de utilidad no puede ser instanciada");
    }

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return formatter.format(date);
    }

    public static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return formatter.parse(dateStr);
    }
}
