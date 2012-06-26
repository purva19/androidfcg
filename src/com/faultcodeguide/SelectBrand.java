package com.faultcodeguide;
 


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SelectBrand extends ListActivity {
	Cursor c=null;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	
	   public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	setTitle("Please Select Your Brand");
	    	System.out.println("I am in the Main");
    	 
	    	Toast.makeText(SelectBrand.this, "Success", Toast.LENGTH_SHORT).show();
	    	
	    	
	    	
	    	
	    	db = (new DataBaseHelper(this)).getReadableDatabase();
	    	c=db.query("brand", null, null, null,null,null,null);
		  	
	    	if(c.moveToFirst())
            {
             
		  		do {
		  				String sid= c.getString(0);
		  				int id=Integer.parseInt( sid );
		  				System.out.println("String: " + sid);
		  			  System.out.println("Integer: " + id);
		  			  String s1= c.getString(1);
			  			 System.out.println("Brand Name: " + s1);

					  			  
                } while (c.moveToNext());
                
  
            }
	    	
	    	c = db.rawQuery("SELECT * FROM brand ORDER BY  `brand`.`brand_name` ASC", null);
			adapter = new SimpleCursorAdapter(this, R.layout.list_view, c, new String [] {"brand_name", "info"}, new int[] {R.id.name});
			setListAdapter(adapter);
			db.close();
			
			
			
			
			
//
//try 	
//	    	{
//	    		
//				db = (new DataBaseHelper(this)).getReadableDatabase();
//				c= db.rawQuery("SELECT * FROM brand BY  `brand`.`brand_name` ASC", null);
//				adapter = new SimpleCursorAdapter(this, R.layout.list_view, cursor, new String [] {"brand_name", "info"}, new int[] {R.id.name});
//				setListAdapter(adapter);
//				db.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	   

    
   
	   }  
    
}///end of class
        
        