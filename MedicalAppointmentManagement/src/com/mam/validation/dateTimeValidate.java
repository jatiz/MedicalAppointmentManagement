package com.mam.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mam.customexception.mamException;
import com.mam.customexception.mamThrowableException;

public class dateTimeValidate {

	private Pattern pattern;
	private Matcher matcher;

	private static final String TIME12HOURS_PATTERN = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";

	public dateTimeValidate() {
		pattern = Pattern.compile(TIME12HOURS_PATTERN);
	}

	/**
	 * Validate time in 12 hours format with regular expression
	 * 
	 * @param time
	 *            time address for validation
	 * @return true valid time format, false invalid time format
	 */
	public boolean validateTime(final String time) {		//validate Time format
		matcher = pattern.matcher(time);
		return matcher.matches();
	}
	
	public String convertTimeFormat(String time) throws mamThrowableException{
		String formattedTime = "null";
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
	    SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
	    try {
	    	Date date = parseFormat.parse(time);
	    	formattedTime = displayFormat.format(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("Invalid time", e);
		}
		return formattedTime;
	}

	public boolean validateDate(String date) throws mamException, mamThrowableException {		//Validate Date format
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date.trim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new mamThrowableException("Invalid date", e);
		}
		return true;
	}

}
