package com.home.cascao.viannadecolar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.home.cascao.viannadecolar.adapters.ViewPageAdapter;
import com.home.cascao.viannadecolar.enums.Tabs;

public class MainActivity extends AppCompatActivity {

    private final SearchFragment searchFragment = SearchFragment.newInstance();
    private final MinhasPassagensFragment minhasPassagensFragment = MinhasPassagensFragment.newInstance();
    private FragmentManager fragmentManager;
    private ViewPager viewPage;

    // Fragments
    private BottomNavigationView navigation;
    private MenuItem prevMenuItem;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_voos:
                    gotToTab(Tabs.VOOS);
                    break;
                case R.id.navigation_minhas_passagens:
                    gotToTab(Tabs.PASSAGENS);
                    break;
            }

            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        bind();
        setupNavigation();
        setupViewPager();
    }

    private void bind() {
        viewPage = findViewById(R.id.viewPage);
        navigation = findViewById(R.id.navigation);
    }

    private void setupNavigation() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupViewPager() {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragment(searchFragment);
        viewPageAdapter.addFragment(minhasPassagensFragment);

        viewPage.setAdapter(viewPageAdapter);

        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }

                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void gotToTab(Tabs reference) {
        viewPage.setCurrentItem(reference.getCode());
    }

}
