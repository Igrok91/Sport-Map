package com.map.sport.sportmap.view.controller.create;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.MainActivity;
import com.map.sport.sportmap.view.controller.action.NewsFragment;
import com.map.sport.sportmap.view.controller.profile.ProfileFragment;
import com.map.sport.sportmap.view.controller.search.SearchPlaygroundFragment;
import com.map.sport.sportmap.view.controller.subscribe.SubscribeFragment;
import com.map.sport.sportmap.view.controller.subscribe.SubscribePlaygroundFragment;

import java.lang.reflect.Field;

public class CreateActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private SearchPlaygroundFragment searchPlaygroundFragment;
    private NewsFragment newsFragment;

    private SubscribeFragment subscribeFragment;
    private SubscribePlaygroundFragment playgroundFragment;
    private ProfileFragment profileFragment;
    private View newPoll;
    private View template;
    private View subscribeView;
    private View profileView;
    private CreateActivity createActivity;
    private Toolbar toolbar;
    private BottomNavigationView navigation;
    private ImageButton imageButtonBottom;
    private ImageButton imageButtonCreate;

    private TabLayout tabLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        toolbar = (Toolbar) findViewById(R.id.toolbarCreate);
        setSupportActionBar(toolbar);
        template = (View) findViewById(R.id.fl_contentCreate2);

        tabLayout = (TabLayout) findViewById(R.id.CreateTabLayout);
        tabLayout.addOnTabSelectedListener(this);
        imageButtonBottom = (ImageButton) findViewById(R.id.imageButton6);
        imageButtonCreate = (ImageButton) findViewById(R.id.imageButton8);

        imageButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        imageButtonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();
        createActivity = this;
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        String tabId = (String) tab.getText();
        View newsPoll = (View) findViewById(R.id.fl_contentCreate);
        if (tabId.equalsIgnoreCase("новый")) {
            newsPoll.setVisibility(View.VISIBLE);
            template.setVisibility(View.INVISIBLE);
        } else {
            newsPoll.setVisibility(View.INVISIBLE);
            template.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
