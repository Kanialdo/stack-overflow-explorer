package pl.krystiankaniowski.stackoverflowexplorer.dagger.components;

import dagger.Component;
import pl.krystiankaniowski.stackoverflowexplorer.MainActivity;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.scopes.ActivityScope;

@ActivityScope
@Component(dependencies = BaseComponent.class)
public interface MainActivityComponent {

    void inject(MainActivity activity);

}
