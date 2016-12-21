package d.hospital.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import d.hospital.BaseFragment;
import d.hospital.R;
import d.hospital.adapter.GalleryAdapter;
import d.hospital.adapter.ImageAdapter;
import d.hospital.activity.MineActivity;
import d.hospital.bean.Home_moduleBean;
import d.hospital.utils.UrlUtils;
import okhttp3.Call;

public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private ImageView area1_big1,area1_little11,area1_little21,area1_little31,area1_little41;
    private ImageView area2_big2,area2_little12,area2_little22,area2_little32,area2_little42;
    private View view;
    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<String> mDatas;
    private List<String> mDatass;
    private ViewPager pager;
    private LinearLayout dot_layout;

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            pager.setCurrentItem(pager.getCurrentItem() + 1);
            handler.sendEmptyMessageDelayed(0, 4000);
        }
    };

    private ImageView iv_user;//我的

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        initView();
        initData();
        initListener();
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

        dot_layout = (LinearLayout)view.findViewById(R.id.dot_layout);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.mRecyclerView);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //这里有网络获取
        mDatas = new ArrayList<String>(Arrays.asList("http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"
                , "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"));
        mAdapter = new GalleryAdapter(getActivity().getApplicationContext(),mDatas);
        mRecyclerView.setAdapter(mAdapter);

        pager = (ViewPager)view.findViewById(R.id.pager);




    }



    public void initData() {
        mDatass = new ArrayList<String>(Arrays.asList("http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"
                , "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"));
        //小圆点
        initDots();
        pager.setAdapter(new ImageAdapter(getActivity().getApplication(), mDatass));
        int centerValue = Integer.MAX_VALUE/2;
        int value = centerValue % mDatass.size();
        //设置viewPager的第一页为最大整数的中间数，实现伪无限循环
        pager.setCurrentItem(centerValue-value);
        updateIntroAndDot();
        handler.sendEmptyMessageDelayed(0, 4000);


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

                    glide(area1_big, area1_big1);
                    glide(area1_little1, area1_little11);
                    glide(area1_little2, area1_little21);
                    glide(area1_little3, area1_little31);
                    glide(area1_little4, area1_little41);

                    glide(area2_big, area2_big2);
                    glide(area2_little1, area2_little12);
                    glide(area2_little2, area2_little22);
                    glide(area2_little3, area2_little32);
                    glide(area2_little4, area2_little42);

                }
            }
        });

    }
    //初始化监听器，当页面改变时，更新其相应数据
    private void initListener() {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                updateIntroAndDot();
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initDots() {
        for (int i=0; i< mDatass.size(); i++)
        {
            View view = new View(getActivity().getApplication());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8,8);
//            params.gravity = Gravity.CENTER_VERTICAL;
//            dot_layout.setLayoutParams(params);
            if(i!=0) {
                params.leftMargin = 5;
            }
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.dot_select);
            dot_layout.addView(view);
        }
    }

    //更新数据与圆点
    private void updateIntroAndDot(){
        Log.i("mmm", "---"+pager.getCurrentItem());
        int currentPage = pager.getCurrentItem() % mDatass.size();
        //   tv_intro.setText(list.get(currentPage).getIntro());
        for (int i = 0; i < dot_layout.getChildCount(); i++)
            dot_layout.getChildAt(i).setEnabled(i==currentPage);
    }


    private void glide(String imageurl,ImageView imageView){
        Glide.with(HomeFragment.this)
                .load(imageurl)
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
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
