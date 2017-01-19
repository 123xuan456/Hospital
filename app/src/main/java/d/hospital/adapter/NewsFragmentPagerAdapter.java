package d.hospital.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by de on 2017/1/12.
 */
public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {
    FragmentManager childFragmentManager;
    List<Fragment> fragments;
    public NewsFragmentPagerAdapter(FragmentManager childFragmentManager, List<Fragment> fragments) {
        super(childFragmentManager);
        this.childFragmentManager=childFragmentManager;
        this.fragments=fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position%fragments.size());
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;//
    }
}
