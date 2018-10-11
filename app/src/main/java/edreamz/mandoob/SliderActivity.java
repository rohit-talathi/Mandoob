package edreamz.mandoob;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class SliderActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);


        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        ;
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return new FirstFragment();

                case 1:
                    return new SecondFragment();

                case 2:
                    return new ThirdFragment();

                default:
                    break;
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}