package pl.krystiankaniowski.stackoverflowexplorer;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import pl.krystiankaniowski.stackoverflowexplorer.dagger.injectors.ActivityInjector;

public class MainActivity extends AppCompatActivity {

    @Inject
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityInjector.inject(this);

    }

}
