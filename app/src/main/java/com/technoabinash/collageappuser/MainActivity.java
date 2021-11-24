package com.technoabinash.collageappuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private NavController controller;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        controller = Navigation.findNavController(this, R.id.fragment_container);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_drawer_menu);

        NavigationUI.setupWithNavController(bottomNavigationView, controller);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_video:
                Toast.makeText(this, "video lectures", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_book:
                startActivity(new Intent(MainActivity.this,BookActivity.class));
                break;

            case R.id.navigation_share:
                Toast.makeText(this, "shere", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_rate_us:
                Toast.makeText(this, "rate us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_theme:
                Toast.makeText(this, "theme changed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_website:
                Toast.makeText(this, "visit website", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_developer:
                Toast.makeText(this, "about developers", Toast.LENGTH_SHORT).show();
                break;


        }
        return true;
    }
}