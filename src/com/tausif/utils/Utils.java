package com.tausif.utils;

public class Utils {
	public static void printCounters(String label , int count)
	{
		for(int i=0;i<count;i++)
		{
			System.out.println(label+" : "+i);
		}
	}
}
