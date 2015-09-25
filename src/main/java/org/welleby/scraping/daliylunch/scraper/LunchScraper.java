package org.welleby.scraping.daliylunch.scraper;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.welleby.scraping.daliylunch.LunchMenuItem;

public abstract class LunchScraper {
	protected URL mainUrl;
	protected Map<DayOfWeek, List<LunchMenuItem>> lunchMenu = new HashMap<DayOfWeek, List<LunchMenuItem>>();
	
	public List<String> getLunch(DayOfWeek day, boolean update) throws Exception{
		if(update)
			update();
		return getLunch(day);
	}
	protected List<String> getLunch(DayOfWeek day) throws Exception {
		List<LunchMenuItem> lunch = lunchMenu.get(day);
		List<String> result = new ArrayList<String>();
		if(lunch!=null)
			for (LunchMenuItem item : lunch) {
				result.add(item.getLunch());
			}
		return result;
	}
	public abstract void update() throws Exception;
	
	public URL getMainUrl() {
		return mainUrl;
	}
	protected void setMainUrl(URL mainUrl) {
		this.mainUrl = mainUrl;
	}
}
