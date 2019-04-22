package com.daothihang.demoviewpagerandmvp.view.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daothihang.demoviewpagerandmvp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createViewPager(viewPager);
        cutomTabs();
    }
    private void cutomTabs(){
        if (tabs.getWidth() < MainActivity.this.getResources().getDisplayMetrics().widthPixels) {
            tabs.setTabMode(TabLayout.MODE_FIXED);
            ViewGroup.LayoutParams mParams = tabs.getLayoutParams();
            mParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            tabs.setLayoutParams(mParams);
            tabs.setupWithViewPager(viewPager);
        } else {
            tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
        createTabIcons();
    }
    private void createTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.intent_tab_layout, null);
        tabOne.setText("RecyclerView");
        tabs.getTabAt(0).setCustomView(tabOne);
        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.intent_tab_layout, null);
        tabTwo.setText("GridView");
        tabs.getTabAt(1).setCustomView(tabTwo);
        TextView tabThree=(TextView)LayoutInflater.from(this).inflate(R.layout.intent_tab_layout,null);
        tabThree.setText("ListView");
        tabs.getTabAt(2).setCustomView(tabThree);
    }
    private void createViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentRecyclerView(), "RecyclerView");
        adapter.addFrag(new FragmentGridView(), "GridView");
        adapter.addFrag(new FragmentListView(),"ListView");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
