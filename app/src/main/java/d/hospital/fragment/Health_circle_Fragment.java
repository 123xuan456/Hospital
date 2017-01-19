package d.hospital.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import d.hospital.R;
import d.hospital.adapter.NewsFragmentPagerAdapter;
import d.hospital.bean.Tab_HealthBean;
import d.hospital.fragment.circle.BlankFragment;
import d.hospital.utils.UrlUtils;
import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * 健康圈
 */
public class Health_circle_Fragment extends Fragment implements ViewPager.OnPageChangeListener{
    @Bind(R.id.iv_scan)
    TextView ivScan;
    @Bind(R.id.hunt)
    ImageView hunt;
    @Bind(R.id.tv_hunt)
    EditText tvHunt;
    @Bind(R.id.rgChannel)
    RadioGroup rgChannel;
    @Bind(R.id.hvChannel)
    HorizontalScrollView hvChannel;
    @Bind(R.id.ivShowChannel)
    ImageView ivShowChannel;
    @Bind(R.id.vpNewsList)
    ViewPager vpNewsList;
    private View view;
    private List<Fragment> fragments=new ArrayList<>();
    private NewsFragmentPagerAdapter adapter;
    private String tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_health_circle, null);
            ButterKnife.bind(this, view);
            rgChannel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    vpNewsList.setCurrentItem(checkedId);
                }
            });

            initTab(inflater);
            // initViewpager();
        }
        ViewGroup parent=(ViewGroup)view.getParent();
        if(parent!=null){
            parent.removeView(view);
        }
        return view;
    }
    public List<Tab_HealthBean.HealthheadlinesBean> healthheadlines;
    public Tab_HealthBean h;

    private void initTab(final LayoutInflater inflater) {
        OkGo.get(UrlUtils.HEALTH_CIRCLE_TAB).
                tag(this).
                cacheKey("health_circle_tab").
                cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE).
                execute(new StringCallback() {

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        json(s,inflater);
                    }
                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        super.onCacheSuccess(s, call);
                        json(s,inflater);
                    }
                });

    }
    private void json(String s, LayoutInflater inflater) {
        Gson gson=new Gson();
        h=gson.fromJson(s,Tab_HealthBean.class);
        healthheadlines=h.getHealthheadlines();
        for (int i1=0;i1<healthheadlines.size();i1++){
            tab=healthheadlines.get(i1).getHeatitle();
            RadioButton  rb= (RadioButton) inflater.inflate(R.layout.tab_rb,null);
            rb.setId(i1);
            rb.setText(tab);
            RadioGroup.LayoutParams params=new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            rb.setLayoutParams(params);
            rgChannel.addView(rb);
            rgChannel.check(0);
        }
        initViewpager(healthheadlines);
    }

    private void initViewpager(List<Tab_HealthBean.HealthheadlinesBean> healthheadlines1) {
        for (int i1=0;i1<healthheadlines1.size();i1++){
            tab=healthheadlines.get(i1).getHeatitle();
                BlankFragment fragment=new BlankFragment();
                Bundle bundle=new Bundle();
                bundle.putString("cname", tab);
                bundle.putInt("id", healthheadlines.get(i1).getId());
                fragment.setArguments(bundle);
                fragments.add(fragment);
            adapter=new NewsFragmentPagerAdapter(getChildFragmentManager(),fragments);
            vpNewsList.setAdapter(adapter);
            vpNewsList.setOffscreenPageLimit(2);//预加载
            vpNewsList.setCurrentItem(0);
            vpNewsList.addOnPageChangeListener(this);
        }

    }


    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onPageSelected(int idx) {
        setTab(idx);
    }
    private void setTab(int idx){
        RadioButton rb=(RadioButton)rgChannel.getChildAt(idx);
        rb.setChecked(true);
        int left=rb.getLeft();
        int width=rb.getMeasuredWidth();
        DisplayMetrics metrics=new DisplayMetrics();
        super.getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenWidth=metrics.widthPixels;
        int len=left+width/2-screenWidth/2;
        hvChannel.smoothScrollTo(len, 0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
