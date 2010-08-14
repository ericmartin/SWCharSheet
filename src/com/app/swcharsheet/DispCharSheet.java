package com.app.swcharsheet;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Mike Rushford
 * @author Eric Martin
 * @version 20100809
 */


public class DispCharSheet extends Activity {

	characterSheet sheet;
	
	private int adjHP[], adjXP[];
	
	static final private int HPDialog = 0,
							 XPDialog = 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.dispcharsheet);
        
        int i;
        sheet = new characterSheet();

    	adjHP = new int[] {0,0,0,0};
    	adjXP = new int[] {0,0,0,0};
        
        int[] displayFields = new int[] 
                             {R.id.dispCharName,   R.id.dispPlayerName,
       		 				  R.id.dispCharClass,  R.id.dispCharSpecies,
       		 				  R.id.dispCharLevel,  R.id.dispCharAge,
       		 				  R.id.dispCharGender, R.id.dispCharHeight,
       		 				  R.id.dispCharWeight, R.id.dispCharDestiny,
       		 				  R.id.dispCharXP,	   R.id.dispCharToNextLevel,
       		 				  R.id.dispSTR,		   R.id.dispDEX, R.id.dispINT,
       		 				  R.id.dispCON, 	   R.id.dispWIS, R.id.dispCHA,
       		 				  R.id.dispHP, 	 	   R.id.dispDmgThresh,
       		 				  R.id.dispFort, 	   R.id.dispRef, R.id.dispWill,
       		 				  R.id.dispCharSpeed,  R.id.dispCharInit,
       		 				  R.id.dispCharPerc,   R.id.dispCharBaseAtk,
       		 				  R.id.dispCharFP};
        int[] SkillIds = new int[] 
                             {R.id.dispAcro, R.id.dispClimb, R.id.dispDec,   R.id.dispEnd,   R.id.dispGInfo,
                          	  R.id.dispInit, R.id.dispJump,  R.id.dispKnow1, R.id.dispKnow2, R.id.dispMech,
                          	  R.id.dispPerc, R.id.dispPers,  R.id.dispPil,   R.id.dispRide,  R.id.dispStlth,
                          	  R.id.dispSurv, R.id.dispSwim,  R.id.dispTreat, R.id.dispUCom,  R.id.dispUForce};	 				  
        for(i = 0; i < 28; i++){
        	populateField(displayFields[i], sheet.fieldStats[i]);
        }
        for(i = 0; i < 20; i++){
          	populateField(SkillIds[i], Integer.toString(sheet.getSkillBonus(i)));
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
	    	showDialog(HPDialog);
	    	//adjHPInteractions();
	    	return true;
	    case R.id.adjXP:
	    	showDialog(XPDialog);
	    	return true;
	    case R.id.adjFP:
	    	return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	public Dialog onCreateDialog(int id){
		AlertDialog.Builder temp = new AlertDialog.Builder(this);
		LayoutInflater li = LayoutInflater.from(this);
		View mView;
		switch(id) {
			case(HPDialog):
				mView = li.inflate(R.layout.adjhp,null);
				temp.setTitle("Adjust HP");
				temp.setView(mView);
	    		return temp.create();
			case(XPDialog):
				mView = li.inflate(R.layout.adjxp,null);
				temp.setTitle("Adjust XP");
				temp.setView(mView);
		    	return temp.create();
		    default:
		    	return null;
		}
	}
	@Override
	public void onPrepareDialog(int id, Dialog dialog){
		switch(id) {
			case(HPDialog):
				adjHPInteractions();
				break;
			case(XPDialog):
	    		adjXPInteractions();
				break;
		}
	}
	
	//TODO: Get these two methods to not cause a Force Close
	private void adjHPInteractions(){
		
    	/*final Button incHPButton1000 = (Button) findViewById(R.id.incHP1000);
    	incHPButton1000.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[0]++;
    			populateField(R.id.adjHPText1000,Integer.toString(adjHP[0]));
    		}
    	});
    	final Button incHPButton0100 = (Button) findViewById(R.id.incHP0100);
    	incHPButton0100.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[1]++;
    			populateField(R.id.adjHPText0100,Integer.toString(adjHP[1]));
    		}
    	});
    	final Button incHPButton0010 = (Button) findViewById(R.id.incHP0010);
    	incHPButton0010.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[2]++;
    			populateField(R.id.adjHPText0010,Integer.toString(adjHP[2]));
    		}
    	});
    	final Button incHPButton0001 = (Button) findViewById(R.id.incHP0001);
    	incHPButton0001.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[3]++;
    			populateField(R.id.adjHPText0001,Integer.toString(adjHP[3]));
    		}
    	});
    	final Button decHPButton1000 = (Button) findViewById(R.id.decHP1000);
    	decHPButton1000.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[0]--;
    			populateField(R.id.adjHPText1000,Integer.toString(adjHP[0]));
    		}
    	});
    	final Button decHPButton0100 = (Button) findViewById(R.id.decHP0100);
    	decHPButton0100.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[1]--;
    			populateField(R.id.adjHPText0100,Integer.toString(adjHP[1]));
    		}
    	});
    	final Button decHPButton0010 = (Button) findViewById(R.id.decHP0010);
    	decHPButton0010.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[2]--;
    			populateField(R.id.adjHPText0010,Integer.toString(adjHP[2]));
    		}
    	});
    	final Button decHPButton0001 = (Button) findViewById(R.id.decHP0001);
    	decHPButton0001.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjHP[3]--;
    			populateField(R.id.adjHPText0001,Integer.toString(adjHP[3]));
    		}
    	});
    	
    	final Button adjHPOK = (Button) findViewById(R.id.adjHPOK);
    	adjHPOK.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			sheet.adjHP(0-convertToInt(adjHP));
    		}
    	});
    	
    	final Button adjHPCANCEL = (Button) findViewById(R.id.adjHPCANCEL);
    	adjHPCANCEL.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			//adjHPDialog.dismiss();
    		}
    	});*/
    	
	}
	
	private void adjXPInteractions(){
		/*final Button incXPButton1000 = (Button) findViewById(R.id.incXP1000);
    	incXPButton1000.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[0]++;
    			populateField(R.id.adjXPText1000,Integer.toString(adjXP[0]));
    		}
    	});
    	final Button incXPButton0100 = (Button) findViewById(R.id.incXP0100);
    	incXPButton0100.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[1]++;
    			populateField(R.id.adjXPText0100,Integer.toString(adjXP[1]));
    		}
    	});
    	final Button incXPButton0010 = (Button) findViewById(R.id.incXP0010);
    	incXPButton0010.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[2]++;
    			populateField(R.id.adjXPText0010,Integer.toString(adjXP[2]));
    		}
    	});
    	final Button incXPButton0001 = (Button) findViewById(R.id.incXP0001);
    	incXPButton0001.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[3]++;
    			populateField(R.id.adjXPText0001,Integer.toString(adjXP[3]));
    		}
    	});
    	final Button decXPButton1000 = (Button) findViewById(R.id.decXP1000);
    	decXPButton1000.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[0]--;
    			populateField(R.id.adjXPText1000,Integer.toString(adjXP[0]));
    		}
    	});
    	final Button decXPButton0100 = (Button) findViewById(R.id.decXP0100);
    	decXPButton0100.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[1]--;
    			populateField(R.id.adjXPText0100,Integer.toString(adjXP[1]));
    		}
    	});
    	final Button decXPButton0010 = (Button) findViewById(R.id.decXP0010);
    	decXPButton0010.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[2]--;
    			populateField(R.id.adjXPText0010,Integer.toString(adjXP[2]));
    		}
    	});
    	final Button decXPButton0001 = (Button) findViewById(R.id.decXP0001);
    	decXPButton0001.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			adjXP[3]--;
    			populateField(R.id.adjXPText0001,Integer.toString(adjXP[3]));
    		}
    	});
    	
    	final Button adjXPOK = (Button) findViewById(R.id.adjXPOK);
    	adjXPOK.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			sheet.adjXP(convertToInt(adjXP));
    		}
    	});
    	
    	final Button adjXPCANCEL = (Button) findViewById(R.id.adjXPCANCEL);
    	adjXPCANCEL.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    			//adjXPDialog.dismiss();
    		}
    	});*/
	}
	
	private int convertToInt(int temp[]){
		return temp[0]*1000+temp[1]*100+temp[2]*10+temp[3];
	}
}