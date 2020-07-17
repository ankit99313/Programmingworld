package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class theorycontent extends AppCompatActivity {
    ListView listView;
    String[] st = {"1.First program","2.Constant","3.Data type","4.Variable and Keyword",
    "5.Printf & scanf","6.Operator","7.If and If else","8.Nesting of If else","9.Switch","10.For loop","11.While loop",
    "12.Do while loop","13.Pointer","14.Array","15.Function","16.Recursion","17.Structure and union","18.Enumeration","19.Memory allocation",
    "20.File handling"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theorycontent);
        listView=(ListView)findViewById(R.id.listview);






        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, st);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String listItem = listView.getItemAtPosition(position).toString();

               /** if (listItem == "1.History of C") {
                    Intent intent = new Intent(theorycontent.this, History.class);
                    startActivity(intent);
                } else if (listItem == "2.Importance of C") {
                    Intent intent = new Intent(theorycontent.this, Importance.class);
                    startActivity(intent);
                }**/  if (listItem == "1.First program") {
                    Intent intent = new Intent(theorycontent.this, First.class);
                    startActivity(intent);
                }
                else if (listItem == "2.Constant") {
                    Intent intent = new Intent(theorycontent.this, Constant.class);
                    startActivity(intent);
                }
                else if (listItem == "3.Data type") {
                    Intent intent = new Intent(theorycontent.this, Datatype.class);
                    startActivity(intent);
                } else if (listItem == "4.Variable and Keyword") {
                    Intent intent = new Intent(theorycontent.this, VariableKeyword.class);
                    startActivity(intent);
                }
                else if (listItem == "5.Printf & scanf") {
                    Intent intent = new Intent(theorycontent.this, Sprintf.class);
                    startActivity(intent);
                }
                else if (listItem == "6.Operator") {
                    Intent intent = new Intent(theorycontent.this, Operators.class);
                    startActivity(intent);
                } else if (listItem == "7.If and If else") {
                    Intent intent = new Intent(theorycontent.this, If.class);
                    startActivity(intent);
                }
                else if (listItem == "8.Nesting of If else") {
                    Intent intent = new Intent(theorycontent.this, Nestingif.class);
                    startActivity(intent);
                }
                else if (listItem == "9.Switch") {
                    Intent intent = new Intent(theorycontent.this, Switch.class);
                    startActivity(intent);
                } else if (listItem == "10.For loop") {
                    Intent intent = new Intent(theorycontent.this, For.class);
                    startActivity(intent);
                }
                else if (listItem == "11.While loop") {
                    Intent intent = new Intent(theorycontent.this, Whileloop.class);
                    startActivity(intent);
                }
                else if (listItem == "12.Do while loop") {
                    Intent intent = new Intent(theorycontent.this, Dowhileloop.class);
                    startActivity(intent);
                } else if (listItem == "13.Pointer") {
                    Intent intent = new Intent(theorycontent.this, Pointer.class);
                    startActivity(intent);
                }
                else if (listItem == "14.Array") {
                    Intent intent = new Intent(theorycontent.this, Array.class);
                    startActivity(intent);
                }
                else if (listItem == "15.Function") {
                    Intent intent = new Intent(theorycontent.this, Function.class);
                    startActivity(intent);
                } else if (listItem == "16.Recursion") {
                    Intent intent = new Intent(theorycontent.this, Recursion.class);
                    startActivity(intent);
                }
                else if (listItem == "17.Structure and union") {
                    Intent intent = new Intent(theorycontent.this, Structure.class);
                    startActivity(intent);
                }
                else if (listItem == "18.Enumeration") {
                    Intent intent = new Intent(theorycontent.this, Enumeration.class);
                    startActivity(intent);
                } else if (listItem == "19.Memory allocation") {
                    Intent intent = new Intent(theorycontent.this, Dynamic.class);
                    startActivity(intent);
                }
                else if (listItem == "20.File handling") {
                    Intent intent = new Intent(theorycontent.this, Filehandling.class);
                    startActivity(intent);
                }
            }

        });



    }


}
