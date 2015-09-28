package org.welleby.scraping.daliylunch.cli;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.welleby.scraping.daliylunch.scraper.LunchScraper;
import org.welleby.scraping.daliylunch.scraper.GolfenSkovde;

public class DailyLunchCLIApp {

	private List<String> lunch = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		LunchScraper scraper = new GolfenSkovde();
		
		Calendar now = new GregorianCalendar(); 
		DayOfWeek today = DayOfWeek.of(now.get(Calendar.DAY_OF_WEEK));
		System.out.println(today.toString() + " : \r\n");
		System.out.println(scraper.getRestaurantName() +" : "+ scraper.getLunch(today));
		
		

	}

	@SuppressWarnings("unused")
	private void printWeek(LunchScraper scraper) throws Exception{
		for(DayOfWeek day : DayOfWeek.values()){
			lunch.addAll(scraper.getLunch(day));
		}
		for (String string : lunch) {
			System.out.println(string);
		}
	}
	
}
