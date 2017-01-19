package d.hospital.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.util.List;

import d.hospital.R;
import d.hospital.adapter.Inquiry_XiangqingAdapter;
import d.hospital.bean.Inquiry_xiangqingBean;
import d.hospital.utils.UrlUtils;
import okhttp3.Call;
import okhttp3.Response;

public class Inquiry_XiangqingActivity extends Activity implements View.OnClickListener{

    private int id;
    private ListView listview;
    private String name;
    private TextView finish_title;
    private ImageView finish_fanhui;
    private SwipeRefreshLayout refreshLayout;
    private Inquiry_XiangqingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry__xiangqing);
        refreshLayout=(SwipeRefreshLayout)findViewById(R.id.refreshLayout);
        listview=(ListView)findViewById(R.id.listview);
        Intent i=getIntent();
        id=i.getIntExtra("id",0);
        name=i.getStringExtra("name");
        System.out.println("id="+id);
        System.out.println("name="+name);
        finish_title=(TextView)findViewById(R.id.finish_title);
        finish_title.setText(name);
        finish_fanhui=(ImageView)findViewById(R.id.finish_fanhui);
        finish_fanhui.setOnClickListener(this);
        getData();

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getData();
                        mHandler.sendEmptyMessage(1);
                    }
                }).start();
            }
        });

    }

    @Override
    public Context createDisplayContext(Display display) {
        return super.createDisplayContext(display);
    }

    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return super.createPackageContext(packageName, flags);
    }


    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    refreshLayout.setRefreshing(false);
                    adapter.notifyDataSetChanged();
                    break;

            }
        }
    };
    public void getData() {
        System.out.println("来了");
        String url= UrlUtils.INQUIRY_XIANGQING+id;
        OkGo.get(url).
                tag(this)
                .cacheKey("inquiry_xiangqing")
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Json(s);
                    }

                    public void Json(String s){
                        Gson gson=new Gson();
                        Inquiry_xiangqingBean inquiry_xiangqingBean=gson.fromJson(s,Inquiry_xiangqingBean.class);
                        if (inquiry_xiangqingBean.getCode()==200){
                            List<Inquiry_xiangqingBean.MessageBean> message1 = inquiry_xiangqingBean.getMessage();
                            adapter=new Inquiry_XiangqingAdapter(Inquiry_XiangqingActivity.this,message1);
                            listview.setAdapter(adapter);
                        }else {
                            System.out.println("有问题啦");
                            Log.i("","");
                            Toast.makeText(getApplicationContext(),inquiry_xiangqingBean.getCode()+"",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish_fanhui:
                finish();
                break;
        }
    }
}
