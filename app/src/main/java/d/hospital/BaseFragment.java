package d.hospital;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by de on 2016/12/9.
 */
public class BaseFragment extends Fragment{
     MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity)getActivity();
    }

    //Intent跳转
//    public void intent2activity(Class<? extends activity> tarActivity){
//        Intent intent = new Intent(activity,tarActivity);
//        startActivity(intent);
//    }
}
