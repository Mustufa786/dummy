package com.aku.edu.dummy;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aku.edu.dummy.adapter.ViewPagerAdapter;
import com.aku.edu.dummy.callbacks.Callbacks;
import com.aku.edu.dummy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements Callbacks {

    ActivityMainBinding bi;
    boolean valid;
    FragmentManager fm;
    OneFrament frament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);


        setSupportActionBar(bi.toolbar);
        setupViewPager();

        final Fragment fragment = getSupportFragmentManager().findFragmentByTag("android:switcher:" + bi.viewpager + ":" + bi.viewpager.getCurrentItem());

        bi.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }

    private void setupViewPager() {


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFrament(), "Domain 1");
        adapter.addFragment(new TwoFragment(), "Domain 2");
        adapter.addFragment(new ThreeFragment(), "Domain 3");
        adapter.addFragment(new FourFragment(), "Domain 4");
        bi.viewpager.setAdapter(adapter);
        bi.tabs.setupWithViewPager(bi.viewpager);

    }

    @Override
    public void validateFragmentOne(boolean validated) {

        valid = validated;
    }
}
