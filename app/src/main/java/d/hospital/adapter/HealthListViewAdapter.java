package d.hospital.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Health_ListViewBean;

/**
 * Created by mhysa on 2016/12/12.
 */
public class HealthListViewAdapter extends BaseAdapter {

    private List<Health_ListViewBean.Result> viewlist;
    private Context context;
    public HealthListViewAdapter(Context context, List<Health_ListViewBean.Result> viewlist) {

        this.context = context;
        this.viewlist = viewlist;
    }

    @Override
    public int getCount() {

            return viewlist.size();
    }


    @Override
    public Object getItem(int position) {

        return viewlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

      //  viewlist.size();
        Log.i("position-->","------------"+position);
        Log.i("mhysa","------------"+viewlist.get(position).getResults().size());

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.health_item, null);
            holder.iv_big_ll = (ImageView)convertView.findViewById(R.id.iv_big_ll);

            holder.image00 = (ImageView)convertView.findViewById(R.id.module1).findViewById(R.id.image0);
            Log.i("liuliuliu","------1234344------"+holder.image00);
            holder.image01 = (ImageView)convertView.findViewById(R.id.module1).findViewById(R.id.image1);
            holder.image02 = (ImageView)convertView.findViewById(R.id.module1).findViewById(R.id.image2);
            holder.image03 = (ImageView)convertView.findViewById(R.id.module1).findViewById(R.id.image3);
            holder.image04 = (ImageView)convertView.findViewById(R.id.module1).findViewById(R.id.image4);
            holder.image05 = (ImageView)convertView.findViewById(R.id.module1).findViewById(R.id.image5);

            holder.image06 = (ImageView)convertView.findViewById(R.id.module2).findViewById(R.id.image0);
            holder.image07 = (ImageView)convertView.findViewById(R.id.module2).findViewById(R.id.image1);
            holder.image08 = (ImageView)convertView.findViewById(R.id.module2).findViewById(R.id.image2);
            holder.image09 = (ImageView)convertView.findViewById(R.id.module2).findViewById(R.id.image3);
            holder.image10 = (ImageView)convertView.findViewById(R.id.module2).findViewById(R.id.image4);
            holder.image11 = (ImageView)convertView.findViewById(R.id.module2).findViewById(R.id.image5);

            holder.image12 = (ImageView)convertView.findViewById(R.id.module3).findViewById(R.id.image0);
            holder.image13 = (ImageView)convertView.findViewById(R.id.module3).findViewById(R.id.image1);
            holder.image14 = (ImageView)convertView.findViewById(R.id.module3).findViewById(R.id.image2);
            holder.image15 = (ImageView)convertView.findViewById(R.id.module3).findViewById(R.id.image3);
            holder.image16 = (ImageView)convertView.findViewById(R.id.module3).findViewById(R.id.image4);
            holder.image17 = (ImageView)convertView.findViewById(R.id.module3).findViewById(R.id.image5);

            holder.title3 = (LinearLayout)convertView.findViewById(R.id.title3);
            holder.module3 = (LinearLayout)convertView.findViewById(R.id.module3);

                convertView.setTag(holder);
        }else {

            holder = (ViewHolder)convertView.getTag();
        }
        glide(viewlist.get(position).getImgurl(), holder.iv_big_ll);
       // Log.i("liuliuliu","------------"+viewlist.get(position).getResults().size());
        if(viewlist.get(position).getResults().size()==12&&viewlist.get(position).getResults().size()<18){

            Log.i("liuliuliu","------------"+holder.image00);

            holder.title3.setVisibility(View.GONE);
            holder.module3.setVisibility(View.GONE);

            glide(viewlist.get(position).getResults().get(0).getImg(),holder.image00);
            glide(viewlist.get(position).getResults().get(1).getImg(),holder.image01);
            glide(viewlist.get(position).getResults().get(2).getImg(),holder.image02);
            glide(viewlist.get(position).getResults().get(3).getImg(),holder.image03);
            glide(viewlist.get(position).getResults().get(4).getImg(),holder.image04);
            glide(viewlist.get(position).getResults().get(5).getImg(),holder.image05);

            glide(viewlist.get(position).getResults().get(6).getImg(),holder.image06);
            glide(viewlist.get(position).getResults().get(7).getImg(),holder.image07);
            glide(viewlist.get(position).getResults().get(8).getImg(),holder.image08);
            glide(viewlist.get(position).getResults().get(9).getImg(),holder.image09);
            glide(viewlist.get(position).getResults().get(10).getImg(), holder.image10);
            glide(viewlist.get(position).getResults().get(11).getImg(), holder.image11);


        }else {

            holder.title3.setVisibility(View.VISIBLE);
            holder.module3.setVisibility(View.VISIBLE);
            glide(viewlist.get(position).getResults().get(0).getImg(), holder.image00);
            glide(viewlist.get(position).getResults().get(1).getImg(),holder.image01);
            glide(viewlist.get(position).getResults().get(2).getImg(),holder.image02);
            glide(viewlist.get(position).getResults().get(3).getImg(),holder.image03);
            glide(viewlist.get(position).getResults().get(4).getImg(),holder.image04);
            glide(viewlist.get(position).getResults().get(5).getImg(),holder.image05);

            glide(viewlist.get(position).getResults().get(6).getImg(),holder.image06);
            glide(viewlist.get(position).getResults().get(7).getImg(),holder.image07);
            glide(viewlist.get(position).getResults().get(8).getImg(),holder.image08);
            glide(viewlist.get(position).getResults().get(9).getImg(),holder.image09);
            glide(viewlist.get(position).getResults().get(10).getImg(),holder.image10);
            glide(viewlist.get(position).getResults().get(11).getImg(),holder.image11);

            glide(viewlist.get(position).getResults().get(12).getImg(),holder.image12);
            glide(viewlist.get(position).getResults().get(13).getImg(),holder.image13);
            glide(viewlist.get(position).getResults().get(14).getImg(),holder.image14);
            glide(viewlist.get(position).getResults().get(15).getImg(),holder.image15);
            glide(viewlist.get(position).getResults().get(16).getImg(),holder.image16);
            glide(viewlist.get(position).getResults().get(17).getImg(),holder.image17);

        }
        return convertView;
    }
    public void glide(String imageurl,ImageView imageView){

        if(imageView!=null){
            Glide.with(context)
                    .load(imageurl)
                    .centerCrop()//拉伸图片
                    .crossFade()//淡入淡出图片
                    .into(imageView);
        }
//        Log.i("liuliuliu",)

    }

    public static class ViewHolder{

        public ImageView iv_big_ll;
        public ImageView image00,image01,image02,image03,image04,image05;
        public ImageView image06,image07,image08,image09,image10,image11;
        public ImageView image12,image13,image14,image15,image16,image17;
        public LinearLayout title3,module3;

    }
}
