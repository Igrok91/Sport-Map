package com.map.sport.sportmap.view.controller.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchPlaygroundFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchPlaygroundFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchPlaygroundFragment extends Fragment implements CompoundButton.OnCheckedChangeListener, TabLayout.OnTabSelectedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Switch sw;
    private TextView titleToollBar;
    private ImageButton button;
    private Activity activity;
    private TabItem tabItem;
    private TabItem tabItemMaps;
    private TabLayout tabLayout;
    private ImageButton footbalButton;
    private ImageButton voleyballButton;
    private ImageButton basketBallButton;
    private ImageButton allButton;

    private OnFragmentInteractionListener mListener;

    public SearchPlaygroundFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchPlaygroundFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchPlaygroundFragment newInstance(String param1, String param2) {
        SearchPlaygroundFragment fragment = new SearchPlaygroundFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        activity = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        sw = (Switch) activity.findViewById(R.id.switch1);
        titleToollBar = (TextView) activity.findViewById(R.id.TitleToollBar);
        button = (ImageButton) activity.findViewById(R.id.imageButton4);

        tabItem = (TabItem) activity.findViewById(R.id.TabItemList);

        tabItemMaps = (TabItem) activity.findViewById(R.id.TabItemMaps);


        return inflater.inflate(R.layout.fragment_search_playground, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        sw.setVisibility(View.GONE);
        button.setVisibility(View.GONE);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        View costList = (View) activity.findViewById(R.id.lr_cost_list);
        View freeList = (View) activity.findViewById(R.id.layoutContentList);
        if (isChecked) {
            sw.setText(R.string.cost);
            costList.setVisibility(View.VISIBLE);
            freeList.setVisibility(View.INVISIBLE);
        } else {
            sw.setText(R.string.free);
            costList.setVisibility(View.INVISIBLE);
            freeList.setVisibility(View.VISIBLE);
        }

        Toast.makeText(activity, (isChecked ? "Платные площадки" : "Бесплатные площадки"), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        String tabId = (String) tab.getText();
        View layoutMaps = (View) activity.findViewById(R.id.lr_maps_playground);
        View costList = (View) activity.findViewById(R.id.lr_cost_list);
        View layoutList = (View) activity.findViewById(R.id.lr_list_playground);
        if (tabId.equalsIgnoreCase("карта")) {
            if (sw.isChecked()) {
               costList.setVisibility(View.INVISIBLE);
            } else {
                layoutList.setVisibility(View.INVISIBLE);
            }
            layoutMaps.setVisibility(View.VISIBLE);


        } else if (tabId.equalsIgnoreCase("список")) {
            if (sw.isChecked()) {
                costList.setVisibility(View.VISIBLE);
            } else {
                layoutList.setVisibility(View.VISIBLE);
            }
            layoutMaps.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void setVisibilityToollbar() {
        sw.setVisibility(View.VISIBLE);
        titleToollBar.setText(R.string.title_search);
        button.setVisibility(View.VISIBLE);
    }


    public void setClickListener(MainActivity mainActivity) {
        tabLayout = (TabLayout) mainActivity.findViewById(R.id.SearchTabLayout);
        tabLayout.addOnTabSelectedListener(this);
        sw.setOnCheckedChangeListener(this);
        footbalButton = mainActivity.findViewById(R.id.imageButton3);
        voleyballButton = mainActivity.findViewById(R.id.imageButton2);
        basketBallButton = mainActivity.findViewById(R.id.imageButton);
        allButton = mainActivity.findViewById(R.id.imageButtonAll);

        footbalButton.setOnClickListener(clickListener);
        voleyballButton.setOnClickListener(clickListener);
        basketBallButton.setOnClickListener(clickListener);
        allButton.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.imageButton3) {
                footbalButton.setImageResource(R.mipmap.ic_foot_select_round);
                voleyballButton.setImageResource(R.mipmap.ic_voleyball_round);
                basketBallButton.setImageResource(R.mipmap.ic_basketball_round);
                allButton.setImageResource(R.mipmap.ic_all2_round);
            } else if (id == R.id.imageButton2) {
                footbalButton.setImageResource(R.mipmap.ic_football_list_round);
                voleyballButton.setImageResource(R.mipmap.ic_voley_select_round);
                basketBallButton.setImageResource(R.mipmap.ic_basketball_round);
                allButton.setImageResource(R.mipmap.ic_all2_round);
            } else if (id == R.id.imageButton) {
                footbalButton.setImageResource(R.mipmap.ic_football_list_round);
                voleyballButton.setImageResource(R.mipmap.ic_voleyball_round);
                basketBallButton.setImageResource(R.mipmap.ic_basket_select_round);
                allButton.setImageResource(R.mipmap.ic_all2_round);
            } else if (id == R.id.imageButtonAll) {
                allButton.setImageResource(R.mipmap.ic_all_select_round);
                footbalButton.setImageResource(R.mipmap.ic_football_list_round);
                voleyballButton.setImageResource(R.mipmap.ic_voleyball_round);
                basketBallButton.setImageResource(R.mipmap.ic_basketball_round);
            }
        }
    };

    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onFocusChange(View view, boolean b) {
            int id = view.getId();
            if (id == R.id.imageButton3 && !b) {
                ImageButton button = (ImageButton) view;
                button.setBackgroundColor(R.color.cardview_light_background);
            } else if (id == R.id.imageButton2 && b) {
                ImageButton button = (ImageButton) view;
                button.setBackgroundColor(R.color.cardview_light_background);
            } else if (id == R.id.imageButton && b) {
                ImageButton button = (ImageButton) view;
                button.setBackgroundColor(R.color.cardview_light_background);
            }
        }
    };

    public void setVisibilty(View searchView) {
        searchView.setVisibility(View.INVISIBLE);
        sw.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
