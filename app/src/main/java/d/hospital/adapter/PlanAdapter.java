package d.hospital.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Home_twoBean;

/**
 * Created by mhysa on 2016/12/12.
 */
public class PlanAdapter extends BaseAdapter {

    private List<Home_twoBean.HealthPlan> viewlist;
    private Context context;
    public PlanAdapter(Context context, List<Home_twoBean.HealthPlan> viewlist) {

        this.context = context;
        this.viewlist = viewlist;
        Log.i("moor","------------"+viewlist.size());
    }

    @Override
    public int getCount() {
        return viewlist.size();
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
            convertView = View.inflate(context, R.layout.item_plan, null);
            holder.tit = (TextView)convertView.findViewById(R.id.tit);
                convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tit.setText(viewlist.get(position).getPlan());
//        Glide.with(context)
//                .load(viewlist.get(position))
//                .centerCrop()//拉伸图片
//                .crossFade()//淡入淡出图片
//                .into(holder.iv_touxiang);
        return convertView;
    }

    public static class ViewHolder{

        public TextView tv_content;
        public TextView tit;

    }
}
