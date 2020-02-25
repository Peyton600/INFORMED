package com.example.testapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.testapp.Adapter.SectionPagerAdapter;
import com.example.testapp.R;
import com.example.testapp.ui.EarlyFragment;
import com.example.testapp.ui.SScheduleFragment;
import com.example.testapp.ui.SpotLightFragment;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {
        View myFragment;

        ViewPager viewPager;
        TabLayout tabLayout;


        public HomeFragment() {
            // Required empty public constructor
        }

        public static HomeFragment getInstance()    {
            return new HomeFragment();
        }
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            myFragment = inflater.inflate(R.layout.fragment_home, container, false);
            viewPager = myFragment.findViewById(R.id.viewPager);
            tabLayout = myFragment.findViewById(R.id.tabLayout);

            return myFragment;
        }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new EarlyFragment(), "EarlyOuts");
        adapter.addFragment(new SScheduleFragment(), "Sports Schedule");
        adapter.addFragment(new SpotLightFragment(),"Spotlight");

        viewPager.setAdapter(adapter);
    }
}

