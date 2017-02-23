package d.hospital.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by mhysa on 2016/12/23.
 */
public abstract class CommonAdapter<T> extends PagerAdapter {

    protected List<T> viewlist;
    protected Context mcontext;
    public CommonAdapter(Context context, List<T> viewlist) {

        this.mcontext = context;
        this.viewlist = viewlist;
        Log.i("moor","------------"+viewlist.size());
    }

        /**
         * 返回多少page
         */
    public int getCount() {
        return viewlist.size();
    }
    /**view滑动到一半时是否创建新的view
     * true:表示不去创建，使用缓存；false:去重新创建
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    /**
     * 类似于BaseAdapter的getView方法
     */
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        View view = View.inflate(context, R.layout.item_viewpager, null);
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
