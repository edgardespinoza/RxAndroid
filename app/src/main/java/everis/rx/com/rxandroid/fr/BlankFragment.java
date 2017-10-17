package everis.rx.com.rxandroid.fr;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import everis.rx.com.rxandroid.ApplicationRx;
import everis.rx.com.rxandroid.R;
import everis.rx.com.rxandroid.util.Navigator;


public class BlankFragment extends BaseFragment {


    @BindView(R.id.id_a)
    EditText a;

    @BindView(R.id.id_b)
    EditText b;

    @BindView(R.id.id_c)
    TextView c;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @OnClick(R.id.idsumar)
    public void onStartChangePasswordClick() {
        int ant = Integer.parseInt(a.getText().toString());
        int bnt = Integer.parseInt(b.getText().toString());
        c.setText(""+(ant+bnt));

    }

    @OnClick(R.id.btn_next)
    public void onNext() {
        Log.d("IBK", mNavigator.toString());

        mNavigator.navigateToSecondData(getFragmentManager(), R.id.content);

    }


}
