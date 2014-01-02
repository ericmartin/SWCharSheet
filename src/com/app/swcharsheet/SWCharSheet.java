package com.app.swcharsheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Mike Rushford
 * @author Eric Martin
 * @version 20100809
 */
public class SWCharSheet extends Activity {
	public static DBManager managedDatabase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        managedDatabase = new DBManager(this);
        managedDatabase.open();
        
        final Button newCharButton = (Button) findViewById(R.id.newCharButton);
        newCharButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
            	Intent intent = new Intent(getApplicationContext(), Biocreation.class);
            	startActivity(intent);
            }
        });
        
        final Button loadCharButton = (Button) findViewById(R.id.loadCharButton);
        loadCharButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
            	Intent intent = new Intent(getApplicationContext(), LoadCharSheet.class);
            	startActivity(intent);
            }
        });
        
    }
	@Override
	public void onDestroy() {
		managedDatabase.close();
		super.onDestroy();
	}
}