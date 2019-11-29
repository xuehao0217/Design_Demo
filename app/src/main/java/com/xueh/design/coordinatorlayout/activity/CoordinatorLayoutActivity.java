package com.xueh.design.coordinatorlayout.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.xueh.design.R;
import com.xueh.design.coordinatorlayout.adapter.MainTabAdapter;
import com.xueh.design.coordinatorlayout.fragment.NestedscrollFragment;
import com.xueh.design.coordinatorlayout.fragment.RecyclerGridFragment;
import com.xueh.design.coordinatorlayout.fragment.RecyclerLinearFragment;
import com.xueh.design.coordinatorlayout.fragment.RecyclerStaggeredFragment;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends BaseCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private MainTabAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerLinearFragment());
        fragments.add(new RecyclerGridFragment());
        fragments.add(new RecyclerStaggeredFragment());
        fragments.add(new NestedscrollFragment());

        List<String> titles = new ArrayList<>();
        titles.add("RecyclerLinear");
        titles.add("RecyclerGrid");
        titles.add("RecyclerStaggered");
        titles.add("Nestedscroll");

        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(3)));


        mAdapter = new MainTabAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_scroller_hidden_toolbar) {
            startActivity(new Intent(this, JianShuActivity.class));
        } else if (id == R.id.nav_recycler_hidden_toolbar) {
            startActivity(new Intent(this, HideToolBarActivity.class));
        } else if (id == R.id.nav_viewpager) {
            startActivity(new Intent(this, HeaderViewPagerActivty.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
