package com.tausif.interrupt.interrupted;

public class InterruptAndBehaveNormalThreadExample {
	public static void main(String[] args)
	{
		Processor processor1=new Processor("P1");
		processor1.start();
		processor1.interrupt();
		
		Processor processor2=new Processor("P2");
		processor2.start();
	}
}

class Processor extends Thread
{
	String name;
	public Processor(String name)
	{
		this.name=name;
	}
	@Override
	public void run() 
	{
		System.out.println("Hey! Processor start processing task...");
		
		for(int i=0;i<20;i++)
		{
			if(isInterrupted())
			{
				System.out.println(name+" = Job Processing Interrupted : "+i);
			}
			else
			{
				System.out.println(name+" = Job Processed : "+i);	
			}
		}
		
		System.out.println("Processing Completed! Nice Job.");
	}	
}