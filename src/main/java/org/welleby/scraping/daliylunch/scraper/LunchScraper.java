package org.welleby.scraping.daliylunch.scraper;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities.EscapeMode;
import org.welleby.scraping.daliylunch.LunchMenuItem;

public abstract class LunchScraper {
	protected String restaurantName;
	protected String url;
	protected Document doc;
	protected List<LunchMenuItem> lunchMenu = new ArrayList<LunchMenuItem>();
	
	public List<String> getLunch(DayOfWeek day) throws Exception {
		if(doc==null)
			update();
		if(lunchMenu==null || lunchMenu.size()<1)
			scrape();
		
		List<String> result = new ArrayList<String>();
		for (LunchMenuItem lunchMenuItem : lunchMenu) {
			if(lunchMenuItem.getDay().equals(day))
				result.add(lunchMenuItem.getLunch());
		}
		return result;
	}
	protected void addLunch(String lunch, DayOfWeek day){
		lunch = lunch.replaceAll("^[\\s;:,.-]+", "");
		lunch = lunch.replaceAll("$[\\s;:,.-]+", "");
		LunchMenuItem item = new LunchMenuItem(lunch, day);
		if(!lunchMenu.contains(item))
			lunchMenu.add(item);
	}
	public void update() throws Exception {
		setDoc(Jsoup.connect(url).get());
	}
	public abstract void scrape() throws Exception;
	
	public String getMainUrl() {
		return url;
	}
	protected void setMainUrl(String url) {
		this.url = url;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public Document getDoc() {
		return doc;
	}
	public void setDoc(Document doc) {
		this.doc = doc;
		doc.outputSettings().charset("UTF-8");
		doc.outputSettings().escapeMode(EscapeMode.xhtml);
	}
}
