package d.hospital.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import d.hospital.R;

/**
 * Created by de on 2016/12/26.
 */
public class InQuiry_GridView1_item_Adapter extends BaseAdapter {

    private List<String> datas;
    private Context context;
    private int clickStatus = 0;
    public InQuiry_GridView1_item_Adapter(Context context, List<String> datas){
        this.context = context;
        this.datas = datas;
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewTag;
        if(convertView==null){
            viewTag = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_inquiry_describe, null);
            viewTag.mtitel = (TextView) convertView.findViewById(R.id.title);
            viewTag.root = (RelativeLayout)convertView.findViewById(R.id.root);
            convertView.setTag(viewTag);
        }else {
            viewTag = (ViewHolder) convertView.getTag();
        }
        viewTag.mtitel.setText(datas.get(position));
        if (clickStatus==position) {
            viewTag.mtitel.setBackgroundResource(R.drawable.lanseyuanjiao);
            viewTag.mtitel.setTextColor(Color.WHITE);
        }else{
            viewTag.mtitel.setBackgroundResource(R.drawable.miaobianyuanjiao);
            viewTag.mtitel.setTextColor(Color.parseColor("#646464"));
        }
        return convertView;

    }

    public static class ViewHolder {
        public TextView mtitel;
        public RelativeLayout root;

    }
    //  定义一个公有方法，在activity中调用
    public void setSeclection(int position) {
        clickStatus = position;
    }
}
