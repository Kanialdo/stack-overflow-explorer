package pl.krystiankaniowski.stackoverflowexplorer.dagger.components;

import dagger.Component;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.scopes.ApplicationScope;

@ApplicationScope
@Component(dependencies = ApplicationComponent.class)
public interface BaseComponent {

}
