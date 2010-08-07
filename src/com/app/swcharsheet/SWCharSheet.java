package com.app.swcharsheet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SWCharSheet extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Button newCharButton = (Button) findViewById(R.id.newCharButton);
        newCharButton.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks
            	Intent intent = new Intent(getApplicationContext(), Biocreation.class);
            	startActivity(intent);
            }
        });
    }
}