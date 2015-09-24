package org.welleby.datacollection.daliylunch.collection;

import java.net.URL;
import java.net.URLConnection;
import java.time.DayOfWeek;

public abstract class Collector {
	protected URL mainUrl;
	protected URLConnection connection;
	
	public abstract String getLunch(DayOfWeek day) throws Exception;
	public URL getMainUrl() {
		return mainUrl;
	}
	protected void setMainUrl(URL mainUrl) {
		this.mainUrl = mainUrl;
	}
}
