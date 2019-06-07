package com.opah.apihoteis.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Metodos utilitarios
 * @author <a href="mailto:michelmdes@gmail.com">Michel Mendes</a> 	07/06/2019
 */
public class Util {
    
    public static String formataData(Date data, String formato) {
    	String dataFormatada = null;
    	SimpleDateFormat formatador = null;
    	if (data != null) {
    		formatador = new SimpleDateFormat(formato);
    		dataFormatada = formatador.format(data);
    	}
    	return dataFormatada;
    }
    
    public static Date obterData(String data, String formato) throws ParseException {
    	Date dataFormatada = null;
    	SimpleDateFormat formatador = null;
    	if (data != null) {
			formatador = new SimpleDateFormat(formato);
			dataFormatada = formatador.parse(data);
    	}
    	return dataFormatada;
    }
    
    public static Integer diferencaEmDias(String dtBegin, String dtEnd, String pattern) {
    	
    	DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
    	
    	DateTime begin = DateTime.parse(dtBegin, format);
    	DateTime end = DateTime.parse(dtEnd, format);
    	
    	Days d = Days.daysBetween(begin, end);
    	return d.getDays();
    }
    
    public static Timestamp currentDate() {
    	return new Timestamp(System.currentTimeMillis());
    }
    
	public static Double roundDouble(Double value, int scale) {
		Double val = null;
		if (value != null) {
			BigDecimal bd = new BigDecimal(value).setScale(scale, RoundingMode.HALF_EVEN);
			val = bd.doubleValue();
		}
		return val;
	}
}
