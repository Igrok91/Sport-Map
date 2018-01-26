package com.map.sport.sportmap.view.controller.create;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.action.NewsFragment;
import com.map.sport.sportmap.view.controller.profile.ProfileFragment;
import com.map.sport.sportmap.view.controller.search.SearchPlaygroundFragment;
import com.map.sport.sportmap.view.controller.subscribe.SubscribeFragment;
import com.map.sport.sportmap.view.controller.subscribe.SubscribePlaygroundFragment;

import java.lang.reflect.Field;

public class CreateActivity extends AppCompatActivity {

    private SearchPlaygroundFragment searchPlaygroundFragment;
    private NewsFragment newsFragment;
    private CreateFragment createFragment;
    private SubscribeFragment subscribeFragment;
    private SubscribePlaygroundFragment playgroundFragment;
    private ProfileFragment profileFragment;
    private View searchView;
    private View actionView;
    private View subscribeView;
    private View profileView;
    private CreateActivity createActivity;
    private Toolbar toolbar;
    private BottomNavigationView navigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        addFragmentToContext();
        searchView = (View) findViewById(R.id.search_contentCreate);
        actionView = (View) findViewById(R.id.fl_contentCreate);
        subscribeView = (View) findViewById(R.id.subscribe_contentCreate);
        profileView = (View) findViewById(R.id.profile_contentCreate);



        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        searchPlaygroundFragment.setVisibilty(searchView);
                        subscribeView.setVisibility(View.INVISIBLE);
                        profileView.setVisibility(View.INVISIBLE);

                        actionView.setVisibility(View.VISIBLE);
                        newsFragment.setVisibilityToollbar();
                        newsFragment.setClickListener(createActivity);
                        return true;
                    case R.id.navigation_search:
                        searchView.setVisibility(View.VISIBLE);
                        actionView.setVisibility(View.INVISIBLE);
                        subscribeView.setVisibility(View.INVISIBLE);
                        profileView.setVisibility(View.INVISIBLE);
                        searchPlaygroundFragment.setVisibilityToollbar();
                        searchPlaygroundFragment.setClickListener(createActivity);
                        return true;
                    case R.id.navigation_create:
                        return true;
                    case R.id.navigation_subscribe:
                        searchPlaygroundFragment.setVisibilty(searchView);
                        actionView.setVisibility(View.INVISIBLE);
                        subscribeView.setVisibility(View.VISIBLE);
                        profileView.setVisibility(View.INVISIBLE);
                        playgroundFragment.setVisibilityToollbar();
                        return true;
                    case R.id.navigation_profile:
                        searchPlaygroundFragment.setVisibilty(searchView);
                        actionView.setVisibility(View.INVISIBLE);
                        subscribeView.setVisibility(View.INVISIBLE);
                        profileView.setVisibility(View.VISIBLE);
                        return true;
                }
                return false;
            }
        });
        disableMenuShiftMode(navigation);
    }


    @Override
    protected void onResume() {
        super.onResume();
        createActivity = this;
    }


    private void addFragmentToContext() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        newsFragment = NewsFragment.newInstance(1);
        searchPlaygroundFragment = SearchPlaygroundFragment.newInstance("asd", "asd");
        createFragment = CreateFragment.newInstance("as", "asd");
        //subscribeFragment = SubscribeFragment.newInstance(1);
        profileFragment = ProfileFragment.newInstance("as", "asd");
        playgroundFragment = SubscribePlaygroundFragment.newInstance("asd", "asd");
        ft.add(R.id.fl_content, newsFragment);
        ft.add(R.id.search_content, searchPlaygroundFragment );
        ft.add(R.id.subscribe_content, playgroundFragment);
        ft.add(R.id.profile_content, profileFragment);
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

}
