package org.androidtown.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    RadioButton radMan;
    RadioButton radWoman;
    CheckBox chkSMS;
    CheckBox chkEmail;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText)findViewById(R.id.editText1);
        radMan = (RadioButton)findViewById(R.id.radioButton1);
        radWoman = (RadioButton)findViewById(R.id.radioButton2);
        chkSMS = (CheckBox)findViewById(R.id.checkBox1);
        chkEmail = (CheckBox)findViewById(R.id.checkBox2);
        btn = (Button)findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String manOrWoman = "";
                String smsAndEmail = "";
                Intent myIntent = new Intent(getApplication(), NewActivity.class);

                if (radMan.isChecked()) {
                    manOrWoman = "남";
                }
                else if (radWoman.isChecked()) {
                    manOrWoman = "여";
                }

                if (chkSMS.isChecked() && chkEmail.isChecked()) {
                    smsAndEmail = "SMS, e-mail";
                }
                else if (chkSMS.isChecked()) {
                    smsAndEmail = "SMS";
                }
                else if (chkEmail.isChecked()) {
                    smsAndEmail = "e-mail";
                }

                myIntent.putExtra("name", name);
                myIntent.putExtra("sex", manOrWoman);
                myIntent.putExtra("call", smsAndEmail);

                startActivity(myIntent);
                finish();
            }
        });
    }
}
