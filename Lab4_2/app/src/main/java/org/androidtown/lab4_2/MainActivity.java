package org.androidtown.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button button;
    boolean check = true;
    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check) {
                    linearLayout.setVisibility(View.VISIBLE);
                    anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_slide);
                    linearLayout.startAnimation(anim);
                    button.setText("CLOSE PAGE");
                    check = false;
                }
                else {
                    anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_slide);
                    linearLayout.startAnimation(anim);
                    button.setText("OPEN PAGE");
                    linearLayout.setVisibility(View.INVISIBLE);
                    check = true;
                }
            }
        });
    }
}
