package com.app.swcharsheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DispCharSheet extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.dispcharsheet);
        
        characterSheet sheet = new characterSheet();
        
        TextView charName = (TextView) findViewById(R.id.dispCharName);
        TextView playerName = (TextView) findViewById(R.id.dispPlayerName);
        TextView charClass = (TextView) findViewById(R.id.dispCharClass);
        TextView charSpecies = (TextView) findViewById(R.id.dispCharSpecies);
        TextView charLevel = (TextView) findViewById(R.id.dispCharLevel);
        TextView charAge = (TextView) findViewById(R.id.dispCharAge);
        TextView charGen = (TextView) findViewById(R.id.dispCharGender);
        TextView charHeight = (TextView) findViewById(R.id.dispCharHeight);
        TextView charWeight = (TextView) findViewById(R.id.dispCharWeight);
        TextView charDest = (TextView) findViewById(R.id.dispCharDestiny);
        TextView xpProg = (TextView) findViewById(R.id.dispXP);
        TextView xpNext = (TextView) findViewById(R.id.toNextLevel);

        charName.setText(sheet.charName);
        playerName.setText(sheet.playerName);
        charClass.setText(sheet.getCharClass());
        charSpecies.setText(sheet.charSpecies);
        charLevel.setText(Integer.toString(sheet.charLevel));
        charAge.setText(Integer.toString(sheet.charAge));
        charGen.setText(Character.toString(sheet.charGender));
        charHeight.setText(Double.toString(sheet.charHeight));
        charWeight.setText(Integer.toString(sheet.charWeight));
        charDest.setText(sheet.charDestiny);
        xpProg.setText(Integer.toString(sheet.charXP));
        xpNext.setText(Integer.toString(sheet.levelXP + sheet.toNextLevelXP));
        
        // progress bar stuff
        int screenwidth=320;//(int) findViewById(R.id.ParentWindow).getWidth();
        //TODO: Get getWidth() ^^ to return something other than 0
        
        View XPBar1 = (View) findViewById(R.id.XPBar1);
        View XPBar2 = (View) findViewById(R.id.XPBar2);
        
        int xpb1 = (int) (screenwidth * sheet.XPProgress);
        int xpb2 = screenwidth-xpb1;
        
        XPBar1.setLayoutParams(new LinearLayout.LayoutParams(xpb1,8));
        XPBar2.setLayoutParams(new LinearLayout.LayoutParams(xpb2,8));
        
        int[] AbilIds = new int[]{R.id.STR,
        						  R.id.DEX,
        						  R.id.CON,
        						  R.id.INT,
        						  R.id.WIS,
        						  R.id.CHA};        
        
        TextView tempAbil;// = new TextView;
        for(int i=0; i<6; i++)
        {
        	tempAbil = (TextView) findViewById(AbilIds[i]);
        	tempAbil.setText(Integer.toString(characterSheet.abilities[i]));
        }
        
        TextView charHP = (TextView) findViewById(R.id.HP);
        String hpString = Integer.toString(sheet.charCurrentHealthPoints) + '/'
        	+ Integer.toString(characterSheet.charTotalHealthPoints);
        charHP.setText(hpString);
        
        TextView dmgThresh = (TextView) findViewById(R.id.dispDmgThresh);
        dmgThresh.setText(Integer.toString(sheet.charDmgThresh));
        
        TextView speed = (TextView) findViewById(R.id.SPD);
        TextView init = (TextView) findViewById(R.id.INIT);
        TextView perc = (TextView) findViewById(R.id.PERC);
        TextView baseatk = (TextView) findViewById(R.id.BATK);
        TextView forcep = (TextView) findViewById(R.id.FP);

        speed.setText(Integer.toString(sheet.getSpeed()));
        init.setText(Integer.toString(sheet.getSkillBonus(5)));
        perc.setText(Integer.toString(sheet.getSkillBonus(10)));
        baseatk.setText(Integer.toString(sheet.getBaseAttack()));
        forcep.setText(Integer.toString(sheet.charCurrentForcePoints));
        
        TextView dispFort = (TextView) findViewById(R.id.dispFort);
        TextView dispRef = (TextView) findViewById(R.id.dispRef);
        TextView dispWill = (TextView) findViewById(R.id.dispWill);

        dispFort.setText(Integer.toString(sheet.getDefense(0)));
        dispRef.setText(Integer.toString(sheet.getDefense(1)));
        dispWill.setText(Integer.toString(sheet.getDefense(2)));
        
        int[] SkillIds = new int[] 
               {R.id.dispAcro, R.id.dispClimb, R.id.dispDec, R.id.dispEnd, R.id.dispGInfo,
        		R.id.dispInit, R.id.dispJump, R.id.dispKnow1, R.id.dispKnow2, R.id.dispMech,
        		R.id.dispPerc, R.id.dispPers, R.id.dispPil, R.id.dispRide, R.id.dispStlth,
        		R.id.dispSurv, R.id.dispSwim, R.id.dispTreat, R.id.dispUCom, R.id.dispUForce};
        
        for(int i=0; i<20; i++)
        {
        	tempAbil = (TextView) findViewById(SkillIds[i]);
        	tempAbil.setText(Integer.toString(sheet.getSkillBonus(i)));
        }	
        
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

