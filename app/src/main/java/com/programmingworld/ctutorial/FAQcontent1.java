package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FAQcontent1 extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> topics1;
    Map<String,List<String>> subtopics1;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqcontent1);

        expandableListView=(ExpandableListView)findViewById(R.id.expandablelistview1);
        filldata1();

        expandableListAdapter=new MyExpandableListView(this,topics1,subtopics1);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String iii=subtopics1.get(topics1.get(groupPosition)).get(childPosition);

                //Basic content

                if (iii=="1.What is scope of a variable ?How are variables scoped in C ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fbasic1.class);
                    startActivity(intent);
                }

                if (iii=="2.What are local static variables ?What is their use ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fbasic2.class);
                    startActivity(intent);
                }

                if (iii=="3.Write down the smallest executable code")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fbasic3.class);
                    startActivity(intent);
                }

                if (iii=="4.What is the difference between including the header file with in angular braces and double quotes ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fbasic4.class);
                    startActivity(intent);
                }

                if (iii=="5.Describe the difference between = and == symbols in C programming ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fbasic5.class);
                    startActivity(intent);
                }

                if (iii=="6.What are entry control and exit control loops ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fbasic6.class);
                    startActivity(intent);
                }

                //Poionter content

                if (iii=="1.What is difference between array and pointer ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fpon1.class);
                    startActivity(intent);
                }

                if (iii=="2.What is null pointer ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fpon2.class);
                    startActivity(intent);
                }

                if (iii=="3.What id dangling pointer ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fpon3.class);
                    startActivity(intent);
                }

                if (iii=="4.What is wild pointer ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fpon4.class);
                    startActivity(intent);
                }

                if (iii=="5.Can we add two pointers ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fpon5.class);
                    startActivity(intent);
                }

                //Array content

                if (iii=="1.Can we declare array size as a negative number ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Farr1.class);
                    startActivity(intent);
                }


                if (iii=="2.When will we get ArrayStoreException")
                {
                    Intent intent=new Intent(FAQcontent1.this,Farr2.class);
                    startActivity(intent);
                }

                if (iii=="3.Is there any difference between int[ ] a and int a[ ] ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Farr3.class);
                    startActivity(intent);
                }

                if (iii=="4.How do we search a specific element in an array ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Farr4.class);
                    startActivity(intent);
                }

                if (iii=="5.How much memory does the following arr variable will be take ? int arr[25];")
                {
                    Intent intent=new Intent(FAQcontent1.this,Farr5.class);
                    startActivity(intent);
                }

                if (iii=="6.What is the default value of Array?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Farr6.class);
                    startActivity(intent);
                }

                //Function content

                if (iii=="1.What is difference between declaration and defintion of function ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffun1.class);
                    startActivity(intent);
                }

                if (iii=="2.What is static function  ?What is their use ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffun2.class);
                    startActivity(intent);
                }

                if (iii=="3.Why do we need prototype in function ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffun3.class);
                    startActivity(intent);
                }

                if (iii=="4.How many parameters a function should have ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffun4.class);
                    startActivity(intent);
                }

                if (iii=="5.What is difference between call by value and call by reference ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffun5.class);
                    startActivity(intent);
                }

                //Structure content

                if (iii=="1.What is structure  and union ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fstr1.class);
                    startActivity(intent);
                }

                if (iii=="2.Difference between array and structure")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fstr2.class);
                    startActivity(intent);
                }

                if (iii=="3.What is user-defined data type ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fstr3.class);
                    startActivity(intent);
                }

                //Memory content
                if (iii=="1.Explain the concept of Dynamic Memory Allocation (DMA) ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fmem0.class);
                    startActivity(intent);
                }

                if (iii=="2.What is difference between malloc( ) and calloc( ) ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fmem1.class);
                    startActivity(intent);
                }

                if (iii=="3.What is static and dynamic memory allocation  ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fmem2.class);
                    startActivity(intent);
                }

                if (iii=="4.What is memory leak ?How to avoid this memory leak ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Fmem3.class);
                    startActivity(intent);
                }


                //File content

                if (iii=="1.What is FILES in C and its type ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffile1.class);
                    startActivity(intent);
                }

                if (iii=="2.Error handling")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffile2.class);
                    startActivity(intent);
                }

                if (iii=="3.What happen if we don't close a FILE ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffile3.class);
                    startActivity(intent);
                }

                if (iii=="4.What is a file pointer ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffile4.class);
                    startActivity(intent);
                }

                if (iii=="5.What is the purpose of rewind() ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffile5.class);
                    startActivity(intent);
                }

                if (iii=="6.What is difference between file opening mode r+ and w+ in C ?")
                {
                    Intent intent=new Intent(FAQcontent1.this,Ffile6.class);
                    startActivity(intent);
                }


                return false;
            }
        });


    }

    public void filldata1()
    {
        topics1=new ArrayList<String>();
        subtopics1=new HashMap<>();

        topics1.add("1. Basic");
        topics1.add("2. Pointer");
        topics1.add("3. Array");
        topics1.add("4. Function");
        topics1.add("5. Structure and Union");
        topics1.add("6. Memory allocation");
        topics1.add("7. File handling");

        List<String>Basics=new ArrayList<>();
        List<String>Pointer=new ArrayList<>();
        List<String>Array=new ArrayList<>();
        List<String>Function=new ArrayList<>();
        List<String>Structure=new ArrayList<>();
        List<String>Memory=new ArrayList<>();
        List<String>File=new ArrayList<>();

        Basics.add("1.What is scope of a variable ?How are variables scoped in C ?");
        Basics.add("2.What are local static variables ?What is their use ?");
        Basics.add("3.Write down the smallest executable code");
        Basics.add("4.What is the difference between including the header file with in angular braces and double quotes ?");
        Basics.add("5.Describe the difference between = and == symbols in C programming ?");
        Basics.add("6.What are entry control and exit control loops ?");

        Pointer.add("1.What is difference between array and pointer ?");
        Pointer.add("2.What is null pointer ?");
        Pointer.add("3.What id dangling pointer ?");
        Pointer.add("4.What is wild pointer ?");
        Pointer.add("5.Can we add two pointers ?");

        Array.add("1.Can we declare array size as a negative number ?");
        Array.add("2.When will we get ArrayStoreException");
        Array.add("3.Is there any difference between int[ ] a and int a[ ] ?");
        Array.add("4.How do we search a specific element in an array ?");
        Array.add("5.How much memory does the following arr variable will be take ? int arr[25];");
        Array.add("6.What is the default value of Array?");

        Function.add("1.What is difference between declaration and defintion of function ?");
        Function.add("2.What is static function  ?What is their use ?");
        Function.add("3.Why do we need prototype in function ?");
        Function.add("4.How many parameters a function should have ?");
        Function.add("5.What is difference between call by value and call by reference ?");

        Structure.add("1.What is structure  and union ?");
        Structure.add("2.Difference between array and structure");
        Structure.add("3.What is user-defined data type ?");

        Memory.add("1.Explain the concept of Dynamic Memory Allocation (DMA) ?");
        Memory.add("2.What is difference between malloc( ) and calloc( ) ?");
        Memory.add("3.What is static and dynamic memory allocation  ?");
        Memory.add("4.What is memory leak ?How to avoid this memory leak ?");

        File.add("1.What is FILES in C and its type ?");
        File.add("2.Error handling");
        File.add("3.What happen if we don't close a FILE ?");
        File.add("4.What is a file pointer ?");
        File.add("5.What is the purpose of rewind() ?");
        File.add("6.What is difference between file opening mode r+ and w+ in C ?");

        subtopics1.put(topics1.get(0),Basics);
        subtopics1.put(topics1.get(1),Pointer);
        subtopics1.put(topics1.get(2),Array);
        subtopics1.put(topics1.get(3),Function);
        subtopics1.put(topics1.get(4),Structure);
        subtopics1.put(topics1.get(5),Memory);
        subtopics1.put(topics1.get(6), File);


    }
}
