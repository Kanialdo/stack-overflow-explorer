package pl.krystiankaniowski.stackoverflowexplorer.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import pl.krystiankaniowski.stackoverflowexplorer.MainApplication;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.modules.ApplicationModule;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    // Exposes Application to any component which depends on this
    MainApplication getApplication();

}