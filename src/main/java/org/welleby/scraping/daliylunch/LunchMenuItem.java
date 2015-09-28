package org.welleby.scraping.daliylunch;

import java.time.DayOfWeek;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class LunchMenuItem {
	private LunchType type;
	private String lunch;
	private DayOfWeek day;
	
	public LunchMenuItem(String lunch, DayOfWeek day, LunchType type ){
		this.type = type;
		this.lunch = lunch;
		this.day = day;
	}
	public LunchMenuItem(String lunch, DayOfWeek day) {
		this.type = LunchType.UNKNOWN;
		this.lunch = lunch;
		this.day = day;
	}
	public LunchType getType() {
		return type;
	}
	public void setType(LunchType lunchType) {
		this.type = lunchType;
	}
	public String getLunch() {
		return lunch;
	}
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	@Override
	public String toString(){
		return lunch;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).
				append(type).
				append(lunch).
				append(day).
				toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof LunchMenuItem))
			return false;
		if (obj == this)
			return true;

		LunchMenuItem rhs = (LunchMenuItem) obj;
		return new EqualsBuilder().
				append(type, rhs.type).
				append(lunch, rhs.lunch).
				append(day, rhs.day).
				isEquals();
	}

}
