package com.programmingworld.ctutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChatActivity extends AppCompatActivity {

    private static final int SIGN_IN_REQUEST_CODE =1 ;
    FirebaseListAdapter<ChatMessage> adapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();
    FirebaseAuth auth;

    DatabaseReference ref2,ref3,ref4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        auth=FirebaseAuth.getInstance();



        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);



        FloatingActionButton fab =
                (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText)findViewById(R.id.input);
                ref2=databaseReference.child("User");
                // String userId=
                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
                databaseReference.child("User").child(auth.getCurrentUser().getUid()).push().setValue(new ChatMessage(input.getText().toString(),auth.getCurrentUser().getDisplayName()));
                /*FirebaseDatabase.getInstance()
                        .getReference()
                        .push()
                        .setValue(new ChatMessage(input.getText().toString(),
                                FirebaseAuth.getInstance()
                                        .getCurrentUser()
                                        .getDisplayName())
                        );*/

                // Clear the input
                input.setText("");
            }


        });


        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            // Start sign in/sign up activity
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .build(),
                    SIGN_IN_REQUEST_CODE
            );
        } else {
            ListView listOfMessages = (ListView)findViewById(R.id.list_of_messages);
            // User is already signed in. Therefore, display
            // a welcome Toast
            /** Toast.makeText(this,
             "Welcome " + FirebaseAuth.getInstance()
             .getCurrentUser()
             .getDisplayName(),
             Toast.LENGTH_LONG)
             .show();**/

            // Load chat room contents
            displayChatMessages();


           /* final DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference().child("User");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1 :dataSnapshot.getChildren())
                    {
                        String value=String.valueOf(dataSnapshot1.child(auth.getCurrentUser().getUid()).getValue());
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*/
        }


        // ref3 = FirebaseDatabase.getInstance().getReference().child("User");





    }






    private void displayChatMessages()
    {
        ListView listOfMessages = (ListView)findViewById(R.id.list_of_messages);



        adapter = new FirebaseListAdapter<ChatMessage>(ChatActivity.this, ChatMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference("User")) {


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
                //   model.getMessageTime()));


            }
        };

        listOfMessages.setAdapter(adapter);


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_IN_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();
                displayChatMessages();
            } else {
                Toast.makeText(this,
                        "We couldn't sign you in. Please try again later.",
                        Toast.LENGTH_LONG)
                        .show();

                // Close the app

            }
        }

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_sign_out) {
            AuthUI.getInstance().signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(ChatActivity.this,
                                    "You have been signed out.",
                                    Toast.LENGTH_LONG)
                                    .show();

                            // Close activity
                            finish();
                        }
                    });
        }
        return true;
    }
}
