package d.hospital.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.HealthBena;

/**
 * Created by de on 2017/1/18.
 */
public class BlankAdapter extends BaseAdapter{
    Context context;
    List<HealthBena.TheheadlinesBean> list;


    public BlankAdapter(Context context, List<HealthBena.TheheadlinesBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_tab_health,null);
            holder.iv1= (ImageView) convertView.findViewById(R.id.iv1);
            holder.iv2= (ImageView) convertView.findViewById(R.id.iv2);
            holder.iv3= (ImageView) convertView.findViewById(R.id.iv3);
            holder.imageView21= (ImageView) convertView.findViewById(R.id.imageView21);
            holder.linearLayout= (LinearLayout) convertView.findViewById(R.id.three_image);
            holder.rl= (RelativeLayout) convertView.findViewById(R.id.one_image);
            holder.title= (TextView) convertView.findViewById(R.id.title);
            holder.title1= (TextView) convertView.findViewById(R.id.title1);
            holder.textView1= (TextView) convertView.findViewById(R.id.textView1);
            holder.textView= (TextView) convertView.findViewById(R.id.textView);
            holder.textView11= (TextView) convertView.findViewById(R.id.textView11);
            holder.tvComment= (TextView) convertView.findViewById(R.id.tvComment);

            convertView.setTag(holder);
        }else {
           holder= (ViewHolder) convertView.getTag();
        }
        HealthBena.TheheadlinesBean thehead = list.get(position);
        List<HealthBena.TheheadlinesBean.ImgBean> imgBeanList = thehead.getImg();
        if (imgBeanList.size()==1){//只有一个图片的时候
            holder.rl.setVisibility(View.VISIBLE);
            holder.linearLayout.setVisibility(View.GONE);
            holder.title1.setText(thehead.getHeatitle());
//            holder.tvComment.setText(thehead.getHeatitle());
//            holder.textView11.setText(thehead.getHeatitle());

            Glide.with(context).load(imgBeanList.get(0).getLiimg()).placeholder(R.mipmap.a).into(holder.imageView21);
        }else if (imgBeanList.size()==3){
            holder.rl.setVisibility(View.GONE);
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.title.setText(thehead.getHeatitle());
//            holder.textView1.setText(thehead.getHeatitle());
//            holder.textView.setText(thehead.getHeatitle());
            Glide.with(context).load(imgBeanList.get(0).getLiimg()).placeholder(R.mipmap.a).into(holder.iv1);
            Glide.with(context).load(imgBeanList.get(1).getLiimg()).placeholder(R.mipmap.a).into(holder.iv2);
            Glide.with(context).load(imgBeanList.get(2).getLiimg()).placeholder(R.mipmap.a).into(holder.iv3);
        }



        return convertView;
    }

    class ViewHolder{
        //三个图片时
        LinearLayout linearLayout;
        ImageView iv1;
        ImageView iv2;
        ImageView iv3;
        TextView title;
        TextView textView1;
        TextView textView;//评论
        //一个
        RelativeLayout rl;
        ImageView imageView21;
        TextView tvComment;
        TextView textView11;//评论
        TextView title1;
    }
}
