package com.sergioescudero.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Clase para convertir objetos tipo java.util.Date a java.lang.String y
 * viceversa
 *
 */
public class DateStringUtils {

	public static String[] months = { "October", "November", "December", "January", "February", "March", "April", "May", "June", "July", "August",
			"September" };

	/**
	 * A partir de un String (value) con fecha en el formato (pattern)
	 * especificado devuelve un objeto de tipo java.util.Date
	 * 
	 * @param value
	 *            - string con el valor de la fecha
	 * @param pattern
	 *            - formato de fecha
	 * @return fecha en objeto tipo java.util.Date
	 * @throws ParseException
	 *             - si ocurre un error en el parseo de la fecha
	 */
	public static Date parseStringToDate(String value, String pattern) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		return formatter.parse(value);
	}

	/**
	 * Devuelve un String con la representacion de una fecha java.util.Date en
	 * el formato pedido
	 * 
	 * @param date
	 *            - objeto que contiene la fecha
	 * @param pattern
	 *            - formato de fecha
	 * @return - representacion de la fecha en el formato pedido
	 */
	public static String parseDateToString(Date date, String pattern) {
		String result = null;

		if (date != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			result = formatter.format(date);
		}

		return result;
	}

	/**
	 * Devuelve una fecha retrasada tantos meses como se especifique en la
	 * variable 'totalMonthToLoad' ej si hoy es 11-06-2012 y totalMonthToLoad=1
	 * entonces devolvera 11-05-2012
	 * 
	 * @param totalMonthToLoad
	 * @return
	 */
	// TODO ver que pasa con los meses que tengan menos de 31 dias
	public static Date getMinimunDate(int totalMonthToLoad) {

		Calendar calendar = new GregorianCalendar();

		int backward;
		if (totalMonthToLoad < 0) {
			backward = totalMonthToLoad;
		} else {
			backward = totalMonthToLoad * -1;
		}

		calendar.add(Calendar.MONTH, backward);

		return calendar.getTime();

	}

	public static String getFormattedPeriod(int m) {
		return DateStringUtils.months[m - 1];
	}

}
