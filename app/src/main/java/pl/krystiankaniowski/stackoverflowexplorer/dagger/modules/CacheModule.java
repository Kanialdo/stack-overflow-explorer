package pl.krystiankaniowski.stackoverflowexplorer.dagger.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import pl.krystiankaniowski.stackoverflowexplorer.MainApplication;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.scopes.ApplicationScope;

@Module
public class CacheModule {

    @ApplicationScope
    @Provides
    public SharedPreferences provideSharedPreferences(MainApplication application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

}
