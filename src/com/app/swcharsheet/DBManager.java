package com.app.swcharsheet;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Database Manager for StarWars Character App.  Handles all database functions
 * @author Eric Martin
 * @author Mike Rushford
 * @version 2010-08-13
 */
public class DBManager extends Activity {
	private static final String DB_NAME = "SWCharSheet.db";
	private static final String PRI_KEY = "_ID";
	private static final int DB_VERSION = 1;
	
	// yes I need all of these variables, they help to eliminate typos and save a lot of headaches
	public static final String ABILITY_TABLE = "Ability";
	public static final String CHARACTER_TABLE = "Character";
	public static final String FEAT_TABLE = "Feat";
	public static final String FEAT_PREREQ_TABLE = "FeatPreReq";
	public static final String LEVEL_TABLE = "Level";
	public static final String REF_DESTINY_TABLE = "Ref_Destiny";
	public static final String SKILL_TABLE = "Skill";
	
	private static final String ABILITY_COL = "Ability";
	private static final String SCORE_COL = "Score";
	private static final String NAME_COL = "Name";
	private static final String PLAYERNAME_COL = "PlayerName";
	private static final String SPECIES_COL = "Species";
	private static final String AGE_COL = "Age";
	private static final String GENDER_COL = "Gender";
	private static final String HEIGHT_COL = "Height";
	private static final String WEIGHT_COL = "Weight";
	private static final String DESTINY_COL = "Destiny";
	private static final String HP_COL = "HP";
	private static final String SPEED_COL = "Speed";
	private static final String CONDITION_COL = "Condition";
	private static final String DESTINYPTS_COL = "DestinyPts";
	private static final String FORCEPTS_COL = "ForcePTS";
	private static final String STR_COL = "STR";
	private static final String DEX_COL = "DEX";
	private static final String CON_COL = "CON";
	private static final String INT_COL = "INT";
	private static final String WIS_COL = "WIS";
	private static final String CHA_COL = "CHA";
	
	private static final String FEAT_COL = "Feat";
	private static final String PAGE_COL = "pg";
	
	private static final String CREATE_ABILITY = "CREATE TABLE " + ABILITY_TABLE + 
													"(" + PRI_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
													+ ABILITY_COL + " TEXT NOT NULL, "
													+ SCORE_COL + " INTEGER NOT NULL);";
	
	private static final String CREATE_CHARACTER = "CREATE TABLE " + CHARACTER_TABLE +
													"(" + PRI_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
													+ NAME_COL + " TEXT NOT NULL, "
													+ PLAYERNAME_COL + " TEXT NOT NULL, "
													+ SPECIES_COL + " INTEGER NOT NULL, " // ref_Species
													+ AGE_COL + " INTEGER NOT NULL, "
													+ GENDER_COL + " INTEGER NOT NULL, " // ref_Gender
													+ HEIGHT_COL + " FLOAT, "
													+ WEIGHT_COL + " FLOAT NOT NULL, "
													+ DESTINY_COL + " INTEGER, " // ref_Destiny
													+ HP_COL + " INTEGER NOT NULL, "
													+ SPEED_COL + " INTEGER NOT NULL, "
													+ CONDITION_COL + " INTEGER NOT NULL, " // ref_Condition
													+ DESTINYPTS_COL + " INTEGER, "
													+ FORCEPTS_COL + " INTEGER NOT NULL, "
													+ STR_COL + " INTEGER NOT NULL, "
													+ DEX_COL + " INTEGER NOT NULL, "
													+ CON_COL + " INTEGER NOT NULL, "
													+ INT_COL + " INTEGER NOT NULL, "
													+ WIS_COL + " INTEGER NOT NULL, "
													+ CHA_COL + " INTEGER NOT NULL);";
	
	private static final String CREATE_FEAT = "CREATE TABLE " + FEAT_TABLE +
													"(" + PRI_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
													+ FEAT_COL + " STRING NOT NULL, "
													+ PAGE_COL + " INTEGER NOT NULL);";
	
	private static final String CREATE_FEAT_PREREQ = "";
	private static final String CREATE_LEVEL = "";
	private static final String CREATE_REF_DESTINY = "";
	private static final String CREATE_SKILL = "";
	
	private final Context context;
	private SQLiteDatabase db;
	private DBManagerOpenHelper dbHelper;

	public DBManager (Context _context){
		context = _context;
		dbHelper = new DBManagerOpenHelper(context,DB_NAME,null,DB_VERSION);
	}
	
	/**
	 * void open() -- Attempts to open the SQLite database in db as RW but fails to RO
	 * @precondition: db is a handle to a SQLite database
	 * @postcondition: db is a handle to an Open SQLite database, RO if not RW
	 * @throws SQLiteException if it can't get a RW db, fails over to RO
	 */
	public void open() throws SQLiteException {

		try{
			db = dbHelper.getWritableDatabase();
		}
		catch (SQLiteException e){
			db = dbHelper.getReadableDatabase();
		}
	}
	
	/** 
	 * void close() -- Closes the database
	 * @precondition: db is an open SQLite database
	 * @postcondition: db is a closed SQLite database
	 * Closes SQLite database db
	 */
	public void close(){

		db.close();
	}
	
private static class DBManagerOpenHelper extends SQLiteOpenHelper{
		
		public DBManagerOpenHelper(Context context, String name, CursorFactory factory,int version) {
			super(context, name, factory, version);
		}

		@Override
		public void onCreate(SQLiteDatabase myDB) {
			myDB.execSQL(CREATE_ABILITY);
			myDB.execSQL(CREATE_CHARACTER);
			myDB.execSQL(CREATE_FEAT);
			myDB.execSQL(CREATE_FEAT_PREREQ);
			myDB.execSQL(CREATE_LEVEL);
			myDB.execSQL(CREATE_REF_DESTINY);
			myDB.execSQL(CREATE_SKILL);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase oldDB, int oldVersion, int newVersion) {
			//Drop the table and start over!
			oldDB.execSQL("DROP TABLE IF EXISTS " + ABILITY_TABLE + ";");
			oldDB.execSQL("DROP TABLE IF EXISTS " + CHARACTER_TABLE + ";"); 
			oldDB.execSQL("DROP TABLE IF EXISTS " + FEAT_TABLE + ";");
			oldDB.execSQL("DROP TABLE IF EXISTS " + FEAT_PREREQ_TABLE + ";");
			oldDB.execSQL("DROP TABLE IF EXISTS " + LEVEL_TABLE + ";");
			oldDB.execSQL("DROP TABLE IF EXISTS " + REF_DESTINY_TABLE + ";");
			oldDB.execSQL("DROP TABLE IF EXISTS " + SKILL_TABLE + ";");
			onCreate(oldDB);
		}
	}
}
