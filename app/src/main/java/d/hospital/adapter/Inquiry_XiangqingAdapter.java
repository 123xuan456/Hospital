package d.hospital.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Inquiry_xiangqingBean;

/**
 * Created by de on 2016/12/26.
 */
public class Inquiry_XiangqingAdapter extends BaseAdapter {
    private final ImageLoader imageLoader;
    private final DisplayImageOptions options;
    private Context context;
    private List<Inquiry_xiangqingBean.MessageBean> list;
    public Inquiry_XiangqingAdapter(Context context, List<Inquiry_xiangqingBean.MessageBean> message1) {
    this.context=context;
        this.list=message1;
         imageLoader = ImageLoader.getInstance();
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.hui) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.yonghu) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.baoxian) // 设置图片加载或解码过程中发生错误显示的图片
                .resetViewBeforeLoading(false)  // default 设置图片在加载前是否重置、复位
                .cacheInMemory(true) // default  设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // default  设置下载的图片是否缓存在SD卡中
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default 设置图片以如何的编码方式显示
                .displayer(new RoundedBitmapDisplayer(50)) // default  还可以设置圆角图片new RoundedBitmapDisplayer(20)
                .build();

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
        viewHolder holder;
        if (convertView == null) {
            holder=new viewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_xiangqing,null);
            holder.iv= (ImageView) convertView.findViewById(R.id.view);
            holder.tv1= (TextView) convertView.findViewById(R.id.name);
            holder.tv2= (TextView) convertView.findViewById(R.id.textView2);
            holder.tv3= (TextView) convertView.findViewById(R.id.textView30);
            convertView.setTag(holder);
        }else{
            holder= (viewHolder) convertView.getTag();
        }
        Inquiry_xiangqingBean.MessageBean x = list.get(position);
        imageLoader.displayImage(x.getDoctorPic(),holder.iv,options);
        holder.tv1.setText(x.getDoctorName());
        holder.tv2.setText(x.getDoctorGoodAt());
//        holder.tv3.setText(x.getClassName());

        return convertView;
    }
    class viewHolder{
        ImageView iv;
        TextView tv1;
        TextView tv2;
        TextView tv3;

    }
}
