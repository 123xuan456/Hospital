package d.hospital;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import d.hospital.fragment.HealthFragment;
import d.hospital.fragment.Health_circle_Fragment;
import d.hospital.fragment.HomeFragment;
import d.hospital.fragment.InquiryFragment;
import d.hospital.fragment.MessageFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup radioGroup;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                fragment = new InquiryFragment();//问诊
            }
            break;
            case R.id.tab_three: {
                fragment = new HealthFragment();//健康商城
            }
            break;
            case R.id.tab_four1: {
                fragment = new MessageFragment();//消息
            }
            break;
            case R.id.tab_five: {
                fragment = new Health_circle_Fragment();//健康圈
            }
            break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).commit();
        }
    }
}
