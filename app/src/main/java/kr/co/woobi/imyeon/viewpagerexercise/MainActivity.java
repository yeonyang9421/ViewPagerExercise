package kr.co.woobi.imyeon.viewpagerexercise;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout= findViewById(R.id.tab);
        ViewPager viewPager=findViewById(R.id.pager);

        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(ListViewFragment.newInstance(createCharList('a','z')));
        fragmentList.add(ListViewFragment.newInstance(createCharList('A','Z')));
        fragmentList.add(ListViewFragment.newInstance(createCharList('ㄱ','ㅎ')));
        fragmentList.add(ListViewFragment.newInstance(createCharList('0','9')));

        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),
                fragmentList,
                new String[]{"영어 소문자", "영어 대문자","한글", "숫자"});
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    private  List<String> createCharList(char start, char end){
        List<String> list= new ArrayList<>();
        char ch=start;
        for(char i=ch;  i<=end; i++){
            list.add(String.valueOf(i));
        }
        return list;
    }

//    private  List<String> createUpperCaseAlphabetList(){
//        List<String> list= new ArrayList<>();
//        char ch='A';
//        for(char i=ch;  i<='Z'; i++){
//            list.add(String.valueOf(i));
//        }
//        return list;
//    }
//
//    private  List<String> createHangleList(){
//        List<String> list= new ArrayList<>();
//        char ch='ㄱ';
//        for(char i=ch;  i<='ㅎ'; i++){
//            list.add(String.valueOf(i));
//        }
//        return list;
//    }
//
//    private  List<String> createNumberList(){
//        List<String> list= new ArrayList<>();
//        char ch='0';
//        for(char i=ch;  i<='9'; i++){
//            list.add(String.valueOf(i));
//        }
//        return list;
//    }


    private static class MyAdapter extends FragmentPagerAdapter{
        private List<Fragment>mmFragmentList;
        private  String[] mmPageTitles;

        public MyAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] pagetTitles) {
            super(fm);
            mmFragmentList=fragmentList;
            mmPageTitles=pagetTitles;
        }

        @Override
        public Fragment getItem(int i) {
            return mmFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mmFragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mmPageTitles[position];
        }
    }
}