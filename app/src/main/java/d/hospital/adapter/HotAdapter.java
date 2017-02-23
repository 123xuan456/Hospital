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
public class HotAdapter extends BaseAdapter {

    private List<Home_twoBean.HotPost> viewlist;
    private Context context;
    public HotAdapter(Context context, List<Home_twoBean.HotPost> viewlist) {

        this.context = context;
        this.viewlist = viewlist;
        Log.i("moor","------------"+viewlist.size());
    }

    @Override
    public int getCount() {
        return 2;
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
            convertView = View.inflate(context, R.layout.item_hot, null);
            holder.iv_touxiang = (ImageView)convertView.findViewById(R.id.iv_touxiang);
            holder.tv_name = (TextView)convertView.findViewById(R.id.tv_name);
            holder.tv_content = (TextView)convertView.findViewById(R.id.tv_content);
            holder.tv_date = (TextView)convertView.findViewById(R.id.tv_date);
            holder.tv_likeNum = (TextView)convertView.findViewById(R.id.tv_likeNum);
            holder.tv_commentNum = (TextView)convertView.findViewById(R.id.tv_commentNum);
                convertView.setTag(holder);
        }else {

            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv_name.setText(viewlist.get(position).getUserName());
        holder.tv_content.setText(viewlist.get(position).getContent());
        holder.tv_date.setText(viewlist.get(position).getDate());
//        holder.tv_likeNum.setText(viewlist.get(position).getLikeNum());
//        holder.tv_commentNum.setText(viewlist.get(position).getCommentNum());

        Glide.with(context)
                .load(viewlist.get(position).getUserPic())
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(holder.iv_touxiang);
        return convertView;
    }

    public static class ViewHolder{

        public ImageView iv_touxiang;
        public TextView tv_name,tv_content,tv_date;
        public TextView tv_likeNum,tv_commentNum;

    }
}
