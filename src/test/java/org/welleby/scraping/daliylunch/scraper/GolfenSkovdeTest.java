package org.welleby.scraping.daliylunch.scraper;


import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class GolfenSkovdeTest extends LunchScraperTest{
	@Override
	public void setup() throws IOException {
		scraper = new GolfenSkovde();
		input = IOUtils.toString(classLoader.getResourceAsStream("scraper/input/golfenskovde_input.html"), "UTF-8");
		output = IOUtils.toString(classLoader.getResourceAsStream("scraper/output/golfenskovde_output.txt"), "UTF-8");
	}
}
