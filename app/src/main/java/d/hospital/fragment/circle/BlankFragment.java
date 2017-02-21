package d.hospital.fragment.circle;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import java.util.List;

import d.hospital.R;
import d.hospital.adapter.BlankAdapter;
import d.hospital.bean.HealthBena;
import d.hospital.utils.UrlUtils;
import okhttp3.Call;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private TextView tv;

    private String tab;
    private int id;
    private PullToRefreshListView mPullRefreshListView;
    private BlankAdapter adapter;

    public BlankFragment() {

    }

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        tab=args.getString("cname");
        id=args.getInt("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);

        mPullRefreshListView.setBackgroundResource(R.color.white_bg);
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //当前时间
                String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                Log.d("label", label);
                // 用不着显示时间
                //refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                loading();
                //adapter.notifyDataSetChanged();


            }
        });
        // Add an end-of-list listener
        mPullRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {

            @Override
            public void onLastItemVisible() {
                Toast.makeText(getActivity(), "末尾了", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 添加声音
         */
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener<ListView>(getActivity());
        soundListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH, R.raw.pull_event);
        soundListener.addSoundEvent(PullToRefreshBase.State.RESET, R.raw.reset_sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.refreshing_sound);
        mPullRefreshListView.setOnPullEventListener(soundListener);

        // 可以用 actualListView.setListAdapter(mAdapter)
        // 或者 mPullRefreshListView.setAdapter(mAdapter)
        loading();
        ViewGroup parent=(ViewGroup)view.getParent();
        if(parent!=null){
            parent.removeView(view);
        }
        return view;
    }

    private void loading() {
        Log.d("BlankFragment", "id="+id+"");
        OkGo.get(UrlUtils.HEALTH_CIRCLE+id).
                cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST).
                cacheKey("HEALTH_CIRCLE").tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);

                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        super.onCacheSuccess(s, call);
                         json(s);
                    }

                    @Override
                    public String convertSuccess(Response response) throws Exception {
                        return super.convertSuccess(response);
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        json(s);
                    }

                    private void json(String s) {
                        Gson gson=new Gson();
                        HealthBena a = gson.fromJson(s,HealthBena.class);
                        if (a.getCode()==200){
                            List<HealthBena.TheheadlinesBean> theheadlines = a.getTheheadlines();
                            BlankAdapter adapter=new BlankAdapter(getContext(),theheadlines);
                            mPullRefreshListView.setAdapter(adapter);
                            mPullRefreshListView.onRefreshComplete();
                        }else if (a.getCode()==400){
                            Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
                            mPullRefreshListView.onRefreshComplete();
                        }
                    }
                });
    }

}
