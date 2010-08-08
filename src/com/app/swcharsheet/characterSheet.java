package com.app.swcharsheet;

import java.lang.Math;

public class characterSheet{
	String charName;
	String playerName;
	int[] abilities;
	int[] modifiers;
	int totalHP, currentHP;
	
	characterSheet(){
		charName="Jaksor Sa'lya";
		playerName="Eric";
		abilities = new int[] {14,15,12,17,15,18};
		modifiers= new int[6];
		modifiers = getMods(abilities);
		totalHP=45;
		currentHP=totalHP;
		
	}
	static private int[] getMods(int[] abils){
		int[] mods = new int[6];
		int i;
		for (i=0; i<6; i++)
			mods[i]=(int) Math.floor(abils[i]/2)-5;
		return mods;
		}
	
}