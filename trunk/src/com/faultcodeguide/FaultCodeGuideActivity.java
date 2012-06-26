package com.faultcodeguide;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FaultCodeGuideActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        DataBaseHelper myDbHelper = new DataBaseHelper(this);
        ///WE WILL cpo
        try {
        	//System.out.println("I M CLICKED");
        	myDbHelper.createDataBase();
        }//end of try 
        catch (IOException ioe) {
        	throw new Error("Unable to create database");
        	}//end of catch	
        
        Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		System.out.println("I am printing here");
		
		Intent selectBrandIntent = new Intent(this, SelectBrand.class);
		startActivityForResult(selectBrandIntent, 0);
		
		System.out.println("printing brands names");
		
	 
		
		
		
		
	}
	
}