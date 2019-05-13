package com.example.car;


import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.car.BuyFragment.BuyOneFragment;
import com.example.car.BuyFragment.BuyThreeFragment;
import com.example.car.BuyFragment.BuyTwoFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements
        homePageFragment.OnFragmentInteractionListener ,
        buyFragment.OnFragmentInteractionListener,
        meFragment.OnFragmentInteractionListener, BuyOneFragment.OnFragmentInteractionListener,
        BuyTwoFragment.OnFragmentInteractionListener, BuyThreeFragment.OnFragmentInteractionListener {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    List<Fragment> fragmentList;


    @Override
    public void onFragmentInteraction(Uri uri) {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     /*   if (Build.VERSION.SDK_INT >= 21){
            View decroView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decroView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();



        viewPager = findViewById(R.id.view_page);
        bottomNavigationView = findViewById(R.id.navigation);
        fragmentList = new ArrayList<>();
        fragmentList.add(new homePageFragment());
        fragmentList.add(new buyFragment());
        fragmentList.add(new meFragment());
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),this,fragmentList);
        viewPager.setAdapter(adapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        return  true;

                    case  R.id.buy:
                        viewPager.setCurrentItem(1);
                        return  true;

                    case R.id.me:
                        viewPager.setCurrentItem(2);
                        return  true;

                     default:
                         break;

                }



                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bottomNavigationView.getMenu().getItem(i).setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });





    }


}
