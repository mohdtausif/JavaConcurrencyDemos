package com.tausif.join;

public class JoinThreadExample 
{
	public static void main(String[] args)
	{
		ThreadA t1 = new ThreadA("T1");
		ThreadA t2 = new ThreadA("T2");
		ThreadA t3 = new ThreadA("T3");
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		t3.start();
	}
	
	static class ThreadA extends Thread
	{
		String title;
		public ThreadA(String title)
		{
			this.title=title;
		}
		
		@Override
		public void run() 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println(title+" : "+i);
			}
		}
	}
}


