package org.androidtown.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView)findViewById(R.id.textView1);
        goBtn = (Button)findViewById(R.id.button2);
        backBtn = (Button)findViewById(R.id.button3);

        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("Url");
        textView.setText(passedUrl);
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!passedUrl.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + passedUrl));
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
