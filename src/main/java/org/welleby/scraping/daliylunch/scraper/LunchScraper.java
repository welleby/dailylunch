package org.welleby.scraping.daliylunch.scraper;

import java.net.URL;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

import org.welleby.scraping.daliylunch.LunchMenuItem;

public abstract class LunchScraper {
	protected URL mainUrl;
	protected List<LunchMenuItem> lunchMenu = new ArrayList<LunchMenuItem>();
	
	public List<String> getLunch(DayOfWeek day, boolean update) throws Exception{
		if(update)
			update();
		return getLunch(day);
	}
	protected List<String> getLunch(DayOfWeek day) throws Exception {
		List<String> result = new ArrayList<String>();
		for (LunchMenuItem lunchMenuItem : lunchMenu) {
			if(lunchMenuItem.getDay().equals(day))
				result.add(lunchMenuItem.getLunch());
		}
		return result;
	}
	protected void addLunch(String lunch, DayOfWeek day){
		LunchMenuItem item = new LunchMenuItem(lunch, day);
		if(!lunchMenu.contains(item))
			lunchMenu.add(item);
	}
	public abstract void update() throws Exception;
	
	public URL getMainUrl() {
		return mainUrl;
	}
	protected void setMainUrl(URL mainUrl) {
		this.mainUrl = mainUrl;
	}
}
