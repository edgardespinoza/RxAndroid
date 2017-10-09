package everis.rx.com.rxandroid.fr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import everis.rx.com.rxandroid.R;
import everis.rx.com.rxandroid.util.Navigator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link multiplicar.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link multiplicar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class multiplicar extends Fragment {

    @Inject
    Navigator mNavigator;

    @BindView(R.id.id_a)
    EditText a;

    @BindView(R.id.id_b)
    EditText b;

    @BindView(R.id.id_c)
    TextView c;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multiplicar, container, false);
        ButterKnife.bind(this, view);
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
        c.setText(""+(ant*bnt));

    }

    @OnClick(R.id.btn_next)
    public void onNext() {

        mNavigator = new Navigator();
        mNavigator.navigateToFirstData(getFragmentManager(), R.id.content);

    }

}
