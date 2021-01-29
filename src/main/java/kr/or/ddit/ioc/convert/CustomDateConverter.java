package kr.or.ddit.ioc.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomDateConverter implements Converter<String, Date> {
    private String dateFormat;
    


	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}



	//source: 2021-01-11, yyyy-mm-dd
	// . 개발자가 만드는 converter는 Converter인터페이스를 구현하여 만든다
	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
   
}
