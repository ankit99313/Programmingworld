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

public class Quizpointer extends AppCompatActivity {
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
        setContentView(R.layout.activity_quizpointer);


        question=(TextView)findViewById(R.id.question);
        no_counter=(TextView)findViewById(R.id.counter2);
        options_layout=(LinearLayout)findViewById(R.id.optionlayout);
        next_btn=(Button)findViewById(R.id.next_btn);

        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        list=new ArrayList<QuestionModel>();

        //list.add(new QuestionModel("Comment on the following pointer declaration ?","ptr is a pointer to integer, p is not.","ptr and p, both are pointers to integer.","ptr is pointer to integer, p may or may not be.","ptr and p both are not pointers to integer.","ptr is a pointer to integer, p is not."));
        list.add(new QuestionModel("The declaration\nint(*p)[5];\nmeans","p is one dimensional array of size 5, of pointers to integers.","p is a pointer to a 5 elements integer array.","The same as int *p","None of these.","p is a pointer to a 5 elements integer array."));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nvoid main()\n{\nint *ptr, a=10;\nptr=&a;\n*ptr+=1;\nprintf(\"%d, %d\", *ptr ,a);\n}","10, 10","10, 11","11, 10","11, 11","11, 11"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nvoid main()\n{\nint i=4, *j, **k;\nj=&i;\nk=&j;\nprintf(\"%d%d%d\", *j, **k, *(*k));\n}","444","000","333","334","444"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<stdio.h>\nvoid main()\n{\nchar *msg='hi';\nprintf(msg);\n}","hi","h","compile time error","run time error","hi"));
        list.add(new QuestionModel("What will be the output of the following C code ?\n#include<Stdio.h>\nvoid main()\n{\nprintf(\"%d,%d\",sizeof(int*),sizeof(int**));\n}","0,2","2,0","2,2","4,4","2,2"));
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
                    Intent intent=new Intent(Quizpointer.this,Score.class);
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
