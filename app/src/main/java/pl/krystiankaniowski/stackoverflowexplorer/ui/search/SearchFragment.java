package pl.krystiankaniowski.stackoverflowexplorer.ui.search;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import butterknife.BindView;
import pl.krystiankaniowski.stackoverflowexplorer.R;
import pl.krystiankaniowski.stackoverflowexplorer.ui.BaseFragment;

public class SearchFragment extends BaseFragment implements SearchContract.View {

    private SearchContract.Presenter presenter;

    @BindView(android.R.id.edit)
    EditText inputField;

    @BindView(android.R.id.list)
    RecyclerView recyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    public void setData() {

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
    }

}
