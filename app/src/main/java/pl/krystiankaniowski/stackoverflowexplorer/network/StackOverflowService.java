package pl.krystiankaniowski.stackoverflowexplorer.network;

import android.util.Log;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StackOverflowService {

    private StackExchangeApi api;

    private String site = "stackoverflow";
    private String sort = "activity";
    private String order = "desc";

    public StackOverflowService(StackExchangeApi api) {
        this.api = api;
    }

    public void getQuestions(String pattern) {

        api.getQuestions(site, sort, order, pattern)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> Log.v("TAG", item.getItems().get(0).toString()),
                        throwable -> Log.w("TAG", "error", throwable),
                        () -> {
                        }
                );

    }

}
