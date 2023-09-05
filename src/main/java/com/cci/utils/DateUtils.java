package com.cci.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtils {
	public static LocalDateTime getLocalDateTime(String dateTime) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		LocalDateTime localDate = LocalDateTime.parse(dateTime, dtf);
        return localDate;
	}
}
