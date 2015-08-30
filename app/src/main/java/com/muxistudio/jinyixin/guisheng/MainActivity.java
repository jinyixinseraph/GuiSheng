package com.muxistudio.jinyixin.guisheng;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;


public class MainActivity extends Activity {
    //侧滑栏相关变量定义
    private SlidingMenu slidingMenu;
    //分页相关变量定义
    private View news,originate,interaction;
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<View> arrayList;
    private PagerTabStrip pagerTabStrip;
    private Button news_button,originate_button,interaction_button;
    private ImageView tabLine;
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int bmpW;// 动画图片宽度
//    private ViewPager.OnPageChangeListener onPageChangeListener;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //自定义actionbar
        ViewGroup myActionBarLayout = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.actionbar_layout, null);
        ActionBar actionBar = getActionBar();
        assert actionBar != null;
        actionBar.setCustomView(myActionBarLayout);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        ImageButton logging = (ImageButton)myActionBarLayout.findViewById(R.id.logging);
        logging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle(); //使logging按钮生效
            }
        });

        //侧滑栏
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);//设定模式，SlidingMenu在左边
        slidingMenu.setBehindOffsetRes(R.dimen.sliding_menu_offset);//打开侧滑栏后主页面显示的剩余宽度
        slidingMenu.setTouchModeAbove(SlidingMenu.SLIDING_WINDOW);//设置要使菜单滑动，触碰屏幕的范围
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);//附加到当前的Aty上去
        slidingMenu.setMenu(R.layout.sliding_menu);


        //viewpager分页实现
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        news_button = (Button)findViewById(R.id.news);
        originate_button = (Button)findViewById(R.id.original);
        interaction_button = (Button)findViewById(R.id.interact);
        tabLine = (ImageView)findViewById(R.id.tab_line);

        LayoutInflater li = getLayoutInflater();
        news = li.inflate(R.layout.news_fragment, null);
        originate = li.inflate(R.layout.originate_fragment, null);
        interaction = li.inflate(R.layout.interaction_fragment, null);
        arrayList = new ArrayList<View>();
        arrayList.add(news);
        arrayList.add(originate);
        arrayList.add(interaction);

        myPagerAdapter = new MyPagerAdapter(arrayList);
        viewPager.setAdapter(myPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}








































































//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
