package com.app.swcharsheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Mike Rushford
 * @author Eric Martin
 * @version 20100809
 */

public class DispCharSheet extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.dispcharsheet);
        
        characterSheet sheet = new characterSheet();
        int i;
        
        int[] displayFields = new int[] 
                             {R.id.dispCharName, R.id.dispPlayerName,
       		 				  R.id.dispCharClass, R.id.dispCharSpecies,
       		 				  R.id.dispCharLevel, R.id.dispCharAge,
       		 				  R.id.dispCharGender, R.id.dispCharHeight,
       		 				  R.id.dispCharWeight, R.id.dispCharDestiny,
       		 				  R.id.dispCharXP, R.id.dispCharToNextLevel,
       		 				  R.id.dispSTR, R.id.dispDEX, R.id.dispINT,
       		 				  R.id.dispCON, R.id.dispWIS, R.id.dispCHA,
       		 				  R.id.dispHP, R.id.dispDmgThresh,
       		 				  R.id.dispFort, R.id.dispRef, R.id.dispWill,
       		 				  R.id.dispCharSpeed, R.id.dispCharInit,
       		 				  R.id.dispCharPerc, R.id.dispCharBaseAtk,
       		 				  R.id.dispCharFP};
       		 				  
        for(i = 0; i < 28; i++){
        	populateField(displayFields[i], sheet.fieldStats[i]);
        }
        
        // progress bar stuff
        int screenwidth = 320;//(int) findViewById(R.id.ParentWindow).getWidth();
        //TODO: Get getWidth() ^^ to return something other than 0
        
        View XPBar1 = (View) findViewById(R.id.XPBar1);
        View XPBar2 = (View) findViewById(R.id.XPBar2);
        
        int xpb1 = (int) (screenwidth * sheet.XPProgress);
        int xpb2 = screenwidth-xpb1;
        
        XPBar1.setLayoutParams(new LinearLayout.LayoutParams(xpb1,8));
        XPBar2.setLayoutParams(new LinearLayout.LayoutParams(xpb2,8));
        
         int[] SkillIds = new int[] 
               {R.id.dispAcro, R.id.dispClimb, R.id.dispDec, R.id.dispEnd, R.id.dispGInfo,
        		R.id.dispInit, R.id.dispJump, R.id.dispKnow1, R.id.dispKnow2, R.id.dispMech,
        		R.id.dispPerc, R.id.dispPers, R.id.dispPil, R.id.dispRide, R.id.dispStlth,
        		R.id.dispSurv, R.id.dispSwim, R.id.dispTreat, R.id.dispUCom, R.id.dispUForce};
        
        for(i = 0; i < 20; i++){
        	populateField(SkillIds[i], Integer.toString(sheet.getSkillBonus(i)));
        }	
	}
	
	public void populateField(int textID, String value){
		TextView thisText = (TextView) findViewById(textID);
		thisText.setText(value);
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.dispmenu, menu);
	    return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.adjHP:
	    	return true;
	    case R.id.adjXP:
	    	return true;
	    case R.id.adjFP:
	    	return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
}