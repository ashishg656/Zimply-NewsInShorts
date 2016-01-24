package shorts.zimply.com.zimplyshorts.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import shorts.zimply.com.zimplyshorts.R;
import shorts.zimply.com.zimplyshorts.objects.HomeActivityObjectSingle;

/**
 * Created by Ashish Goel on 1/24/2016.
 */
public class HomeActivityFragment extends Fragment {

    ImageView image;
    TextView title, description;

    HomeActivityObjectSingle mData;

    public static HomeActivityFragment newInstance(Bundle b) {
        HomeActivityFragment frg = new HomeActivityFragment();
        frg.setArguments(b);
        return frg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_activity_viewpager_item_normal, container, false);

        image = (ImageView) v.findViewById(R.id.homeviewpagerimage);
        title = (TextView) v.findViewById(R.id.title);
        description = (TextView) v.findViewById(R.id.description);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = getArguments().getParcelable("obj");

        if (mData.isZimplyPage()) {
            title.setVisibility(View.GONE);
            description.setVisibility(View.GONE);
        }


    }
}
