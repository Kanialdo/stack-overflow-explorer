package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items;

import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;

public class MessageItem implements ViewItem {

    private CharSequence message;

    public MessageItem(CharSequence message) {
        this.message = message;
    }

    public CharSequence getMessage() {
        return message;
    }

    @Override
    public int geViewType() {
        return ViewItem.MESSAGE_ITEM;
    }

    public static class Factory {

        public static MessageItem create(Throwable throwable) {
            return new MessageItem(throwable.getMessage());
        }

        public static MessageItem create(CharSequence text) {
            return new MessageItem(text);
        }

    }

}