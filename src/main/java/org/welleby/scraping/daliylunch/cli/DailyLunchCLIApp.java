package org.welleby.scraping.daliylunch.cli;

import java.time.DayOfWeek;

import org.welleby.scraping.daliylunch.scraper.Scraper;
import org.welleby.scraping.daliylunch.scraper.GolfenSkovde;

public class DailyLunchCLIApp {

	public static void main(String[] args) throws Exception {
		Scraper scraper = new GolfenSkovde();
		scraper.getLunch(DayOfWeek.FRIDAY);
	}

}
