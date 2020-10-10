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

public class Quizfunction extends AppCompatActivity {
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
        setContentView(R.layout.activity_quizfunction);

        question=(TextView)findViewById(R.id.question);
        no_counter=(TextView)findViewById(R.id.counter2);
        options_layout=(LinearLayout)findViewById(R.id.optionlayout);
        next_btn=(Button)findViewById(R.id.next_btn);

        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        list=new ArrayList<QuestionModel>();

        list.add(new QuestionModel("Which of the following is a correct format for declaration of function?","return-type function-name(argument type);","return-type function-name(argument type) {}","return-type (argument type)function-name;","Both (a) and (b)","return-type function-name(argument type);"));
        list.add(new QuestionModel("Which function definition will run correctly?\nA.  int sum(int a, int b)\nreturn (a + b);\nB.  int sum(int a, int b)\n{return (a + b);}\nC.  int sum(a, b)\nreturn (a + b);\nD. Both (a) and (b)","A","B","C","D","B"));
        list.add(new QuestionModel("What is the output of the following C code ?\n#include<stdio.h>\nvoid foo(void);\nint main()\n{\nfoo();\nreturn 0;\n}\nvoid foo()\n{\nprintf(\"2\");\n}","No output","Compile time error","0","2","2"));
        list.add(new QuestionModel("What is the output of this code ?\n#include<stdio.h>\nvoid m()\n{\nprintf(\"hi\");\n}\nvoid main()\n{\nm();\n}","hi","0","No output","Run time error","hi"));
        list.add(new QuestionModel("What is the output of this code ?\n#include<stdio.h>\nvoid main()\n{\nm()\n}\nvoid m()\n{\nprintf(\"hi\");\nm();\n} ","hi","infinite hi","error","hihi","hihi"));
        list.add(new QuestionModel("What is the output of this code ?\n#include<stdio.h>\nvoid foo()\n{\nreturn 1;\n}\nvoid main()\n{\nint x;\nx=foo();\nprintf(\"%d\",x);\n}","1","No output","Compile time error","Run time error","1"));
        list.add(new QuestionModel("What is the output of the following C code ?\n#include<stdio.h>\nint *m()\n{\nint *p=5;\nreturn p;\n}\nvoid main()\n{\nint *k=m();\nprintf(\"%d\",k);\n}","5","0","error","Address of an integer","5"));
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
                    Intent intent=new Intent(Quizfunction.this,Score.class);
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
                options_layout.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
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
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#008000")));
            showToast2();
        }
        else {
            selectedoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
            Button correctoption = (Button) options_layout.findViewWithTag(list.get(position).getCorrectAns());
            correctoption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#008000")));
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
