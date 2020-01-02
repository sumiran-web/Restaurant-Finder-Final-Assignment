package com.example.restaurantfinder.Adapters;

import java.util.ArrayList;
import java.util.List;

public class ViewpageAdapterextends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmenttitle = new ArrayList<>();

    public ViewpageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {

        return fragmentList.size();
    }

    public CharSequence getPageTitle(int position) {
        return fragmenttitle.get(position);
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmenttitle.add(title);
    }
}
 {
}
