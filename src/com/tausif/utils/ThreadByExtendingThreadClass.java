package com.tausif.utils;

public class ThreadByExtendingThreadClass extends Thread
{
	String title;
	int counter;
	public ThreadByExtendingThreadClass(String title, int counter)
	{
		this.title=title;
		this.counter=counter;
	}
	@Override
	public void run() 
	{
		Utils.printCounters(title, counter);
		
//		for(int i=0;i<counter;i++)
//		{
//			System.out.println(title+":"+i);
//		}
	}
}
