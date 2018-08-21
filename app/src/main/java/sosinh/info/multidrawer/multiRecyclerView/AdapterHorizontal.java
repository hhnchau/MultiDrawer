package sosinh.info.multidrawer.multiRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sosinh.info.multidrawer.R;

/**
 * Created by Chau Huynh on 2/21/2018.
 */

public class AdapterHorizontal extends RecyclerView.Adapter<AdapterHorizontal.MyViewHolder> {
    List<Horizontal> mList;

    public AdapterHorizontal(List<Horizontal> mList) {
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =  itemView.findViewById(R.id.item_label);
        }
    }
}
