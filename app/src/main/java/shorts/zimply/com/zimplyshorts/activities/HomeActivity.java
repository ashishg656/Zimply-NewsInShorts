package shorts.zimply.com.zimplyshorts.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import shorts.zimply.com.zimplyshorts.R;
import shorts.zimply.com.zimplyshorts.application.AppApplication;
import shorts.zimply.com.zimplyshorts.fragments.HomeActivityFragment;
import shorts.zimply.com.zimplyshorts.objects.HomeActivityObjectList;
import shorts.zimply.com.zimplyshorts.objects.HomeActivityObjectSingle;
import shorts.zimply.com.zimplyshorts.serverApi.AppRequestListener;
import shorts.zimply.com.zimplyshorts.serverApi.CustomStringRequest;
import shorts.zimply.com.zimplyshorts.serverApi.ZTags;
import shorts.zimply.com.zimplyshorts.serverApi.ZUrls;

/**
 * Created by Ashish Goel on 1/24/2016.
 */
public class HomeActivity extends BaseActivity implements ZUrls, ZTags, AppRequestListener {

    ViewPager viewPager;
    MyPagerAdapter adapter;
    List<HomeActivityObjectSingle> mData;

    int nextPage = 1;
    boolean isRequestRunning;
    boolean isMoreAllowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);

        mData = new ArrayList<>();

        viewPager = (ViewPager) findViewById(R.id.homeviewpager);

        loadData();
    }

    private void loadData() {
        String url = AppApplication.getBaseUrl() + HOME_REQUEST_URL + "?p=" + nextPage;
        CustomStringRequest request = new CustomStringRequest(Request.Method.GET, url, HOME_NEWS_REQUEST_TAG, this, null);
        AppApplication.getInstance().addToRequestQueue(request);
    }

    void setPagerAdapter(HomeActivityObjectList obj) {
        mData.addAll(obj.getStories());

        HomeActivityObjectSingle zimplyObj = new HomeActivityObjectSingle();
        zimplyObj.setZimplyPage(true);
        zimplyObj.setImg("http://decofilia.com/blog/wp-content/uploads/2013/12/como-decorar-salones-con-papel-pintado-01.jpg");
        mData.add(zimplyObj);

        if (obj.getNext_page() == null)
            isMoreAllowed = false;
        else {
            isMoreAllowed = true;
            nextPage = obj.getNext_page();
        }

        if (adapter == null) {
            adapter = new MyPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRequestStarted(String requestTag) {
        if (requestTag.equals(HOME_NEWS_REQUEST_TAG)) {

        }
    }

    @Override
    public void onRequestFailed(String requestTag, VolleyError error) {
        if (requestTag.equals(HOME_NEWS_REQUEST_TAG)) {

        }
    }

    @Override
    public void onRequestCompleted(String requestTag, String response) {
        if (requestTag.equals(HOME_NEWS_REQUEST_TAG)) {
            HomeActivityObjectList obj = new Gson().fromJson(response, HomeActivityObjectList.class);
            setPagerAdapter(obj);
        }
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
