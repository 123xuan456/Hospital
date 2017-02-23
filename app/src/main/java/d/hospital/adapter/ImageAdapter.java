package d.hospital.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Home_moduleBean;

/**
 * Created by mhysa on 2016/12/12.
 */
public class ImageAdapter extends CommonAdapter {
    List<Home_moduleBean.Area4> mviewlists;
    public ImageAdapter(Context context,List<Home_moduleBean.Area4> mviewlist) {
        super(context,mviewlist);
        this.mviewlists = mviewlist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(mcontext, R.layout.item_viewpager, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.id_index_gallery_item);
        //   Ad ad = list.get(position%list.size());

        Glide.with(mcontext)
                .load(mviewlists.get(position).getPicUrl4())
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(imageView);
//        imageView.setImageResource(R.mipmap.ic_launcher);
        container.addView(view);
        Log.i("moorliulu", "是否有数据" + viewlist.get(position));
        return view;
    }

    //    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        View view = View.inflate(mcontext, R.layout.item_viewpager, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.id_index_gallery_item);
//     //   Ad ad = list.get(position%list.size());
//
//        Glide.with(context)
//                .load(viewlist.get(position).getPicUrl4())
//                .centerCrop()//拉伸图片
//                .crossFade()//淡入淡出图片
//                .into(imageView);
////        imageView.setImageResource(R.mipmap.ic_launcher);
//        container.addView(view);
//        Log.i("moorliulu", "是否有数据" + viewlist.get(position));
//        return view;
//    }
    /**
     * @param position:当前需要销毁第几个page
     * @param object:当前需要销毁的page
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
//        ((ViewPager) container).removeView(mViews.get(position));
    }
}

