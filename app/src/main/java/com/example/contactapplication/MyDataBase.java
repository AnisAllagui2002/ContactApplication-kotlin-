package com.example.contactapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="contact.db";
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_NAME ="my_contact";
    private static final String COLUMN_NAME ="name";

    private static final String COLUMN_TELEPHONE ="telephone";
    private static final String COLUMN_EMAIL ="email";
    private static final String COLUMN_VILLE ="ville";
    private static final String COLUMN_CPostale ="code_postale";

    public MyDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME,null ,DATABASE_VERSION);
        this.context =context  ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "CREATE TABLE " + TABLE_NAME +
                        "(" + COLUMN_NAME + " TEXT, " +
                        COLUMN_TELEPHONE + " TEXT, " +
                        COLUMN_EMAIL + " TEXT, " +
                        COLUMN_VILLE + " TEXT, " +
                        COLUMN_CPostale + " TEXT);";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addContact(String name,String telephone,String email,String ville,String cpostale){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues() ;

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_TELEPHONE, telephone);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_VILLE, ville);
        cv.put(COLUMN_CPostale, cpostale);

      long result = db.insert(TABLE_NAME,null,cv);
      if(result ==-1 ){
          Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
      }
      else {
          Toast.makeText(context, "Added Successfuly", Toast.LENGTH_SHORT).show();
      }

    }

    Cursor readAllData(){
        String query ="SELECT * FROM " + TABLE_NAME ;
        SQLiteDatabase db =this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return  cursor;
    }

    void updateData(String name,String email,String telephone,String ville,String codepostale){

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_TELEPHONE, telephone);
        cv.put(COLUMN_VILLE, ville);
        cv.put(COLUMN_CPostale, codepostale);

        long result = db.update(TABLE_NAME,cv,"name=?",new String[]{name});
        if (result == -1){
            Toast.makeText(context,"Failed to Update",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();

        }
        }

        void deleteData(String name){
            SQLiteDatabase db =this.getWritableDatabase();
            long result = db.delete(TABLE_NAME,"name=?",new String[]{name});
            if (result == -1 ){
                Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context,"success",Toast.LENGTH_SHORT).show();

            }

        }









    }


