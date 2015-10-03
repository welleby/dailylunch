package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.welleby.commons.time.DayOfWeekHelper;

public class MangosSkovde extends LunchScraper {
	private final String divId;

	public MangosSkovde()  {
		super();
		this.restaurantName = "Mangos";
		this.url = "http://mangos.se/lunch/";
		this.divId = "inner-content";
	}
	
	@Override
	public void scrape() throws IOException, ParseException{
		Element lunchDiv = doc.getElementById(divId);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DayOfWeek dayOfWeek = null;
		String tempResult=null;
		for (Element element : lunchDiv.children()) {
			if(element.tagName().equals("p")) {
				if(element.text().matches("\\d{2}/\\d{2}/\\d{4}")) {
					Date date = sdf.parse(element.text());
					Calendar cal = new GregorianCalendar();
					cal.setTime(date);
					dayOfWeek = DayOfWeekHelper.getDay(cal);
				}
				Elements category = element.getElementsByAttributeValue("style", "text-decoration: underline;");
				
				if(category.size()>0) {
					tempResult=category.first().text().trim()+": ";
				} else if(tempResult!=null) {
					tempResult+=element.text().trim();
					if(dayOfWeek!=null)
						addLunch(tempResult, dayOfWeek);
					tempResult=null;
				}
				
			}
		}
		
	}
}
