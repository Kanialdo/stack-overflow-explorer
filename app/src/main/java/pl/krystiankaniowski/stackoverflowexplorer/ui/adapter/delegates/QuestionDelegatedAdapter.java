package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.delegates;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import pl.krystiankaniowski.stackoverflowexplorer.R;
import pl.krystiankaniowski.stackoverflowexplorer.network.data.Question;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.BaseViewHolder;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.DelegatedAdapter;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.LoadingItem;

public class QuestionDelegatedAdapter implements DelegatedAdapter {

    Context context;

    public QuestionDelegatedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return new ViewHolder(parent);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, ViewItem viewItem) {

        ViewHolder viewHolder = (ViewHolder) holder;
        Question item = (Question) viewItem;

        viewHolder.text.setText(item.getTitle());
        Picasso.with(context).load(item.getOwner().getProfileImage()).placeholder(android.R.drawable.btn_star).into(viewHolder.avatar);

    }

    @Override
    public int getViewType() {
        return ViewItem.QUESTION_ITEM;
    }

    static class ViewHolder extends BaseViewHolder<LoadingItem> {

        @BindView(android.R.id.text1)
        TextView text;

        @BindView(android.R.id.icon)
        ImageView avatar;

        public ViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_question);
        }

    }

}