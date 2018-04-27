package org.androidtown.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    TextView nameView;
    TextView sexView;
    TextView callView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent myIntent2 = getIntent();

        nameView = (TextView)findViewById(R.id.textView2);
        sexView = (TextView)findViewById(R.id.textView4);
        callView = (TextView)findViewById(R.id.textView6);
        button = (Button)findViewById(R.id.button);

        nameView.setText(": " + myIntent2.getStringExtra("name"));
        sexView.setText(": " + myIntent2.getStringExtra("sex"));
        callView.setText(": " + myIntent2.getStringExtra("call"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), MainActivity.class));
                finish();
            }
        });

    }

}
