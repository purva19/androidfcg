package com.faultcodeguide;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class SelectSeries extends ListActivity{
	Cursor c=null;
	
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setTitle("Please Select Your Series");
    	
    	db = (new DataBaseHelper(this)).getReadableDatabase();
		Intent intent = getIntent();
		
		int recieved_id=intent.getExtras().getInt("giri_id");
		
		System.out.println("I am in Select Series");
		System.out.println("Printing the recieved variable");
		System.out.println(recieved_id);
		
		int brand_id=recieved_id;
		
		String bid=Integer.toString(brand_id);
		
		
		bid="'"+bid+"'";
		String q="SELECT * FROM series WHERE brand_id="+bid;
		//String q="SELECT * FROM series WHERE brand_id=2";
		System.out.println("My Sql Quesry ios ");
		System.out.println(q);		
		c = db.rawQuery(q,null);
		//c=db.rawQuery("SELECT * FROM series WHERE brand_id ="+brand_id+" ORDER BY  `series`.`series_name` ASC ", null);
		
		
		
	  	if (c.moveToFirst())
	  	{
		do {
				String sid= c.getString(0);
				String series_name= c.getString(3);
			
				System.out.println("Seris name: " + series_name);
				
				
				int id=Integer.parseInt( sid );
//				System.out.println("String: " + sid);
//			  System.out.println("Integer: " + id);
//			  String s1= c.getString(1);
// 			 System.out.println("brand_id: " + s1);
//		  	System.out.println("I m in do while of series");
  			 
		} while (c.moveToNext());
    
	  	}
		adapter = new SimpleCursorAdapter(this, R.layout.list_view, c, new String [] {"series_name", "info"}, new int[] {R.id.name});
		setListAdapter(adapter);
		db.close();
		 ListView lv = getListView();

	       // listening to single list item on click
	       lv.setOnItemClickListener(new OnItemClickListener() {
	         public void onItemClick(AdapterView<?> parent, View view,
	             int position, long series_id) {
	        	        	
	        	 	System.out.println("i AM IN SelectSeries :");
	        	 	System.out.println("and series ID is");
	       	        System.out.println(series_id);
	       	        
	       	     Cursor cursor = (Cursor) adapter.getItem(position);
	       	        String string_brand_id= cursor.getString(1);
	       	        System.out.println("Brand id in SelectSeries and brand ID is ... \n"+string_brand_id);
	       	   
	       	        
	       	        
	       	        
	       	     Intent intent = new Intent(SelectSeries.this,SelectErrorcode.class);
	       	  //System.out.println(" printing the Errorcode ");
	         	adapter.getItem(position);
	         	
	         	int db_series_id=cursor.getInt(cursor.getColumnIndex("_id"));
	         	intent.putExtra("sending_series_id", db_series_id);
	         	int brand_id=Integer.parseInt(string_brand_id);
	         	intent.putExtra("sending_brand_id", brand_id);
	         	

	         	//String series_name=cursor.getString(cursor.getColumnIndex("series_name"));
	         	//intent.putExtra("sending_series_name", series_name);
	         	
	         	
	         	
	         	//intent.putExtra("giri_id", cursor.getInt(cursor.getColumnIndex("_id")));
	         	startActivity(intent);
	       			
	         }
	       });
	
	}
}	