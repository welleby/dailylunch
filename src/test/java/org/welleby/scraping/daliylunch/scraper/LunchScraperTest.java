package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class LunchScraperTest {
	public static LunchScraper scraper;
	public static String input;
	public static String output;
	public ClassLoader classLoader = getClass().getClassLoader();
	
	@Before
	public abstract void setup() throws IOException;
	
	@Test
	public void testScrape() throws Exception{
		Document doc = new Document("");
		doc.append(input);
		scraper.setDoc(doc);
		assertNotNull(scraper.getLunch(DayOfWeek.FRIDAY));
		String result = "";
		for (DayOfWeek day : DayOfWeek.values()) {
			List<String> lunch = scraper.getLunch(day);
			for (String string : lunch) {
				result +=string+"\r\n";
			}
		}
		result = result.replaceFirst("\\r\\n$", "");
		assertEquals(output, result);
	}
}
