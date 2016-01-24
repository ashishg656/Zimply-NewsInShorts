package shorts.zimply.com.zimplyshorts.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

import shorts.zimply.com.zimplyshorts.R;
import shorts.zimply.com.zimplyshorts.fragments.HomeActivityFragment;
import shorts.zimply.com.zimplyshorts.objects.HomeActivityObjectSingle;

/**
 * Created by Ashish Goel on 1/24/2016.
 */
public class HomeActivity extends BaseActivity {

    ViewPager viewPager;
    MyPagerAdapter adapter;
    List<HomeActivityObjectSingle> mData;

    int nextPage;
    boolean isRequestRunning;
    boolean isMoreAllowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);

        viewPager = (ViewPager) findViewById(R.id.homeviewpager);

        loadData();
    }

    private void loadData() {

    }

    void setPagerAdapter() {
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("obj", mData.get(position));
            return HomeActivityFragment.newInstance(bundle);
        }

        @Override
        public int getCount() {
            return mData.size();
        }
    }
}
