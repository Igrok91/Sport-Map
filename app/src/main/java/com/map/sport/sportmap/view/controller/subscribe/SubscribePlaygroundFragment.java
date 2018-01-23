package com.map.sport.sportmap.view.controller.subscribe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SubscribePlaygroundFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SubscribePlaygroundFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SubscribePlaygroundFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Switch sw;
    private TextView titleToollBar;;
    private Activity activity;
    private TabLayout tabLayout;
    private ImageButton footbalButton;
    private ImageButton voleyballButton;
    private ImageButton basketBallButton;
    private ImageButton allButton;

    private OnFragmentInteractionListener mListener;

    public SubscribePlaygroundFragment() {
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
    public static SubscribePlaygroundFragment newInstance(String param1, String param2) {
        SubscribePlaygroundFragment fragment = new SubscribePlaygroundFragment();
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
        sw.setOnCheckedChangeListener(this);
        return inflater.inflate(R.layout.fragment_subscribe, container, false);
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

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            sw.setText(R.string.cost);
        } else {
            sw.setText(R.string.free);
        }
        Toast.makeText(activity, (isChecked ? "Платные площадки" : "Бесплатные площадки"), Toast.LENGTH_SHORT).show();
    }


    public void setVisibilityToollbar() {
        sw.setVisibility(View.VISIBLE);
        titleToollBar.setText(R.string.title_subscribe);
    }


    public void setClickListener(MainActivity mainActivity) {


    }


    public void setVisibilty(View searchView) {
        searchView.setVisibility(View.INVISIBLE);
        sw.setVisibility(View.INVISIBLE);
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
