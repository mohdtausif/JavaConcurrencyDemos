package com.tausif.interrupt.interrup_exit_thread;

public class InterruptAndExitThreadExample {
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
			throw new RuntimeException("Processor Interrupted processing : "+e);
		}
		System.out.println("Processing Completed! Nice Job.");
	}	
}