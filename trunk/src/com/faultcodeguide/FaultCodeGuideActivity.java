package com.faultcodeguide;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FaultCodeGuideActivity extends Activity implements OnClickListener {
    private static final String TAG ="";
    int selecteddb;
    protected Cursor cursor;
	 String exp = "";
    
    /*
     * 1==full;
     * 0==demo;
     */
	/** Called when the activity is first created. */

	long purchaseTime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        ///WE WILL cpo 
        try { 
        	//System.out.println("I M CLICKED");
        	myDbHelper.createDataBase(); 
        	
        	//String formatter;
        	Date date;
			//date = (Date)formatter.parse(databaseDate);  
        	String exp=myDbHelper.getExpiryDate();
        	
        	System.out.println("EXPIRY DATE EID DATAVABE"+exp);

        	 
        	
        	Calendar currentDate = Calendar.getInstance();
        	SimpleDateFormat formatter=  new SimpleDateFormat("yyyy/MM/dd");
        	String dateNow = formatter.format(currentDate.getTime());
        	System.out.println("CURRENT DATE = "+dateNow);
        	
      int x = dateNow.compareTo(exp);
        	System.out.println("Pinting X = " +x);  
    		 
        	 
        }//end of try 
        catch (IOException ioe) {
        	throw new Error("Unable to create database");
        	}//end of catch	
        
        Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
    }
		 
		public void onClick(View arg0) {
			
			
			
			DataBaseHelper myDbHelper = new DataBaseHelper(this);
	        ///WE WILL cpo 
	        try { 
	        	//System.out.println("I M CLICKED");
	        	myDbHelper.createDataBase(); 
	        	
	        	//String formatter;
	        	Date date;
				//date = (Date)formatter.parse(databaseDate);  
	        	 exp=myDbHelper.getExpiryDate();
	        	
	        	System.out.println("EXPIRY DATE EID DATAVABE"+exp);

	        }//end of try 
	        catch (IOException ioe) {
	        	throw new Error("Unable to create database");
	        	}//end of catch	
	        
			// TODO Auto-generated method stub
			System.out.println("I am printing here");
			Calendar currentDate = Calendar.getInstance();
	    	SimpleDateFormat formatter=  new SimpleDateFormat("yyyy/MM/dd");
	    	String dateNow = formatter.format(currentDate.getTime());
	    	System.out.println("CURRENT DATE = "+dateNow);
	    	
	    	int x = dateNow.compareTo(exp);
	        	System.out.println("Pinting X = " +x);  
	    		 
	//  int x = dateNow.compareTo(databaseDate);
//	    	System.out.println("Pinting X = " +x);  
	   		
	    	if(exp.compareTo(dateNow)>=0){ 
	    		System.out.println("exp is after dateNow");
	    		System.out.println("DATABASE IS Not Expired");

	    		DataBaseHelper myDbHelper1 = new DataBaseHelper(this);
	            
	            ///WE WILL cpo  
	            try { 
	            	//System.out.println("I M CLICKED");
	            	myDbHelper1.createDataBase();
	            	 
	            	 
	            	//String formatter; 
//	            	Date date;
//	            	 String exp = "2012/02/01";
//	            	 System.out.println("Printing the Database date" +exp);        
	 	
	            }//end of try 
	            catch (IOException ioe) {
	            	throw new Error("Unable to create database");
	            	}//end of catch	
	        	try {
	        		selecteddb=1;
					myDbHelper1.openDataBase();

				} 
	        	catch (SQLException sqle) {

					throw sqle;

				} 
	    		 
	    	}else if(exp.compareTo(dateNow)<0){

	    		System.out.println("DATABASE HAS EXPIRED");
	    		
	    		System.out.println("exp is before dateNow");
	    		 LiteDataBaseHelper liteDatabaseHelper = new LiteDataBaseHelper(this);
	              
	             ///WE WILL cpo 
	             try { 
	            	 selecteddb=0;
	            	 liteDatabaseHelper.createDataBase();
	             	
	             	
	             	//String formatter; 
//	             	Date date;
//	             	 String exp = "2012/02/01";
//	             	 System.out.println("Printing the Database date" +exp);        
//	  	
	             }//end of try 
	             catch (IOException ioe) {
	             	throw new Error("Unable to create database");
	             	}//end of catch	
	         	try {

	         		liteDatabaseHelper.openDataBase();

	 			} catch (SQLException sqle) {
	 
	 				throw sqle; 

	 			} 
	     		
	    	}
	    	else{
	    		System.out.println("How to get here?");
	    	}
	    	 
			Intent selectBrandIntent = new Intent(this, SelectBrand.class);
			selectBrandIntent.putExtra("selecteddb",selecteddb);
			startActivityForResult(selectBrandIntent, 0); 
			System.out.println("printing brands names");
			
			 
		}

	}