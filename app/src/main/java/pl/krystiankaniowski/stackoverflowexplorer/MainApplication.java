package pl.krystiankaniowski.stackoverflowexplorer;

import android.app.Application;

import pl.krystiankaniowski.stackoverflowexplorer.dagger.components.ApplicationComponent;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.components.BaseComponent;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.components.DaggerApplicationComponent;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.components.DaggerBaseComponent;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.modules.ApplicationModule;

public class MainApplication extends Application {

    private static ApplicationComponent applicationComponent;
    private static BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        baseComponent = DaggerBaseComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

    }

    public static BaseComponent getBaseComponent() {
        return baseComponent;
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}

