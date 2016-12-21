package d.hospital.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Inquiry_fenkeBean;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by de on 2016/12/20.
 */
public class Inquiry_FuCanAdapter extends BaseAdapter{
        private Context context;
        private  List<Inquiry_fenkeBean.Message2Bean> mes2;

    public Inquiry_FuCanAdapter(Context context,  List<Inquiry_fenkeBean.Message2Bean> mes2) {
            this.context=context;
            this.mes2=mes2;
    }

    @Override
    public int getCount() {
        return mes2.size();
    }

    @Override
    public Object getItem(int position) {
        return mes2.get(position);
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
                convertView= LayoutInflater.from(context).inflate(R.layout.item_fenke,null);
                RelativeLayout.LayoutParams a = (RelativeLayout.LayoutParams) convertView.getLayoutParams();
                holder.iv= (CircleImageView) convertView.findViewById(R.id.imageView20);
                holder.tv1= (TextView) convertView.findViewById(R.id.textView25);
                holder.tv2= (TextView) convertView.findViewById(R.id.textView26);
                convertView.setTag(holder);

            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            Inquiry_fenkeBean.Message2Bean m = mes2.get(position);
            com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(m.getDoctorPic(), holder.iv);
        holder.tv1.setText(m.getDoctorName());
        holder.tv2.setText(m.getClassName());
            return convertView;
    }

    class ViewHolder{
        CircleImageView iv;
        TextView tv1;
        TextView tv2;
    }

}
