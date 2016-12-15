package pl.krystiankaniowski.stackoverflowexplorer.ui.search;

import pl.krystiankaniowski.stackoverflowexplorer.mvp.BasePresenter;
import pl.krystiankaniowski.stackoverflowexplorer.mvp.BaseView;

public interface SearchContract {

    interface View extends BaseView<Presenter> {

        void setData();

    }

    interface Presenter extends BasePresenter {

        void requestQuestionQuery(String pattern);

    }

}
