package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class GolfenSkovde extends LunchScraper {
	private final String divName;

	public GolfenSkovde()  {
		super();
		this.restaurantName = "Golfen";
		this.url = "http://mattiasmat.se/golfen/";
		this.divName = "lunch-content-golfen";
	}
	
	@Override
	public void scrape() throws IOException{
		Element lunchDiv = doc.getElementById(divName);
		Elements monday = lunchDiv.getElementsMatchingOwnText("Måndag");
		Elements tuesday = lunchDiv.getElementsMatchingOwnText("Tisdag");
		Elements wednesday = lunchDiv.getElementsMatchingOwnText("Onsdag");
		Elements thursday = lunchDiv.getElementsMatchingOwnText("Torsdag");
		Elements friday = lunchDiv.getElementsMatchingOwnText("Fredag");
		insertLunches(DayOfWeek.MONDAY, monday.get(0).nextElementSibling());
		insertLunches(DayOfWeek.TUESDAY, tuesday.get(0).nextElementSibling());
		insertLunches(DayOfWeek.WEDNESDAY, wednesday.get(0).nextElementSibling());
		insertLunches(DayOfWeek.THURSDAY, thursday.get(0).nextElementSibling());
		insertLunches(DayOfWeek.FRIDAY, friday.get(0).nextElementSibling());
	}
	
	private void insertLunches(DayOfWeek day, Element lunchElement){
		List<TextNode> textNodes = lunchElement.textNodes();
		for (TextNode textNode : textNodes) {
			addLunch(textNode.text().trim(), day);
		}
	}



}
