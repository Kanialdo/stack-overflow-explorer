package pl.krystiankaniowski.stackoverflowexplorer.dagger.components;

import android.content.SharedPreferences;

import dagger.Component;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.modules.CacheModule;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.modules.NetworkModule;
import pl.krystiankaniowski.stackoverflowexplorer.dagger.scopes.ApplicationScope;

@ApplicationScope
@Component(modules = {CacheModule.class, NetworkModule.class}, dependencies = ApplicationComponent.class)
public interface BaseComponent {

    SharedPreferences getSharedPreferences();

}
