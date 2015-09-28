package org.welleby.scraping.daliylunch.scraper;

import java.io.File;
import java.time.DayOfWeek;

import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class LunchScraperTest {
	public LunchScraper scraper;
	public File input;
	public File output;
	
	@BeforeClass
	public abstract void setup();
	
	@Test
	public void testScrape() throws Exception{
		Document doc = new Document(null);
		String inputString = FileUtils.readFileToString(input);
		doc.append(inputString);
		scraper.setDoc(doc);
		
		
		assertNotNull(scraper.getLunch(DayOfWeek.FRIDAY));
	}
}
