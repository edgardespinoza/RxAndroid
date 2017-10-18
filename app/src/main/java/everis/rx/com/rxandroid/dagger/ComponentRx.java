package everis.rx.com.rxandroid.dagger;

import javax.inject.Singleton;

import dagger.Component;
import everis.rx.com.rxandroid.MainActivity;
import everis.rx.com.rxandroid.fr.BaseFragment;

@Singleton
@Component(modules = {ModuleRx.class})
public interface ComponentRx {
    void inject(MainActivity mainActivity);

    void inject(BaseFragment BaseFragment);

}
