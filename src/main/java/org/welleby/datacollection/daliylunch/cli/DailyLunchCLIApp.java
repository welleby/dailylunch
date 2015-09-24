package org.welleby.datacollection.daliylunch.cli;

import java.time.DayOfWeek;

import org.welleby.datacollection.daliylunch.collection.Collector;
import org.welleby.datacollection.daliylunch.collection.GolfenSkovde;

public class DailyLunchCLIApp {

	public static void main(String[] args) throws Exception {
		Collector collector = new GolfenSkovde();
		collector.getLunch(DayOfWeek.FRIDAY);
	}

}
