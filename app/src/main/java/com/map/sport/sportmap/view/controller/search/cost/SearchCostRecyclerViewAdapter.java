package com.map.sport.sportmap.view.controller.search.cost;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.view.controller.search.cost.dummy.SearchCostContent.PlaygroundItem;



import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaygroundItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SearchCostRecyclerViewAdapter extends RecyclerView.Adapter<SearchCostRecyclerViewAdapter.ViewHolder> {

    private final List<PlaygroundItem> mValues;
    private final SearchCostFragment.OnListFragmentInteractionListener mListener;

    public SearchCostRecyclerViewAdapter(List<PlaygroundItem> items, SearchCostFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_search_cost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
/*        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);*/

        holder.mView.setOnClickListener(new View.OnClickListener() {
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
        public final View mView;
        public PlaygroundItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
