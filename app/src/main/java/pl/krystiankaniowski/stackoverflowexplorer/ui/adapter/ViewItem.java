package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter;

public interface ViewItem {

    int LOADING_ITEM = 0;
    int MESSAGE_ITEM = 1;

    int geViewType();

}