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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Comment extends AppCompatActivity {
    private static final String TAG = "rrr";
    TextView usertext;
    private FirebaseDatabase mdatabase;
    private DatabaseReference mre;
    FirebaseListAdapter<ChatMessage> adapte;
    FirebaseAuth auth;
    ProgressBar progressBar;
    Toolbar toolbar;
    //long user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        auth = FirebaseAuth.getInstance();
        mdatabase = FirebaseDatabase.getInstance();
        mre = mdatabase.getReference("comment");


        toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        usertext = (TextView) findViewById(R.id.usertext);


        //usertext.se(userkey);

        Intent i = getIntent();
        //String tv=i.getStringExtra("Message");
        long user = i.getLongExtra("Time", 0);


        FloatingActionButton fab =
                (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText) findViewById(R.id.input);

                mre.child(String.valueOf(user)).push().setValue(new ChatMessage(input.getText().toString(), auth.getCurrentUser().getDisplayName(), user));


                input.setText("");
            }


        });


        displaycommentmessage();

    }


    private void displaycommentmessage() {

        SharedPreferences pref=getSharedPreferences("ankit", Context.MODE_PRIVATE);


        String gg= pref.getString("option","nhi mm");






















            ListView listOfMessages = (ListView) findViewById(R.id.list_of_messages);

            FirebaseListAdapter<ChatMessage> adapter = new FirebaseListAdapter<ChatMessage>(Comment.this, ChatMessage.class,
                    R.layout.message, FirebaseDatabase.getInstance().getReference("comment").child(gg))
        {

                @Override
                protected void populateView(View v, ChatMessage model, int position) {






                            // Get references to the views of message.xml
                            TextView messageText = (TextView) v.findViewById(R.id.message_text);
                            TextView messageUser = (TextView) v.findViewById(R.id.message_user);
                            // TextView messageTime = (TextView)v.findViewById(R.id.message_time);


                            // Set their text

                            messageText.setText(model.getMessageText());
                            messageUser.setText(model.getMessageUser());
                            // Format the date before showing it
                            //  messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                            //  model.getMessageTime()));

                    //progressBar.setVisibility(View.GONE);



                }

            };

            listOfMessages.setAdapter(adapter);


       // Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();

    }



}
























