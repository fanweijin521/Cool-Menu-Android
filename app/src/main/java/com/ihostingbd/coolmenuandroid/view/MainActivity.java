package com.ihostingbd.coolmenuandroid.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.dxtt.coolmenu.CoolMenuFrameLayout;
import com.ihostingbd.coolmenuandroid.R;
import com.ihostingbd.coolmenuandroid.fragments.FragmentAbout;
import com.ihostingbd.coolmenuandroid.fragments.FragmentContact;
import com.ihostingbd.coolmenuandroid.fragments.FragmentProject;
import com.ihostingbd.coolmenuandroid.fragments.FragmentTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button bt;

    boolean open;

    CoolMenuFrameLayout coolMenuFrameLayout;

    List<Fragment> fragments = new ArrayList<>();

    List<String> titleList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coolMenuFrameLayout = $(R.id.rl_main);
        String[] titles = {"CONTACT", "ABOUT", "TEAM", "PROJECTS"};
        titleList = Arrays.asList(titles);
        coolMenuFrameLayout.setTitles(titleList);
        fragments.add(new FragmentContact());
        fragments.add(new FragmentAbout());
        fragments.add(new FragmentTeam());
        fragments.add(new FragmentProject());
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        coolMenuFrameLayout.setAdapter(adapter);
    }

    private <T extends View> T $(@IdRes int id) {
        return (T) findViewById(id);
    }
}
