package com.map.sport.sportmap.view.controller.action;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.action.NewsFragment.OnListFragmentInteractionListener;
import com.map.sport.sportmap.view.controller.action.dummy.NewsDummyContent.Event;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Event} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class NewsItemRecyclerViewAdapter extends RecyclerView.Adapter<NewsItemRecyclerViewAdapter.ViewHolder> {

    private final List<Event> mValues;
    private final OnListFragmentInteractionListener mListener;

    public NewsItemRecyclerViewAdapter(List<Event> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.namePlayground.setText(mValues.get(position).getPlayground().getName());
        holder.namePoll.setText(mValues.get(position).getNamePoll());
        holder.date.setText("час назад");
        holder.playgroundPhoto.setImageResource(mValues.get(position).photoid);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView namePlayground;
        TextView namePoll;
        TextView date;
        ImageView playgroundPhoto;
        public Event mItem;

        public ViewHolder(View view) {
            super(view);
            cv = (CardView)itemView.findViewById(R.id.cv);
            namePlayground = (TextView)itemView.findViewById(R.id.namePlayground);
            namePoll = (TextView)itemView.findViewById(R.id.namePoll);
            date = (TextView)itemView.findViewById(R.id.date);
            playgroundPhoto = (ImageView)itemView.findViewById(R.id.imageView2);
        }

        @Override
        public String toString() {
            return super.toString() + " '" ;
        }
    }
}
