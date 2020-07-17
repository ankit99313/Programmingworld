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

public class Quizarray extends AppCompatActivity {
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
        setContentView(R.layout.activity_quizarray);

        question=(TextView)findViewById(R.id.question);
        no_counter=(TextView)findViewById(R.id.counter2);
        options_layout=(LinearLayout)findViewById(R.id.optionlayout);
        next_btn=(Button)findViewById(R.id.next_btn);

        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        list=new ArrayList<QuestionModel>();
        list.add(new QuestionModel("Choose a correct statement about C language arrays.","An array address is the address of first element of array itself.","An array size must be declared if not initialized immediately.","Array size is the sum of sizes of all elements of the array.","All the above","All the above"));
        list.add(new QuestionModel("An array index starts with ?","0","1","-1","None of the above","0"));
        list.add(new QuestionModel("What is the output of following C program ?\n#include<stdio.h>\nint main()\n{\nint a[  ];\na[3]={1,2,3};\nprintf(\"%d\", a[0]);\n}","1","2","3","error","1"));list.add(new QuestionModel("","","","","",""));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<Stdio.h>\nint mian()\n{\nint a[]={1,2,3,4};\nint b[4]={5,6,7,8};\nprintf(\"%d,%d\",a[0],b[0]);\n}","1,6","2,6","1,5","error","1,5"));
        list.add(new QuestionModel("Choose the correct output ?\n#include<stdio.h>\nint main()\n{\nfloat marks[3]={90.5,92.5,96.5};\nint a=0;\nwhile(a<3)\n{\nprintf(\"%.2f\", marks[a]);\na++\n}\nreturn 0;\n}","90.5,92.5,96.5","90.5,92.5","0,0,0","90.50,92.50,96.50","90.50,92.50,96.50"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nint main()\n{\nint a[3]={11,12,13};\na[1]=20;\nint i=0\nwhile(i<3)\n{\nprintf(\"%d\",a[i]);\ni++;\n}\n}","11,20,13","11,12,13","20,12,13","20,11,12","11,20,13"));
        list.add(new QuestionModel("Choose the correct output ?\n#include<stdio.h>\nint main()\n{\nint a[3]={11,12,13};\nint b[3];\nb=a;\nprintf(\"%d\",b[0]);\nreturn 0;\n}","11","12","13","compile time error","compile time error"));
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
                    Intent intent=new Intent(Quizarray.this,Score.class);
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
