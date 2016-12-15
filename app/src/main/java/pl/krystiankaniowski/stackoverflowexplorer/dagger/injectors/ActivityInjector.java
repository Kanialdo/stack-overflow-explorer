package pl.krystiankaniowski.stackoverflowexplorer.dagger.injectors;

import pl.krystiankaniowski.stackoverflowexplorer.MainActivity;
import pl.krystiankaniowski.stackoverflowexplorer.MainApplication;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.components.DaggerMainActivityComponent;

public class ActivityInjector {

    public static void inject(MainActivity mainActivity) {
        DaggerMainActivityComponent
                .builder()
                .baseComponent(MainApplication.getBaseComponent())
                .build()
                .inject(mainActivity);
    }

}
