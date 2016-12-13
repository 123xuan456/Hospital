package d.hospital.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import d.hospital.R;

/**
 * Created by de on 2016/12/12.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private Context mcontext;
    private List<String> mDatas;

    public GalleryAdapter(Context context, List<String> datats)
    {
        this.mcontext = context;
        this.mDatas = datats;
        Log.i("moor", "是否有数据" +mDatas.size() );
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ViewHolder(View arg0)
        {
            super(arg0);
        }

        ImageView mImg;
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.item_horizontalscrollview,
                viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.mImg = (ImageView) view
                .findViewById(R.id.id_index_gallery_item_image);
        return viewHolder;
    }

    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        Glide.with(mcontext)
                .load(mDatas.get(i))
                .centerCrop()//拉伸图片
                .crossFade()//淡入淡出图片
                .into(viewHolder.mImg);
        Log.i("moor1", "是否有数据" + mDatas.get(i));
        Log.i("moor1", "是否有数据" );
//        viewHolder.mImg.setImageResource(mDatas.get(i));

    }
}
