package com.tausif.utils;

public class ThreadByImplementingRunnable implements Runnable
{
	String title;
	int counter;
	public ThreadByImplementingRunnable(String title, int counter)
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
