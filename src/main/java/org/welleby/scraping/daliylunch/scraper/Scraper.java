package org.welleby.scraping.daliylunch.scraper;

import java.net.URL;
import java.time.DayOfWeek;

public abstract class Scraper {
	protected URL mainUrl;
	
	public abstract String getLunch(DayOfWeek day) throws Exception;
	public URL getMainUrl() {
		return mainUrl;
	}
	protected void setMainUrl(URL mainUrl) {
		this.mainUrl = mainUrl;
	}
}
