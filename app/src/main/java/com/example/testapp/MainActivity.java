package com.example.testapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.testapp.ui.dashboard.DashboardFragment;
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
    Fragment currentFragment = null;
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemIconTintList(null);
        ft = getSupportFragmentManager().beginTransaction();
        currentFragment = new HomeFragment();
        ft.replace(R.id.nav_host_fragment, currentFragment);
        ft.commit();
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }




    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener(){



        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    currentFragment = new HomeFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_events:
                    currentFragment = new EventsFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_schedule:
                    currentFragment = new ScheduleFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;
                case R.id.navigation_dashboard:
                    currentFragment = new DashboardFragment();
                    ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content, currentFragment);
                    ft.commit();
                    return true;

            }

            return false;
        }

    };



}
