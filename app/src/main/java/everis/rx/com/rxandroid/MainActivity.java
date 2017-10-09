package everis.rx.com.rxandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import everis.rx.com.rxandroid.util.Navigator;

public class MainActivity extends AppCompatActivity {

    @Inject
    Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavigator = new Navigator();
        mNavigator.navigateToFirstData(getSupportFragmentManager(), R.id.content );

    }


}
