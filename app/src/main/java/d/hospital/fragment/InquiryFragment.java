package d.hospital.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import d.hospital.BaseFragment;
import d.hospital.R;
import d.hospital.activity.Inquiry_KeShiActivity;
import d.hospital.activity.Inquiry_XiangqingActivity;
import d.hospital.adapter.Inquiry_ErKeAdapter;
import d.hospital.adapter.Inquiry_FuCanAdapter;
import d.hospital.bean.Inquiry_fenkeBean;
import d.hospital.bean.Inquiry_keshiBean;
import d.hospital.bean.Inquiry_picBean;
import d.hospital.utils.GlideImageLoader;
import d.hospital.utils.UrlUtils;
import d.hospital.view.HorizontalListView;
import d.hospital.view.MyGridView;
import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 * 问诊页面
 */
public class InquiryFragment extends BaseFragment {

    Context context;
    View view;
    private Banner banner;
    private MyGridView gridview1;
    private HorizontalListView horizontalListView;
    private HorizontalListView horizontalListView1;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private TextView textView23;
    private TextView textView2;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;
    MyGridView gridView;
    private List<Inquiry_keshiBean.MessageBean> message;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_inquiry_fragment_i, container, false);
        img1= (ImageView) view.findViewById(R.id.image1);
        img2= (ImageView) view.findViewById(R.id.image2);
        img3= (ImageView) view.findViewById(R.id.image3);
        textView23= (TextView) view.findViewById(R.id.textView23);
        textView2= (TextView) view.findViewById(R.id.textView2);
        relativeLayout1= (RelativeLayout) view.findViewById(R.id.relativeLayout1);

        relativeLayout2= (RelativeLayout) view.findViewById(R.id.relativeLayout2);


        banner = (Banner) view.findViewById(R.id.banner);
        carousel();//轮播图
        gridview1=(MyGridView)view.findViewById(R.id.gridview);
        keshi();//科室

        // horizontalListView= (HorizontalListView) view.findViewById(R.id.horizontallistview);
        horizontalListView1= (HorizontalListView) view.findViewById(R.id.horizontallistview1);
        fenke();//
        gridView = (MyGridView) view.findViewById(R.id.grid);

        return view;

    }

    private void setGridView(List<Inquiry_fenkeBean.Message1Bean> cityList) {
        int size = cityList.size();
        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView.setColumnWidth(itemWidth); // 设置列表项宽
        gridView.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(size); // 设置列数量=列表集合数

        Inquiry_ErKeAdapter adapter = new Inquiry_ErKeAdapter(getContext(),
                cityList);
        gridView.setAdapter(adapter);

    }

    private void fenke() {
        OkGo.get(UrlUtils.INQUIRY_FENKE)
                .tag(this)
                .cacheKey("inquiry_fenke")
                .cacheMode(CacheMode.IF_NONE_CACHE_REQUEST)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        json(s);
                    }

                    private void json(String s) {
                        Gson gson = new Gson();
                        Inquiry_fenkeBean fen = gson.fromJson(s, Inquiry_fenkeBean.class);
                        //儿科
                        final List<Inquiry_fenkeBean.Message1Bean> mes1 = fen.getMessage1();
                        textView23.setText(mes1.get(1).getClassName());
                        relativeLayout1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i=new Intent(getActivity(),Inquiry_XiangqingActivity.class);
                                i.putExtra("id",mes1.get(1).getClassId());
                                i.putExtra("name",mes1.get(1).getClassName());
                                startActivity(i);
                            }
                        });
                        setGridView(mes1);
//                        Inquiry_ErKeAdapter adapter = new Inquiry_ErKeAdapter(getContext(),
//                                mes1);
//                        gridView.setAdapter(adapter);
                        //  Inquiry_PediatricsAdapter adapter=new Inquiry_PediatricsAdapter(getActivity(),mes1);
                        // horizontalListView.setAdapter(adapter);
                        //妇产科

                        final List<Inquiry_fenkeBean.Message2Bean> mes2 = fen.getMessage2();
                        textView2.setText(mes2.get(1).getClassName());
                        relativeLayout2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i=new Intent(getActivity(),Inquiry_XiangqingActivity.class);
                                i.putExtra("id",mes2.get(1).getClassId());
                                i.putExtra("name",mes2.get(1).getClassName());
                                startActivity(i);
                            }
                        });
                        Inquiry_FuCanAdapter adapter1=new Inquiry_FuCanAdapter(getActivity(),mes2);
                        horizontalListView1.setAdapter(adapter1);

                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        super.onCacheSuccess(s, call);
                        json(s);
                    }
                });


    }


    private void keshi() {
        OkGo.get(UrlUtils.INQUIRY_KESHI)
                .tag(this)
                .cacheKey("inquiry_keshi")
                .cacheMode(CacheMode.IF_NONE_CACHE_REQUEST)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        json(s);
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        super.onCacheSuccess(s, call);
                        json(s);
                    }

                    private void json(String s) {
                        Gson gson=new Gson();
                        Inquiry_keshiBean ke = gson.fromJson(s, Inquiry_keshiBean.class);
                        message = ke.getMessage();
                        MyAdapter adapter=new MyAdapter(message);
                        gridview1.setAdapter(adapter);
                    }


                });

    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }
    @Override
    public void onStop()    {
        super.onStop();
        banner.stopAutoPlay();
    }

    public void carousel() {
        OkGo.get(UrlUtils.INQUIRY_PIC)// 请求方式和请求url
                .tag(this)                       // 请求的 tag, 主要用于取消对应的请求
                .cacheKey("inquiry_pic")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                .cacheMode(CacheMode.IF_NONE_CACHE_REQUEST)    // 缓存
                .execute(new StringCallback() {
                    public Inquiry_picBean Area1Bean;
                    public Inquiry_picBean Area2Bean;

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        // s 即为所需要的结果
                        json(s);


                    }

                    private void json(String s) {
                        Gson gson=new Gson();
                        Area1Bean=gson.fromJson(s, Inquiry_picBean.class);
                        Area2Bean=gson.fromJson(s, Inquiry_picBean.class);
                        Inquiry_picBean.Area1Bean image = Area1Bean.getArea1();
                        String[] urls= {
                                image.getArea1_big1(),
                                image.getArea1_big2(),
                                image.getArea1_big3()
                        };
                        List list = Arrays.asList(urls);
                        ArrayList images = new ArrayList(list);
                        //banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                        //设置图片集合
                        banner.setImages(images);
                        //设置图片加载器
                        banner.setImageLoader(new GlideImageLoader());
                        //banner.setOnBannerClickListener(this);
                        banner.start();
                        Inquiry_picBean.Area2Bean image1 = Area2Bean.getArea2();

                        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(image1.getArea2_left1(), img1);
                        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(image1.getArea2_left2(), img2);
                        com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(image1.getArea2_right(), img3);

                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        super.onCacheSuccess(s, call);
                        json(s);

                    }
                });
    }

    /**
     * 科室分类
     * 判断了显示的科室名，在最后的位置显示更多
     * 进行了点击事件
     *
     */
    class MyAdapter extends BaseAdapter{
        private List<Inquiry_keshiBean.MessageBean> message;
        public MyAdapter(List<Inquiry_keshiBean.MessageBean> message) {
            this.message=message;

        }


        @Override
        public int getCount() {
            if (message.size()>12){
                return 12;
            }
            return message.size();
        }

        @Override
        public Object getItem(int position) {
            return message.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView=LayoutInflater.from(getActivity()).inflate(R.layout.item_gridview_inquiry,null);
            TextView tv= (TextView) convertView.findViewById(R.id.textView22);

            if (message.size()>=12){
                message.get(11).setClassName("更多");
                String name = message.get(position).getClassName();
                if (name.equals("更多")){
                    tv.setTextColor(ContextCompat.getColor(getContext(),R.color.text_blue));
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(), Inquiry_KeShiActivity.class);
                            i.putExtra("id",message.get(position).getClassName());
                            startActivity(i);
                        }
                    });
                }else if (!name.equals("更多"))
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id=message.get(position).getClassId();
                            Intent i=new Intent(getActivity(),Inquiry_XiangqingActivity.class);
                            i.putExtra("id",id);
                            i.putExtra("name",message.get(position).getClassName());
                            startActivity(i);
                        }
                    });
                tv.setText(name);

            }else if (message.size()<12){
                message.get(position-1).setClassName("更多");
                String name = message.get(position).getClassName();
                if (name.equals("更多")){
                    tv.setTextColor(ContextCompat.getColor(getContext(),R.color.text_blue));
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getActivity(), Inquiry_KeShiActivity.class);
                            i.putExtra("id",message.get(position).getClassName());
                            startActivity(i);
                        }
                    });
                }else if (!name.equals("更多"))
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id=message.get(position).getClassId();
                            Intent i=new Intent(getActivity(),Inquiry_XiangqingActivity.class);
                            i.putExtra("id",id);
                            i.putExtra("name",message.get(position).getClassName());
                            startActivity(i);
                        }
                    });
                tv.setText(name);
            }

            return convertView;
        }


    }
}
