package pl.krystiankaniowski.stackoverflowexplorer.ui.adapter;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.delegates.LoadingDelegatedAdapter;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.delegates.MessageDelegatedAdapter;

public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<? extends ViewItem> items;

    private SparseArrayCompat<DelegatedAdapter> delegatedAdapters = new SparseArrayCompat<>();

    public BaseRecyclerViewAdapter(List<? extends ViewItem> items) {

        this.items = items;

        registerDelegatedAdapter(new LoadingDelegatedAdapter());
        registerDelegatedAdapter(new MessageDelegatedAdapter());

    }

    public void update(List<? extends ViewItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void registerDelegatedAdapter(DelegatedAdapter adapter) {
        delegatedAdapters.put(adapter.getViewType(), adapter);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return delegatedAdapters.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        delegatedAdapters.get(getItemViewType(position)).bindViewHolder(holder, items.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).geViewType();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}