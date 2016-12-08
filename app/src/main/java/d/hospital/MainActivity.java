package d.hospital;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import d.hospital.fragment.HealthFragment;
import d.hospital.fragment.HomeFragment;
import d.hospital.fragment.InquiryFragment;
import d.hospital.fragment.MessageFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup radioGroup;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.rl_titlebar);
=======
        setContentView(R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup.setOnCheckedChangeListener(this);
        fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);

        if (fragment == null) {
            fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, new HomeFragment()).commit();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_one: {
                fragment = new HomeFragment();//首页
            }
            break;
            case R.id.tab_two: {
                fragment = new InquiryFragment();//我的
            }
            break;
            case R.id.tab_three: {
                fragment = new HealthFragment();//我的
            }
            break;
            case R.id.tab_four1: {
                fragment = new MessageFragment();//我的
            }
            break;
            case R.id.tab_five: {
                fragment = new HealthFragment();//我的
            }
            break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
        }
>>>>>>> 1ac6567073449f5f1852428fa96f9f4b3c4e77c1
    }
}
