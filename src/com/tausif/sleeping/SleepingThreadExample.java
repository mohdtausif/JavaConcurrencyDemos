package com.tausif.sleeping;

public class SleepingThreadExample {
	public static void main(String[] args)
	{
		Thread thread = new Thread(){
			@Override
			public void run() 
			{
				System.out.println("Train is going to Faizabad.");
				for(int i=0;i<10;i++)
				{
					if(i==3)
					{
						System.out.println("Train stopped at Ghaziabad Junction : wait for 2 secs");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(i==6)
					{
						System.out.println("Train stopped at Kanpur Junction : wait for 2 secs");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(i==8)
					{
						System.out.println("Train stopped at Lucknow Junction : wait for 2 secs");
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println("Train is moving...");
				}
				System.out.println("Train reached at Faizabad.");
			}
		};
		thread.start();
	}
}
