package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter;

import java.util.ArrayList;
import java.util.List;

public interface ViewItem {

    int LOADING_ITEM = 0;
    int MESSAGE_ITEM = 1;
    int QUESTION_ITEM = 2;

    int geViewType();

    class Wrapper {

        public static List<? extends ViewItem> wrap(ViewItem item) {
            List<ViewItem> items = new ArrayList<>();
            items.add(item);
            return items;
        }

    }

}