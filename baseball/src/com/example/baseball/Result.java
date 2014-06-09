package com.example.baseball;

import com.example.baseball.MainActivity.myThread;
import com.example.baseball.R.animator;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends Activity {
	private ImageView imageView1;
	private TextView txt1,txt2;
	Context context1;
	int x=0;
	int ca=0,co=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		context1=this;
		 imageView1= (ImageView)findViewById(R.id.imageView1);
		 txt2=(TextView)findViewById(R.id.textView2);
		 txt1=(TextView)findViewById(R.id.textView1);
		 txt1.setVisibility(View.INVISIBLE);
		 txt2.setVisibility(View.INVISIBLE);
		 Bundle bundle=this.getIntent().getExtras();
		 ca =bundle.getInt("case");
		
			
	
			new Thread(new myThread()).start();

		
	}
	
	class myThread implements Runnable {   
	       @Override
		public void run() {  
	    	   Message message = new Message();
	    	   co++;
	    	   if(co>1){
	    		   ca=0xff;
					Thread.currentThread().interrupt(); 
	    	   }
				switch(ca)
				{
				case 0x1F:   //軟弱滾地球 刺殺出局
					
		  			message.what=0x1f;             
		  			Result.this.myHandler.sendMessage(message);
	      						
					break;
				case 0x20:   //安打
				
		  			message.what=0x20;             
		  			Result.this.myHandler.sendMessage(message);
		  		
					break;
				case 0x21:   //(打擊出去)接殺
			
		  			message.what=0x21;             
		  			Result.this.myHandler.sendMessage(message);
		  			
					break;
				case 0x22:   //(打擊出去)界外
				
		  			message.what=0x22;             
		  			Result.this.myHandler.sendMessage(message);
		  			
					break;
				case 0xff:
					message.what=0xff;      
				}
				ca=0xff;
				 Thread.currentThread().interrupt(); 
				
	       }
	 }
public Animation.AnimationListener listener1=new AnimationListener() {
		
		
		@Override
		public void onAnimationEnd(Animation arg0) {
			// TODO Auto-generated method stub
			 if(x==0x1f){
				 txt2.setText("軟弱滾地球 刺殺出局");
				 txt2.setVisibility(View.VISIBLE);
			
			ca=0xff;
			}
			 if(x==0x20){
				 txt2.setText("(打擊出去)安打");
				 txt2.setVisibility(View.VISIBLE);
					Animation am2 = AnimationUtils.loadAnimation(context1, R.animator.hit2);
					imageView1.setAnimation(am2);
					am2.startNow();
					ca=0xff;
			}
			 if(x==0x21){
				 txt2.setText("(打擊出去)接殺");
				 txt2.setVisibility(View.VISIBLE);
					Animation am2 = AnimationUtils.loadAnimation(context1, R.animator.catchout2);
					imageView1.setAnimation(am2);
					am2.startNow();
					ca=0xff;
			}
			 if(x==0x22){
				 txt2.setText("(打擊出去)界外");
				 txt2.setVisibility(View.VISIBLE);
				 Result.this.finish();
			}
			 ca=0xff;
			 x=0xff;
			
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			
		}

		
	};
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
	            double xa=Math.abs(upX-downX);
	            double y=Math.abs(upY-downY);
	            double z=Math.sqrt(xa*xa+y*y);
	            int jiaodu=Math.round((float)(Math.asin(y/z)/Math.PI*180));//角度
	             
	            if (upY < downY && jiaodu>45) {//上
//	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:上");
//	                mDirection="up";
	                
	      		 
	                
	                
	            }else if(upY > downY && jiaodu>45) {//下
	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:下");
	                mDirection="down";
	                Message message = new Message();
		  			message.what=0x01;             
		  			this.myHandler.sendMessage(message);
		  			
	                
			
	             
	            }else if(upX < downX && jiaodu<=45) {//左
	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:左");
	                // 原方向不是向右時，方向轉右
	                
	                /*if (mDirection != EAST) {
	                    mNextDirection = WEST;
	                }*/
	            }else if(upX > downX && jiaodu<=45) {//右
	                Log.d("onTouchEvent-ACTION_UP","角度:"+jiaodu+", 動作:右");
	                // 原方向不是向左時，方向轉右
	                Result.this.finish();
	                
	                /*if (mDirection ! = WEST) {
	                    mNextDirection = EAST;
	                }*/
	            }
	            return true;
	        }
	 
	        return super.onTouchEvent(event);
	    }
	Handler myHandler = new Handler() {  
        @Override
		public void handleMessage(Message msg) {   
             switch (msg.what) {   
                  case 0x01:
           
                	  txt1.setText("1");
  					Animation am5 = AnimationUtils.loadAnimation(context1, R.animator.out);
  					imageView1.setAnimation(am5);
  					am5.setAnimationListener(listener1);
  					x=22;
  					am5.startNow();
                  case 0x1f:   //軟弱滾地球 刺殺出局
      				txt1.setText("1");
      				Animation am = AnimationUtils.loadAnimation(context1, R.animator.roll);
      				imageView1.setAnimation(am);
      				am.startNow();
      				am.setAnimationListener(listener1);
      				x=0x1f;
            			

      				break;
      			case 0x20:   //安打
      				txt1.setText("1");
      				Animation am3 = AnimationUtils.loadAnimation(context1, R.animator.hit);
      				imageView1.setAnimation(am3);
      				am3.setAnimationListener(listener1);
      				am3.startNow();
      				x=0x20;
      		
      				break;
      			case 0x21:   //(打擊出去)接殺
      				txt1.setText("1");
      				Animation am4 = AnimationUtils.loadAnimation(context1, R.animator.catchout);
      				imageView1.setAnimation(am4);
      				am4.setAnimationListener(listener1);
      				am4.startNow();
      				x=0x21;
      				
      				break;
      			case 0x22:   //(打擊出去)界外
      				txt1.setText("1");
      				Animation am6 = AnimationUtils.loadAnimation(context1, R.animator.out);
      				imageView1.setAnimation(am6);
      				am6.setAnimationListener(listener1);
      				am6.startNow();
      				x=0x22;
      				break;  
  					
  					
                	  }
             super.handleMessage(msg);   
        }   
   };  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
//AnimatorSet bouncer = new AnimatorSet();
//AnimationSet bouncer2=new AnimationSet(false );
//bouncer2.addAnimation( am );
//bouncer2.addAnimation( am2 );
//imageView1.setAnimation(bouncer2);
//bouncer2.startNow();
//Animator  animator=new 
//bouncer.play(R.animator.hit);
//bouncer.play(R.animator.catchout2).after(R.animator.catchout);
//animatorSet.start();
	