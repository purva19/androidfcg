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
	Cursor d=null;
	Cursor g=null;
	protected SQLiteDatabase db;
	protected Cursor cursor;
	protected ListAdapter adapter;
	protected String parent_series_id;
	protected String parent_brand_id;
	
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
	    	///d=db.rawQuery("SELECT parent_series_id FROM series WHERE _id = +s_id ", null);
	    	
 			String series_id=Integer.toString(recieved_id);
	    	series_id= "'"+series_id+"'";
	    	String stable_name = "series" ;
	    	String w="SELECT parent_series_id FROM " + stable_name +" WHERE _id =" +s_id;
	    	System.out.println(w);
	    	d=db.rawQuery(w, null);
	    	
	    	System.out.println("Printing the Parent_series_id");
	    	System.out.println(d);
	    	if (d.moveToFirst())
		  	{
			do {
					String sid= d.getString(0);
				 parent_series_id= d.getString(0);
				
					System.out.println("parent_series_id: " + parent_series_id);
					
					
				//int id=Integer.parseInt( sid );
				//System.out.println("String: " + sid);
				//System.out.println("Integer: " + id);
				//String s1= d.getString(8);
	 			//System.out.println("parent_series_id: " + s1);
			  	
			} while (d.moveToNext());
		  }
			
	    	if (parent_series_id == series_id)
	    	{
	    		System.out.println("the display_panal_code");
	    		System.out.println(q);
	    	}	
	    		else
	    		{
	    			String p_id="'"+parent_series_id+"'";
	    			String z="SELECT brand_id FROM " + stable_name +" WHERE _id =" +p_id;
	    			System.out.println("PARENT SERIESIS ID QURESTRY TO SELEECT BRAND ");
	    			System.out.println(z);
	    			c = db.rawQuery(z,null);
	    			System.out.println("Printing the brand_id of the parent seried id");
	    			System.out.println(c);
	    			
	    			if (c.moveToFirst())
	    		  	{
	    			do {
	    					parent_brand_id= c.getString(0);
	    				
	    					System.out.println("Brand Id of parent Series is: " + parent_brand_id);
	    					
	    					
	    				//int id=Integer.parseInt( sid );
	    				//System.out.println("String: " + sid);
	    				//System.out.println("Integer: " + id);
	    				//String s1= d.getString(8);
	    	 			//System.out.println("parent_series_id: " + s1);
	    			  	
	    					} while (c.moveToNext());
	    		  	}////end of if (c.moveToFirst())
	    		
	    	}
	    	
	    	
	    	
	    	 //c=db.rawQuery("SELECT * FROM brand_24_errorcode  WHERE  series_id = '128' ", null);
	    	 //System.out.println(c);
	    	
	    	
		   	
	    	
	    		String b_id=Integer.toString(brand_id);
		    	
		    	parent_series_id="'"+parent_series_id+"'";
		    	String parent_table_name = "brand_" + b_id+ "_errorcode";
		    	String p="SELECT * FROM " +table_name +" WHERE series_id="+parent_series_id;
		    	System.out.println(p);	
		    	System.out.println("This is my brand query of parent series id");
				c = db.rawQuery(p,null);
				
				 	
			   //g=db.rawQuery("SELECT display_panel_code FROM brand_17_errorcode  WHERE  series_id = '95' ", null);
			   	 //System.out.println(g);
			   	 
				series_id="'"+series_id+"'";
		    	String parent_brand_id_table = "brand_" + parent_brand_id+ "_errorcode";
			   	 String t= "SELECT * FROM " +parent_brand_id_table +" WHERE series_id="+parent_series_id;
			   	System.out.println(t);	
		    	System.out.println("Here I am printing the display panel code ");
				 g = db.rawQuery(t,null);
			   	 
			   	if (g.moveToFirst())
			  	{
				do {
						//String sid= g.getString(0);
						String display_panel_code= g.getString(2);
					
						 System.out.println("display panel code: " + display_panel_code);
						
				  	
				} while (g.moveToNext());
			  }
			 
				
			adapter = new SimpleCursorAdapter(this, R.layout.list_view, g, new String [] {"display_panel_code"}, new int[] {R.id.name});
			setListAdapter(adapter);
			db.close();	
	    	System.out.println("Printing  the value of c " +c);
	    	
	    
	   
	
 }
}