package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class Quizloop extends AppCompatActivity {
    private TextView question,no_counter;
    private LinearLayout options_layout;
    private Button next_btn;
    private int count=0;
    private ArrayList<QuestionModel> list;
    private int position=0;
    private int score;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizloop);

        question=(TextView)findViewById(R.id.question);
        no_counter=(TextView)findViewById(R.id.counter2);
        options_layout=(LinearLayout)findViewById(R.id.optionlayout);
        next_btn=(Button)findViewById(R.id.next_btn);

        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        list=new ArrayList<QuestionModel>();

        list.add(new QuestionModel("Choose a right C statement.","Loops or Repetition block executes a group of statements repeatedly.","Loop is usually executed as long as a condition is met.","Loops usually take advantage of Loop Counter","All the above.","All the above."));
        list.add(new QuestionModel("Which loop is faster in C Language, for, while or do while.?","for","while","do while","All work at same speed","All work at same speed"));
        list.add(new QuestionModel("What is the output of following C Program?\n#include<stdio.h>\nint main()\nint a=5;\nwhile(a==5)\n{\nprintf(\"hllo\");\nbreak;\n}","unlimited time hllo","hllo","compile time error","None of the above","hllo"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nint a=5;\nwhile(a>=3);\n{\nprintf(\"hllo\");\nbreak;\n}\nprintf(\"hai\");\nreturn 0;\n}","hllo","hllohai","unlimited time hllo","none of the above","none of the above"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nint a=32;\ndo\n{\nprintf(\"%d\",a);\na++\n}while(a<=30);\nreturn 0;\n}","30","32","33","no output","32"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nint i;\nfor(i=1; i<=5, i++)\n{\nprintf(\"%d\", k);\n}\nreturn 0;\n}","1 2 3 4 5","1 2 3 4","6","5","1 2 3 4 5"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nint k;\nfor(k=1; k<=5; k++);\n{\nprintf(\"%d\",k);\n}\nreturn 0;\n}","1 2 3 4 5","1 2 3 4","6","5","6"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nint k;\nfor(;;)\n{\nprintf(\"TESTING\");\nbreak;\n}\nreturn 0;\n}","TESTING","No output","Compile time error","None of the above","TESTING"));
        list.add(new QuestionModel("What is the way to suddenly come out of or Quit any Loop in C Language.?","continue; statement","break; statement","leave; statement","quit; statement","break; statement"));
        //list.add(new QuestionModel("","","","","",""));


        for (int i=0; i<4; i++) {
            options_layout.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAnswer((Button)view);
                }

            });
        }
        playAnim(question,0,list.get(position).getQuestion());
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_btn.setEnabled(false);
                next_btn.setAlpha(0.07f);
                enableoption(true);
                position++;
                if (position==list.size()){
                    Intent intent=new Intent(Quizloop.this,Score.class);
                    intent.putExtra("score",score);
                    intent.putExtra("total",list.size());
                    startActivity(intent);
                    return;
                }
                count=0;
                playAnim(question,0,list.get(position).getQuestion());

            }
        });

    }

    private void enableoption(boolean enable) {
        for (int i=0; i<4; i++)
        {
            options_layout.getChildAt(i).setEnabled(enable);
            if (enable)
            {
                options_layout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
            }
        }
    }

    private void playAnim(final View view,final int value, final String data) {
        view.animate().alpha(value).scaleX(value).scaleY(1).setDuration(500).setStartDelay(50)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                if (value==0 && count<4)
                {
                    String option="";
                    if (count==0)
                    {
                        option=list.get(position).getOptionA();
                    }
                    else if (count==1)
                    {
                        option=list.get(position).getOptionB();
                    }
                    else if (count==2)
                    {
                        option=list.get(position).getOptionC();
                    }
                    else if (count==3)
                    {
                        option=list.get(position).getOptionD();
                    }
                    playAnim(options_layout.getChildAt(count),0,option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (value==0)
                {
                    try {
                        ((TextView)view).setText(data);
                        no_counter.setText(position+1+"/"+list.size());
                    }
                    catch (ClassCastException ex)
                    {
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);

                    playAnim(view,1,data);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    private void checkAnswer(Button selectedoption) {
        enableoption(false);
        next_btn.setEnabled(true);
        next_btn.setAlpha(1);
        if (selectedoption.getText().toString().equals(list.get(position).getCorrectAns()))
        {
            score++;
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff40")));
            showToast2();
        }
        else {
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff4000")));
            Button correctoption = (Button) options_layout.findViewWithTag(list.get(position).getCorrectAns());
            correctoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00ff40")));
            showToast();

            // Toast toast=Toast.makeText(getApplicationContext(),"wrong question",R.style.WrongToast);
            //toast.setDuration(Toast.LENGTH_LONG);

        }
    }
    public void showToast()
    {
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.toast));

        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }
    public void showToast2()
    {
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.customtoast2,(ViewGroup)findViewById(R.id.toast2));

        Toast toast=new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }
}
