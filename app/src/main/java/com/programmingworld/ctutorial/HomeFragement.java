package com.programmingworld.ctutorial;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.gms.ads.formats.NativeAd;

public class HomeFragement extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);
        //return inflater.inflate(R.layout.fragement_home,container,false);
        final View view=inflater.inflate(R.layout.fragement_home,container,false);
        final CardView notes=(CardView) view.findViewById(R.id.theory);
        final CardView program=(CardView)view.findViewById(R.id.programs);
        final CardView faqs=(CardView)view.findViewById(R.id.faqs);
        final CardView mcq=(CardView)view.findViewById(R.id.mcq);
        final CardView rate=(CardView)view.findViewById(R.id.rateus);
        final CardView share=(CardView)view.findViewById(R.id.share);


        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),theorycontent.class);
                startActivity(intent);
            }
        });

        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Programcontent1.class);
                startActivity(intent);
            }
        });

        faqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),FAQcontent1.class);
                startActivity(intent);
            }
        });

        mcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Objectivecontent.class);
                startActivity(intent);
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ChatActivity.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.programmingworld.ctutorial";
                String shareSubject = "your subject here";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "share using"));

            }
        });



        return view;
    }

    public void rateMe(View view){
        try{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+"com.programmingworld.ctutorial")));
        }
        catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+"com.programmingworld.ctutorial")));
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=null,chooser=null;
        int id=item.getItemId();
        if (id==R.id.feedback){
            intent=new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"ankit.03432@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"The C tutorial");
            intent.setType("message/rfc822");
            chooser=Intent.createChooser(intent,"Send Email");
            startActivity(chooser);
            return true;
        }
        if (id==R.id.dis){
            Intent i=new Intent(getActivity(),Disclaimer.class);
            startActivity(i);
            return true;
        }
        return true;
    }
}
