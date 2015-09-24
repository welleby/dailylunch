package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;
import org.welleby.scraping.daliylunch.LunchMenuItem;

public class GolfenSkovde extends LunchScraper {
	private final String divName;

	public GolfenSkovde() throws Exception {
		super();
		this.mainUrl = new URL("http://mattiasmat.se/golfen/");
		this.divName = "lunch-content-golfen";

	}
	@Override
	public String getLunch(DayOfWeek day) throws IOException {

		Document doc = Jsoup.connect(mainUrl.toString()).get();
		doc.outputSettings().charset("UTF-8");
		doc.outputSettings().escapeMode(EscapeMode.xhtml);
		
		System.out.println(doc.toString());
		
		Element lunchDiv = doc.getElementById(divName);
		Elements monday = lunchDiv.getElementsMatchingOwnText("Måndag");
		Elements tuesday = lunchDiv.getElementsMatchingOwnText("Tisdag");
		Elements wednesday = lunchDiv.getElementsMatchingOwnText("Onsdag");
		Elements thursday = lunchDiv.getElementsMatchingOwnText("Torsdag");
		Elements friday = lunchDiv.getElementsMatchingOwnText("Fredag");
		lunchMenu.put(DayOfWeek.MONDAY, new LunchMenuItem(monday.get(0).nextElementSibling().text()));
		lunchMenu.put(DayOfWeek.TUESDAY, new LunchMenuItem(tuesday.get(0).nextElementSibling().text()));
		lunchMenu.put(DayOfWeek.WEDNESDAY, new LunchMenuItem(wednesday.get(0).nextElementSibling().text()));
		lunchMenu.put(DayOfWeek.THURSDAY, new LunchMenuItem(thursday.get(0).nextElementSibling().text()));
		lunchMenu.put(DayOfWeek.FRIDAY, new LunchMenuItem(friday.get(0).nextElementSibling().text()));
		System.out.println(lunchMenu);
		
		
		return lunchMenu.get(day).getLunch();
	}

}
