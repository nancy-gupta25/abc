package com.trainingapps.stockapp.suppliedstockms.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;
@Component
public class DateUtil {

	final String pattern="dd-MM-yyyy";
	private DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
	
	public LocalDate convertToDate(String text) {
		LocalDate date = LocalDate.parse(text, format);
		return date;
	}
	
	public String convertToText(LocalDate date) {
		String text = date.format(format);
		return text;
	}
}
