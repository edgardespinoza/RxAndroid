package everis.rx.com.rxandroid.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import everis.rx.com.rxandroid.ApplicationRx;
import everis.rx.com.rxandroid.util.Navigator;


@Module
public class ModuleRx {

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }
}
