package com.programmingworld.ctutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.solver.widgets.Snapshot;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.data.model.User;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class ChatActivity extends AppCompatActivity {
    private static final String TAG ="ooo";
    private FirebaseDatabase mdatabase;
    private DatabaseReference mref,mref2;
    Toolbar toolbar;

    private static final int SIGN_IN_REQUEST_CODE =1 ;
    FirebaseListAdapter<ChatMessage> adapter;
    //FirebaseDatabase database = getInstance();
   // DatabaseReference databaseReference = database.getReference("Messages");


    FirebaseAuth auth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar=(ProgressBar)findViewById(R.id.progress_bar);

        auth=FirebaseAuth.getInstance();
        mdatabase=FirebaseDatabase.getInstance();
        mref=mdatabase.getReference("messages");
        mref2=mdatabase.getReference("duplicate");


        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);





        FloatingActionButton fab =
                (FloatingActionButton)findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText)findViewById(R.id.input);
                //ref2=databaseReference.child("Messages");
                // String userId=
                // Read the input field and push a new instance
                // of ChatMessage to the Firebase database
               //String ke=mref.push().getKey();
              // Map<String,Object> updatesvalues=new HashMap<>();

               // updatesvalues.put("/"+ke+"/messageText",new ChatMessage(input.getText().toString()));


                mref.push().setValue(new ChatMessage(input.getText().toString(),auth.getCurrentUser().getDisplayName()));
                mref2.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).push().setValue(new ChatMessage(input.getText().toString(),auth.getCurrentUser().getDisplayName(),FirebaseAuth.getInstance().getCurrentUser().getUid()));


               /* LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.mlinear);
                String ke=mref.push().getKey();

                linearLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), Comment.class);
                        intent.putExtra("Message", ChatMessage.getMessageUser());
                        intent.putExtra("key", ke);
                        startActivityForResult(intent, 1);
                    }
                });*/
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





    }




    private void displayChatMessages() {
        progressBar.setVisibility(View.VISIBLE);
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






        adapter = new FirebaseListAdapter<ChatMessage>(ChatActivity.this, ChatMessage.class,
                R.layout.message, FirebaseDatabase.getInstance().getReference("messages"))
        {

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

                progressBar.setVisibility(View.GONE);

               // String ke=mref.push().getKey();
               // Log.d(TAG,"hhheeyy"+ke);
                SharedPreferences pref=getSharedPreferences("ankit", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putString("option", String.valueOf(model.getMessageTime()));
                editor.apply();

               linearLayout.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {



                        Intent intent = new Intent(getApplicationContext(), Comment.class);
                        intent.putExtra("Message", model.getMessageUser());
                        intent.putExtra("Time", model.getMessageTime());
                       // Log.d(TAG,"hhheeyy"+model.getMessageTime());
                       // intent.putExtra("key", ke);
                       startActivity(intent);
                    }
                });

            }

        };

        listOfMessages.setAdapter(adapter);


    }






    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGN_IN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this,
                        "Successfully signed in. Welcome!",
                        Toast.LENGTH_LONG)
                        .show();
                displayChatMessages();
            }

            if (auth.getCurrentUser() == null) {

                if (requestCode != RESULT_OK) {
                    Toast.makeText(this,
                            "We couldn't sign you in. Please try again later.",
                            Toast.LENGTH_LONG)
                            .show();

                    // Close the app

                }
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

        if (item.getItemId()==R.id.menu_person){
            Intent intent=new Intent(ChatActivity.this,YourProblems.class);
            startActivity(intent);
        }
        return true;


    }

  
}
