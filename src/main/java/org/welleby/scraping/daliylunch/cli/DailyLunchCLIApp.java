package org.welleby.scraping.daliylunch.cli;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.welleby.commons.time.DayOfWeekHelper;
import org.welleby.scraping.daliylunch.scraper.GladjeSkovde;
import org.welleby.scraping.daliylunch.scraper.GolfenSkovde;
import org.welleby.scraping.daliylunch.scraper.LunchScraper;
import org.welleby.scraping.daliylunch.scraper.MammaMiaSkovde;
import org.welleby.scraping.daliylunch.scraper.PinchosSkovde;

public class DailyLunchCLIApp {

	private List<String> lunch = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		List<LunchScraper> scrapers = new ArrayList<LunchScraper>();
		scrapers.add(new GladjeSkovde());
		scrapers.add(new GolfenSkovde());
		scrapers.add(new MammaMiaSkovde());
		scrapers.add(new PinchosSkovde());
		
		Calendar now = new GregorianCalendar(); 
		DayOfWeek today = DayOfWeekHelper.getDay(now);
		
		System.out.println(today.toString() + " : \r\n");
		for (LunchScraper scraper : scrapers) {
			System.out.println(scraper.getRestaurantName() +" : "+ scraper.getLunch(today));
		}
		

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
