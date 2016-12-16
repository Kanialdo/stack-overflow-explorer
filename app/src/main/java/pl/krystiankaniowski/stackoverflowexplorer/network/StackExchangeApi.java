package pl.krystiankaniowski.stackoverflowexplorer.network;

import pl.krystiankaniowski.stackoverflowexplorer.network.data.QuestionResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface StackExchangeApi {

    String INTITLE = "intitle";
    String ORDER = "order";
    String SORT = "sort";
    String SITE = "site";

    @GET("search")
    Observable<QuestionResponse> getQuestions(@Query(SITE) String site, @Query(SORT) String sort, @Query(ORDER) String order, @Query(INTITLE) String intitle);

}
