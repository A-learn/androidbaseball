package com.example.baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.xml.datatype.Duration;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.transition.Visibility;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	protected static final int GUIUPDATEIDENTIFIER = 0x123;
	//Socket ss=null;
	private EditText edt;
	private Button btn1;
	private TextView text1,txt4,txt5;
	private ImageView imageView1,ImageView02,ImageView03,ImageView01,imageView3,ImageView04,ImageView05,ImageView06;
	private ImageView imageView2;
	private Button button1;
	private Button button2,button3,button4;
	private Context am;
	Context context1;
	private PrintWriter out ;
	BufferedReader in ;
	private boolean start=false;
	final clithread cc= new clithread();
	
	msg p1=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1=(Button)findViewById(R.id.button1);
		
		button1.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				cc.start();
				
//				ImageView02.setImageResource(R.drawable.redball);
				
				try {
					Thread.sleep(1500);
					Toast.makeText(getApplicationContext(), cc.getlogin(),
							Toast.LENGTH_SHORT).show();
					out=cc.getout();
					in=cc.in;
					p1=cc.getm();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				out.println("start");
				out.flush();
				//button1.setVisibility(View.INVISIBLE);
				
				 text1.setText("");
				 com.example.baseball.msg.number++;
				 
				 start=true;
				 Timer timer=new Timer();
       		  timer.schedule(timerTask, 0,100);
       		  new Thread(new myThread2()).start();
       		  new Thread(new myThread4()).start();
       		 new Thread(new myThread5()).start();
//				Message message = new Message();
//            	
//    			message.what=0x10;             
//    			 MainActivity.this.myHandler.sendMessage(message);   
              
			}
               
		});
		button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				out.println("np");
				out.flush();
				 
//				c=0;d=0;e=0;f=0;g=0;h=0;i=0;
				c4=c5=0;
				co=1;
				com.example.baseball.msg.number++;
				Message message = new Message();
	  			message.what=0x19;             
	  			MainActivity.this.myHandler.sendMessage(message);
	  			new Thread(new myThread3()).start();
			}
		});
		
		button4=(Button)findViewById(R.id.button4);
		button4.setOnClickListener(new Button.OnClickListener() {
			String[] from = {"item"};
			ArrayList<HashMap<String,String>> data = new ArrayList();
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent intent =new Intent();
 				  intent.setClass(MainActivity.this, LoginGradeActivity.class);
 				 Bundle bundle=new Bundle();
 				
 				 intent.putExtras(bundle);
 				 startActivity(intent); 
		  }
			});
		dialog();
		text1=(TextView)findViewById(R.id.textView1);
		txt5=(TextView)findViewById(R.id.textView5);
		txt5.setVisibility(View.INVISIBLE);
		
//		Animation am = new TranslateAnimation(-3,100,-7,650);
//		am.setDuration( 2000 );
//		am.setRepeatCount( 0 ); 
//		imageView1.setAnimation(am);
//		am.startNow();
		///////*********/////////
		 imageView1= (ImageView)findViewById(R.id.imageView1);
		  imageView2=(ImageView)findViewById(R.id.imageView2);
		  ImageView02=(ImageView)findViewById(R.id.ImageView02);
		  ImageView01=(ImageView)findViewById(R.id.ImageView01);
		  ImageView03=(ImageView)findViewById(R.id.ImageView03);
		  imageView3=(ImageView)findViewById(R.id.imageView3);
		  ImageView04=(ImageView)findViewById(R.id.ImageView04);
		  ImageView05=(ImageView)findViewById(R.id.ImageView05);
		  ImageView06=(ImageView)findViewById(R.id.ImageView06);
		  context1=this.getBaseContext();
		 
		  new Thread(new myThread()).start();
		
		  //new Thread(new myThread()).start();  
//		  Timer timer=new Timer();
//		  timer.schedule(timerTask, 0,100);
		 
	}

	Handler myHandler = new Handler() {  
        @Override
		public void handleMessage(Message msg) {   
             switch (msg.what) {   
                  case MainActivity.GUIUPDATEIDENTIFIER:   
//                       myBounceView.invalidate();
                	//  text1.setText(""+i);
                	
                	  Animation am2 = AnimationUtils.loadAnimation(context1, R.animator.anim);
            		  imageView2.setAnimation(am2);
            		  am2.startNow();
            		  break;
                  case 0x10:
                	
                	 // text1.setText(time+"");
                	  	Animation am = new TranslateAnimation(0,80,0,170);
              			am.setDuration( 5000 );
              			am.setRepeatCount( 0 ); 
              			imageView1.setAnimation(am);
              			
              			am.startNow();
              			
//      				Toast.makeText(getApplicationContext(), "ball",
//							Toast.LENGTH_SHORT).show();
      				break;
                  case 0x11:
                	  
                	  text1.setText(time+"");
                	  
                	  break;
                  case 0x12:
                	  com.example.baseball.msg.setcount(0);
                	  ImageView02.setImageResource(R.drawable.redball);
                	  Toast.makeText(getApplicationContext(), "好球",
  							Toast.LENGTH_SHORT).show();
                	
                	  break;
                  case 0x13:
                	  com.example.baseball.msg.setcount(0);
                	  ImageView01.setImageResource(R.drawable.redball);
                	  Toast.makeText(getApplicationContext(), "好球",
    							Toast.LENGTH_SHORT).show();
                	 
                	  break;
                  case 0x14:
                	  com.example.baseball.msg.setcount(0);
                	  ImageView03.setImageResource(R.drawable.redball);
                	  Toast.makeText(getApplicationContext(), "好球",
    							Toast.LENGTH_SHORT).show();
                	
                	  break;
                  case 0x15:
                	  com.example.baseball.msg.setcount(0);
                	  imageView3.setImageResource(R.drawable.yelb);
                	  Toast.makeText(getApplicationContext(), "壞球",
                			  Toast.LENGTH_SHORT).show();
                	  break;
                  case 0x16:
                	  com.example.baseball.msg.setcount(0);
                	  ImageView04.setImageResource(R.drawable.yelb);
                	  Toast.makeText(getApplicationContext(), "壞球",
  							Toast.LENGTH_SHORT).show();              	 
                	  break;
                  case 0x17:
                	  com.example.baseball.msg.setcount(0);
                	  ImageView05.setImageResource(R.drawable.yelb);
                	  Toast.makeText(getApplicationContext(), "壞球",
  							Toast.LENGTH_SHORT).show();
                	 
                	  break;
                  case 0x18:
                	  com.example.baseball.msg.setcount(0);
                	  ImageView06.setImageResource(R.drawable.yelb);
                	  Toast.makeText(getApplicationContext(), "壞球",
  							Toast.LENGTH_SHORT).show();
                	  
                	  break;
                  case 0x19:
                	  ImageView02.setImageResource(R.drawable.nonred);
                	  ImageView01.setImageResource(R.drawable.nonred);
                	  ImageView03.setImageResource(R.drawable.nonred);
                	  imageView3.setImageResource(R.drawable.nonyelb);
                	  ImageView04.setImageResource(R.drawable.nonyelb);
                	  ImageView05.setImageResource(R.drawable.nonyelb);
                	  ImageView06.setImageResource(R.drawable.nonyelb);
                	  break;
                  case 0x1A:
                	 
                	 txt5.setText("2秒後投出");
                	 txt5.setVisibility(View.VISIBLE);
                	  com.example.baseball.msg.setcount(0);
                	  
                	
                	  break;
                  case 0x1B:
                 	 
                 	 txt5.setText("3振出局 下一打席");
                 	 txt5.setVisibility(View.VISIBLE);
                 	  com.example.baseball.msg.setcount(0);

                 	  break;	
                  case 0x1C:
                  	 
                  	 txt5.setText("保送上壘 下一打席");
                  	 txt5.setVisibility(View.VISIBLE);
                  	  com.example.baseball.msg.setcount(0);
                    	com.example.baseball.msg.walk++;
                  	  break;
                  case 0x1D:
                   	 
                   	 txt5.setText("揮棒太早 ");
                   	 txt5.setVisibility(View.VISIBLE);
                   	  com.example.baseball.msg.setcount(0);                                
                   	
               	 
                   	  break;	  
                  case 0x1E:
                    	 
                    txt5.setText("(揮棒過早)揮棒落空 好球 ");
                    txt5.setVisibility(View.VISIBLE);
                    com.example.baseball.msg.setcount(0);                                
                    	 
                	 
                    	  break;
                  case 0x1F:
                 	 
                 	 txt5.setText("(揮棒稍晚)軟弱滾地球 刺殺出局 ");
                 	 txt5.setVisibility(View.VISIBLE);
                 	  com.example.baseball.msg.setcount(0);                                
                 	 Intent intent =new Intent();
      				  intent.setClass(MainActivity.this, Result.class);
      				 Bundle bundle=new Bundle();
      				 bundle.putInt("case", 0x1F);
      				 intent.putExtras(bundle);
      				 startActivity(intent); 
             	 
                 	  break; 
                  case 0x20:
                  	 
                  	 txt5.setText("(打擊出去)安打 ");
                  	 txt5.setVisibility(View.VISIBLE);
                  	  com.example.baseball.msg.setcount(0);                                
                  	intent =new Intent();
    				intent.setClass(MainActivity.this, Result.class);
    				bundle=new Bundle();
    				bundle.putInt("case",0x20);
    				intent.putExtras(bundle);
    				startActivity(intent); 
    			   	com.example.baseball.msg.hit++;
                  	  break;
                  case 0x21:
                   	 
                   	 txt5.setText("(打擊出去)接殺 ");
                   	 txt5.setVisibility(View.VISIBLE);
                   	  com.example.baseball.msg.setcount(0);                                
                   	intent =new Intent();
    				intent.setClass(MainActivity.this, Result.class);
    				bundle=new Bundle();
    				bundle.putInt("case",0x21);
    				intent.putExtras(bundle);
    				startActivity(intent); 
               	 	
                   	  break;
                  case 0x22:
                    	 
                    	 txt5.setText("(打擊出去)界外 ");
                    	 txt5.setVisibility(View.VISIBLE);
                    	 com.example.baseball.msg.setcount(0);                                
                    	intent =new Intent();
         				intent.setClass(MainActivity.this, Result.class);
         				bundle=new Bundle();
         				bundle.putInt("case",0x22);
         				intent.putExtras(bundle);
         				startActivity(intent); 
                	 
                     break;
                  case 0xfe:   
                	 
                		  txt5.setVisibility(View.INVISIBLE);
                    	              	 
                	  break;
                  case 0xff:
                	  
             
                	   text1.setText(""+time);
                   break;
                     
             }   
             super.handleMessage(msg);   
        }   
   };  
   static boolean swing=true;
   boolean again=true;
 
   String msg2="";
  class myThread implements Runnable {   
       @Override
	public void run() {  
    	   
    	   String msgg="";
            while (!Thread.currentThread().isInterrupted()) {
            	Message message = new Message();
            	while(true){//按下開始紐
            		if(start==true)
            			 { 
            			   break;
            			 }
            	}
            	
            	
            	String x = "";
				
                msgg=p1.getrev();
            	if(msgg.indexOf("球投出")>=0 )
            	{
//            		Log.i("msg", "======="+time);
            		message.what=0x10;             
                    MainActivity.this.myHandler.sendMessage(message);                 
                   cx=1;
                   while(msgg.indexOf("球投出")>=0){//直到收到的不是球投出
                	   msgg=p1.getrev();
                   }
                   
//                   Log.i("msg", "======="+time);
            	}
            	
                 try {   
                      Thread.sleep(100);    
                 } catch (InterruptedException e) {   
                	 Log.i("msg", "mythread break");
                      Thread.currentThread().interrupt();   
                 } 
            	
            }   
       }   
  }   
  private double time=0;
  private TimerTask timerTask=new TimerTask() {
		
	  @Override
		public void run() {
				time=time+0.1;
				Message message = new Message();
	  			message.what=0xff;             
	  			MainActivity.this.myHandler.sendMessage(message);
				
			}
		
	};
	String temp="";
	msg msgx=new msg();
	  int c=0,d=0,e=0,f=0,g=0,h=0,i=0,co=1;
	  int cx=1;
	class myThread2 implements Runnable {   
	       @Override
		public void run() {  
	    	   
	    	  // Message message = new Message();
	    	   while(true){
	    		   //clithread.str.indexOf("1 好球")
	    		  
	    		  
	            	 if(msg.getcount()==8)//2S後
	            	  {	Message message = new Message();
	            		message.what=0x1A;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    new Thread(new myThread3()).start();
	                    //Log.i("msg", "======="+clithread.str);
	                    
	            	  } 
	            	 if(msg.getcount()==9&&co==1)//3振
	            	  {	Message message = new Message();
	            		message.what=0x1B;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    co++;
	                    //Log.i("msg", "======="+clithread.str);
	                    
	            	  } 
	            	 if(msg.getcount()==10&&co==1)//保送
	            	  {	Message message = new Message();
	            		message.what=0x1C;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    //Log.i("msg", "======="+clithread.str);
	                    co++;
	            	  } 
	            	 if(msg.getcount()==0X1D)//太早
	            	  {	Message message = new Message();
	            		message.what=0X1D;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    new Thread(new myThread3()).start();
	                    //Log.i("msg", "======="+clithread.str);
	                    
	            	  } 
	            	 if(msg.getcount()==0X1E&&co==1)//過早
	            	  {	Message message = new Message();
	            		message.what=0X1E;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    new Thread(new myThread3()).start();
	                    co++;
	            	  }
	            	 if(msg.getcount()==0X1F&&co==1)//稍晚
	            	  {	Message message = new Message();
	            		message.what=0X1F;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    new Thread(new myThread3()).start();
	                    co++;
	            	  }
	            	 if(msg.getcount()==0X20&&co==1)
	            	  {	Message message = new Message();
	            		message.what=0X20;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    co++;
	            	  }
	            	 if(msg.getcount()==0X21&&co==1)
	            	  {	Message message = new Message();
	            		message.what=0X21;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    co++;
	            	  }
	            	 if(msg.getcount()==0X22&&cx==1)
	            	  {	Message message = new Message();
	            		message.what=0X22;             
	                    MainActivity.this.myHandler.sendMessage(message);
	                    cx++;
	            	  }
	            	 
	    		   try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    	
	    	   }
	    	   
	       }   
	  }	
	class myThread3 implements Runnable { 
		@Override
		public void run(){
			try {
				Thread.sleep(1500);
				Message message = new Message();
        		message.what=0xfe;             
                MainActivity.this.myHandler.sendMessage(message);
                Thread.currentThread().interrupt();  
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	int c4=0,c5=0;
	class myThread4 implements Runnable { 
		@Override
		public void run(){
			
		while(true){
		  if(msg.getcount()==1)//好球
       	  {	Message message1 = new Message();
       		message1.what=0x12;             
               MainActivity.this.myHandler.sendMessage(message1);
               Log.i("msg", "=======1g");
       	  }   
       	 if(msg.getcount()==2)
       	  {	Message message2 = new Message();
       		message2.what=0x13;             
               MainActivity.this.myHandler.sendMessage(message2);
               Log.i("msg", "=======2g");
       	  }  
       	 if(msg.getcount()==3)
       	  {	Message message3 = new Message();
       		message3.what=0x14;             
               MainActivity.this.myHandler.sendMessage(message3);
               Log.i("msg", "=======3g");
       	  }  
           
	
		    
       	
       	try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}//while
		}
	}
	 class myThread5 implements Runnable {   
	       @Override
		public void run() {  
	    	   while(true){
	    		   if(msg.getcount()==4)//壞球
	    	       	  {	Message message4 = new Message();
	    	       		message4.what=0x15;             
	    	               MainActivity.this.myHandler.sendMessage(message4);
	    	               Log.i("msg", "=======1b");

	    	       	  }   
	    	       	 if(msg.getcount()==5)
	    	       	  {	Message message5 = new Message();
	    	       		message5.what=0x16;             
	    	               MainActivity.this.myHandler.sendMessage(message5);
	    	         

	    	       	  }  
	    	       	 if(msg.getcount()==6)
	    	       	  {	Message message6 = new Message();
	    	       		message6.what=0x17;             
	    	               MainActivity.this.myHandler.sendMessage(message6);
	    	               Log.i("msg", "=======3b");
	    	            
	    	       	  }  
	    	       	 if(msg.getcount()==7)
	    	       	  {	Message message7 = new Message();
	    	       		message7.what=0x18;             
	    	               MainActivity.this.myHandler.sendMessage(message7);
	    	      
	    	              
	    	       	  }
	    			try {
	    				Thread.sleep(10);
	    			} catch (InterruptedException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
	    	   }
	       }
	  }
	
	public  clithread getclith(){
		return cc;
	}
	int index=1;
	public Animation.AnimationListener listener=new AnimationListener() {
		
		@Override
		public void onAnimationStart(Animation arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationRepeat(Animation arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onAnimationEnd(Animation arg0) {
			// TODO Auto-generated method stub
			 
			  Animation am2 = AnimationUtils.loadAnimation(am, R.animator.anim);
			  am2.setDuration( 1000 );
			  imageView2.setAnimation(am2);
			  am2.startNow();
		}
	};
	protected void dialog() {
	 AlertDialog.Builder builder = new Builder(MainActivity.this);
	 builder.setMessage("規則:\n 按連線按鈕連線後，準備打擊 3秒後回開始投球 往上滑來揮棒打擊");
	 builder.setTitle("歡迎進入");
//	 builder.setPositiveButton("離開", new OnClickListener() {
//
//		 @Override
//  	public void onClick(DialogInterface dialog, int which) {
//	   dialog.dismiss();
//	   MainActivity.this.finish();
//		 }
//	 });
		
	 builder.setNegativeButton("確認", new OnClickListener() {
		 
		 @Override
	public void onClick(DialogInterface dialog, int which) {
			 dialog.dismiss();
		 }
	 });
	 builder.create().show();
	 }
	
	//裡面的upX upY downX downY 是float全域變數
	 private double downX=0;
	 private double downY=0;
	 private double upX=0;
	 private double upY=0;
	private String mDirection;
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	 
	        float X = event.getX(); // 觸控的 X 軸位置
	        float Y = event.getY(); // 觸控的 Y 軸位置
	 
	        switch (event.getAction()) { // 判斷觸控的動作
	 
	        case MotionEvent.ACTION_DOWN: // 按下
	            downX = event.getX();
	            downY = event.getY();
	 
	            return true;
	        case MotionEvent.ACTION_MOVE: // 拖曳
	 
	            return true;
	        case MotionEvent.ACTION_UP: // 放開
	            Log.d("onTouchEvent-ACTION_UP","UP");
	            upX = event.getX();
	            upY = event.getY();
	            double x=Math.abs(upX-downX);
	            double y=Math.abs(upY-downY);
	            double z=Math.sqrt(x*x+y*y);
	            int jiaodu=Math.round((float)(Math.asin(y/z)/Math.PI*180));//角度
	             
	            if (upY < downY && jiaodu>45) {//上
//	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:上");
//	                mDirection="up";
	                
	      		 
	                swing=true;
	                out.println("5");
	                out.flush();
	                Message message2 = new Message(); 
	                 if(swing==true)
	                 {message2.what = MainActivity.GUIUPDATEIDENTIFIER;
	                 swing=false;
	                 }
	                 else message2.what=0xff;
	                 MainActivity.this.myHandler.sendMessage(message2);   
	                Toast.makeText(MainActivity.this, "上", Toast.LENGTH_SHORT).show();
	                
	            }else if(upY > downY && jiaodu>45) {//下
	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:下");
	                mDirection="down";
	                  
	                Toast.makeText(MainActivity.this, "下", Toast.LENGTH_SHORT).show();
	            }else if(upX < downX && jiaodu<=45) {//左
	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:左");
	                // 原方向不是向右時，方向轉右
	                
	                /*if (mDirection != EAST) {
	                    mNextDirection = WEST;
	                }*/
	            }else if(upX > downX && jiaodu<=45) {//右
	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:右");
	                // 原方向不是向左時，方向轉右
	                /*if (mDirection ! = WEST) {
	                    mNextDirection = EAST;
	                }*/
	            }
	            return true;
	        }
	 
	        return super.onTouchEvent(event);
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
