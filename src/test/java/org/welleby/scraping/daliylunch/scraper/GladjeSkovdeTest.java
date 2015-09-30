package org.welleby.scraping.daliylunch.scraper;


import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class GladjeSkovdeTest extends LunchScraperTest{
	@Override
	public void setup() throws IOException {
		scraper = new GladjeSkovde();
		input = IOUtils.toString(classLoader.getResourceAsStream("scraper/input/gladjeskovde_input.html"), "UTF-8");
		output = IOUtils.toString(classLoader.getResourceAsStream("scraper/output/gladjeskovde_output.txt"), "UTF-8");
	}
}
