package com.programmingworld.ctutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class YourProblems extends AppCompatActivity {
    Toolbar toolbar;
    private FirebaseDatabase mdatabase;
    private DatabaseReference mref,mref2;
    FirebaseListAdapter<ChatMessage> adapter;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_problems);

        toolbar=(Toolbar)findViewById(R.id.toolbar);

        //toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth=FirebaseAuth.getInstance();
        mdatabase=FirebaseDatabase.getInstance();
        mref2=mdatabase.getReference("duplicate");

        displayChatMessages();
    }



    private void displayChatMessages() {

        ListView listOfMessages = (ListView) findViewById(R.id.list_of_messages);




     /*  mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Map<String,Object> data=(Map<String,Object>)snapshot.getValue();
                ;
                String ke=mref.push().getKey();
                Log.d(TAG,"hhheeyy"+ke);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/


        adapter = new FirebaseListAdapter<ChatMessage>(YourProblems.this, ChatMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference("duplicate").child(FirebaseAuth.getInstance().getCurrentUser().getUid())) {

            @Override
            protected void populateView(View v, ChatMessage model, int position) {


                // Get references to the views of message.xml
                TextView messageText = (TextView) v.findViewById(R.id.message_text);
                TextView messageUser = (TextView) v.findViewById(R.id.message_user);
                // TextView messageTime = (TextView)v.findViewById(R.id.message_time);

                LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.mlinear);


                // Set their text
                messageText.setText(model.getMessageText());
                messageUser.setText(model.getMessageUser());
                // Format the date before showing it
                //  messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                //  model.getMessageTime()));



                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(YourProblems.this,Comment.class);
                        startActivity(intent);
                    }
                });




                // String ke=mref.push().getKey();
                // Log.d(TAG,"hhheeyy"+ke);

              /*  linearLayout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences pref = getSharedPreferences("ankit", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();


                        mdatabase=FirebaseDatabase.getInstance();
                        mref=mdatabase.getReference("messages");
                        String ke=mref.push().getKey();

Log.d(ke,"iii");
                        //mref.child(ke).addValueEventListener(new ValueEventListener() {

                        mref.child(ke).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {

                               // for (DataSnapshot childSnapshot :snapshot.getChildren()) {
                                    Log.d("hh","mm");
                                    Log.d(String.valueOf(snapshot.child("messageTime").getValue(long.class)),"hiii");
                              //  }


                                editor.putString("option", String.valueOf(snapshot.child("messageTime").getValue(long.class)));
                                editor.apply();
                                Intent intent = new Intent(getApplicationContext(), Comment.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    }
                });*/

            }

        };

        listOfMessages.setAdapter(adapter);

    }
    }