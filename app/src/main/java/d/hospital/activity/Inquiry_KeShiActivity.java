package d.hospital.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Inquiry_keshiBean;
import d.hospital.utils.UrlUtils;
import okhttp3.Call;
import okhttp3.Response;

public class Inquiry_KeShiActivity extends Activity implements View.OnClickListener{
    private ListView listView;
    private TextView finish_title;
    private ImageView finish_fanhui;
    private List<Inquiry_keshiBean.MessageBean> message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_shi);
        listView = (ListView) findViewById(R.id.listview);
        finish_title=(TextView)findViewById(R.id.finish_title);
        finish_title.setText("科室");
        finish_fanhui=(ImageView)findViewById(R.id.finish_fanhui);
        finish_fanhui.setOnClickListener(this);
        getdate();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id1) {
                int id=message.get(position).getClassId();
                Intent i=new Intent(Inquiry_KeShiActivity.this,Inquiry_XiangqingActivity.class);
                i.putExtra("id",id);
                i.putExtra("name",message.get(position).getClassName());
                startActivity(i);
                Glide.with(getApplicationContext()).load(id+"").thumbnail(0.1f).into(finish_fanhui);
            }
        });



    }
    public void getdate() {
        Intent i=getIntent();
        String id = i.getStringExtra("id");
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
                        listView.setAdapter(adapter);
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


    class MyAdapter extends BaseAdapter {
        private List<Inquiry_keshiBean.MessageBean> message;

        public MyAdapter(List<Inquiry_keshiBean.MessageBean> message) {
            this.message = message;

        }


        @Override
        public int getCount() {
            if (message.size() > 12) {
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
            convertView = LayoutInflater.from(Inquiry_KeShiActivity.this).inflate(R.layout.item_listview_inquiry, null);
            TextView tv = (TextView) convertView.findViewById(R.id.textView22);
            String name = message.get(position).getClassName();
            tv.setText(name);
            return convertView;
        }
    }
}
