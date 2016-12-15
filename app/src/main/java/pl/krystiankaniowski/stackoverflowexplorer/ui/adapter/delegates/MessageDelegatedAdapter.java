package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.delegates;

import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import pl.krystiankaniowski.stackoverflowexplorer.R;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.BaseViewHolder;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.DelegatedAdapter;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.LoadingItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.MessageItem;

public class MessageDelegatedAdapter implements DelegatedAdapter {

    @Override
    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(parent);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, ViewItem viewItem) {

        ViewHolder viewHolder = (ViewHolder) holder;
        MessageItem item = (MessageItem) viewItem;

        viewHolder.text1.setText(item.getMessage());

    }

    @Override
    public int getViewType() {
        return ViewItem.MESSAGE_ITEM;
    }

    static class ViewHolder extends BaseViewHolder<LoadingItem> {

        @BindView(android.R.id.text1)
        TextView text1;

        public ViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_message);
        }

    }

}