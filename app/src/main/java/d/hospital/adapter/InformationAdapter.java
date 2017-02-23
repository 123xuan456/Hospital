package d.hospital.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Home_twoBean;

/**
 * Created by mhysa on 2016/12/12.
 */
public class InformationAdapter extends BaseAdapter {

    private List<Home_twoBean.HealthInformation> viewlist;
    private Context context;
    public InformationAdapter(Context context, List<Home_twoBean.HealthInformation> viewlist) {

        this.context = context;
        this.viewlist = viewlist;
        Log.i("moor","------------"+viewlist.size());
    }

    @Override
    public int getCount() {
        if (viewlist.size()<=4&&viewlist.size()>0){
            return viewlist.size();
        }
        return 4;
    }


    @Override
    public Object getItem(int position) {
        return viewlist.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_information, null);
            holder.iv_touxiang = (ImageView)convertView.findViewById(R.id.iv_touxiang);
            holder.tv_articleClass = (TextView)convertView.findViewById(R.id.tv_articleClass);
            holder.tv_articleTitle = (TextView)convertView.findViewById(R.id.tv_articleTitle);
                convertView.setTag(holder);
        }else {

            holder = (ViewHolder)convertView.getTag();
        }


        Glide.with(context)
                .load(viewlist.get(position).getArticlePic())
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(holder.iv_touxiang);
        holder.tv_articleTitle.setText(viewlist.get(position).getArticleTitle());
        holder.tv_articleClass.setText("浏览量："+viewlist.get(position).getBrowseTime()+" | "+viewlist.get(position).getArticleClass());
        return convertView;
    }

    public static class ViewHolder{

        public ImageView iv_touxiang;
        public TextView tv_articleClass;
        public TextView tv_articleTitle;

    }
}
