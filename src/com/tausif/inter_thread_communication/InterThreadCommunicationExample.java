package com.tausif.inter_thread_communication;

public class InterThreadCommunicationExample 
{
	public static void main(String[] args)
	{
		ChocolateSeller chocolateSeller=new ChocolateSeller();
		Thread customer = new Thread(){
			@Override
			public void run() 
			{
				chocolateSeller.sellChocolate(5);
			}
		};
		
		Thread chocolateVender = new Thread(){
			@Override
			public void run() 
			{
				chocolateSeller.buyChocolateStock(7);
			}
		};
		
		customer.start();
		
		chocolateVender.start();
		
	}
}

class ChocolateSeller
{
	int chocolateStock=0;
	public synchronized void sellChocolate(int chocolateCount)
	{
		System.out.println("Going to sell chocolate =>");
		if(chocolateCount>chocolateStock)
		{
			System.out.println("Out of stock, Buy more stocks.");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chocolateStock=chocolateStock-chocolateCount;
		System.out.println("Sold Out : "+chocolateCount+" and Left stock is :"+chocolateStock);
	}
	
	public synchronized void buyChocolateStock(int chocolateCount)
	{
			System.out.println("Going to buy stock =>");
			chocolateStock=chocolateStock+chocolateCount;
			System.out.println(" More stock purchased successfully.");
			notify();	
	}
}