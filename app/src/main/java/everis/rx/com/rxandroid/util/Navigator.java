package everis.rx.com.rxandroid.util;


import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;
import javax.inject.Singleton;

import everis.rx.com.rxandroid.R;
import everis.rx.com.rxandroid.fr.BlankFragment;
import everis.rx.com.rxandroid.fr.MultiplicarFragment;
import everis.rx.com.rxandroid.fr.SecondFragment;


public class Navigator {

    public void navigateToFirstData(FragmentManager fragmentManager, @IdRes int containerId) {
       final FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        BlankFragment f = new BlankFragment();
        ft.replace(containerId, f);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();

    }

    public void navigateToSecondData(FragmentManager fragmentManager, @IdRes int containerId) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        SecondFragment f = new SecondFragment();
        ft.replace(containerId, f);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

    public void navigateToMultiplicar(FragmentManager fragmentManager, @IdRes int containerId) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        MultiplicarFragment f = new MultiplicarFragment();
        ft.replace(containerId, f);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
}
