package org.welleby.scraping.daliylunch.scraper;


import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class PinchosSkovdeTest extends LunchScraperTest{
	@Override
	public void setup() throws IOException {
		scraper = new PinchosSkovde();
		input = IOUtils.toString(classLoader.getResourceAsStream("scraper/input/pinchosskovde_input.html"), "UTF-8");
		output = IOUtils.toString(classLoader.getResourceAsStream("scraper/output/pinchosskovde_output.txt"), "UTF-8");
	}
}
