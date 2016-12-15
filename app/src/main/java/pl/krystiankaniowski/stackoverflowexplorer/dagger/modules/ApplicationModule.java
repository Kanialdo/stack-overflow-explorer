package pl.krystiankaniowski.stackoverflowexplorer.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.krystiankaniowski.stackoverflowexplorer.MainApplication;

@Module
public class ApplicationModule {

    private MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public MainApplication provideApplication(){
        return application;
    }

}
