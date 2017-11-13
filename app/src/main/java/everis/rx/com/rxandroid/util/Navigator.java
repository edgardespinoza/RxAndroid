package everis.rx.com.rxandroid.util;


import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import everis.rx.com.rxandroid.R;
import everis.rx.com.rxandroid.fr.PagoAguaFragment;
import everis.rx.com.rxandroid.fr.PagoLuzFragment;
import everis.rx.com.rxandroid.fr.TrasferenciaFragment;


public class Navigator {

    public void navigateToFirstData(FragmentManager fragmentManager, @IdRes int containerId) {
       final FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        PagoLuzFragment f = new PagoLuzFragment();
        ft.replace(containerId, f);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();

    }

    public void navigateToSecondData(FragmentManager fragmentManager, @IdRes int containerId) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        PagoAguaFragment f = new PagoAguaFragment();
        ft.replace(containerId, f);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

    public void navigateToMultiplicar(FragmentManager fragmentManager, @IdRes int containerId) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

        TrasferenciaFragment f = new TrasferenciaFragment();
        ft.replace(containerId, f);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }
}
