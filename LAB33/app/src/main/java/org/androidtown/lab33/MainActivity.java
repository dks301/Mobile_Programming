package org.androidtown.lab33;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button btn_frag1;
    public Button btn_frag2;

    public FragmentManager fragManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_frag1 = (Button)findViewById(R.id.btn1);
        btn_frag2 = (Button)findViewById(R.id.btn2);

        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragManager.beginTransaction().replace(R.id.frameLayout, FragmentFirst.newInstance()).commit();
            }
        });

        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragManager.beginTransaction().replace(R.id.frameLayout, FragmentSecond.newInstance()).commit();
            }
        });
        fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.frameLayout, FragmentFirst.newInstance()).commit();
    }
}
