package d.hospital.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import d.hospital.R;
import d.hospital.bean.Health_GridViewBean;

/**
 * Created by de on 2016/12/26.
 */
public class GridViewAdapter extends RecyclerView.Adapter {

    private List<Health_GridViewBean.Message> datas;
    private Context context;
    public LayoutInflater mLayoutInflater;
    private int a=1;
    public GridViewAdapter(Context context, List<Health_GridViewBean.Message> datas){
        this.context = context;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(context);

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        inflate(R.layout.item_gridview, parent, false)
//            return new ItemViewHolder(mLayoutInflater.from(context).inflate(R.layout.item_gridview, null));
        return new ItemViewHolder(mLayoutInflater.inflate(R.layout.item_gridview,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder instanceof ItemViewHolder;
        ((ItemViewHolder) holder).title.setText(datas.get(position).getHeaname());
        Glide.with(context)
                .load(datas.get(position).getHeaimg())
//                .placeholder(R.mipmap.home)
//                .error(R.mipmap.home)
                .centerCrop()
                .crossFade()
                .into(((ItemViewHolder) holder).image);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;
        private final TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.title);
        }
    }
}
