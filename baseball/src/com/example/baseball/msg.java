package com.example.baseball;

public class msg {
	protected   String rev="NULL";
	public   synchronized void setr(String x){
		rev=x;
	}
	public  synchronized String getrev(){
		return rev;
	}
	
	protected   boolean rec=false;
	public   synchronized void setre(boolean x){
		rec=x;
	}
	public  synchronized boolean getre(){
		return rec;
	}
	
	protected   boolean ini=false;
	public   synchronized void setini(boolean x){
		ini=x;
	}
	public  synchronized boolean getini(){
		return ini;
	}
	
	 static int  count=0;
	  public   static  void setcount(int x){
		count=x;
	}
	 public  static  int getcount(){
		return count;
	}
	 //synchronized
	
}
