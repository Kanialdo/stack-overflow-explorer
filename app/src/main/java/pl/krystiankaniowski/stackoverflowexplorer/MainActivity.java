package pl.krystiankaniowski.stackoverflowexplorer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import pl.krystiankaniowski.stackoverflowexplorer.dagger.injectors.ActivityInjector;
import pl.krystiankaniowski.stackoverflowexplorer.ui.BaseFragment;
import pl.krystiankaniowski.stackoverflowexplorer.ui.FragmentChanger;
import pl.krystiankaniowski.stackoverflowexplorer.ui.search.SearchFragment;
import pl.krystiankaniowski.stackoverflowexplorer.ui.search.SearchPresenter;

public class MainActivity extends AppCompatActivity implements FragmentChanger {

    @Inject
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityInjector.inject(this);

        SearchFragment searchFragment = new SearchFragment();
        showFragment(searchFragment);

        SearchPresenter searchPresenter = new SearchPresenter(searchFragment);

    }

    @Override
    public void showFragment(BaseFragment baseFragment) {
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, baseFragment).commit();
    }

    @Override
    public void showInnerFragment(BaseFragment baseFragment) {
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, baseFragment).addToBackStack(baseFragment.toString()).commit();
    }

}
