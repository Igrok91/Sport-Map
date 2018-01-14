package com.map.sport.sportmap.view.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.action.NewsFragment;
import com.map.sport.sportmap.view.controller.create.CreateFragment;
import com.map.sport.sportmap.view.controller.profile.ProfileFragment;
import com.map.sport.sportmap.view.controller.search.SearchFragment;
import com.map.sport.sportmap.view.controller.subscribe.SubscribeFragment;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        disableMenuShiftMode(navigation);

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_content, fragment);
        ft.commit();
    }

    @SuppressLint("RestrictedApi")
    public static void disableMenuShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            //Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            // Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    loadFragment(NewsFragment.newInstance(1));
                    return true;
                case R.id.navigation_search:
                    loadFragment(SearchFragment.newInstance("as", "asd"));
                    return true;
                case R.id.navigation_create:
                    loadFragment(CreateFragment.newInstance("as", "asd"));
                    return true;
                case R.id.navigation_subscribe:
                    loadFragment(SubscribeFragment.newInstance(1));
                    return true;
                case R.id.navigation_profile:
                    loadFragment(ProfileFragment.newInstance("as", "asd"));
                    return true;
            }
            return false;
        }
    };

}
