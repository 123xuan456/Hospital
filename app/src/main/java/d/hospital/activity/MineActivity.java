package d.hospital.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import d.hospital.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineActivity extends Activity implements View.OnClickListener{
    TextView name,//昵称
            textView,//健康号
            textView3,//微信登录
            textView4,
            textView6;
    private CircleImageView circleimageview;
    private ImageView finish_fanhui;
    private RelativeLayout relativeLayout2;
    private RelativeLayout me_doctor_layout;
    private RelativeLayout me_jiankangquan_layout;
    private RelativeLayout me_ceping_layout;
    private RelativeLayout me_jihua_layout;
    private RelativeLayout me_friend_layout;
    private RelativeLayout me_dangan_layout;
    private RelativeLayout me_dingdan_layout;
    private RelativeLayout me_gouwuka_layout;
    private RelativeLayout me_youhuiquan_layout;
    private RelativeLayout me_kaquan_layout;
    private RelativeLayout me_baoxian_layout;
    private RelativeLayout me_invitefriends_layout;
    private RelativeLayout me_zhibo_layout;
    private RelativeLayout me_fuwu_layout;
    private RelativeLayout me_toutiao_layout;
    private RelativeLayout me_jianyi_layout;
    private RelativeLayout me_shezhi_layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        setview();
    }

    private void setview() {
        name= (TextView) findViewById(R.id.name);
        textView= (TextView) findViewById(R.id.textView);
        textView3= (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
        textView4= (TextView) findViewById(R.id.textView4);
        textView6= (TextView) findViewById(R.id.textView6);
        circleimageview=(CircleImageView)findViewById(R.id.view);
        finish_fanhui= (ImageView) findViewById(R.id.finish_fanhui);
        finish_fanhui.setOnClickListener(this);
        relativeLayout2=(RelativeLayout)findViewById(R.id.relativeLayout2);
        relativeLayout2.setOnClickListener(this);

        me_doctor_layout=(RelativeLayout)findViewById(R.id.me_doctor_layout);
        me_jiankangquan_layout=(RelativeLayout)findViewById(R.id.me_jiankangquan_layout);
        me_ceping_layout=(RelativeLayout)findViewById(R.id.me_ceping_layout);
        me_jihua_layout=(RelativeLayout)findViewById(R.id.me_jihua_layout);
        me_friend_layout=(RelativeLayout)findViewById(R.id.me_friend_layout);
        me_dangan_layout=(RelativeLayout)findViewById(R.id.me_dangan_layout);
        me_dingdan_layout=(RelativeLayout)findViewById(R.id.me_dingdan_layout);
        me_gouwuka_layout=(RelativeLayout)findViewById(R.id.me_gouwuka_layout);
        me_youhuiquan_layout=(RelativeLayout)findViewById(R.id.me_youhuiquan_layout);
        me_kaquan_layout=(RelativeLayout)findViewById(R.id.me_kaquan_layout);
        me_baoxian_layout=(RelativeLayout)findViewById(R.id.me_baoxian_layout);
        me_invitefriends_layout=(RelativeLayout)findViewById(R.id.me_invitefriends_layout);
        me_zhibo_layout=(RelativeLayout)findViewById(R.id.me_zhibo_layout);
        me_fuwu_layout=(RelativeLayout)findViewById(R.id.me_fuwu_layout);
        me_toutiao_layout=(RelativeLayout)findViewById(R.id.me_toutiao_layout);
        me_jianyi_layout=(RelativeLayout)findViewById(R.id.me_jianyi_layout);
        me_shezhi_layout=(RelativeLayout)findViewById(R.id.me_shezhi_layout);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView3:

                break;
            case R.id.finish_fanhui:
                finish();
                break;
            case R.id.relativeLayout2:
                Intent intent=new Intent(this,InformationActivity.class);
                startActivity(intent);

                break;



        }
    }
}
