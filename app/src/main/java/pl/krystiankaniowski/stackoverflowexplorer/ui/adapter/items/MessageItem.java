package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items;

import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;

public class MessageItem implements ViewItem {

    private String message;

    public MessageItem(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int geViewType() {
        return ViewItem.MESSAGE_ITEM;
    }

}