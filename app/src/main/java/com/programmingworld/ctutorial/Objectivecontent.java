package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Objectivecontent extends AppCompatActivity {
    ListView listView;
    String[] st = {"1.Basic","2.Operator","3.If and If else","4.Switch","5.Loop","6.Pointer","7.Array","8.Function","9.Structure and Union",
    "10.Memory allocation","11.File handling"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectivecontent);

        listView=(ListView)findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, st);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listItem = listView.getItemAtPosition(position).toString();

                if (listItem == "1.Basic") {
                    Intent intent = new Intent(Objectivecontent.this, Quizbasic.class);
                    startActivity(intent);
                } else if (listItem == "2.Operator") {
                    Intent intent = new Intent(Objectivecontent.this, Quizoperator.class);
                    startActivity(intent);
                } else if (listItem == "3.If and If else") {
                    Intent intent = new Intent(Objectivecontent.this, Quizifelse.class);
                    startActivity(intent);
                } else if (listItem == "4.Switch") {
                    Intent intent = new Intent(Objectivecontent.this, Quizswitch.class);
                    startActivity(intent);
                } else if (listItem == "5.Loop") {
                    Intent intent = new Intent(Objectivecontent.this, Quizloop.class);
                    startActivity(intent);
                } else if (listItem == "6.Pointer") {
                    Intent intent = new Intent(Objectivecontent.this, Quizpointer.class);
                    startActivity(intent);
                } else if (listItem == "7.Array") {
                    Intent intent = new Intent(Objectivecontent.this, Quizarray.class);
                    startActivity(intent);
                } else if (listItem == "8.Function") {
                    Intent intent = new Intent(Objectivecontent.this, Quizfunction.class);
                    startActivity(intent);
                } else if (listItem == "9.Structure and Union") {
                    Intent intent = new Intent(Objectivecontent.this, Quizstructure.class);
                    startActivity(intent);
                }
                else if (listItem == "10.Memory allocation") {
                    Intent intent = new Intent(Objectivecontent.this, Quizmemory.class);
                    startActivity(intent);
                }
                else if (listItem == "11.File handling") {
                    Intent intent = new Intent(Objectivecontent.this, Quizfilehandling.class);
                    startActivity(intent);
                }
            }
            });
                                        }
    }



