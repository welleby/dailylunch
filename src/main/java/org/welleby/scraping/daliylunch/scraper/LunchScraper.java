package org.welleby.scraping.daliylunch.scraper;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

import org.welleby.scraping.daliylunch.LunchMenuItem;

public abstract class LunchScraper {
	protected URL mainUrl;
	protected Map<DayOfWeek, LunchMenuItem> lunchMenu = new HashMap<DayOfWeek, LunchMenuItem>();
	
	public String getLunch(DayOfWeek day) throws Exception {
		LunchMenuItem lunch = lunchMenu.get(day);
		if(lunch!= null)
			return lunch.getLunch();
		return null;
	}
	public URL getMainUrl() {
		return mainUrl;
	}
	protected void setMainUrl(URL mainUrl) {
		this.mainUrl = mainUrl;
	}
}
