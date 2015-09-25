package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.welleby.scraping.daliylunch.LunchMenuItem;

public class GolfenSkovde extends LunchScraper {
	private final String divName;

	public GolfenSkovde() throws Exception {
		super();
		this.mainUrl = new URL("http://mattiasmat.se/golfen/");
		this.divName = "lunch-content-golfen";
	}
	
	public void update() throws IOException{
		Document doc = Jsoup.connect(mainUrl.toString()).get();
		doc.outputSettings().charset("UTF-8");
		doc.outputSettings().escapeMode(EscapeMode.xhtml);
		
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
		List<String> lunches = new ArrayList<String>();
		List<TextNode> textNodes = lunchElement.textNodes();
		for (TextNode textNode : textNodes) {
			lunches.add(textNode.text());
		}
		
		List<LunchMenuItem> result = new ArrayList<LunchMenuItem>();
		for (String string : lunches) {
			LunchMenuItem lunchMenuItem = new LunchMenuItem(string);
			result.add(lunchMenuItem);
		}
		lunchMenu.put(day, result);
	}

}
