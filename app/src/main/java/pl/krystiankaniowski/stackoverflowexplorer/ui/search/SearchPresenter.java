package pl.krystiankaniowski.stackoverflowexplorer.ui.search;

import rx.subscriptions.CompositeSubscription;

public class SearchPresenter  implements SearchContract.Presenter {

    private SearchContract.View view;

    private CompositeSubscription compositeSubscription;

    public SearchPresenter(SearchContract.View view) {

        this.view = view;

        compositeSubscription = new CompositeSubscription();

        view.setPresenter(this);

    }

    @Override
    public void requestQuestionQuery(String pattern) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
    }

}
