package com.example.baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

public class cli2 extends Thread{
	public void run() {
	try{
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://203.64.183.102/ex1.php");
		Log.i("msg", "xxxxxs1");
		HttpResponse response = client.execute(get);
		Log.i("msg", "xxxxxs2");
		HttpEntity entity = response.getEntity();
		Log.i("msg", "xxxxxs3");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(entity.getContent()));
		String raw;
		HashMap<String,String> it = new HashMap();
		while ((raw = reader.readLine()) != null){
			Log.i("msg", "xxxxx"+raw);
//		it.put(from[0], raw);
//		data.add(it);
//		txt4.setText(from+""+it.put(from[0], raw));
		
		} reader.close();
		
	}catch (Exception ee){Log.i("msg", "xxxxxxerr");}
	
  }
}
