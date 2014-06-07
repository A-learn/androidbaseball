package com.example.baseball;

import com.example.baseball.R.animator;

import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends Activity {
	private ImageView imageView1;
	private TextView txt1;
	Context context1;
	int x=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		context1=this;
		 imageView1= (ImageView)findViewById(R.id.imageView1);
		 txt1=(TextView)findViewById(R.id.textView1);
		 //txt1.setVisibility(View.INVISIBLE);
		 Bundle bundle=this.getIntent().getExtras();
			int ca =bundle.getInt("case");
			
			txt1.setText("1");
			Animation am = AnimationUtils.loadAnimation(this, R.animator.catchout);
			imageView1.setAnimation(am);	
			am.startNow();
  		
  		  	/*
			switch(ca)
			{
			case 0x1F:   //軟弱滾地球 刺殺出局
//				txt1.setText("1");
//				Animation am = new TranslateAnimation(0,80,0,170);
//      			am.setDuration( 5000 );
//      			am.setRepeatCount( 0 ); 
//      			imageView1.setAnimation(am);
//      			am.startNow();
      			
      			
//				Animation am = AnimationUtils.loadAnimation(this, R.animator.catchout);
//				imageView1.setAnimation(am);	
//				am.startNow();
//				am.setAnimationListener(listener1);
//				x=0x1f;
//      		  	imageView1.setAnimation(am);
//       		  
//				AnimatorSet bouncer = new AnimatorSet();
//				AnimationSet bouncer2=new AnimationSet(false );
//				bouncer2.addAnimation( am );
//				bouncer2.addAnimation( am2 );
//				imageView1.setAnimation(bouncer2);
//				bouncer2.startNow();
//				bouncer.play(R.animator.catchout).before(R.animator.catchout2);
//				bouncer.play(R.animator.catchout2).after(R.animator.catchout);
//				animatorSet.start();
				break;
			case 0x20:   //安打
				txt1.setText("1");
//				Animation am3 = AnimationUtils.loadAnimation(this, R.animator.hit);
//				imageView1.setAnimation(am3);
//				am3.setAnimationListener(listener1);
//				am3.startNow();
//				x=0x20;
				txt1.setText("1");
				Animation am2 = new TranslateAnimation(0,80,0,170);
      			am2.setDuration( 5000 );
      			am2.setRepeatCount( 0 ); 
      			imageView1.setAnimation(am2);
      			am2.startNow();
				break;
			case 0x21:   //(打擊出去)接殺
				txt1.setText("1");
//				Animation am4 = AnimationUtils.loadAnimation(this, R.animator.catchout);
//				imageView1.setAnimation(am4);
//				am4.setAnimationListener(listener1);
//				am4.startNow();
//				x=0x1f;
				txt1.setText("1");
				Animation am3 = new TranslateAnimation(0,80,0,170);
      			am3.setDuration( 5000 );
      			am3.setRepeatCount( 0 ); 
      			imageView1.setAnimation(am3);
      			am3.startNow();
				break;
			case 0x22:   //(打擊出去)界外
				txt1.setText("1");
//				Animation am5 = AnimationUtils.loadAnimation(this, R.animator.catchout);
//				imageView1.setAnimation(am5);
//				am5.setAnimationListener(listener1);
//				am5.startNow();
//				x=0x1f;
				txt1.setText("1");
				Animation am5 = new TranslateAnimation(0,80,0,170);
      			am5.setDuration( 5000 );
      			am5.setRepeatCount( 0 ); 
      			imageView1.setAnimation(am5);
      			am5.startNow();
				break;
			}
			*/
		

		
	}
public Animation.AnimationListener listener1=new AnimationListener() {
		
		
		@Override
		public void onAnimationEnd(Animation arg0) {
			// TODO Auto-generated method stub
			 if(x==0x1f){
				 txt1.setText("1");
			Animation am2 = AnimationUtils.loadAnimation(context1, R.animator.catchout2);
			imageView1.setAnimation(am2);
			am2.startNow();
			}
			 if(x==0x20){
				 txt1.setText("1");
					Animation am2 = AnimationUtils.loadAnimation(context1, R.animator.hit2);
					imageView1.setAnimation(am2);
					am2.startNow();
			}
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
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
		return true;
	}

}
