package com.example.testapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.testapp.ui.alerts.AlertsFragment;

import com.example.testapp.ui.events.EventsFragment;
import com.example.testapp.ui.home.HomeFragment;
import com.example.testapp.ui.schedule.ScheduleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
bottomNav.setItemIconTintList(null);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                    new HomeFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_sports:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_events:
                            selectedFragment = new EventsFragment();
                            break;
                        case R.id.navigation_alerts:
                            selectedFragment = new AlertsFragment();
                            break;
                        case R.id.navigation_schedule:
                            selectedFragment = new ScheduleFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            selectedFragment).commit();

                    return true;
                }
            };
}
