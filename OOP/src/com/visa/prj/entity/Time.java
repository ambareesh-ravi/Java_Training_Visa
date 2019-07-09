package com.visa.prj.entity;

public class Time {
	private int hours,minutes;
	
	public Time(int h,int m)
	{
		hours=h;
		minutes=m;
	}
	
	public static Time addTime(Time t1, Time t2) {
		
		return new Time(t1.getHours() + t2.getHours() + (t1.getMin() + t2.getMin())/60  , (t1.getMin() + t2.getMin())%60 );
		
		
	}
	public Time addTime(Time t1)
	{
		return new Time(this.getHours() + t1.getHours() + (this.getMin() + t1.getMin())/60  , (this.getMin() + t1.getMin())%60 );
	}
	public int getHours() {
		return hours;
	}
	
	public int getMin() {
		return minutes;
	}

}
