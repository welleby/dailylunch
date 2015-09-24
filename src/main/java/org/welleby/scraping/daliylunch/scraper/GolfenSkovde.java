package org.welleby.scraping.daliylunch.scraper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.DayOfWeek;

import org.apache.commons.io.IOUtils;

public class GolfenSkovde extends Scraper {

	public GolfenSkovde() throws IOException {
		super();
		this.mainUrl = new URL("http://mattiasmat.se/golfen/");
		this.connection = mainUrl.openConnection();
	}
	@Override
	public String getLunch(DayOfWeek day) throws IOException {

		InputStream in = connection.getInputStream();
		String encoding = connection.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		System.out.println(body);
		
		return null;
	}

}
