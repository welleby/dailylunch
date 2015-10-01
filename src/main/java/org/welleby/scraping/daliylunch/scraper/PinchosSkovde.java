package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class PinchosSkovde extends LunchScraper {
	private final String divName;

	public PinchosSkovde() {
		super();
		this.restaurantName = "Pinchos";
		this.url = "http://www.pinchos.se/lunch-skovde/";
		this.divName = "block-yui_3_17_2_3_1428390440531_10505";
	}
	
	public void scrape() throws IOException{
		Element lunchDiv = doc.getElementById(divName);
		List<Elements> prefixElements = new ArrayList<Elements>();
		
		prefixElements.add(lunchDiv.getElementsMatchingOwnText("Fisk"));
		prefixElements.add(lunchDiv.getElementsMatchingOwnText("Kött"));
		prefixElements.add(lunchDiv.getElementsMatchingOwnText("Pasta"));
		prefixElements.add(lunchDiv.getElementsMatchingOwnText("Vegetariskt"));
		prefixElements.add(lunchDiv.getElementsMatchingOwnText("Sallad"));
		
		Calendar now = new GregorianCalendar(); 
		DayOfWeek today = DayOfWeek.of(now.get(Calendar.DAY_OF_WEEK));
		
		for (Elements elements : prefixElements) {
			Element lunchElement = elements.get(0).nextElementSibling();
			while(lunchElement.tag().getName().equals("p")) {
				insertLunches(today, lunchElement);
				lunchElement = lunchElement.nextElementSibling();
			}
		}
	}
	
	private void insertLunches(DayOfWeek day, Element lunchElement){
		List<TextNode> textNodes = lunchElement.textNodes();
		for (TextNode textNode : textNodes) {
			String text = textNode.text().trim();
			text = text.replaceAll("^[  ]", "");
			addLunch(text, day);
		}
	}

}
