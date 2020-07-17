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

public class Quizswitch extends AppCompatActivity {
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
        setContentView(R.layout.activity_quizswitch);

        question=(TextView)findViewById(R.id.question);
        no_counter=(TextView)findViewById(R.id.counter2);
        options_layout=(LinearLayout)findViewById(R.id.optionlayout);
        next_btn=(Button)findViewById(R.id.next_btn);

        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        list=new ArrayList<QuestionModel>();
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nvoid main()\n{\nswitch(2)\n{\ncase 1:\n  printf(\"hello\");\n  break;\ncase 2:\n  print(\"hai\");\n  break;\ncase3:\n  printf(\"hi\");\n  break;\ndefault:\n  print(\"hey\");\n}\n}","hello","hai","hi","hey","hai"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nvoid main()\n{\nint x=2;\nswitch(x+2)\n{\ncase 1:\n  printf(\"hello\");\ncase 2:\n  printf(\"hai\");\ncase 3:\n  printf(\"hi\");\ndefault:\n  printf(\"hey\")\n}\n}","hello","hai","hi","hey","hai"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\n#define L 10\nvoid main()\n{\nint a=10;\nswitch(a,a*2)\n{\ncase L:\n  printf(\"ABC\");\n  break;\ncase L*2:\n  printf(\"XYZ\");\n  break;\ncase L*3:\n  printf(\"PQR\");\n  break;\ndefault:\n  printf(\"MNO\")\n}\n}","ABC","XYZ","PQR","MNO","XYZ"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nvoid main()\n{\ndouble ch;\nprintf(\"enter a value between 1 to 2\");\nscanf(\"%c\",&ch);\nswitch(ch);\ncase 1:\n  printf(\"1\");\n  break;\ncase 2:\n  printf(\"2\");\n  break;\n}\n}" ,"1","2","compile time error","run time error","compile time error"));
        list.add(new QuestionModel("What will be the output of the following code ?\n#include<stdio.h>\nvoid main()\n{\nint ch=2;\nswitch(ch)\n{\ncase 1:\n  printf(\"1\");\ndefault:\n  printf(\"2\");\n}\n}" ,"1","2","1 2","compile time error","2"));
        list.add(new QuestionModel("What will be the output of the following code ?\n#include<stdio.h>\nvoid main()\n{\nint ch=1;\nswitch(ch)\ncase 1:\n  printf(\"1\");\ndefault:\n  printf(\"2\");\n}\n}" ,"1","2","1 2","compile time error","1 2"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nfloat f=1;\nswitch(f)\n{\ncase 1.0\n  printf(\"hllo\");\n  break;\ndefault:\n  printf(\"hai\");\n}\n}","hllo","hai","hllohai","compile time error","compile time error"));
       // list.add(new QuestionModel("","","","","",""));




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
                    Intent intent=new Intent(Quizswitch.this,Score.class);
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
