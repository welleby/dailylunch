package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class PinchosSkovde extends LunchScraper {
	private final String divName;

	public PinchosSkovde() {
		super();
		this.restaurantName = "Pinchos";
		this.url = "http://http://www.pinchos.se/lunch-skovde/";
		this.divName = "block-yui_3_17_2_3_1428390440531_10505";
	}
	
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
