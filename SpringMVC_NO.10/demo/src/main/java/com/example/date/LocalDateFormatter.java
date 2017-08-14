package com.example.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    public static final String US_PATTERN = "yyyy-MM-dd";
    public static final String NORMAL_PATTERN="yyyy-MM-dd";

    @Override
    public String print(LocalDate localDate, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(localDate);
    }

    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        return LocalDate.parse(s,DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    /**
     * 获取用户所处地域的日期格式
     * @param locale
     * @return
     */
    public static String getPattern(Locale locale){
        return isUnitedStates(locale)?US_PATTERN : NORMAL_PATTERN;
    }

    private static boolean isUnitedStates(Locale locale){
        return Locale.US.getCountry().equals(locale.getCountry());
    }
}
