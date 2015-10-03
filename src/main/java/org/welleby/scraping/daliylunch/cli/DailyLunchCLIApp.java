package org.welleby.scraping.daliylunch.cli;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.welleby.commons.time.DayOfWeekHelper;
import org.welleby.scraping.daliylunch.scraper.GladjeSkovde;
import org.welleby.scraping.daliylunch.scraper.GolfenSkovde;
import org.welleby.scraping.daliylunch.scraper.LunchScraper;
import org.welleby.scraping.daliylunch.scraper.MammaMiaSkovde;
import org.welleby.scraping.daliylunch.scraper.PinchosSkovde;

public class DailyLunchCLIApp {

	private List<String> lunch = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		CommandLineParser parser = new DefaultParser();
		Options options = new Options();
		options.addOption( "d", "day", true, "which day to show menus for" );
		
		try {
		    CommandLine line = parser.parse( options, args );
		    DayOfWeek today = null;
		    if( line.hasOption( "day" ) ) {
		    	String value = line.getOptionValue("day");
		    	today = DayOfWeek.valueOf(value.toUpperCase());
		    	if(today==null)
		    		throw new ParseException("Didnt recognize day "+value+".");
		    }else {
		    	Calendar now = new GregorianCalendar(); 
		    	today = DayOfWeekHelper.getDay(now);
		    }
		    
		    List<LunchScraper> scrapers = new ArrayList<LunchScraper>();
		    fillScrapers(scrapers);
		    
		    
		    System.out.println(today.toString() + " : \r\n");
		    for (LunchScraper scraper : scrapers) {
		    	System.out.println(scraper.getRestaurantName() +" : "+ scraper.getLunch(today));
		    }
		}
		catch( ParseException exp ) {
		    System.out.println( "Unexpected exception:" + exp.getMessage() );
		}
	}
	
	private static void fillScrapers(List<LunchScraper> scrapers) {
	    scrapers.add(new GladjeSkovde());
	    scrapers.add(new GolfenSkovde());
	    scrapers.add(new MammaMiaSkovde());
	    scrapers.add(new PinchosSkovde());
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
