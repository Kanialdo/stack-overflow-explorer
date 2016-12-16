package pl.krystiankaniowski.stackoverflowexplorer.ui.search;

import java.util.List;

import pl.krystiankaniowski.stackoverflowexplorer.mvp.BasePresenter;
import pl.krystiankaniowski.stackoverflowexplorer.mvp.BaseView;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void setData(List<? extends ViewItem> items);

    }

    interface Presenter extends BasePresenter {

        void requestQuestionQuery(String pattern);

        void requestMoreResults();

    }

}
