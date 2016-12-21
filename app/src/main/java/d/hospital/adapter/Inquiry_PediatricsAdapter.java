package d.hospital.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import d.hospital.bean.Inquiry_fenkeBean;

/**
 * Created by de on 2016/12/20.
 */
public class Inquiry_PediatricsAdapter extends BaseAdapter{
        private Context context;
        private List<Inquiry_fenkeBean.Message1Bean> mes1;

    public Inquiry_PediatricsAdapter(Context context, List<Inquiry_fenkeBean.Message1Bean> mes1) {
            this.context=context;
            this.mes1=mes1;
    }

    @Override
    public int getCount() {
        return mes1.size();
    }

    @Override
    public Object getItem(int position) {
        return mes1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {




        return null;
    }
    class ViewHolder{
        ImageView iv;

    }

}
