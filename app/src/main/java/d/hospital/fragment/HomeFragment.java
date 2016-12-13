package d.hospital.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import d.hospital.BaseFragment;
import d.hospital.R;
import d.hospital.activity.MineActivity;
import d.hospital.bean.Home_moduleBean;
import d.hospital.utils.UrlUtils;
import okhttp3.Call;

public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private ImageView area1_big1,area1_little11,area1_little21,area1_little31,area1_little41;
    private ImageView area2_big2,area2_little12,area2_little22,area2_little32,area2_little42;
    private View view;
    private ImageView iv_user;//我的

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        initView();
        initData();
        return view;


    }

    private void initView() {
        area1_big1 = (ImageView)view.findViewById(R.id.area1_big);
        iv_user = (ImageView)view.findViewById(R.id.iv_user);
        iv_user.setOnClickListener(this);
        area1_little11 = (ImageView)view.findViewById(R.id.area1_little1);
        area1_little21 = (ImageView)view.findViewById(R.id.area1_little2);
        area1_little31 = (ImageView)view.findViewById(R.id.area1_little3);
        area1_little41 = (ImageView)view.findViewById(R.id.area1_little4);

        area2_big2 = (ImageView)view.findViewById(R.id.area2_big);
        area2_little12 = (ImageView)view.findViewById(R.id.area2_little1);
        area2_little22 = (ImageView)view.findViewById(R.id.area2_little2);
        area2_little32 = (ImageView)view.findViewById(R.id.area2_little3);
        area2_little42 = (ImageView)view.findViewById(R.id.area2_little4);
    }

    public void initData() {
        String url= UrlUtils.HOME_UP_MODULE;
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(String response, int id) {
                Gson g = new Gson();
                Home_moduleBean homemodule = g.fromJson(response, Home_moduleBean.class);
                if (homemodule.getCode() == 200) {
                    String area1_big = homemodule.getArea1_big();
                    String area1_little1 = homemodule.getArea1_little1();
                    String area1_little2 = homemodule.getArea1_little2();
                    String area1_little3 = homemodule.getArea1_little3();
                    String area1_little4 = homemodule.getArea1_little4();

                    String area2_big = homemodule.getArea2_big();
                    String area2_little1 = homemodule.getArea2_little1();
                    String area2_little2 = homemodule.getArea2_little2();
                    String area2_little3 = homemodule.getArea2_little3();
                    String area2_little4 = homemodule.getArea2_little4();

                    glide(area1_big,area1_big1);
                    glide(area1_little1,area1_little11);
                    glide(area1_little2,area1_little21);
                    glide(area1_little3,area1_little31);
                    glide(area1_little4,area1_little41);

                    glide(area2_big,area2_big2);
                    glide(area2_little1,area2_little12);
                    glide(area2_little2,area2_little22);
                    glide(area2_little3,area2_little32);
                    glide(area2_little4,area2_little42);

                }
            }
        });
    }

    private void glide(String imageurl,ImageView imageView){
        Glide.with(HomeFragment.this)
                .load(imageurl)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_user:
                Intent intent = new Intent(getActivity(),MineActivity.class);
                startActivity(intent);
                break;


        }
    }
}
