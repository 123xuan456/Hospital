package d.hospital;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import com.lzy.okgo.OkGo;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import d.hospital.receiver.NetReceiver;

/**
 * Created by de on 2016/12/19.
 */
public class BaseApplication extends Application{
    //将这判断的放在每次打开时的欢迎页面，现在暂时放在这
    NetReceiver mReceiver = new NetReceiver();
    IntentFilter mFilter = new IntentFilter();
    @Override
    public void onCreate() {
        super.onCreate();
        //必须调用初始化
        OkGo.init(this);//OkGo框架，里面有缓存机制

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);

        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mReceiver, mFilter);
    }
}
