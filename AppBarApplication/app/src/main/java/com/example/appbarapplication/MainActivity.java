package com.example.appbarapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TableLayout tablayout;
private List<String> titles;
private List<Fragment> fragmentList;
private  MyFragmentAdaper fragmentAdaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tablayout = findViewById(R.id.top_tab);
        viewPager=findViewById(R.id.view_pager2);
        setContentView(R.layout.activity_main);

        initTab();
    }
    private void initTab(){
        titles = new ArrayList<String>();
        titles.add("首页");
        titles.add("热点");
        titles.add("推荐");
        titles.add("我的");

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();
        Fragment4 fragment4 = new Fragment4();

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);

       //借助FragmentStateAdapter将Fragment配置到ViewPager中
        fragmentAdaper = new MyFragmentAdaper(MainActivity.this,fragmentList);
        viewPager.setAdapter(fragmentAdaper);

        //借助TabLayoutMediator实现TabLayout 和ViewPager的联动
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        }).attach();
    }
    }
}
