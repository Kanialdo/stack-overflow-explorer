package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.delegates;

import android.view.ViewGroup;

import pl.krystiankaniowski.stackoverflowexplorer.R;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.BaseViewHolder;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.DelegatedAdapter;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.LoadingItem;

public class LoadingDelegatedAdapter implements DelegatedAdapter {

    @Override
    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(parent);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, ViewItem viewItem) {
    }

    @Override
    public int getViewType() {
        return ViewItem.LOADING_ITEM;
    }

    static class ViewHolder extends BaseViewHolder<LoadingItem> {

        public ViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_loading);
        }

    }

}