package org.welleby.scraping.daliylunch.cli;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.welleby.scraping.daliylunch.scraper.LunchScraper;
import org.welleby.scraping.daliylunch.scraper.GolfenSkovde;

public class DailyLunchCLIApp {

	public static void main(String[] args) throws Exception {
		LunchScraper scraper = new GolfenSkovde();
		scraper.update();
		List<String> lunch = new ArrayList<String>();
		for(DayOfWeek day : DayOfWeek.values()){
			lunch.addAll(scraper.getLunch(day, false));
		}
		for (String string : lunch) {
			System.out.println(string);
		}
	}

}
