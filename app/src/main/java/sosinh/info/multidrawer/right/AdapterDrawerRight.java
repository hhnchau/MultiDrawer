package sosinh.info.multidrawer.right;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sosinh.info.multidrawer.R;
import sosinh.info.multidrawer.viewpager.AdapterViewPager;

/**
 * Created by Chau Huynh on 2/20/2018.
 */

public class AdapterDrawerRight extends RecyclerView.Adapter<AdapterDrawerRight.ViewHolder> {
    public interface OnItemClick {
        void onClick(int p);
    }

    private List<String> mList;
    private OnItemClick onItemClick;

    public AdapterDrawerRight(List<String> mList, OnItemClick onItemClick) {
        this.mList = mList;
        this.onItemClick = onItemClick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_right, parent, false);
        //View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_viewpager, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtTitle.setText(mList.get(position));

        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(holder.getAdapterPosition());
            }
        });

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        AdapterViewPager adapterViewPager = new AdapterViewPager(list);
//        holder.viewPager.setAdapter(adapterViewPager);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        //private ViewPager viewPager;
        private TextView txtTitle;
        ViewHolder(View itemView) {
            super(itemView);
            //viewPager = itemView.findViewById(R.id.view_pager);
            txtTitle = itemView.findViewById(R.id.item_drawer_right_title);
        }
    }
}
