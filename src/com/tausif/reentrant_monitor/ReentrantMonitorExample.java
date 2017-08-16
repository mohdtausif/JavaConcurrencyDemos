package com.tausif.reentrant_monitor;

public class ReentrantMonitorExample 
{
	public static void main(String[] args)
	{
		TrafficSignal trafficSignal = new TrafficSignal();
		Thread trafficSignalProcessor = new Thread()
		{
			public void run() 
			{
				trafficSignal.showRed();
			}
		};
		trafficSignalProcessor.start();	
	}
	
}

class TrafficSignal
{
	public synchronized void showRed(){
		for(int i=0;i<5;i++)
		{
			System.out.println("Signal is : RED");
			try {
				Thread.sleep(1000);//for 1 sec
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		showYellow(true);
	}
	
	public synchronized void showYellow(boolean flag){
		for(int i=0;i<2;i++)
		{
			System.out.println("Signal is : YELLOW");
			try {
				Thread.sleep(1000);//for 1 sec
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(flag)
		{
			showGreen();
		}
		else
		{
			showRed();
		}
	}
	
	public synchronized void showGreen(){
		for(int i=0;i<5;i++)
		{
			System.out.println("Signal is : GREEN");
			try {
				Thread.sleep(1000);//for 1 sec
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		showYellow(false);
	}
}
