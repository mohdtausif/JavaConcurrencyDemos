package com.tausif.naming;

public class NamingThreadExample 
{
	public static void main(String[] args)
	{
		MyThread t=new MyThread();
		
		System.out.println(t.getName());
		System.out.println(t.getId());
	}
	
	static class MyThread extends Thread
	{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	}
}
