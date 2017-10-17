package everis.rx.com.rxandroid.fr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import everis.rx.com.rxandroid.ApplicationRx;
import everis.rx.com.rxandroid.R;
import everis.rx.com.rxandroid.util.Navigator;

/**
 * Created by eespinor on 17/10/2017.
 */

public abstract class BaseFragment extends Fragment {
    @Inject
    Navigator mNavigator;

    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ApplicationRx)this.getActivity().getApplication()).getComponentRx().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectView(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    private void injectView(View view) {
        ButterKnife.setDebug(true);
        mUnbinder = ButterKnife.bind(this, view);
    }


}
