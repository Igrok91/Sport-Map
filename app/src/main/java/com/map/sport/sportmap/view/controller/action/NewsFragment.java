package com.map.sport.sportmap.view.controller.action;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.MainActivity;
import com.map.sport.sportmap.view.controller.action.dummy.NewsDummyContent;
import com.map.sport.sportmap.view.controller.action.dummy.NewsDummyContent.Event;
import com.map.sport.sportmap.view.controller.create.CreateActivity;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NewsFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private TextView titleToollBar;
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private TextView countVoice1;
    private TextView countVoice2;

    private static boolean toggleOn1 = false;
    private static boolean toggleOn2 = false;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NewsFragment newInstance(int columnCount) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_news_list, container, false);
        titleToollBar = (TextView) getActivity().findViewById(R.id.TitleToollBar);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new NewsItemRecyclerViewAdapter(NewsDummyContent.ITEMS, mListener));
        }
        return view;
    }




/*    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setVisibilityToollbar() {
        titleToollBar.setText(R.string.title_home);
    }

    public void setClickListener(MainActivity mainActivity) {
        radioButton1 = (RadioButton) mainActivity.findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) mainActivity.findViewById(R.id.radioButton2);
        radioButton1.setOnClickListener(radioButtonClickListener);
        radioButton2.setOnClickListener(radioButtonClickListener);

        countVoice1 = (TextView) mainActivity.findViewById(R.id.countVoice1);
        countVoice2 = (TextView) mainActivity.findViewById(R.id.countVoice2);
    }

    public void setClickListener(CreateActivity mainActivity) {
        radioButton1 = (RadioButton) mainActivity.findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) mainActivity.findViewById(R.id.radioButton2);
        radioButton1.setOnClickListener(radioButtonClickListener);
        radioButton2.setOnClickListener(radioButtonClickListener);

        countVoice1 = (TextView) mainActivity.findViewById(R.id.countVoice1);
        countVoice2 = (TextView) mainActivity.findViewById(R.id.countVoice2);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Event item);
    }

    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            switch (rb.getId()) {
                case R.id.radioButton:
                    if (toggleOn1) {
                        rb.setChecked(false);
                        rb.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                        countVoice1.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                        countVoice1.setText(decreaseCountVoice(countVoice1));
                        toggleOn1 = false;
                    }
                    if (rb.isChecked()) {
                        if (toggleOn2) {
                            radioButton2.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                            countVoice2.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                            radioButton2.setChecked(false);
                            toggleOn2 = false;
                            countVoice2.setText(decreaseCountVoice(countVoice2));
                        }
                        rb.setBackgroundColor(getResources().getColor(R.color.colorPressedButton));
                        countVoice1.setBackgroundColor(getResources().getColor(R.color.colorPressedButton));
                        countVoice1.setText(multiplyCountVoice(countVoice1));
                        toggleOn1 = true;
                    }
                    radioButton2.setChecked(false);
                    break;
                case R.id.radioButton2:
                    if (toggleOn2) {
                        rb.setChecked(false);
                        rb.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                        countVoice2.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                        countVoice2.setText(decreaseCountVoice(countVoice2));
                        toggleOn2 = false;
                    }
                    if (rb.isChecked()) {
                        if (toggleOn1) {
                            radioButton1.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                            countVoice1.setBackgroundColor(getResources().getColor(R.color.ic_all2_background));
                            radioButton1.setChecked(false);
                            toggleOn1 = false;
                            countVoice1.setText(decreaseCountVoice(countVoice1));
                        }
                        rb.setBackgroundColor(getResources().getColor(R.color.colorPressedButton));
                        countVoice2.setBackgroundColor(getResources().getColor(R.color.colorPressedButton));
                        countVoice2.setText(multiplyCountVoice(countVoice2));
                        toggleOn2 = true;
                    }

                    break;
                default:
                    break;
            }
        }
    };

    private String decreaseCountVoice(TextView countVoice1) {
        int count = Integer.parseInt((String) countVoice1.getText());
        --count;
        return String.valueOf(count);
    }

    private String multiplyCountVoice(TextView countVoice1) {
        int count = Integer.parseInt((String) countVoice1.getText());
        ++count;
        return String.valueOf(count);
    }
}
