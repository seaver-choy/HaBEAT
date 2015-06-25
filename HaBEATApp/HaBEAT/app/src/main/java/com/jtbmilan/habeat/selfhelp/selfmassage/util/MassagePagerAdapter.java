package com.jtbmilan.habeat.selfhelp.selfmassage.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jtbmilan on 6/18/15.
 */
public class MassagePagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public MassagePagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(MassageFragment.newInstance("Ear Massage"));
        fragments.add(MassageFragment.newInstance("Hand Massage"));
        fragments.add(MassageFragment.newInstance("Back Massage"));
    }

    @Override
    public Fragment getItem(int position) {
        return new MassageFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
