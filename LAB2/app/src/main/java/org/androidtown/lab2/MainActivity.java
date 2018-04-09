package org.androidtown.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.editName);
        Age = (EditText)findViewById(R.id.editAge);
        button1 = (Button)findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String newName = Name.getText().toString();
                String newAge = Age.getText().toString();

                Intent intent = new Intent (getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", newName);
                intent.putExtra("loginAge", newAge);
                startActivity(intent);
            }
        });
    }
}
