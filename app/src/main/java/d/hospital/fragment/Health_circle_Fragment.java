package d.hospital.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import d.hospital.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Health_circle_Fragment extends Fragment {


    public Health_circle_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_health_circle, container, false);
    }

}