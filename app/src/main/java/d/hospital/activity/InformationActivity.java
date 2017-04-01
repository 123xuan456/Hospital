package d.hospital.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import d.hospital.R;
import de.hdodenhof.circleimageview.CircleImageView;
/**
 * 个人信息页面
 * */
public class InformationActivity extends Activity implements View.OnClickListener{

    private TextView finish_title;
    private TextView name;
    private TextView sex;
    private TextView textView15;
    private TextView textView17;
    private TextView textView19;
    private ImageView finish_fanhui;
    private RelativeLayout relativeLayout4;
    private RelativeLayout relativeLayout5;
    private RelativeLayout relativeLayout6;
    private RelativeLayout relativeLayout7;
    private RelativeLayout relativeLayout8;
    private RelativeLayout relativeLayout9;
    private RelativeLayout relativeLayout10;
    private CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setview();

    }

    private void setview() {
        finish_title=(TextView)findViewById(R.id.finish_title);
        finish_title.setText("个人信息");
        finish_fanhui=(ImageView)findViewById(R.id.finish_fanhui);
        finish_fanhui.setOnClickListener(this);
        relativeLayout4= (RelativeLayout) findViewById(R.id.relativeLayout4);
        relativeLayout4.setOnClickListener(this);
        relativeLayout5= (RelativeLayout) findViewById(R.id.relativeLayout5);
        relativeLayout5.setOnClickListener(this);
        relativeLayout6= (RelativeLayout) findViewById(R.id.relativeLayout6);
        relativeLayout6.setOnClickListener(this);
        relativeLayout7= (RelativeLayout) findViewById(R.id.relativeLayout7);
        relativeLayout7.setOnClickListener(this);
        relativeLayout8= (RelativeLayout) findViewById(R.id.relativeLayout8);
        relativeLayout8.setOnClickListener(this);
        relativeLayout9= (RelativeLayout) findViewById(R.id.relativeLayout9);
        relativeLayout9.setOnClickListener(this);
        relativeLayout10= (RelativeLayout) findViewById(R.id.relativeLayout10);
        relativeLayout10.setOnClickListener(this);
        circleImageView= (CircleImageView) findViewById(R.id.view);
        name= (TextView) findViewById(R.id.name);
        sex= (TextView) findViewById(R.id.sex);
        textView15= (TextView) findViewById(R.id.textView15);
        textView17= (TextView) findViewById(R.id.textView17);
        textView19= (TextView) findViewById(R.id.textView19);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_fanhui:
                finish();
                break;
            case R.id.relativeLayout4:


                break;
            case R.id.relativeLayout5:


                break;
            case R.id.relativeLayout6:


                break;
            case R.id.relativeLayout7:


                break;
            case R.id.relativeLayout8:


                break;
            case R.id.relativeLayout9:


                break;
            case R.id.relativeLayout10:


                break;

        }
    }
}
