package d.hospital.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import d.hospital.BaseFragment;
import d.hospital.R;
import d.hospital.activity.CommonScanActivity;
import d.hospital.activity.InQuiryActivity;
import d.hospital.activity.MineActivity;
import d.hospital.adapter.AppraisalAdapter;
import d.hospital.adapter.GalleryAdapter;
import d.hospital.adapter.HotAdapter;
import d.hospital.adapter.ImageAdapter;
import d.hospital.adapter.InformationAdapter;
import d.hospital.adapter.PlanAdapter;
import d.hospital.bean.Home_moduleBean;
import d.hospital.bean.Home_twoBean;
import d.hospital.utils.UrlUtils;
import d.hospital.view.MyListView;
import d.hospital.view.ScrollViewExtend;
import okhttp3.Call;

public class HomeFragment extends BaseFragment implements View.OnClickListener{

   // @InjectView(R.id.area1_big)
    ImageView area1_big1;
    private ImageView area1_little11, area1_little21, area1_little31, area1_little41;
    private ImageView area2_big2, area2_little12, area2_little22, area2_little32, area2_little42;
    private View view;
    private TextView tv_roll;
    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<String> mDatas;
    private List<String> mDatass;

    private ViewPager pager, appraisal_pager;
    private LinearLayout dot_layout;
    private ListView listView, plan_listview;
    private MyListView information_listview;
    private List<String> textdatas;
    private List setexts;
    private RelativeLayout in_total_rl_text_image, rl_pack_up;
    private ImageView iv_user;//我的
    private ImageView iv_bt_three, iv_bt_two, iv_bt_one;
    private PlanAdapter planAdapter;
    private List<Home_moduleBean.Area4> result4;
    private ScrollViewExtend sc_scrollview;
    private String a = 1 + "";

    private TextView tv_bt_in;
    private TextView textView, textView1, textView5;//步步为金
    private TextView tv_schedule, tv_time;
    List<Home_twoBean.HealthPlan> plans;


    private TextView textView21, textView22, textView23;//记经期

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
       // ButterKnife.inject(this, view);
        area1_big1 = (ImageView) view.findViewById(R.id.area1_big);
        initView();
        initData();
        initListener();

        return view;


    }

    private void initView() {
        tv_roll = (TextView) view.findViewById(R.id.tv_roll);

        iv_user = (ImageView) view.findViewById(R.id.iv_user);
        iv_user.setOnClickListener(this);
        area1_little11 = (ImageView) view.findViewById(R.id.area1_little1);
        area1_little21 = (ImageView) view.findViewById(R.id.area1_little2);
        area1_little31 = (ImageView) view.findViewById(R.id.area1_little3);
        area1_little41 = (ImageView) view.findViewById(R.id.area1_little4);

        area2_big2 = (ImageView) view.findViewById(R.id.area2_big);
        area2_little12 = (ImageView) view.findViewById(R.id.area2_little1);
        area2_little22 = (ImageView) view.findViewById(R.id.area2_little2);
        area2_little32 = (ImageView) view.findViewById(R.id.area2_little3);
        area2_little42 = (ImageView) view.findViewById(R.id.area2_little4);

        iv_bt_three = (ImageView) view.findViewById(R.id.iv_bt_three);
        iv_bt_two = (ImageView) view.findViewById(R.id.iv_bt_two);
        iv_bt_one = (ImageView) view.findViewById(R.id.iv_bt_one);

        dot_layout = (LinearLayout) view.findViewById(R.id.dot_layout);//小圆点

        mRecyclerView = (RecyclerView) view.findViewById(R.id.mRecyclerView);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //这里有网络获取
        mDatas = new ArrayList<String>(Arrays.asList("http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"
                , "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"));

        //轮播图
        pager = (ViewPager) view.findViewById(R.id.pager);
        //健康测评
        appraisal_pager = (ViewPager) view.findViewById(R.id.appraisal_pager);

        listView = (ListView) view.findViewById(R.id.listView);//热门帖子的listview
        listView.setFocusable(false);

        information_listview = (MyListView) view.findViewById(R.id.information_listview);//健康资讯的listview

        plan_listview = (ListView) view.findViewById(R.id.plan_listview);//健康计划

        in_total_rl_text_image = (RelativeLayout) view.findViewById(R.id.in_total_rl_text_image);
        in_total_rl_text_image.setOnClickListener(this);

        rl_pack_up = (RelativeLayout) view.findViewById(R.id.rl_pack_up);
        rl_pack_up.setOnClickListener(this);

        tv_bt_in = (TextView) view.findViewById(R.id.tv_bt_in);

        //步步为金
        textView = (TextView) view.findViewById(R.id.textView);
        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView5 = (TextView) view.findViewById(R.id.textView5);

        tv_time = (TextView) view.findViewById(R.id.tv_time);

        textView21 = (TextView) view.findViewById(R.id.textView21);
        textView22 = (TextView) view.findViewById(R.id.textView22);
        textView23 = (TextView) view.findViewById(R.id.textView23);

        sc_scrollview = (ScrollViewExtend) view.findViewById(R.id.sc_scrollview);
        sc_scrollview.smoothScrollBy(0, 0);

        area1_big1.setOnClickListener(this);//快速问诊


    }

    public void initData() {

        mDatass = new ArrayList<String>(Arrays.asList("http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"
                , "http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"));


//        setListViewHeightBasedOnChildren(listView);
//        getListViewParams();


        String url = UrlUtils.HOME_UP_MODULE;
        String url2 = UrlUtils.HOME_UP_TWO;
        OkHttpUtils.get().url(url2)
                .addParams("userId", a)
                .id(1).build().execute(MyStringCallBack);

        OkHttpUtils.get().url(url).id(0).build().execute(MyStringCallBack);

    }

    StringCallback MyStringCallBack = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {

            Log.i("mhysa-->",response);
            Gson g = new Gson();
            switch (id) {
                case 0:
                    Home_moduleBean homemodule = g.fromJson(response, Home_moduleBean.class);
                    if (homemodule.getCode() == 200) {
                        tv_roll.setText(homemodule.getHealthNews());

                        List<Home_moduleBean.Area1> result1 = homemodule.getArea1();
                        glide(result1.get(0).getPicUrl1(), area1_big1);
                        glide(result1.get(1).getPicUrl1(), area1_little11);
                        glide(result1.get(2).getPicUrl1(), area1_little21);
                        glide(result1.get(3).getPicUrl1(), area1_little31);
                        glide(result1.get(4).getPicUrl1(), area1_little41);
                        List<Home_moduleBean.Area2> result2 = homemodule.getArea2();
                        glide(result2.get(0).getPicUrl2(), area2_big2);
                        glide(result2.get(1).getPicUrl2(), area2_little12);
                        glide(result2.get(2).getPicUrl2(), area2_little22);
                        glide(result2.get(3).getPicUrl2(), area2_little32);
                        glide(result2.get(4).getPicUrl2(), area2_little42);

                        glide(result2.get(5).getPicUrl2(), iv_bt_one);
                        glide(result2.get(6).getPicUrl2(), iv_bt_two);
                        glide(result2.get(7).getPicUrl2(), iv_bt_three);
                        List<Home_moduleBean.Area3> result3 = homemodule.getArea3();
                        mAdapter = new GalleryAdapter(getActivity().getApplicationContext(), result3);
                        mRecyclerView.setAdapter(mAdapter);

                        result4 = homemodule.getArea4();
                        //小圆点
                        initDots();
                        pager.setAdapter(new ImageAdapter(getActivity().getApplication(), result4));
                        int centerValue = Integer.MAX_VALUE / 2;
                        int value = centerValue % result4.size();
                        //设置viewPager的第一页为最大整数的中间数，实现伪无限循环
                        pager.setCurrentItem(centerValue - value);
                        updateIntroAndDot();
                        handler.sendEmptyMessageDelayed(0, 4000);

                        List<Home_moduleBean.HealthTest> healthTests = homemodule.getHealthTest();
                        appraisal_pager.setAdapter(new AppraisalAdapter(getActivity().getApplication(), healthTests));
                    }
                    break;
                case 1:
                    Home_twoBean home_twoBean = g.fromJson(response, Home_twoBean.class);
                    if (home_twoBean.getCode() == 200) {
                        //步步为金
                        tv_bt_in.setText(home_twoBean.getEveryStepGetGold().getText());
                        textView.setText(home_twoBean.getEveryStepGetGold().getStep() + "步");
                        textView1.setText(home_twoBean.getEveryStepGetGold().getCalorie() + "卡");
                        textView5.setText(home_twoBean.getEveryStepGetGold().getFat() + "克");

                        //健康计划
                        plans = home_twoBean.getHealthPlan();
                        tv_time.setText(home_twoBean.getDate_today());
//                        tv_schedule.setText("haha");
                        setexts = new ArrayList();
                        if (plans.size() <= 2 && plans.size() > 0) {
                            in_total_rl_text_image.setVisibility(View.GONE);
                            setexts.addAll(plans);
                        } else {
                            setexts.add(plans.get(0));
                            setexts.add(plans.get(1));
                        }
                        planAdapter = new PlanAdapter(getActivity().getApplication(), setexts);
                        plan_listview.setAdapter(planAdapter);

                        //记经期
                        textView21.setText(home_twoBean.getMenstruation().getFromTo());
                        textView22.setText("距离下次月经还有" + home_twoBean.getMenstruation().getHowDay() + "天");
                        textView23.setText("小贴士：" + home_twoBean.getMenstruation().getTips());

                        //热门帖子
                        List<Home_twoBean.HotPost> home_hot = home_twoBean.getHotPost();
                        listView.setAdapter(new HotAdapter(getActivity().getApplication(), home_hot));

                        //资讯
                        List<Home_twoBean.HealthInformation> home_informations = home_twoBean.getHealthInformation();
                        information_listview.setAdapter(new InformationAdapter(getActivity().getApplication(), home_informations));

                    }
                    break;
            }
        }
    };

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            pager.setCurrentItem((pager.getCurrentItem() + 1) % result4.size());
            handler.sendEmptyMessageDelayed(0, 4000);
        }
    };

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
        for (int i = 0; i < result4.size(); i++) {
            View view = new View(getActivity().getApplication());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(8, 8);
//            params.gravity = Gravity.CENTER_VERTICAL;
//            dot_layout.setLayoutParams(params);
            if (i != 0) {
                params.leftMargin = 5;
            }
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.dot_select);
            dot_layout.addView(view);
        }
    }

    //更新数据与圆点
    private void updateIntroAndDot() {

        int currentPage = pager.getCurrentItem() % result4.size();
        //   tv_intro.setText(list.get(currentPage).getIntro());
        for (int i = 0; i < dot_layout.getChildCount(); i++)
            dot_layout.getChildAt(i).setEnabled(i == currentPage);
    }


    private void glide(String imageurl, ImageView imageView) {
        Glide.with(HomeFragment.this)
                .load(imageurl)
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(imageView);
    }




    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user:
                Intent intent = new Intent(getActivity(), MineActivity.class);
                startActivity(intent);
                break;

            case R.id.in_total_rl_text_image:
                planAdapter = new PlanAdapter(getActivity().getApplication(), plans);
                plan_listview.setAdapter(planAdapter);
                rl_pack_up.setVisibility(View.VISIBLE);
                in_total_rl_text_image.setVisibility(View.GONE);
                break;

            case R.id.rl_pack_up:
                planAdapter = new PlanAdapter(getActivity().getApplication(), setexts);
                plan_listview.setAdapter(planAdapter);
                rl_pack_up.setVisibility(View.GONE);
                in_total_rl_text_image.setVisibility(View.VISIBLE);
                break;

            case R.id.area1_big:
                Intent intent1 = new Intent(getActivity(), InQuiryActivity.class);
                startActivity(intent1);
                break;

        }
    }

    //scoview和listview冲突
    public static void setListViewHeightBasedOnChildren(ListView listView2) {
        ListAdapter listAdapter = listView2.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        View listItem = listAdapter.getView(0, null, listView2);
        listItem.measure(0, 0); // 计算子项View 的宽高
        totalHeight = listItem.getMeasuredHeight() * (listAdapter.getCount()); // 统计所有子项的总高度
        ViewGroup.LayoutParams params = listView2.getLayoutParams();
        params.height = totalHeight
                + (listView2.getDividerHeight() * (listAdapter.getCount() - 1));
// listView.getDividerHeight()获取子项间分隔符占用的高度
// params.height最后得到整个ListView完整显示需要的高度
        listView2.setLayoutParams(params);
    }

    public ViewGroup.LayoutParams getListViewParams() {
        //通过ListView获取其中的适配器adapter
        ListAdapter listAdapter = listView.getAdapter();

        //声明默认高度为0
        int totalHeight = 0;
        //便利ListView所有的item，累加所有item的高度就是ListView的实际高度
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        //将累加获取的totalHeight赋值给LayoutParams的height属性
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        return params;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       // ButterKnife.reset(this);
    }
}
