package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseViewHolder<Item extends ViewItem> extends RecyclerView.ViewHolder {

    public BaseViewHolder(ViewGroup parent, int viewId) {
        super(LayoutInflater.from(parent.getContext()).inflate(viewId, parent, false));
        ButterKnife.bind(this, itemView);
    }

}