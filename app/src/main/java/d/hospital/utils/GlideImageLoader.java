package d.hospital.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by de on 2016/12/19.
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context)
                .load(path)
                .crossFade()
                .into(imageView);
 //       com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(path.toString(), imageView);
    }
}
