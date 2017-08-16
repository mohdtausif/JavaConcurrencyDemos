package com.tausif.deadlock;

/**
 * <h1>Dead Lock Condition : </h1>
 * <p>ThreadA acquire lock of "ColorPrinter" shared object and ThreadB acquire lock of "BlackAndWhitePrinter"
 *  shared object, then ThreadA is waiting for "BlackAndWhitePrinter" shared object lock and ThreadB is waiting
 *   for "ColorPrinter" clock, so in this case a cyclic dependency formed and both threads keep on waiting for 
 *   locks and they goes in deadlock state.</p>    
 * @author Mohd Tausif
 *
 */

public class DeadLockExample 
{
	public static void main(String[] args)
	{
		//shared resource 1
		ColorPrinter cp=new ColorPrinter();
		
		//shared resource 2
		BlackAndWhitePrinter bwp=new BlackAndWhitePrinter();
		
		ThreadA a=new ThreadA(cp, bwp);
		ThreadB b=new ThreadB(cp, bwp);
		a.start();
		b.start();
	}
}

class ColorPrinter
{
	public void printCounter(String label, int startCounter, int endCounter)
	{
		for(int i=startCounter;i<=endCounter;i++)
		{
			System.out.println("ColorPrinter : "+i);
		}	
	}
}

class BlackAndWhitePrinter
{
	public void printCounter(String label, int startCounter, int endCounter)
	{
		for(int i=startCounter;i<=endCounter;i++)
		{
			System.out.println("BlackAndWhitePrinter : "+i);
		}	
	}
}

class ThreadA extends Thread
{
	ColorPrinter cp;
	BlackAndWhitePrinter bwp; 
	public ThreadA(ColorPrinter cp, BlackAndWhitePrinter bwp)
	{
		this.cp=cp;
		this.bwp=bwp;
	}
	
	@Override
	public void run() 
	{
		synchronized (cp) {
			System.out.println("ThreadA : locked \"ColorPrinter\" and looking for lock of \"BlackAndWhitePrinter\"");
			
			synchronized (bwp) {
				System.out.println("ThreadA : locked \"BlackAndWhitePrinter\"");
			}
		}
	}
}

class ThreadB extends Thread
{
	ColorPrinter cp;
	BlackAndWhitePrinter bwp; 
	public ThreadB(ColorPrinter cp, BlackAndWhitePrinter bwp)
	{
		this.cp=cp;
		this.bwp=bwp;
	}
	
	@Override
	public void run() 
	{
		synchronized (bwp) {
			System.out.println("ThreadB : locked \"BlackAndWhitePrinter\" and looking for lock of \"ColorPrinter\"");
			
			synchronized (cp) {
				System.out.println("ThreadB : locked \"ColorPrinter\"");
			}
		}
	}
}