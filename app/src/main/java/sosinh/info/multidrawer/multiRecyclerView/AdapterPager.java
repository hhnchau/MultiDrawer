package sosinh.info.multidrawer.multiRecyclerView;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import sosinh.info.multidrawer.R;

/**
 * Created by Chau Huynh on 2/23/2018.
 */

public class AdapterPager extends RecyclerView.Adapter<AdapterPager.MyViewHolder> {
    private Context context;
    private List<Pager> mList;

    public AdapterPager(Context context, List<Pager> mList) {
        this.context = context;
        this.mList = mList;
    }

    private int dots_count;
    private ImageView[] dots;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewpager, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        AdapterItemViewPager adapterItemViewPager = new AdapterItemViewPager(mList);
        holder.viewPager.setAdapter(adapterItemViewPager);
        dots_count = adapterItemViewPager.getCount();
        dots = new ImageView[dots_count];
        for (int i = 0; i < dots_count; i++){
            dots[i] = new ImageView(context);
            dots[i].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_non_active));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);

            holder.indicator.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_active));


        holder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dots_count; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_non_active));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_active));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private LinearLayout indicator;

        public MyViewHolder(View itemView) {
            super(itemView);

            viewPager = itemView.findViewById(R.id.item_viewPager);
            indicator = itemView.findViewById(R.id.indicator_item_viewpager);

        }
    }
}
