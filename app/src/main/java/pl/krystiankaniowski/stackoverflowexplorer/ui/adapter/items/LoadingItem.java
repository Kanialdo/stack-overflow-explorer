package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items;

import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;

public class LoadingItem implements ViewItem {

    @Override
    public int geViewType() {
        return ViewItem.LOADING_ITEM;
    }

    public static class Factory {

        public static LoadingItem create() {
            return new LoadingItem();
        }

    }

}