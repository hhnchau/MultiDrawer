package sosinh.info.multidrawer.multiRecyclerView;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sosinh.info.multidrawer.R;

/**
 * Created by Chau Huynh on 2/23/2018.
 */

public class AdapterItemViewPager extends PagerAdapter {
    private List<Pager> mList;

    public AdapterItemViewPager(List<Pager> mList) {
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_viewpager_item, container, false);

        TextView textView = view.findViewById(R.id.title);
        textView.setText(mList.get(position).getTitle());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
