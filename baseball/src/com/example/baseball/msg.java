package com.example.baseball;

import org.xml.sax.Parser;

import android.R.integer;

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
	 static String grade=""; 
	 static int gradecode=0; 
	 static int number=0;
	 static int hit=0;
	 static int walk=0;
	 static double tt=1;
	 public static String getgrade(){
		 if(number!=0){
			 double hita=(double)hit;
			 double numbera=(double)number;
			 double temx=(hita/numbera)*1000;
			 int temc=(int)temx;
			 tt=(double)temc/1000;
		 }
		
			 grade=number+"+打數+"+hit+"+安打+"+(hit+walk)+"+上壘+"+tt+"+打擊率";
			 return grade;
	 }
	 //synchronized
	
}
