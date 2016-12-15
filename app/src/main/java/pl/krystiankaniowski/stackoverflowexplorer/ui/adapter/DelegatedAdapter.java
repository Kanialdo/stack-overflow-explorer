package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter;

import android.view.ViewGroup;

public interface DelegatedAdapter {

    BaseViewHolder createViewHolder(ViewGroup parent);

    void bindViewHolder(BaseViewHolder holder, ViewItem viewItem);

    int getViewType();

}