package com.productmanagement.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.productmanagement.constant.ProductServiceConstants;

public class DateUtils {

	public static String  dateFormat() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(ProductServiceConstants.DATE_FORMAT);
		LocalDate now = LocalDate.now();
		return dateTimeFormatter.format(now);
	}

	public static String  dateTimeFormat() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		 LocalDateTime now = LocalDateTime.now(); 
		return dtf.format(now);
	}
	
}
