package org.welleby.scraping.daliylunch.scraper;


import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class MammaMiaSkovdeTest extends LunchScraperTest{
	@Override
	public void setup() throws IOException {
		scraper = new MammaMiaSkovde();
		input = IOUtils.toString(classLoader.getResourceAsStream("scraper/input/mammamiaskovde_input.html"), "UTF-8");
		output = IOUtils.toString(classLoader.getResourceAsStream("scraper/output/mammamiaskovde_output.txt"), "UTF-8");
	}
}
