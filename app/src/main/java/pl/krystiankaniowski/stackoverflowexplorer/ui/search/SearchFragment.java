package pl.krystiankaniowski.stackoverflowexplorer.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import pl.krystiankaniowski.stackoverflowexplorer.R;
import pl.krystiankaniowski.stackoverflowexplorer.ui.BaseFragment;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.BaseRecyclerViewAdapter;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.decorators.SimpleDividerItemDecoration;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.MessageItem;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

public class SearchFragment extends BaseFragment implements SearchContract.View {

    @BindView(android.R.id.edit)
    EditText inputField;

    @BindView(android.R.id.list)
    RecyclerView recyclerView;

    private SearchContract.Presenter presenter;
    private BaseRecyclerViewAdapter adapter;
    private List<ViewItem> items = new ArrayList<>();

    private CompositeSubscription compositeSubscription;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items.add(new MessageItem("No data to display"));
        adapter = new BaseRecyclerViewAdapter(getActivity(), items);

        compositeSubscription = new CompositeSubscription();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        compositeSubscription.add(
                RxTextView.textChanges(inputField)
                        .skip(1)
                        .debounce(1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(CharSequence::toString)
                        .subscribe(text -> presenter.requestQuestionQuery(text))
        );

        return view;

    }

    @Override
    public void setData(List<? extends ViewItem> items) {
        adapter.update(items);
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void subscribePresenters() {
        presenter.subscribe();
    }

    @Override
    public void unsubscribePresenters() {
        presenter.unsubscribe();
        compositeSubscription.clear();
    }

}
