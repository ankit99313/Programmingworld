package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShopCategory extends AppCompatActivity {
    Toolbar toolbar;
    CardView laptop, book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_category);

        laptop=(CardView)findViewById(R.id.laptop);
        book=(CardView)findViewById(R.id.books);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShopCategory.this,ShopLaptop.class);
                startActivity(intent);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShopCategory.this,ShopBooks.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ShopCategory.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}