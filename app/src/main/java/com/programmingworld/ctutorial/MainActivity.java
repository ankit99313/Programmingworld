
package com.programmingworld.ctutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.programmingworld.ctutorial.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        //toolbar.setTitle("");
        setSupportActionBar(toolbar);


        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragement()).commit();
        }



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragement()).commit();
                break;

            case R.id.nav_update:
                AppUpdateChecker appUpdateChecker=new AppUpdateChecker(this);  //pass the acti
                appUpdateChecker.checkForUpdate(true);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MessageFragement()).commit();
                break;


            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragement()).commit();
                break;

            case R.id.nav_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "https://play.google.com/store/apps/details?id=com.programmingworld.ctutorial";
                String shareSubject = "your subject here";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "share using"));

                break;

            case R.id.nav_rate:
                rateMe();
                break;

            case R.id.fb_page:
                goToFacebookPage("100221901725933");
                break;


        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
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
            Intent i=new Intent(MainActivity.this,Disclaimer.class);
            startActivity(i);
            return true;
        }
        return true;
    }

    private void goToFacebookPage(String id)
    {
        try {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/"+id));
            startActivity(intent);
        }
        catch (ActivityNotFoundException e)
        {
            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/"+id));
            startActivity(intent);
        }

    }

    public void rateMe(){
        try{
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+"com.programmingworld.ctutorial")));
        }
        catch (ActivityNotFoundException e){
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+"com.programmingworld.ctutorial")));
        }

    }
}
