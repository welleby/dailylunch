package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GolfenSkovde extends Scraper {
	private final String divName;

	public GolfenSkovde() throws Exception {
		super();
		this.mainUrl = new URL("http://mattiasmat.se/golfen/");
		this.divName = "lunch-content-golfen";

	}
	@Override
	public String getLunch(DayOfWeek day) throws IOException {

		Document doc = Jsoup.connect(mainUrl.toString()).get();
		Element lunchDiv = doc.getElementById(divName);
		Elements lunchElements = lunchDiv.getAllElements();
		for (Element element : lunchElements) {
			System.out.println(element.toString());
		}
		
		return null;
	}

}
