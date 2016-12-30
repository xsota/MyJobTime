package me.rmrf.myjobtime.views.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import me.rmrf.myjobtime.fragment.CallenderFragment;
import me.rmrf.myjobtime.fragment.JobTimeFragment;

/**
 * Created by kawanoanna on 2016/12/30.
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter{

    private final String[] tabText = new String[]{"出退勤", "カレンダー"};
    public ArrayList<Fragment> fragments ;

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    /**
     * フラグメントリストを初期化
     */
    public void initFragments(){
        fragments = new ArrayList<>();

        fragments.add(new JobTimeFragment());
        fragments.add(new CallenderFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabText[position];
    }

    @Override
    public int getCount() {
        return tabText.length;
    }


}
