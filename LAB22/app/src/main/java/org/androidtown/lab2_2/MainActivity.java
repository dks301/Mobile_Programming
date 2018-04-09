package org.androidtown.lab2_2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText URL;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URL = (EditText)findViewById(R.id.editURL);
        nextBtn = (Button)findViewById(R.id.button1);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String newURL = URL.getText().toString();

                Intent intent = new Intent (getApplicationContext(), NewActivity.class);
                intent.putExtra("Url", newURL);
                startActivity(intent);
            }
        });
    }
}
