package com.faultcodeguide;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayErrorCode extends Activity{
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected Cursor c;

	String led_code;
	 int brand_id;
	 
	AnimationDrawable [] lightsAnimation=new AnimationDrawable [9];
	 //ImageView [] light = (ImageView) findViewById(R.id.test_image1);
	ImageView [] light = new ImageView [9];
	  
	 

	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	 setContentView(R.layout.error_code);
    	 setTitle("Possible Error Codes");
    	
    	 light[0]=(ImageView) findViewById(R.id.test_image1);
    	 light[1]=(ImageView) findViewById(R.id.test_image2);
    	 light[2]=(ImageView) findViewById(R.id.test_image3);
    	 light[3]=(ImageView) findViewById(R.id.test_image4);
    	 light[4]=(ImageView) findViewById(R.id.test_image5);
    	 light[5]=(ImageView) findViewById(R.id.test_image6);
    	 light[6]=(ImageView) findViewById(R.id.test_image7);
    	 light[7]=(ImageView) findViewById(R.id.test_image8);
    	 light[8]=(ImageView) findViewById(R.id.test_image9);
    	 
 	 
    	 TextView t= (TextView) findViewById(R.id.textView00);
    	 t.setText("Error code: ");
    	 
         TextView t1= (TextView) findViewById(R.id.textView01);
    	 t1.setText("E31");
    	 
    	 TextView t2= (TextView) findViewById(R.id.textView02);
    	 t2.setText("Summary: ");
    	 
    	 TextView t3= (TextView) findViewById(R.id.textView03);
    	 t3.setText("Door not closed Door not closed Door not closed Door not closed Door not closed Door not closed Door not closed Door not closed Door not closed Door not closed Door not closed ");
    	 
    	 TextView t4= (TextView) findViewById(R.id.textView04);
    	 t4.setText("Description: ");
    	 
    	 TextView t5= (TextView) findViewById(R.id.textView05);
    	 t5.setText(" The System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the error.");
    	 
    	 TextView t6= (TextView) findViewById(R.id.textView06);
    	 t6.setText("Possible cause: ");
    	 
    	 TextView t7= (TextView) findViewById(R.id.textView07);
    	 t7.setText("The System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. ");
    	
    	 TextView t8= (TextView) findViewById(R.id.textView08);
    	 t8.setText("Possible solution: ");
    	 
    	 TextView t9= (TextView) findViewById(R.id.textView09);
    	 t9.setText("The System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. ");
    	 
    	 TextView t10= (TextView) findViewById(R.id.textView10);
    	 t10.setText("Remarks: ");
    	 
    	 TextView t11= (TextView) findViewById(R.id.textView11);
    	 t11.setText("The System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. Sometimes the code is returned by a function deep in the stack and far removed from your code that is handling the errorThe System Error Codes are very broad. Each one can occur in one of many hundreds of locations in the system. Consequently the descriptions of these codes cannot be very specific. Use of these codes requires some amount of investigation and analysis. You need to note both the programmatic and the run-time context in which these errors occur. Because these codes are defined in WinError.h for anyone to use, sometimes the codes are returned by non-system software. ");
    	 
    	db = (new DataBaseHelper(this)).getReadableDatabase();
		Intent intent = getIntent();
		System.out.println("**********************************************");
		
		String brand_id_string=intent.getExtras().getString("errorcode_brand_id");
		String error_code_id_string=intent.getExtras().getString("error_code_id");

		int error_code_id_int=Integer.parseInt(error_code_id_string);
		
		System.out.println("Printing the brand_id_string :"+brand_id_string);
		
		System.out.println("I am in DisplayErrorCode");
 
		
		System.out.println("Printing the error_code_id");
		System.out.println(error_code_id_int);
		System.out.println("**********************************************");
		
		
   	 
		String table_name="brand_" + brand_id_string+ "_errorcode";
		String select_errorcodes="SELECT  display_panel_code,number_of_leds,led_code,summary,description,possible_cause,possible_solution,remarks  FROM " +table_name +" WHERE _id='"+error_code_id_string+"'";
		cursor = db.rawQuery(select_errorcodes,null);
		
		
		 
	  	if (cursor.moveToFirst())
	  	{
		do {
			String dispaly_panel_code= cursor.getString(0);
			String number_of_leds= cursor.getString(1);
			led_code= cursor.getString(2);
			String summary= cursor.getString(3);
			String description= cursor.getString(4);
			String possible_cause= cursor.getString(5);
			String possible_solution= cursor.getString(6);
			String remarks= cursor.getString(7);
			
			
				System.out.println("dispaly_panel_code are : " + dispaly_panel_code);
				System.out.println("number_of_leds are :" + number_of_leds);
				System.out.println("led_code are : " + led_code);
				System.out.println("summary are : " + summary);
				System.out.println("description are : " + description);
				System.out.println("possible_cause are : " + possible_cause);
				System.out.println("possible_solution are : " + possible_solution);
				System.out.println("remarks are :" +remarks);
				
				
			 t1.setText(dispaly_panel_code);
			 System.out.println(t1);	
			  	
			 t3.setText(summary);
			 System.out.println(t3);	
			  	
			 t5.setText(description);
			 System.out.println(t5);	
			 
			 t7.setText(possible_cause);
			 System.out.println(t7);
			 
			 t9.setText(possible_solution);
			 System.out.println(t9);
			 
			 t11.setText(remarks);
			 System.out.println(t11);
			
		 }while (cursor.moveToNext());
 
	  	}
	  	System.out.println("!!!!!!!!!!!!!!!!");
	  	
	  	
    	//led_code="321333333";
   	 

		 System.out.println("LED Code");
		 System.out.println(led_code);
  		Character  led_char_code;
  		
    	 int led_int_code;
    	 for (int i=0;i<led_code.length();i++)
    	 {
	
    		 
    		 led_char_code=led_code.charAt(i);
//    		 System.out.println("Charecter Value");
//    		 System.out.println(led_char_code);
//    		  
    		 led_int_code=Integer.parseInt(led_char_code.toString());
//    		 System.out.println("Integer Value");
//    		 System.out.println(led_int_code);
//    		 
    		 
    		 switch (led_int_code) {
             case 1:  ////OFF led 
            	 	
            	 //light[i].setBackgroundResource(R.drawable.nolit2x);
            	 light[i].setImageResource(R.drawable.nolight);
                    break;
             case 2: /////ON led 
            	 light[i].setImageResource(R.drawable.light);
            	 	break;
 
            	 	
             case 3:  //// Bliunkonh led
            	 	light[i].setImageResource(R.drawable.blinkinglight);
            	 	break;
              
             
             default: /// wronf value
            	 		break;
             }///end of switch statehmeyt
    		 
    		 
	       	 
	         // lightsAnimation1=(AnimationDrawable) light1.getDrawable();    
	    		 
    		 
    		 
			 light[i].setVisibility(View.VISIBLE);
			 lightsAnimation[i]=(AnimationDrawable) light[i].getDrawable(); 
    		 
    		 System.out.println("**********************************");
    		 
			}///end of for loop i to read the led code
    	 
	  	
  		 

	  	
	  	}///end of onCreate
	
		public void onWindowFocusChanged(boolean hasFocus) {
			super.onWindowFocusChanged(hasFocus);	
	    
			for (int i=0;i<led_code.length();i++)
			{
				lightsAnimation[i].start();
	    	
				}////end of for
	    
      	}///////	public void onWindowFocusChanged(boolean hasFocus) {


	     
        	
	
	
}///////end of class