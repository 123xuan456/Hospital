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
public class AppraisalAdapter extends PagerAdapter {

    private List<Home_moduleBean.HealthTest> viewlist;
    private Context context;
    public AppraisalAdapter(Context context, List<Home_moduleBean.HealthTest> viewlist) {

        this.context = context;
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
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_appraisal_viewpager, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_first);
        ImageView imageView1 = (ImageView)view.findViewById(R.id.iv_second);
        Glide.with(context)
                .load(viewlist.get(position).getHealthtest_1())
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(imageView);

        Glide.with(context)
                .load(viewlist.get(position).getHealthtest_2())
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(imageView1);
//        imageView.setImageResource(R.mipmap.ic_launcher);
        container.addView(view);
//        Log.i("moorliulu", "是否有数据" + viewlist.get(position));
        return view;
    }
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
