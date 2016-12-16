package pl.krystiankaniowski.stackoverflowexplorer.network;

import java.util.List;

import pl.krystiankaniowski.stackoverflowexplorer.network.data.Question;
import pl.krystiankaniowski.stackoverflowexplorer.network.data.QuestionResponse;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StackOverflowService {

    public interface Callback {

        void onDataReceive(List<Question> questions);

        void onError(Throwable throwable);

    }

    private StackExchangeApi api;

    private String site = "stackoverflow";
    private String sort = "activity";
    private String order = "desc";

    public StackOverflowService(StackExchangeApi api) {
        this.api = api;
    }

    public Subscription getQuestions(String pattern, final Callback callback) {

        return api.getQuestions(site, sort, order, pattern)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(QuestionResponse::getItems)
                .subscribe(
                        callback::onDataReceive,
                        callback::onError,
                        () -> {
                        }
                );

    }

}
