package com.dateSlice;

public class EachDayAttr {
	
	private int which;
	    
    private int week;
    
    private int flag;
    
    public EachDayAttr() {
    	super();
	}

	public EachDayAttr(int which, int week, int flag) {
		super();
		this.which = which;
		this.week = week;
		this.flag = flag;
	}

	public int getWhich() {
		return which;
	}

	public void setWhich(int which) {
		this.which = which;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "EachDayAttr [which=" + which + ", week=" + week + ", flag=" + flag + "]";
	}

}
