package com.example.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Button btnweb;
    Button btnphone;
    Button btncam;
    Button btnNext;
    Intent intent1;
    Intent intent2;
    Intent intent3;
    Intent intent4;
    NavigationView navigationView;
    ActionBarDrawerToggle toogle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        btnweb=findViewById(R.id.btnweb);
        btnphone=findViewById(R.id.btnphone);
        btncam=findViewById(R.id.btncam);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        Menu menu = navigationView.getMenu();

        navigationView.bringToFront();
        toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.pass_home);

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.ensaf.ac.ma";
                intent1=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent1);
            }
        });
        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel:0691642  949");
                intent2=new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent2);
            }
        });
        btncam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent3);
            }
        });


    }
    @Override
    public void onBackPressed() {
        //Fermer le menu si je clique sur le bouton return
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.pass_home) {
            // Action pour Home (vide ici)
        } else if (item.getItemId() == R.id.calc_calculator) {
            Intent intent5 = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent5);
        } else if (item.getItemId() == R.id.nav_share) {
            Toast.makeText(this, "Share", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.nav_logout){
            Intent intent6 = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent6);
        }

        // Fermer le menu
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}