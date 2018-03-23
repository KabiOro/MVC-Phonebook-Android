package com.kuush.mymvc.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;


/**
 * Created by K4K on 19/03/2018.
 */
public class Model {

    public Object[] addTheData(ListView listView, int id, Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String [] from ={
                Database.PhoneBookDatabase.COLUMN_ABRIVATION,
                Database.PhoneBookDatabase.COLUMN_NAME,
                Database.PhoneBookDatabase.COLUMN_NUMBER
        };

        String[] projection = {
                Database.PhoneBookDatabase._ID,
                Database.PhoneBookDatabase.COLUMN_ABRIVATION,
                Database.PhoneBookDatabase.COLUMN_NAME,
                Database.PhoneBookDatabase.COLUMN_NUMBER
        };
        Cursor cursor = db.query(Database.PhoneBookDatabase.TABLE_NAME,projection,null,null,null,null,""+Database.PhoneBookDatabase.COLUMN_NAME+" ASC");
        Object [] arrayList = {cursor,from};
        return arrayList;
    }
    public void insertTheData(EditText inputName,EditText inputNumber,Context context){
        DatabaseHelper databaseHelper  = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        String name = inputName.getText().toString();
        String abrevation ="";
        if(name.contains(" ")){
            abrevation = String.valueOf(String.valueOf(name.charAt(0))+String.valueOf(name.charAt(name.indexOf(' ')+1)));
            Log.w("Abrevation", abrevation);
        }
        values.put(Database.PhoneBookDatabase.COLUMN_ABRIVATION, abrevation);
        values.put(Database.PhoneBookDatabase.COLUMN_NAME,inputName.getText().toString());
        values.put(Database.PhoneBookDatabase.COLUMN_NUMBER,inputNumber.getText().toString());
        db.insert(Database.PhoneBookDatabase.TABLE_NAME,null,values);
    }
}
