package org.androidtown.lab6_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    EditText editNum;
    Button addBtn;
    Button deleteBtn;
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    ListView listView;
    String[] nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.editName);
        editNum = (EditText)findViewById(R.id.editNum);
        addBtn = (Button)findViewById(R.id.addBtn);
        deleteBtn = (Button)findViewById(R.id.deleteBtn);
        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);
        listView = (ListView)findViewById(R.id.listView);

        addBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String num = editNum.getText().toString();
                if (name.equals("") || num.equals("")) {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    insert(name, Integer.parseInt(num));
                    invalidate();
                }
            }
        });

        deleteBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
                }
                else {
                    delete(name);
                    invalidate();
                }
            }
        });
    }

    public void insert(String name, int num) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("num", num);
        db.insert("student", null, values);
    }

    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
    }

    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);

        nameList = new String[c.getCount()];
        int count = 0;

        while(c.moveToNext()) {
            nameList[count] = c.getString(c.getColumnIndex("name"))
                    + " " + c.getString(c.getColumnIndex("num"));
            count++;
        }
        c.close();
    }

    private void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);
        listView.setAdapter(adapter);
    }
}
