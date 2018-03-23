package com.kuush.mymvc;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.kuush.mymvc.data.Model;

public class MVCPhoneBook extends AppCompatActivity {
    public ListView listView;
    public Model model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcphone_book);
            model = new Model();
            listView = (ListView) findViewById(R.id.contactView);
//        DatabaseHelper databaseHelper = new DatabaseHelper(this);
//        SQLiteDatabase db = databaseHelper.getReadableDatabase();
//        listView = (ListView) findViewById(R.id.contactView);
//        String [] from ={
//                Database.PhoneBookDatabase.COLUMN_NAME,
//                Database.PhoneBookDatabase.COLUMN_NUMBER
//        };
//        int [] to = {
//                R.id.name,
//                R.id.phoneNumber
//        };
//        String[] projection = {
//                Database.PhoneBookDatabase._ID,
//                Database.PhoneBookDatabase.COLUMN_NAME,
//                Database.PhoneBookDatabase.COLUMN_NUMBER
//        };
//        Cursor cursor = db.query(Database.PhoneBookDatabase.TABLE_NAME,projection,null,null,null,null,""+Database.PhoneBookDatabase.COLUMN_NAME+" ASC");
//        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.content_view,cursor,from,to);
//        listView.setAdapter(simpleCursorAdapter);
        int [] to = {
                R.id.initials,
                R.id.name,
                R.id.phoneNumber
        };
        Object [] arrayList;
        arrayList = model.addTheData(listView,R.layout.content_view,getBaseContext());
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.content_view, (Cursor) arrayList[0],(String [])arrayList[1],to);
        listView.setAdapter(simpleCursorAdapter);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTheIntent();
            }
        });
    }
    private void startTheIntent(){
        Intent intent = new Intent(this,InputActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mvcphone_book, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        model.addTheData(listView,R.layout.content_view,this);
    }
}
