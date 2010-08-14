package com.app.swcharsheet;

import java.lang.Math;
/**
 * @author Mike Rushford
 * @author Eric Martin
 * @version 20100809
 */
public class characterSheet{
	String  charName,
			playerName,
			charSpecies,
			charDestiny;
	char charGender;
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
	int[][] skills;
	double charHeight;
	int charCurrentForcePoints,
		charCurrentHealthPoints,
		charCurrentDestinyPoints,
		charDmgThresh,
		levelXP,
		toNextLevelXP,
		wearingArmor = 0;
	double XPProgress;
	String[] fieldStats;
	
	/**
	 * Default Constructor
	 */
	characterSheet(){
		
		initStats();
				
		charCurrentHealthPoints = charTotalHealthPoints;
		charCurrentForcePoints = charTotalForcePoints;
		
		charDmgThresh = getCharDefense(0);
		
		levelXP = 0;
		for(int j = charLevel; j > 0; j--)
			levelXP += (j - 1) * 1000;
		
		toNextLevelXP = (charLevel) * 1000;
		XPProgress = (double) (charXP - levelXP) / (double) toNextLevelXP;
		fieldStats= new String[] 
				        {getCharName(), getPlayerName(),
						 getCharClass(), getCharSpecies(),
						 Integer.toString(getCharLevel()), Integer.toString(getCharAge()),
						 Character.toString(getCharGender()), Double.toString(getCharHeight()),
						 Integer.toString(getCharWeight()), getCharDestiny(),
						 Integer.toString(getCharXP()), Integer.toString(getCharNextXP()+levelXP),
						 Integer.toString(getAbil(0)),Integer.toString(getAbil(2)),Integer.toString(getAbil(3)),
						 Integer.toString(getAbil(3)),Integer.toString(getAbil(4)),Integer.toString(getAbil(5)),
						 getHPString(), Integer.toString(getDmgThresh()),
						 Integer.toString(getCharDefense(0)),Integer.toString(getCharDefense(1)), Integer.toString(getCharDefense(2)),
						 Integer.toString(getCharSpeed()), Integer.toString(getSkillBonus(5)), Integer.toString(getSkillBonus(10)),
						 Integer.toString(getCharBaseAttack()),Integer.toString(getCharFP())
						 };
	}
	
	private void initStats(){
		charName = "Zohan";
		playerName = "Brian";
		charClass = 0;
		charSpecies = "Twi\'lek";
		charLevel = 4;
		charAge = 24;
		charGender = 'M';
		charHeight = 1.8;
		charWeight = 65;
		charDestiny = "None";
		abilities = new int[] {16,15,13,13,15,20};
		skills = new int[][] {{1,5,0,0},	//0 Acrobatics
						    {0,0,0,0},	//1 Climb
						    {5,0,0,0},	//2 Deception
						    {2,0,0,0},	//3 Endurance
						    {5,0,0,0},	//4 Gather Information
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
		
		charXP = 6291;
		charTotalHealthPoints = 57;
		charTotalForcePoints = 7;
		charBaseAtk = 4;
		charBaseSpeed = 6;	
	}

	
	/**
	 * @param i Index of the ability (STR:0, DEX:1, CON:2, INT:3, WIS:4, CHA:5
	 * @return Returns the value of the ability
	 */
	public int getAbil(int i){
		return abilities[i];
	}
	
	/**
	 * @return int Character's current amount of XP
	 */
	public int getCharXP(){
		return charXP;
	}
	
	/**
	 * @return int Amount of xp to Next Level
	 */
	public int getCharNextXP(){
		return toNextLevelXP;
	}
	
	/**
	 * @return int Current Health Points
	 */
	public int getCharCurrentHP(){
		return charCurrentHealthPoints;
	}
	
	/**
	 * @return int Total Character Health Points
	 */
	public int getCharTotalHP(){
		return charTotalHealthPoints;
	}

	/**
	 * @return String Current Health Points / Total Health Points
	 */
	public String getHPString(){
		return Integer.toString(getCharCurrentHP())+'/'+Integer.toString(getCharTotalHP());
	}
	
	/**
	 * @return int Damage Threshold
	 */
	public int getDmgThresh(){
		return charDmgThresh;
	}
	
	public int getCharFP(){
		return charCurrentForcePoints;
	}
	
	/**
	 * @return int Character's age in years
	 */
	public int getCharAge() {
		return charAge;
	}
	
	public int getCharBaseAttack(){
		return charBaseAtk;
	}
	
	//TODO add destinies to javadoc code
	/**
	 * @return String Character's destiny [a,b,c,d,e]
	 */
	public String getCharDestiny() {
		return charDestiny;
	}

	/**
	 * @param which Index of the ability for which the modifier is requested
	 * @return int Ability modifier
	 */
	public int getMod(int which){
		int mod =  (int) Math.floor(abilities[which]/2)-5;
		return mod;
		}
	
	/**
	 * @return String class of the current character
	 */
	public String getCharClass() {
		String thisclass[] = {"Jedi",
							  "Noble",
							  "Scoundrel",
							  "Scout",
							  "Soldier"};
		
		return thisclass[charClass];
	}

	public int getCharLevel() {
		return charLevel;
	}
	
	public String getCharName() {
		return charName;
	}
	
	/**
	 * @param which
	 * @return
	 */
	public int getCharDefense(int which) {
		int defense, abilmod, levOrArmor, classBonus, misc;
		switch(which) {
			case 0:
				abilmod=getMod(2);
				//classBonus=
				break;
			case 1:
				abilmod=getMod(1);
				break;
			case 2:
				abilmod=getMod(4);
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

	/**
	 * @return char [M|F]
	 */
	public char getCharGender() {
		return charGender;
	}

	/**
	 * @return double Height in meters
	 */
	public double getCharHeight() {
		return charHeight;
	}

	/**
	 * @return The Player's name associated with this character
	 */
	public String getPlayerName() {
		return playerName;
	}

	public int getSkillBonus(int skill) {
		return (int) Math.floor (charLevel / 2) + getMod(skills[skill][0]) + 
			skills[skill][1] + skills[skill][2] + skills[skill][3];
	}
	
	/**
	 * @return String character species
	 */
	public String getCharSpecies() {
		return charSpecies;
	}

	/** 
	 * @return Character's base speed in squares
	 */
	public int getCharSpeed() {
		return charBaseSpeed;
	}

	/**
	 * @return int weight in kilograms
	 */
	public int getCharWeight() {
		return charWeight;
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