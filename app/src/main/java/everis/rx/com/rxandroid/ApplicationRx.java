package everis.rx.com.rxandroid;

import android.support.multidex.MultiDexApplication;

import everis.rx.com.rxandroid.dagger.ComponentRx;
import everis.rx.com.rxandroid.dagger.DaggerComponentRx;
import everis.rx.com.rxandroid.dagger.ModuleRx;


public class ApplicationRx extends MultiDexApplication {

    ComponentRx componentRx;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();

    }

    private void initializeInjector() {
        this.componentRx = DaggerComponentRx.builder().moduleRx(new ModuleRx()).build();
    }

    public ComponentRx getComponentRx() {
        return this.componentRx;
    }
}
