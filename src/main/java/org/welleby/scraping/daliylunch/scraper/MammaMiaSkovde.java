package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.welleby.commons.time.DayOfWeekHelper;

public class MammaMiaSkovde extends LunchScraper {
	private final String divClassName;

	public MammaMiaSkovde()  {
		super();
		this.restaurantName = "Mamma Mia";
		this.url = "http://mammamia.kvartersmenyn.se";
		this.divClassName = "meny";
	}

	@Override
	public void scrape() throws IOException{
		Element lunchDiv = doc.getElementsByClass(divClassName).first();
		List<Node> divNodes = lunchDiv.childNodes();
		DayOfWeek day = null;
		for (Node node : divNodes) {
			if(node instanceof Element) {
				if(((Element) node).tagName().equals("strong"))
					day = DayOfWeekHelper.getDay(((Element) node).text());
			} else if(day!=null) {
				if(node instanceof TextNode)
					addLunch(((TextNode) node).text(),day);
			}
		}

	}
}
