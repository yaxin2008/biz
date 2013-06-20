package us.co.state.sos.convertors;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

@FacesConverter(value = "sosDateConverter")
public class SosDateConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//"12/13/2012"  //good
		//13/12/2012  // good
		//2012-12-13 //good
		List<String> items = Lists.newArrayList(Splitter.on('/').split(value));
		if (items.size() != 3){
			throw new ConverterException(new FacesMessage("Date is no in recognizable format"));
		}
		
		String yearString = items.get(2);
		
		if (yearString.length() != 4){
			throw new ConverterException(new FacesMessage("Date is no in recognizable format"));
		}
		
		try {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
			DateTime dateTime = dateTimeFormatter.parseDateTime(value);
			
			return dateTime.toDate();
		} catch (Exception e) {
			throw new ConverterException(new FacesMessage("Date is no in recognizable format"));
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {

		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("MM/dd/yyyy");
		if (value instanceof java.util.Date) {
			java.util.Date date = (java.util.Date) value;
			return dateTimeFormatter.print(new DateTime(date));
		}
		return null;
	}
	

}
