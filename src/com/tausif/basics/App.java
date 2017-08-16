package com.tausif.basics;

import com.tausif.utils.ThreadByExtendingThreadClass;
import com.tausif.utils.ThreadByImplementingRunnable;

public class App {
	
	public static void main(String[] args)
	{
		//Create object of thread T1 which is extending Thread class
		ThreadByExtendingThreadClass t1 = new ThreadByExtendingThreadClass("T1", 20);

		//Create object of thread T2 which is implementing Runnable interface
		Thread t2=new Thread(new ThreadByImplementingRunnable("T2", 20));
		
		//Start thread T1
		t1.start();
		
		//Start thread T2
		t2.start();
	}
}
