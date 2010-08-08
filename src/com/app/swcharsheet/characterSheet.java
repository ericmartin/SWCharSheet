package com.app.swcharsheet;

import java.lang.Math;

public class characterSheet{
	static String   charName,
					playerName,
					charSpecies,
					charDestiny;
	static char charGender;
	static int  charClass,
				charAge,
				charLevel,
				charWeight,
				charBaseSpeed,
				charBaseAtk,
				charTotalForcePoints,
				charTotalHealthPoints,
				charXP;
	static int[] abilities;
	static int[][] skills;
	static double charHeight;
	int charCurrentForcePoints,
		charCurrentHealthPoints,
		charCurrentDestinyPoints,
		charDmgThresh,
		levelXP,
		toNextLevelXP,
		wearingArmor=0;
	double XPProgress;
	int[] modifiers;
	
	//Constructor
	characterSheet(){
		
		initStats();
		
		modifiers= new int[6];
		modifiers = getMods(abilities);
		
		charCurrentHealthPoints=charTotalHealthPoints;
		charCurrentForcePoints=charTotalForcePoints;
		
		charDmgThresh=getDefense(0);
		
		levelXP=0;
		for(int j=charLevel; j>0; j--)
		{
			levelXP+=(j-1)*1000;
		}
		toNextLevelXP=(charLevel-1)*1000;
		XPProgress=(double) (charXP-levelXP) / (double) toNextLevelXP;
		
	}
	
	static private void initStats(){
		charName="Zohan";
		playerName="Brian";
		charClass=0;
		charSpecies="Twi\'lek";
		charLevel=4;
		charAge=24;
		charGender='M';
		charHeight=1.8;
		charWeight=65;
		charDestiny="None";
		abilities = new int[] {16,15,13,13,15,20};
		skills=new int[][] {{1,5,0,0},	//0 Acrobatics
						    {0,0,0,0},	//1 Climb
						    {5,0,0,0},	//2 Deception
						    {2,0,0,0},	//3 Endurance
						    {5,0,0,0},	//4 Gather Inf
						    {1,0,0,0},	//5 Initiative
						    {0,0,0,0},	//6 Jump
						    {3,0,0,0},	//7 Knowledge
						    {3,0,0,0},	//8 Knowledge
						    {3,0,0,0},	//9 Mechanics
						    {4,5,0,0}, //10 Perception
						    {5,0,0,0}, //11 Persuasion
						    {1,0,0,0}, //12 Pilot
						    {1,0,0,0}, //13 Ride
						    {1,0,0,0}, //14 Stealth
						    {4,0,0,0}, //15 Survival
						    {0,0,0,0}, //16 Swim
						    {4,0,0,0}, //17 Treat Injury
						    {3,0,0,0}, //18 Use Computer
						    {5,5,0,0}};//19 Use the Force
		
		charXP=6291;
		charTotalHealthPoints=57;
		charTotalForcePoints=7;
		charBaseAtk=4;
		charBaseSpeed=6;
	}
	static private int[] getMods(int[] abils){
		int[] mods = new int[6];
		for (int i=0; i<6; i++)
			mods[i]=(int) Math.floor(abils[i]/2)-5;
		return mods;
		}
	
	public String getCharClass(){
		String thisclass[] = {"Jedi",
							  "Noble",
							  "Scoundrel",
							  "Scout",
							  "Soldier"};
		
		return thisclass[charClass];
	}
	
	public int getDefense(int which){
		int defense, abilmod, levOrArmor, classBonus, misc;
		switch(which) {
			case 0:
				abilmod=modifiers[2];
				//classBonus=
				break;
			case 1:
				abilmod=modifiers[1];
				break;
			case 2:
				abilmod=modifiers[4];
				break;
			default:
				abilmod=0;
				break;
		}
		
		classBonus=0; misc=0;
		if(wearingArmor==1) levOrArmor=5;
		else levOrArmor=charLevel;
		defense=10+levOrArmor+classBonus+abilmod+misc;
		return defense;
	}
	
	public int getSpeed(){
		return charBaseSpeed;
	}
	
	public int getBaseAttack(){
		return charBaseAtk;
	}
	
	public int getSkillBonus(int which){
		return (int)Math.floor(charLevel/2)+modifiers[skills[which][0]]+skills[which][1]+skills[which][2]+skills[which][3];
	}
	
	public void adjHP(int x){
		charCurrentHealthPoints+=x;
	}
	public void adjXP(int x){
		charXP+=x;
	}
	public void adjFP(int x){
		charCurrentForcePoints+=x;
	}
	
}