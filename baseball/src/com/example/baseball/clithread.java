package com.example.baseball;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import android.util.Log;



public class clithread extends Thread{

		BufferedReader in ;
		PrintWriter out ;
		msg p1=null;
//		public clithread(Socket ss) throws IOException{
//			in = new BufferedReader(new 
//					InputStreamReader(ss.getInputStream()));
//			out = new PrintWriter(
//					new OutputStreamWriter(ss.getOutputStream()));
//		}
		
		static  String str="",st2="";
		private String login="連線失敗";
		public clithread() {
			// TODO Auto-generated constructor stub
		}
		@Override
		public void run() {
			try {
				InetAddress serverAddr = InetAddress.getByName("203.64.183.102");
				Log.i("msg", "wait connect");
				Socket ss = new Socket("203.64.183.102",1234);
				Log.i("msg", "connect success!");
				login="成功連線";
				in = new BufferedReader(new 
						InputStreamReader(ss.getInputStream()));
				out = new PrintWriter(
						new OutputStreamWriter(ss.getOutputStream()));
				 p1=new msg();
//				out.println("Hello server");
//				out.flush();
//				System.out.println("�w�e�XHello");
				//window w=new window(clithread.str);
				 String temp="";
			
				while(true){
				p1.setre(false);
				 str = in.readLine();
			
				 p1.setr(str);
				p1.setre(true);
				System.out.println("client 收到:"+str);
				st2=st2+"\n"+str;
				if(str.equals("3"))
				{System.out.println("結束! 下一打席");}
				if(str.indexOf("請默數")>=0)
				{p1.setini(true);
				c=d=e=f=g=h=i=0;
				}
				
				balladj();
				
				
				
				}
				
				
			} catch (IOException e) {
				System.out.println("連線失敗");
				login="連線失敗";
			}
		}
		int c=0,d=0,e=0,f=0,g=0,h=0,i=0;
	public void balladj(){
		if(str.indexOf("2秒後")>=0){
			msg.setcount(8);
		
		}
		if(str.indexOf("3振")>=0){
			try {
				Thread.sleep(200);
				msg.setcount(9);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}
		if(str.indexOf("保送")>=0){
			try {
				Thread.sleep(50);
				msg.setcount(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		if(str.indexOf("揮棒太早")>=0){
			msg.setcount(0X1D);
		
		}
		if(str.indexOf("揮棒過早")>=0){
			msg.setcount(0X1E);
		
		}
		if(str.indexOf("揮棒稍晚")>=0){
			msg.setcount(0X1F);
		
		}
		
		if(str.indexOf("安打")>=0){
			msg.setcount(0X20);
		
		}
		if(str.indexOf("接殺")>=0){
			msg.setcount(0X21);
		
		}
		if(str.indexOf("界外")>=0){
			msg.setcount(0X22);
		
		}
		if(str.indexOf("1 好球")>=0&&c==0){
		
			msg.setcount(1);
			c++;
		}
		if(str.indexOf("2 好球")>=0&&c==1){
			
			msg.setcount(2);
			d++;
		}
		if(str.indexOf("3 好")>=0){
			
			msg.setcount(3);
			
		}
		
		if(str.indexOf("1 壞球")>=0&&e==0){
			
			msg.setcount(4);
			e++;
		}
		if(str.indexOf("2 壞球")>=0&&e==1){
		
			msg.setcount(5);
			f++;
		}
		if(str.indexOf("3 壞球")>=0&&f==1){
			
			msg.setcount(6);
			g++;
		}
		if(str.indexOf("4 壞")>=0){
			
			msg.setcount(7);
			
		}
		
	}
	public PrintWriter getout(){
		return out;
	}
	public String getmsg(){
		return str;
	}
	public String getlogin(){
		return login;
	}
	public msg getm(){
		return p1;
	}

}

