package org.androidtown.lab6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private static final String FILE = "mysdfile.txt";

    EditText editText;
    Button writeBtn;
    Button clearBtn;
    Button readBtn;
    Button finishBtn;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        writeBtn = (Button)findViewById(R.id.writeBtn);
        clearBtn = (Button)findViewById(R.id.clearBtn);
        readBtn = (Button)findViewById(R.id.readBtn);
        finishBtn = (Button)findViewById(R.id.finishBtn);

        writeBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    OutputStreamWriter out = new OutputStreamWriter(openFileOutput(FILE, 0));
                    out.write(editText.getText().toString());
                    out.close();
                    Toast.makeText(getApplicationContext(), "Done writing SD 'mysdfile.txt'", Toast.LENGTH_LONG).show();
                } catch(Throwable t) {}
            }
        });

        clearBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        readBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream in = openFileInput(FILE);
                    if (in != null) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String str = "";
                        StringBuffer buf = new StringBuffer();
                        while ((str = br.readLine()) != null) {
                            buf.append(str + "\n");
                        }
                        in.close();
                        editText.setText(buf.toString());
                        Toast.makeText(getApplicationContext(), "Done reading SD 'mysdfile.txt'", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                } catch (Throwable t) {}
            }
        });

        finishBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}