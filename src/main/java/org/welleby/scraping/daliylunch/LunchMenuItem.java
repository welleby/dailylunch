package org.welleby.scraping.daliylunch;

public class LunchMenuItem {
	private LunchType type;
	private String lunch;
	
	public LunchMenuItem(){};
	public LunchMenuItem(LunchType type, String lunch){
		this.type = type;
		this.lunch = lunch;
	}
	public LunchMenuItem(String lunch) {
		this.type = LunchType.UNKNOWN;
		this.lunch = lunch;
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
	
	@Override
	public String toString(){
		return lunch;
	}

}
