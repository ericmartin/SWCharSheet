package com.app.swcharsheet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class LoadCharSheet extends ListActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);

	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, CHARSHEETS));

	  ListView lv = getListView();
	  lv.setTextFilterEnabled(true);

	  lv.setOnItemClickListener(new OnItemClickListener() {
	    public void onItemClick(AdapterView<?> parent, View view,
	        int position, long id) {
	    	loadCharDB(position);
	    	Intent intent = new Intent(getApplicationContext(), DispCharSheet.class);
        	startActivity(intent);
	    }
	  });
	}
	
	private void loadCharDB(int which){
		
	}
	
	final String[] CHARSHEETS = getCharNames();
	
	private String[] getCharNames(){
		String[] names = new String[] {"Jaksor Sa\'lya","Zohan","Kor Varik","Lurssk"};
		return names;
	}
}