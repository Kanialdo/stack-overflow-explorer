package pl.krystiankaniowski.stackoverflowexplorer.dagger.modules;

import android.app.Application;

import com.squareup.picasso.Picasso;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.scopes.ApplicationScope;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @ApplicationScope
    @Named("stackoverflow")
    Retrofit providesRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.stackexchange.com/2.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    @Provides
    @ApplicationScope
    Picasso providesPicasso(Application application) {
        Picasso.Builder picassoBuilder = new Picasso.Builder(application);
        Picasso.setSingletonInstance(picassoBuilder.build());
        return Picasso.with(application);
    }

}
