package com.faultcodeguide;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SelectErrorcode extends ListActivity{
 
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected Cursor parentCursor;
	protected ListAdapter adapter1;
	protected ListAdapter adapter;
	protected String parent_series_id;
	
	protected String error_code_brand_id;
	protected ArrayList<String []> arrayListErrorCodesInfo = new ArrayList<String[]>(); 
 	protected List<String> errorcode_list = new ArrayList<String>();
 	protected String [] data =new String [7];
 	
	int series_id;
	
	public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	db = (new DataBaseHelper(this)).getReadableDatabase();
	    	Intent intent = getIntent();
	    	int series_id_int=intent.getExtras().getInt("sending_series_id");
	    	int brand_id_int=intent.getExtras().getInt("sending_brand_id");

	    	System.out.println("**************** ");
	    	
	    	String brand_id_string=Integer.toString(brand_id_int);
	    	String series_id_string=Integer.toString(series_id_int);
	    	
	    	buildErrorCodetable (series_id_string , brand_id_string );

	    	System.out.println("Array List Size ");
	    	System.out.println(arrayListErrorCodesInfo.size());
		    	
	    	///*INITIALIZATION
	    	int loopParentSeriesId=getParentSeriesId(series_id_string);
	    	int loopSeriesId=series_id_int;
	    	
	    	///PROCESS
	    	while (loopParentSeriesId!=loopSeriesId)
	    	{
	    		String parent_brand_id_string = null;
	    		String loopParentSeriesIdString = Integer.toString(loopParentSeriesId);;
	    		///getting BRAND OF PARENT SERIES
	    		String select_parent_brand="SELECT brand_id FROM series WHERE _id ='" +loopParentSeriesIdString+"'";
		    	System.out.println(select_parent_brand);
		    	Cursor parent_brand_cursor=db.rawQuery(select_parent_brand, null); 
		    	if (parent_brand_cursor.moveToFirst())
			  	{
				do {
						 
					parent_brand_id_string= parent_brand_cursor.getString(0);
					System.out.println("Parent Brand ID: " + parent_brand_id_string);
					
					} while (parent_brand_cursor.moveToNext());
			  	}
	    		
		    	buildErrorCodetable (loopParentSeriesIdString,parent_brand_id_string );
		    	
		    	
		    	 loopSeriesId=loopParentSeriesId;
		    	 loopParentSeriesId=getParentSeriesId(loopParentSeriesIdString);
		    	
	    		 
	    		
	    	}
	    	
	    	
	    	/*
	    	int parent_series_id_int=Integer.parseInt( parent_series_id );
	    		
	    	if (parent_series_id_int!=series_id_int)
	    	{
	    		
	    		
	    		
	    	}*/
	    	
	    	
	    	/* DEACTIVATED FOR TIME BEING
	    		
	    	String select_parent_brand="SELECT brand_id FROM series WHERE _id ='" +parent_series_id+"'";
	    	System.out.println(select_parent_brand);
	    	cursor=db.rawQuery(select_parent_brand, null); 
	    	if (cursor.moveToFirst())
		  	{
			do {
					 
					parent_brand_id= cursor.getString(0);
					System.out.println("Parent Brand ID: " + parent_brand_id);
				} while (cursor.moveToNext());
		  	}
	    	
	    			
	    	/////SELECTING THE PARENt ERROR CODES
	    	String parent_table_name="brand_" + parent_brand_id+ "_errorcode";
	    	String select_parent_errorCodes="SELECT _id, series_id, display_panel_code, summary  FROM "+parent_table_name+" WHERE series_id ='" +parent_series_id+"'";
	    	System.out.println(select_parent_errorCodes);
	    	parentCursor=db.rawQuery(select_parent_errorCodes, null); 
	    	if (parentCursor.moveToFirst())
		  	{
			do {
					 
					String ecode= parentCursor.getString(2);
					System.out.println("Error Code " + ecode);
				} while (parentCursor.moveToNext());
		  	}

	    	adapter = new SimpleCursorAdapter(this, R.layout.list_view, cursor, new String [] {"display_panel_code"}, new int[] {R.id.name});
			setListAdapter(adapter);

	    	ListView lv = getListView();
	    	*/

	    	
	    	/*TESTING CODDE START*/
 
		
	   
			
			
			
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					R.layout.list_view, errorcode_list);
	
	    		
	    	//adapter1 = new SimpleCursorAdapter(this, R.layout.list_view, cursor, new String [] {"display_panel_code"}, new int[] {R.id.name});
			setListAdapter(adapter);

	    	ListView lv = getListView();

	        // listening to single list item on click
	        lv.setOnItemClickListener(new OnItemClickListener() {
	          public void onItemClick(AdapterView<?> parent, View view,
	              int position, long error_code_id) {
	         	        	
	        	  
	        	  System.out.println("I M CLCIKED AT POSITION");
	        	  System.out.println(error_code_id);
	
	        	  
	          	String fullData [][]=new String [arrayListErrorCodesInfo.size()][7];
		    	fullData=arrayListErrorCodesInfo.toArray(fullData);
		    	
		    	/*	
		    	for (int i=0;i<arrayListErrorCodesInfo.size();i++)
		    	{
		    		System.out.println("%%%%%%%%%%%%%%%%%%%%%%% ");
			    	System.out.println("IN THE LPOOOP Data ");
			    	System.out.println(fullData[i][0]);
			    	System.out.println(fullData[i][1]);
			    	System.out.println(fullData[i][2]);
			    	System.out.println(fullData[i][3]);
			    	System.out.println(fullData[i][4]);
			    	System.out.println(fullData[i][5]);
			    	System.out.println(fullData[i][6]);
		    		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		    	}*/
		    	
		    	/* for a while
		    		System.out.println("++++++++++++++++++++++++++++++ ");
			    	System.out.println("Clicked Data ");
			    	System.out.println(fullData[position][0]);
			    	System.out.println(fullData[position][1]);
			    	System.out.println(fullData[position][2]);
			    	System.out.println(fullData[position][3]);
			    	System.out.println(fullData[position][4]);
			    	System.out.println(fullData[position][5]);
			    	System.out.println(fullData[position][6]);
		    		System.out.println("++++++++++++++++++++++++++++++ ");
		    	*/

	        	  
	        	   
		    			System.out.println(" error_code_id is  :");
	        	        System.out.println(error_code_id);
	        	        
	        	        Intent intent = new Intent(SelectErrorcode.this,DisplayErrorCode.class);           	    
	                 	
	                 	String ecode_brand_id=fullData[position][6];
	                 	String ecode_id=fullData[position][1];
	                 	
	                 	intent.putExtra("errorcode_brand_id",ecode_brand_id );
	                 	intent.putExtra("error_code_id", ecode_id);

	                 	startActivity(intent);
	        	    
	          }
	        });
	   
	
 }
	
	
	public 	int getParentSeriesId (String series_id)
	{
		String select_parent_series="SELECT parent_series_id FROM series WHERE _id ='" +series_id+"'";
    	System.out.println(select_parent_series);
    	cursor=db.rawQuery(select_parent_series, null);
    	if (cursor.moveToFirst())
	  	{
			do {
					 
					parent_series_id= cursor.getString(0);
					System.out.println("parent_series_id: " + parent_series_id);
			} while (cursor.moveToNext());
	  	}
		
    	int parentSeriesIdint=Integer.parseInt(parent_series_id);
    	
    	return parentSeriesIdint;
		
	}///end of function getParentSeriesId (String series_id)
	
	
	public void buildErrorCodetable (String series_id_string , String brand_id_string )
	{
		 
    	
    	String table_name="brand_" + brand_id_string+ "_errorcode";
    	String select_errorcodes="SELECT _id, series_id, display_panel_code, led_code, summary  FROM " +table_name +" WHERE series_id='"+series_id_string+"'";;
    	//System.out.println(select_errorcodes);
		Cursor c = db.rawQuery(select_errorcodes,null);
		int row= 0;
    	if (c.moveToFirst())
		  	{
			do {
				
				String error_code=c.getString(2);
				System.out.println(" ERROR CODES ARE "+error_code);	
				 errorcode_list.add(error_code);

				String errorcode_id=c.getString(0);
				String series_id=c.getString(1);
				String display_panel_code=c.getString(2);
				String led_code=c.getString(3);
				String summary=c.getString(4);
				
				
				//FILLING THE DATA ARRAY
				data[0]=Integer.toString(row);  //This is position
				data[1]=errorcode_id;///this is errorcode id
				data[2]=series_id;//This is series id
				data[3]=display_panel_code;/// Th is is display panel Code
				data[4]=led_code;/// Th is is display panel Code
				data[5]=summary;
				data[6]=brand_id_string;
				arrayListErrorCodesInfo.add(new String []{data[0],data[1],data[2],data[3],data[4],data[5],data[6]});
				row++;
			} while (c.moveToNext());
			
		  }////ennd of c.mocve to first
    		
	}//end of function public void buildErrorCodetable (String series_id_string , String brand_id_string )



}///end of class

