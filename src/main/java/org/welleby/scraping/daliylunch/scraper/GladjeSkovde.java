package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.time.DayOfWeek;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.welleby.commons.time.DayOfWeekHelper;

public class GladjeSkovde extends LunchScraper {
	private final String divClassName;

	public GladjeSkovde()  {
		super();
		this.restaurantName = "Glädje";
		this.url = "http://www.restauranggladje.se/skovde/lunch/";
		this.divClassName = "dagens";
	}
	
	@Override
	public void scrape() throws IOException{
		Elements lunchDivs = doc.getElementsByClass(divClassName);
		for (Element lunchDiv : lunchDivs) {
			Element dayElement = lunchDiv.getElementsByClass("day").first();
			DayOfWeek day = DayOfWeekHelper.getDay(dayElement.text());
			if(day!=null) {
				String tempResult="";
				for (Element lunchElement : lunchDiv.getAllElements()) {
					if(lunchElement.hasClass("foodTitle"))
						tempResult=lunchElement.text().trim()+" ";
					else if(lunchElement.hasClass("foodText")) {
						addLunch(tempResult+lunchElement.text(), day);
						tempResult="";
					}
				}
			}

		}
	}
}
