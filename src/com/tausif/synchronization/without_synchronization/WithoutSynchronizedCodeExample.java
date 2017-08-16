package com.tausif.synchronization.without_synchronization;

public class WithoutSynchronizedCodeExample {
	
	public static void main(String[] args)
	{
		//shared object
		Printer p=new Printer();
		
		//Create object Thread object t1
		ThreadA a = new ThreadA(p);
		
		//Create object Thread object t2
		ThreadB b = new ThreadB(p);
		
		//Start thread t1
		a.start();
		
		//Start thread t2
		b.start();
	}
}

class Printer
{
	public void printCounter(String label, int startCounter, int endCounter)
	{
		for(int i=startCounter;i<=endCounter;i++)
		{
			System.out.println(label+" : "+i);
		}
	}
}

class ThreadA extends Thread
{
	Printer p;
	public ThreadA(Printer p)
	{
		this.p=p;
	}
	@Override
	public void run() 
	{
		p.printCounter("ThreadA", 1, 20);
	}
}

class ThreadB extends Thread
{
	Printer p;
	public ThreadB(Printer p)
	{
		this.p=p;
	}
	@Override
	public void run() 
	{
		p.printCounter("ThreadB", 100, 120);
	}
}