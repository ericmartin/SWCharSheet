package com.app.swcharsheet;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DispCharSheet extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.dispcharsheet);
        
        characterSheet sheet = new characterSheet();
        
        TextView charName = (TextView) findViewById(R.id.dispCharName);
        charName.setText(sheet.charName);
        
        TextView playerName = (TextView) findViewById(R.id.dispPlayerName);
        playerName.setText(sheet.playerName);
        
        int[][] AbilIds;
        AbilIds = new int[][] { {R.id.STR, R.id.StrMod},
        						{R.id.DEX, R.id.DexMod},
        						{R.id.CON, R.id.ConMod},
        						{R.id.INT, R.id.IntMod},
        						{R.id.WIS, R.id.WisMod},
        						{R.id.CHA, R.id.ChaMod}};
        
        
        TextView[][] charAbils = new TextView[6][2];
        for(int i=0; i<6; i++)
        {
        	charAbils[i][0] = (TextView) findViewById(AbilIds[i][0]);
        	charAbils[i][0].setText(Integer.toString(sheet.abilities[i]));
        	charAbils[i][1] = (TextView) findViewById(AbilIds[i][1]);
        	charAbils[i][1].setText(Integer.toString(sheet.modifiers[i]));
        }
        
        TextView charHP = (TextView) findViewById(R.id.HP);
        String hpString= Integer.toString(sheet.currentHP)+'/'+Integer.toString(sheet.totalHP);
        charHP.setText(hpString);
	}

}