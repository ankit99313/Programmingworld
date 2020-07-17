package com.programmingworld.ctutorial;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Programcontent1 extends AppCompatActivity {
    ExpandableListView expandableListView;
    List<String> topics;
    Map<String,List<String>> subtopics;
    ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programcontent1);

        expandableListView=(ExpandableListView)findViewById(R.id.expandablelistview);
        fill();

        listAdapter=new MyExpandableListView(this,topics,subtopics);
        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String ii=subtopics.get(topics.get(groupPosition)).get(childPosition);

                //Operator content

                if (ii=="1.Arithmetic operator")
                {
                    Intent intent=new Intent(Programcontent1.this,Operator1.class);
                    startActivity(intent);
                }

                if (ii=="2.Relational Operators")
                {
                    Intent intent=new Intent(Programcontent1.this,Operator2.class);
                    startActivity(intent);
                }

                if (ii=="3.Logical operator")
                {
                    Intent intent=new Intent(Programcontent1.this,Operator3.class);
                    startActivity(intent);
                }

                if (ii=="4.Assignment operator")
                {
                    Intent intent=new Intent(Programcontent1.this,Operator4.class);
                    startActivity(intent);
                }

                if (ii=="5.Bitwise operator")
                {
                    Intent intent=new Intent(Programcontent1.this,Operator5.class);
                    startActivity(intent);
                }

                if (ii=="6.Increment/Decrement operator")
                {
                    Intent intent=new Intent(Programcontent1.this,Operator6.class);
                    startActivity(intent);
                }

                //If and else content

                if (ii=="1.Finding two numbers are equal or not")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif1.class);
                    startActivity(intent);
                }

                if (ii=="2.Finding greatest numbers between two numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif2.class);
                    startActivity(intent);
                }

                if (ii=="3.Finding roots of a quadritc equation")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif3.class);
                    startActivity(intent);
                }

                if (ii=="4.Checking given number is positive, negative or equal to zero")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif4.class);
                    startActivity(intent);
                }

                if (ii=="5.Checking given numbers are odd or even")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif5.class);
                    startActivity(intent);
                }

                if (ii=="6.Check a number is divisible by 5 or not")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif6.class);
                    startActivity(intent);
                }

                if (ii=="7.Checking character is vowel or consonent")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif7.class);
                    startActivity(intent);
                }

                if (ii=="8.Calculating profit and loss")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif8.class);
                    startActivity(intent);
                }

                if (ii=="9.Finding greatest number among three numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pif9.class);
                    startActivity(intent);
                }

                //Switch content

                if (ii=="1.Finding the day of week")
                {
                    Intent intent=new Intent(Programcontent1.this,Psw1.class);
                    startActivity(intent);
                }

                if (ii=="2.Finding the input characteer is vowel or consonent")
                {
                    Intent intent=new Intent(Programcontent1.this,Psw2.class);
                    startActivity(intent);
                }

                if (ii=="3.Checking number is odd or even using switch")
                {
                    Intent intent=new Intent(Programcontent1.this,Psw3.class);
                    startActivity(intent);
                }

                if (ii=="4.Simple calculator program")
                {
                    Intent intent=new Intent(Programcontent1.this,Psw4.class);
                    startActivity(intent);
                }

                //For loop content

                if (ii=="1.Program to display first 10 natural numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfl1.class);
                    startActivity(intent);
                }

                if (ii=="2.Program of sum of first 10 natural numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfl2.class);
                    startActivity(intent);
                }

                if (ii=="3.Program to find sum of n natural numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfl3.class);
                    startActivity(intent);
                }

                if (ii=="4.Program to display the cube of the number upto given an integer")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfl4.class);
                    startActivity(intent);
                }

                if (ii=="5.Finding the factorial of given number")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfl5.class);
                    startActivity(intent);
                }

                if (ii=="6.Printing pattern like right angle triangle")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfl6.class);
                    startActivity(intent);
                }

                //While loop content
                if (ii=="1.Print numbers from 1 to N using while loop")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl1.class);
                    startActivity(intent);
                }

                if (ii=="2.Print even numbers from 1 to N using while loop")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl2.class);
                    startActivity(intent);
                }

                if (ii=="3.Finding sum of n numbers using while loop")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl3.class);
                    startActivity(intent);
                }

                if (ii=="4.Finding Sum of the digits of given Number using while loop")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl4.class);
                    startActivity(intent);
                }

                if (ii=="5.Print first and last digits of integer using while loop")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl5.class);
                    startActivity(intent);
                }

                if (ii=="6.Print first n natural number using do-while loop")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl6.class);
                    startActivity(intent);
                }

                if (ii=="7.Print digits of integer in reverse order")
                {
                    Intent intent=new Intent(Programcontent1.this,Pwl7.class);
                    startActivity(intent);
                }
                //Pointer content

                if (ii=="1.Printing address of given variable")
                {
                    Intent intent=new Intent(Programcontent1.this,Ppo1.class);
                    startActivity(intent);
                }

                if (ii=="2.Addition of two numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Ppo2.class);
                    startActivity(intent);
                }

                if (ii=="3.Printing first n natural numbers using pointer")
                {
                    Intent intent=new Intent(Programcontent1.this,Ppo3.class);
                    startActivity(intent);
                }

                if (ii=="4.Program to exchange the values stored in two memory location using pointers")
                {
                    Intent intent=new Intent(Programcontent1.this,Ppo4.class);
                    startActivity(intent);
                }

                //Array content

                if (ii=="1.Print all the elements of array")
                {
                    Intent intent=new Intent(Programcontent1.this,Par1.class);
                    startActivity(intent);
                }

                if (ii=="2.Write a program to find greatest among 10 numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Par2.class);
                    startActivity(intent);
                }

                if (ii=="3.Write a program to find the average of five numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Par21.class);
                    startActivity(intent);
                }

                if (ii=="4.Write a program to add two matrices,each of order 2*2")
                {
                    Intent intent=new Intent(Programcontent1.this,Par3.class);
                    startActivity(intent);
                }

                if (ii=="5.Write a program to find the sum of diagonal elements of a m*n matrix")
                {
                    Intent intent=new Intent(Programcontent1.this,Par4.class);
                    startActivity(intent);
                }

                if (ii=="6.Search an element in array")
                {
                    Intent intent=new Intent(Programcontent1.this,Par6.class);
                    startActivity(intent);
                }

                if (ii=="7.Reverse the element of array")
                {
                    Intent intent=new Intent(Programcontent1.this,Par7.class);
                    startActivity(intent);
                }

                //Function content

                if (ii=="1.Function with no return type and no parameter")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu1.class);
                    startActivity(intent);
                }

                if (ii=="2.Function with no return type and with parameter")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu2.class);
                    startActivity(intent);
                }

                if (ii=="3.Function with return type and no parameter")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu3.class);
                    startActivity(intent);
                }

                if (ii=="4.Function with return type and with parameter")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu4.class);
                    startActivity(intent);
                }

                if (ii=="5.Check whether year is leap or not")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu5.class);
                    startActivity(intent);
                }

                if (ii=="6.Swap two number using function")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu6.class);
                    startActivity(intent);
                }

                if (ii=="7.Check whether character is upper case or lower case")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu7.class);
                    startActivity(intent);
                }

                if (ii=="8.Convert decimal number into binary number using function")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfu8.class);
                    startActivity(intent);
                }

                //Recursion content

                if (ii=="1.Program to find factorial of a number using recursion")
                {
                    Intent intent=new Intent(Programcontent1.this,Pre1.class);
                    startActivity(intent);
                }

                if (ii=="2.Program to find sum of n natural number using recursion")
                {
                    Intent intent=new Intent(Programcontent1.this,Pre2.class);
                    startActivity(intent);
                }

                //Structur and content

                if (ii=="1.Addition program using structure")
                {
                    Intent intent=new Intent(Programcontent1.this,Pst1.class);
                    startActivity(intent);
                }

                if (ii=="2.Store user input in structue variable")
                {
                    Intent intent=new Intent(Programcontent1.this,Pst2.class);
                    startActivity(intent);
                }

                if (ii=="3.Passing structure as argument")
                {
                    Intent intent=new Intent(Programcontent1.this,Pst3.class);
                    startActivity(intent);
                }

                if (ii=="4.Program of nested structure")
                {
                    Intent intent=new Intent(Programcontent1.this,Pst4.class);
                    startActivity(intent);
                }

                //Dynamic content

                if (ii=="1.malloc and free")
                {
                    Intent intent=new Intent(Programcontent1.this,Pdy1.class);
                    startActivity(intent);
                }

                if (ii=="2.calloc and free")
                {
                    Intent intent=new Intent(Programcontent1.this,Pdy2.class);
                    startActivity(intent);
                }

                if (ii=="3.realloc")
                {
                    Intent intent=new Intent(Programcontent1.this,Pdy3.class);
                    startActivity(intent);
                }

                //File handling

                if (ii=="1.Open a file and write text into it")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfi1.class);
                    startActivity(intent);
                }

                if (ii=="2.Reading a text file")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfi2.class);
                    startActivity(intent);
                }

                if (ii=="3.Rename the file")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfi3.class);
                    startActivity(intent);
                }

                if (ii=="4.Write a program in C to Find the Number of Lines in a Text File")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfi4.class);
                    startActivity(intent);
                }

                if (ii=="5.Write a program in C to count number of words and characters in a file")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfi5.class);
                    startActivity(intent);
                }

                if (ii=="6.Delete a file")
                {
                    Intent intent=new Intent(Programcontent1.this,Pfi6.class);
                    startActivity(intent);
                }

                //Pattern program

                if (ii=="1.Program to print solid rectangular star pattern")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern1.class);
                    startActivity(intent);
                }

                if (ii=="2.Program to print half pyramid pattern using stars")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern2.class);
                    startActivity(intent);
                }

                if (ii=="3.Program to print inverted half pyramid pattern using stars")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern3.class);
                    startActivity(intent);
                }

                if (ii=="4.Half pyramid pattern using numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern4.class);
                    startActivity(intent);
                }

                if (ii=="5.Inverted half pyramid pattern using numbers")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern5.class);
                    startActivity(intent);
                }

                if (ii=="6.Half pyramid pattern using alphabet")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern6.class);
                    startActivity(intent);
                }

                if (ii=="7.solid rectangular program using alphabet")
                {
                    Intent intent=new Intent(Programcontent1.this,Pattern7.class);
                    startActivity(intent);
                }


                return false;
            }
        });


    }

    public void fill() {
        topics = new ArrayList<String>();
        subtopics=new HashMap<>();

        topics.add("1.Operator");
        topics.add("2.If and If else");
        topics.add("3.Switch");
        topics.add("4.For loop");
        topics.add("5.While loop");
        topics.add("6.Pointer");
        topics.add("7.Array");
        topics.add("8.Function");
        topics.add("9.Recursion");
        topics.add("10.Structure and union");
        topics.add("11.Dynamic memory allocation");
        topics.add("12.File handling");
        topics.add("13.Pattern program");

        List<String>Operator=new ArrayList<>();
        List<String>If=new ArrayList<>();
        List<String>Switch=new ArrayList<>();
        List<String>For=new ArrayList<>();
        List<String>While=new ArrayList<>();
        List<String>Pointer=new ArrayList<>();
        List<String>Array=new ArrayList<>();
        List<String>Function=new ArrayList<>();
        List<String>Recursion=new ArrayList<>();
        List<String>Structure=new ArrayList<>();
        List<String>Dynamic=new ArrayList<>();
        List<String>File=new ArrayList<>();
        List<String>Pattern=new ArrayList<>();

        Operator.add("1.Arithmetic operator");
        Operator.add("2.Relational Operators");
        Operator.add("3.Logical operator");
        Operator.add("4.Assignment operator");
        Operator.add("5.Bitwise operator");
        Operator.add("6.Increment/Decrement operator");

        If.add("1.Finding two numbers are equal or not");
        If.add("2.Finding greatest numbers between two numbers");
        If.add("3.Finding roots of a quadritc equation");
        If.add("4.Checking given number is positive, negative or equal to zero");
        If.add("5.Checking given numbers are odd or even");
        If.add("6.Check a number is divisible by 5 or not");
        If.add("7.Checking character is vowel or consonent");
        If.add("8.Calculating profit and loss");
        If.add("9.Finding greatest number among three numbers");

        Switch.add("1.Finding the day of week");
        Switch.add("2.Finding the input characteer is vowel or consonent");
        Switch.add("3.Checking number is odd or even using switch");
        Switch.add("4.Simple calculator program");

        For.add("1.Program to display first 10 natural numbers");
        For.add("2.Program of sum of first 10 natural numbers");
        For.add("3.Program to find sum of n natural numbers");
        For.add("4.Program to display the cube of the number upto given an integer");
        For.add("5.Finding the factorial of given number");
        For.add("6.Printing pattern like right angle triangle");

        While.add("1.Print numbers from 1 to N using while loop");
        While.add("2.Print even numbers from 1 to N using while loop");
        While.add("3.Finding sum of n numbers using while loop");
        While.add("4.Finding Sum of the digits of given Number using while loop");
        While.add("5.Print first and last digits of integer using while loop");
        While.add("6.Print first n natural number using do-while loop");
        While.add("7.Print digits of integer in reverse order");

        Pointer.add("1.Printing address of given variable");
        Pointer.add("2.Addition of two numbers");
        Pointer.add("3.Printing first n natural numbers using pointer");
        Pointer.add("4.Program to exchange the values stored in two memory location using pointers");

        Array.add("1.Print all the elements of array");
        Array.add("2.Write a program to find greatest among 10 numbers");
        Array.add("3.Write a program to find the average of five numbers");
        Array.add("4.Write a program to add two matrices,each of order 2*2");
        Array.add("5.Write a program to find the sum of diagonal elements of a m*n matrix");
        Array.add("6.Search an element in array");
        Array.add("7.Reverse the element of array");

        Function.add("1.Function with no return type and no parameter");
        Function.add("2.Function with no return type and with parameter");
        Function.add("3.Function with return type and no parameter");
        Function.add("4.Function with return type and with parameter");
        Function.add("5.Check whether year is leap or not");
        Function.add("6.Swap two number using function");
        Function.add("7.Check whether character is upper case or lower case");
        Function.add("8.Convert decimal number into binary number using function");

        Recursion.add("1.Program to find factorial of a number using recursion");
        Recursion.add("2.Program to find sum of n natural number using recursion");

        Structure.add("1.Addition program using structure");
        Structure.add("2.Store user input in structue variable");
        Structure.add("3.Passing structure as argument");
        Structure.add("4.Program of nested structure");

        Dynamic.add("1.malloc and free");
        Dynamic.add("2.calloc and free");
        Dynamic.add("3.realloc");

        File.add("1.Open a file and write text into it");
        File.add("2.Reading a text file");
        File.add("3.Rename the file");
        File.add("4.Write a program in C to Find the Number of Lines in a Text File");
        File.add("5.Write a program in C to count number of words and characters in a file");
        File.add("6.Delete a file");

        Pattern.add("1.Program to print solid rectangular star pattern");
        Pattern.add("2.Program to print half pyramid pattern using stars");
        Pattern.add("3.Program to print inverted half pyramid pattern using stars");
        Pattern.add("4.Half pyramid pattern using numbers");
        Pattern.add("5.Inverted half pyramid pattern using numbers");
        Pattern.add("6.Half pyramid pattern using alphabet");
        Pattern.add("7.solid rectangular program using alphabet");


        subtopics.put(topics.get(0),Operator);
        subtopics.put(topics.get(1),If);
        subtopics.put(topics.get(2),Switch);
        subtopics.put(topics.get(3),For);
        subtopics.put(topics.get(4),While);
        subtopics.put(topics.get(5),Pointer);
        subtopics.put(topics.get(6),Array);
        subtopics.put(topics.get(7),Function);
        subtopics.put(topics.get(8),Recursion);
        subtopics.put(topics.get(9),Structure);
        subtopics.put(topics.get(10),Dynamic);
        subtopics.put(topics.get(11),File);
        subtopics.put(topics.get(12),Pattern);


    }
}
