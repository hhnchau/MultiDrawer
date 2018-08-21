package sosinh.info.multidrawer.left;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sosinh.info.multidrawer.R;
import sosinh.info.multidrawer.right.AdapterDrawerRight;

/**
 * Created by Chau Huynh on 2/25/2018.
 */

public class AdapterDrawerLeft extends RecyclerView.Adapter<AdapterDrawerLeft.ViewHolder> {
    private List<String> mList;

    public AdapterDrawerLeft(List<String> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_drawer_left, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtTitle.setText(mList.get(position));

        holder.txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.item_drawer_left_title);
        }
    }
}
