package com.example.baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.baseball.MainActivity.myThread2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class LoginGradeActivity extends Activity {
	private TextView txt1;
	private Button btn1;
	private EditText edi1;
	private ListView list;
	private Context context=null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_grade);
		txt1=(TextView)findViewById(R.id.textView1);
		btn1=(Button)findViewById(R.id.button1);
		edi1=(EditText)findViewById(R.id.editText1);
		list=(ListView)findViewById(R.id.listView1);
		context=this;
		clithread p2=new clithread();
		btn1.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new Thread(new insert(edi1.getText().toString(),msg.getgrade().toString())).start();
			}
		});
	
		new Thread(new selectfrom()).start();
	}
//////////////////
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_grade, menu);
		return true;
	}
	///////////////////////////////////
	 String[] from = {"item"}; 
		ArrayList<HashMap<String,String>> data = new ArrayList(); 
		int[] to = {R.id.item}; 
	Handler myHandler = new Handler() {  
        @Override
		public void handleMessage(Message msg) {
        	
             switch (msg.what) {   
             	case 0x01:
	    			list.setAdapter(adapter); 
             		break;
             	}
             }
     };
	///////////////
	class insert implements Runnable {   
		private String no="na";
		private String grade="na";
		   public insert(String no ,String grade){
			   this.no=no;
			   this.grade=grade;
		   }
	       @Override
		public void run() {  
	    	 
	    	   try{ 
	    		HttpClient client = new DefaultHttpClient();
	    	   Log.i("msg", "xxxxx1");
	    	   Log.i("msg", no +" "+grade);
	    	   String go="http://203.64.183.102/insert.php?no="+ no +"&grade="+ grade;
	    	   String go2="http://203.64.183.102/insert.php?no=asd&grade=0+打擊率";

	    	   Log.i("msg",  " go"+go);
	    	   HttpGet get = new HttpGet(go);
//	    	   HttpGet get = new HttpGet("http://203.64.183.102/insert.php?no=test&grade=test");
	    	   Log.i("msg", "xxxxx2");
	    	   client.execute(get); 
	    	   Log.i("msg", "xxxxx3");
	    	   }
	    	   catch (Exception ee){
	    		   ee.printStackTrace();
	    	   }
//	    	   relistData(); 
	    	   selec();
	    	   Thread.currentThread().interrupt();   
	       }
	   }
	class selectfrom implements Runnable {
		
		
 
 
	       @Override
		public void run() {  
	    	 
	    		try{
	    			HttpClient client = new DefaultHttpClient();
	    			
	    			HttpGet get = new HttpGet("http://203.64.183.102/ex1.php");
	    		
	    			HttpResponse response = client.execute(get);
	    			
	    			HttpEntity entity = response.getEntity();
	    		
	    			BufferedReader reader = new BufferedReader(
	    					new InputStreamReader(entity.getContent()));
	    			String raw;
	    			
	    			while ((raw = reader.readLine()) != null){
	    				HashMap<String,String> it = new HashMap();
	    			
	    				it.put(from[0], raw);
	    				data.add(it);
		
	    			} 
	    			adapter= new SimpleAdapter(context, data, R.layout.listitem, from, to);
	    			Message message = new Message();
		  			message.what=0x01;             
		  			LoginGradeActivity.this.myHandler.sendMessage(message);
//	    			SimpleAdapter adapter = new SimpleAdapter(context, data, R.layout.listitem, from, to);
//	    		
//	    			list.setAdapter(adapter); 
		  			
//	    			HashMap<String,String> it2 = new HashMap();
//	    			it2=data.get(1);
//	    			Log.i("msg", "data.get(1): "+it2.get(from[0]));
//	    			it2=data.get(0);
//	    			Log.i("msg", "data.get(0): "+it2.get(from[0]));
//	    			it2=data.get(2);
//	    			Log.i("msg", "data.get(2): "+it2.get(from[0]));
	    		
	    			reader.close();
	    			
	    			Thread.currentThread().interrupt(); 
	    		}catch (Exception ee){
	    			Log.i("msg", "xxxxxxerr");
	    			ee.printStackTrace();
	    		}
	       }
	  }
	SimpleAdapter adapter =null;
	private void selec(){
		try{
			HttpClient client = new DefaultHttpClient();
			
			HttpGet get = new HttpGet("http://203.64.183.102/ex1.php");
		
			HttpResponse response = client.execute(get);
			
			HttpEntity entity = response.getEntity();
		
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(entity.getContent()));
			String raw;
			
			while ((raw = reader.readLine()) != null){
				HashMap<String,String> it = new HashMap();
			
				it.put(from[0], raw);
				data.add(it);

			} 
			adapter=new SimpleAdapter(context, data, R.layout.listitem, from, to);
			Message message = new Message();
  			message.what=0x01;             
  			LoginGradeActivity.this.myHandler.sendMessage(message);

			reader.close();
			
			
		}catch (Exception ee){
			Log.i("msg", "xxxxxxerr");
			ee.printStackTrace();
		}
	}
}
