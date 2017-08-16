package com.tausif.interrupt.interrup_behave_normal;

public class InterruptAndBehaveNormalThreadExample {
	public static void main(String[] args)
	{
		Processor processor=new Processor();
		processor.start();
		processor.interrupt();	
	}
}

class Processor extends Thread
{
	@Override
	public void run() 
	{
		System.out.println("Hey! Processor start processing task...");
		
		for(int i=0;i<20;i++)
		{
			System.out.println("Job Processed : "+i);
		}
		
		System.out.println("Processing Completed! Nice Job.");
	}	
}