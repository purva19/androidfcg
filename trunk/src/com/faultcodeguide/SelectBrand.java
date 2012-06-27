package com.faultcodeguide;
 



import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
			
	   	
			
			
			
	   ListView lv = getListView();

       // listening to single list item on click
       lv.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view,
             int position, long id) {
        	        	
        	 	System.out.println("id  :");
       	        System.out.println(id);
       	           
       	     String product = ((TextView) view).getText().toString();  
       	 
    	
       	       
       	        Cursor cursor = (Cursor) adapter.getItem(position);
       	        String brand_name= cursor.getString(1);
       	        System.out.println("Brand name"+brand_name);
       	        
       	        
       	     Cursor c = (Cursor) adapter.getItem(position);   
       	     int brand_id= c.getInt(c.getColumnIndex("_id"));
         	System.out.printf("Brand id is %d",brand_id);
       	        
       	        /*
       	     	String brand_name= cursor.getString(1);
       	     	System.out.printf("Brand id is name"+brand_name);
       	     */
       	     	
         	Intent intent = new Intent();
        	System.out.println(" printing the series ");
    	   	adapter.getItem(position);
    	   	intent.putExtra("brand_id", cursor.getInt(cursor.getColumnIndex("_id")));
    	   	System.out.println(" printing the id ");
    	   	startActivity(intent);
         }
       });
	   }  
    
}///end of class
        
        