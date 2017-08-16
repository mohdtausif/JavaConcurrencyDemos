package com.tausif.interrupt.interrupt_keep_running;

public class InterruptAndKeepOnRunningThreadExample 
{
	public static void main(String[] args)
	{
		Processor processor=new Processor();
		processor.start();
		
		try
		{
			processor.interrupt();	
		}
		catch(Exception e)
		{
			System.out.println("Exception Handled..."+e);
		}
	}
}

class Processor extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("Hey! Processor start processing task...");
		try 
		{
			sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Exception Handled..."+e);
		}
		System.out.println("Processing Completed! Nice Job.");
	}	
}

