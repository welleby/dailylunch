package org.welleby.scraping.daliylunch.scraper;


import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class MangosSkovdeTest extends LunchScraperTest{
	@Override
	public void setup() throws IOException {
		scraper = new MangosSkovde();
		input = IOUtils.toString(classLoader.getResourceAsStream("scraper/input/mangosskovde_input.html"), "UTF-8");
		output = IOUtils.toString(classLoader.getResourceAsStream("scraper/output/mangosskovde_output.txt"), "UTF-8");
	}
}
