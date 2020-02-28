package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.testapp.ui.Helper.BottomNavigationViewHelper;
import com.example.testapp.ui.alerts.AlertsFragment;
import com.example.testapp.ui.events.EventsFragment;
import com.example.testapp.ui.home.HomeFragment;
import com.example.testapp.ui.schedule.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {




    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startActivity(new Intent(MainActivity.this,Pop.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_host_fragment);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId())   {
                    case R.id.navigation_sports:
                        selectedFragment = HomeFragment.getInstance();
                        break;

                    case R.id.navigation_alerts:
                        selectedFragment = AlertsFragment.getInstance();
                        break;

                    case R.id.navigation_schedule:
                        selectedFragment = ScheduleFragment.getInstance();
                        break;

                    case R.id.navigation_events:
                        selectedFragment = EventsFragment.getInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_view,selectedFragment);
                transaction.commit();
                return false;
            }
        });
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_view,HomeFragment.getInstance());
        transaction.commit();
    }


}
