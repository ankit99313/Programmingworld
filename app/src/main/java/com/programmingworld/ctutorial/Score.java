package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private TextView score,total;
    private Button done_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        score=(TextView)findViewById(R.id.score);
        total=(TextView)findViewById(R.id.total);
        done_btn=(Button)findViewById(R.id.done);

        score.setText(String.valueOf(getIntent().getIntExtra("score",0)));
        total.setText(String.valueOf(getIntent().getIntExtra("total",0)));

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Score.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
