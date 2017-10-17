package everis.rx.com.rxandroid.dagger;

import javax.inject.Singleton;

import dagger.Component;
import everis.rx.com.rxandroid.ListenerActivity;
import everis.rx.com.rxandroid.MainActivity;
import everis.rx.com.rxandroid.fr.BaseFragment;
import everis.rx.com.rxandroid.fr.BlankFragment;
import everis.rx.com.rxandroid.fr.MultiplicarFragment;
import everis.rx.com.rxandroid.fr.SecondFragment;
import everis.rx.com.rxandroid.util.Navigator;

@Singleton
@Component(modules = {ModuleRx.class})
public interface ComponentRx {
    void inject(MainActivity mainActivity);
    void inject(BaseFragment BaseFragment);
   // Navigator navigator();
}
