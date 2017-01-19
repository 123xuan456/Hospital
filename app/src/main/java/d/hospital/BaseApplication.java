package d.hospital;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by de on 2016/12/19.
 */
public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //必须调用初始化
        OkGo.init(this);//OkGo框架，里面有缓存机制

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
    }
}
