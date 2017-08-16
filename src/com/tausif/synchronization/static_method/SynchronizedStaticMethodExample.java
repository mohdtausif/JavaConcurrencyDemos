package com.tausif.synchronization.static_method;

public class SynchronizedStaticMethodExample {
	
	public static void main(String[] args)
	{
		//Create object Thread object t1
		ThreadA a = new ThreadA();
		
		//Create object Thread object t2
		ThreadB b = new ThreadB();
		
		//Start thread t1
		a.start();
		
		//Start thread t2
		b.start();
	}
}

class Printer
{
	public static synchronized void printCounter(String label, int startCounter, int endCounter)
	{
		for(int i=startCounter;i<=endCounter;i++)
		{
			System.out.println(label+" : "+i);
		}	
	}
}

class ThreadA extends Thread
{
	@Override
	public void run() 
	{
		Printer.printCounter("ThreadA", 1, 20);
	}
}

class ThreadB extends Thread
{
	@Override
	public void run() 
	{
		Printer.printCounter("ThreadB", 100, 120);
	}
}