package pl.krystiankaniowski.stackoverflowexplorer.ui.search;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import pl.krystiankaniowski.stackoverflowexplorer.dagger.injectors.PresenterInjector;
import pl.krystiankaniowski.stackoverflowexplorer.network.StackOverflowService;
import pl.krystiankaniowski.stackoverflowexplorer.network.data.Question;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.ViewItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.LoadingItem;
import pl.krystiankaniowski.stackoverflowexplorer.ui.adapter.items.MessageItem;
import rx.subscriptions.CompositeSubscription;

public class SearchPresenter implements SearchContract.Presenter {

    private final static String TAG = SearchPresenter.class.getSimpleName();

    @Inject
    StackOverflowService stackOverflowService;

    private SearchContract.View view;

    private CompositeSubscription compositeSubscription;

    private String currentPattern;

    public SearchPresenter(SearchContract.View view) {

        PresenterInjector.inject(this);

        this.view = view;

        compositeSubscription = new CompositeSubscription();

        view.setPresenter(this);

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
    }

    @Override
    public void requestQuestionQuery(String pattern) {
        Log.d(TAG, "requestQuestionQuery() called with: pattern = [" + pattern + "]");
        view.setData(ViewItem.Wrapper.wrap(LoadingItem.Factory.create()));
        currentPattern = pattern;
        compositeSubscription.add(stackOverflowService.getQuestions(currentPattern, callback));
    }

    @Override
    public void requestMoreResults() {

    }

    private StackOverflowService.Callback callback = new StackOverflowService.Callback() {

        @Override
        public void onDataReceive(List<Question> questions) {
            view.setData(questions);
        }

        @Override
        public void onError(Throwable throwable) {
            view.setData(ViewItem.Wrapper.wrap(MessageItem.Factory.create(throwable)));
        }

    };

}
