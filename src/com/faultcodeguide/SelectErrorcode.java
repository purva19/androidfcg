package com.faultcodeguide;




import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SelectErrorcode extends ListActivity{
	Cursor c=null;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	
	int series_id;
	
	public void onCreate(Bundle savedInstanceState) {
	    	super.onCreate(savedInstanceState);
	    	db = (new DataBaseHelper(this)).getReadableDatabase();
	    	Intent intent = getIntent();
	    	int recieved_id=intent.getExtras().getInt("sending_series_id");
	    	System.out.println("printing the series_id in the SelectErrorcode");
	    	System.out.println(recieved_id);
	    	
	    	int brand_id=intent.getExtras().getInt("sending_brand_id");
	    	//String recived_series_name=intent.getExtras().getString("sending_series_name");
	    	
	    	
	    	
	    	//System.out.println("Recvieved series name");
	    	//System.out.println(recived_series_name);
	    	
	    	
	    	System.out.println("printing the brand_id in the SelectErrorcode");
	    	System.out.println(brand_id);
	    	
	    	//int brand_id=intent.getExtras().getInt("brand_id");
			//int series_id=intent.getExtras().getInt("series_id");
			Toast.makeText(this, "DATA ENTERED", Toast.LENGTH_LONG).show();
			System.out.println("I am in Selecy Errorcode");
			//String giri_id = getIntent().getStringExtra("brand_id");
			//Toast.makeText(this, giri_id+"brand_id IS   :"+giri_id , Toast.LENGTH_LONG).show();
	    	//System.out.println("BRAND ID in selectErrorcode "+giri_id);
	    	//System.out.println("Series ID in selectErrorcode "+series_id);
	    	 
	    	setTitle("List of Possible error Codes");
	    	
//	    	c=db.rawQuery("SELECT * FROM brand_2_errorcode WHERE series_id = '7' ", null);
	    	
	    	String bid=Integer.toString(brand_id);
	    	String s_id=Integer.toString(recieved_id);

	    	s_id="'"+s_id+"'";
	    	String table_name = "brand_" + bid+ "_errorcode";
	    	String q="SELECT * FROM " +table_name +" WHERE series_id="+s_id;
	    	System.out.println(q);		
			c = db.rawQuery(q,null);
	    	///c=db.rawQuery("SELECT * FROM brand_2_errorcode WHERE series_id = '7' ", null);
	    	
			adapter = new SimpleCursorAdapter(this, R.layout.list_view, c, new String [] {"display_panel_code"}, new int[] {R.id.name});
			setListAdapter(adapter);
			db.close();	
	    	System.out.println("Printing the value of c " +c);
	    	
	    	if (c.moveToFirst())
		  	{
			do {
					String sid= c.getString(0);
					String display_panel_code= c.getString(2);
				
					System.out.println("display panel code: " + display_panel_code);
					
					
				int id=Integer.parseInt( sid );
				System.out.println("String: " + sid);
				System.out.println("Integer: " + id);
				String s1= c.getString(4);
	 			//System.out.println("display_panel_code: " + s1);
			  	
			} while (c.moveToNext());
		  }
	   }
	

}
