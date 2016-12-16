package pl.krystiankaniowski.stackoverflowexplorer.dagger.injectors;

import pl.krystiankaniowski.stackoverflowexplorer.MainActivity;
import pl.krystiankaniowski.stackoverflowexplorer.MainApplication;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.components.DaggerMainActivityComponent;
import pl.krystiankaniowski.stackoverflowexplorer.ui.search.SearchPresenter;

public class PresenterInjector {

    public static void inject(SearchPresenter presenter) {
        DaggerMainActivityComponent
                .builder()
                .baseComponent(MainApplication.getBaseComponent())
                .build()
                .inject(presenter);
    }


}
