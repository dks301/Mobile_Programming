package org.androidtown.lab6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editNum;
    EditText editName;
    Button loadBtn;
    Button saveBtn;
    Button resetBtn;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String userName, userNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum = (EditText)findViewById(R.id.editNum);
        editName = (EditText)findViewById(R.id.editName);
        loadBtn = (Button)findViewById(R.id.loadBtn);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        resetBtn = (Button)findViewById(R.id.resetBtn);

        saveBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = editName.getText().toString();
                userNum = editNum.getText().toString();
                sh_Pref = getSharedPreferences("data", MODE_PRIVATE);
                toEdit = sh_Pref.edit();
                toEdit.putString("UserName", userName);
                toEdit.putString("UserNum", userNum);
                toEdit.commit();
            }
        });

        resetBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editNum.setText("");
            }
        });

        loadBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                sh_Pref = getSharedPreferences("data", MODE_PRIVATE);
                if (sh_Pref != null && sh_Pref.contains("UserName") && sh_Pref.contains("UserNum")) {
                    String name = sh_Pref.getString("UserName", "noname");
                    String num = sh_Pref.getString("UserNum", "noname");
                    editName.setText(name);
                    editNum.setText(num);
                }
            }
        });
    }
}