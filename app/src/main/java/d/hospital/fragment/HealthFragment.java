package d.hospital.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import d.hospital.R;
import d.hospital.adapter.GridViewAdapter;
import d.hospital.adapter.HealthListViewAdapter;
import d.hospital.adapter.ImageAdapter;
import d.hospital.bean.Health_GridViewBean;
import d.hospital.bean.Health_ListViewBean;
import d.hospital.bean.Home_moduleBean;
import d.hospital.utils.UrlUtils;
import d.hospital.view.MyListView;
import okhttp3.Call;

/**
 * A simple {@link Fragment} subclass.
 * 健康商城
 */
public class HealthFragment extends Fragment {


    private ImageView iv_scan,iv_user;
    private RelativeLayout rl_dingdan;
    private View view;
    private ViewPager pager;
    private List mDatass;
    private LinearLayout dot_layout;
    private RecyclerView gridview;
    private MyListView listview;
    private TextView tv_little_advertisement;
    private ImageView area2_big2,area2_little12,area2_little22,area2_little32,area2_little42;
    List<Home_moduleBean.Area4> result4;


    public HealthFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_health, container, false);
        initView();
        initData();
        initListener();
        return view;
    }
    private void initView() {
        iv_scan = (ImageView)view.findViewById(R.id.iv_scan);
        iv_user = (ImageView)view.findViewById(R.id.iv_user);
        rl_dingdan = (RelativeLayout)view.findViewById(R.id.rl_dingdan);
        iv_user.setVisibility(View.GONE);
        rl_dingdan.setVisibility(View.VISIBLE);
        pager = (ViewPager)view.findViewById(R.id.pager);
        dot_layout = (LinearLayout)view.findViewById(R.id.dot_layout);

        gridview = (RecyclerView)view.findViewById(R.id.gridview);

//        area2_big1 = (ImageView) view.findViewById(R.id.text1).findViewById(R.id.area2_big);

        listview = (MyListView)view.findViewById(R.id.listview);
        tv_little_advertisement = (TextView)view.findViewById(R.id.tv_little_advertisement);

        area2_big2 = (ImageView)view.findViewById(R.id.area2_big);
        area2_little12 = (ImageView)view.findViewById(R.id.area2_little1);
        area2_little22 = (ImageView)view.findViewById(R.id.area2_little2);
        area2_little32 = (ImageView)view.findViewById(R.id.area2_little3);
        area2_little42 = (ImageView)view.findViewById(R.id.area2_little4);

    }
    private void initData() {
//        mDatass = new ArrayList<String>(Arrays.asList("http://192.168.0.56:8080/homepic/1-1.jpg", "http://192.168.0.56:8080/homepic/1-1.jpg"
//                , "http://192.168.0.56:8080/homepic/1-1.jpg"));
        iv_scan.setVisibility(View.GONE);
        String url= UrlUtils.HEALTH_PAGER;
        OkHttpUtils.get().url(url).id(0).build().execute(MyStringCallBack);

        String gridviewurl = UrlUtils.GRIDVIEW_HEALTH;
        OkHttpUtils.get().url(gridviewurl).id(1).build().execute(MyStringCallBack);

        String listviewurl = UrlUtils.HEALTH_LISTVIEW;
        OkHttpUtils.get().url(listviewurl).id(2).build().execute(MyStringCallBack);
    }

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            pager.setCurrentItem((pager.getCurrentItem() + 1)%result4.size());
            handler.sendEmptyMessageDelayed(0, 4000);
        }
    };
    //更新数据与圆点
    private void updateIntroAndDot(){
        Log.i("mmm", "---aa" + pager.getCurrentItem());
        Log.i("mmm", "---bb" + result4.size());
        int currentPage =pager.getCurrentItem()% result4.size();
        Log.i("mmm", "---cc" + currentPage);
        //   tv_intro.setText(list.get(currentPage).getIntro());
        for (int i = 0; i < dot_layout.getChildCount(); i++)
            dot_layout.getChildAt(i).setEnabled(i==currentPage);
    }

    private void initDots() {
        for (int i=0; i< result4.size(); i++)
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


    public StringCallback MyStringCallBack = new StringCallback() {
        @Override
        public void onError(Call call, Exception e, int id) {

        }

        @Override
        public void onResponse(String response, int id) {
            Gson g = new Gson();
            switch (id){
                case 0:
                    Home_moduleBean homemodule = g.fromJson(response, Home_moduleBean.class);
                    if (homemodule.getCode() == 200) {
                        result4 = homemodule.getArea4();
                        //小圆点
                        // Log.i("123123", "---aa" + result4.size());
                        initDots();
                        pager.setAdapter(new ImageAdapter(getActivity().getApplication(), result4));
                        int centerValue = Integer.MAX_VALUE/2;
                        // Log.i("123123", "---bb" + centerValue);
                        int value = centerValue % result4.size();
                        Log.i("123123", "---cc" + value);
                        Log.i("123123", "centerVaule-value=" + (centerValue - value));


                        //设置viewPager的第一页为最大整数的中间数，实现伪无限循环
                        pager.setCurrentItem(centerValue - value);
                        updateIntroAndDot();
                        handler.sendEmptyMessageDelayed(0, 4000);

                        break;

                    }
                case 1:
                    Health_GridViewBean health_gridViewBean = g.fromJson(response,Health_GridViewBean.class);
                    if (health_gridViewBean.getCode()==200){
                        List<Health_GridViewBean.Message> gridviewresult = health_gridViewBean.getMessage();
                        gridview.setLayoutManager(new GridLayoutManager(getActivity().getApplication(), 4));
                        GridViewAdapter adapter =  new GridViewAdapter(getActivity().getApplication(),gridviewresult);
                        gridview.setAdapter(adapter);
                    }
                    break;

                case 2:
                    Health_ListViewBean health_listViewBean = g.fromJson(response,Health_ListViewBean.class);
                    if (health_listViewBean.getCode()==200){
                        List<Health_ListViewBean.ListForArea> listforareas = health_listViewBean.getListForArea();
                        tv_little_advertisement.setText(listforareas.get(0).getTitle());

                        List<Health_ListViewBean.ListForAreatitle> listforareatitle = listforareas.get(0).getListForAreatitle();
                        glide(listforareatitle.get(0).getImg(),area2_big2);
                        glide(listforareatitle.get(1).getImg(),area2_little12);
                        glide(listforareatitle.get(2).getImg(), area2_little22);
                        glide(listforareatitle.get(3).getImg(),area2_little32);
                        glide(listforareatitle.get(4).getImg(), area2_little42);

                        List<Health_ListViewBean.Result> result = health_listViewBean.getResult();
                        listview.setAdapter(new HealthListViewAdapter(getActivity().getApplication(), result));

                    }
                    break;
            }
        }
    };

    private void glide(String imageurl,ImageView imageView){
        Glide.with(HealthFragment.this)
                .load(imageurl)
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(imageView);
    }
}
