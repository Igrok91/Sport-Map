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
        toolbar = (Toolbar) findViewById(R.id.toolbarCreate);
        setSupportActionBar(toolbar);
        actionView = (View) findViewById(R.id.fl_contentCreate);




    }


    @Override
    protected void onResume() {
        super.onResume();
        createActivity = this;
    }



}
