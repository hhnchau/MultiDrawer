package sosinh.info.multidrawer.multiRecyclerView;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sosinh.info.multidrawer.R;

/**
 * Created by Chau Huynh on 2/22/2018.
 */

public class AdapterMain extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object> listObject;
    private final int VERTICAL = 1;
    private final int HORIZONTAL = 2;
    private final int GRID = 3;
    private final int PAGER = 4;



    public AdapterMain(Context context, List<Object> items) {
        this.context = context;
        this.listObject = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case VERTICAL:
                view = inflater.inflate(R.layout.item_recycler_vertical, parent, false);
                holder = new VerticalViewHolder(view);
                break;

            case HORIZONTAL:
                view = inflater.inflate(R.layout.item_recycler_horizintal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;

            case GRID:
                view = inflater.inflate(R.layout.item_recycler_grid, parent, false);
                holder = new GridViewHolder(view);
                break;

            case PAGER:
                view = inflater.inflate(R.layout.item_recycler_viewpager, parent, false);
                holder = new PagerViewHolder(view);
                break;

            default:
                view = inflater.inflate(R.layout.item_recycler_horizintal, parent, false);
                holder = new HorizontalViewHolder(view);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == VERTICAL) {
            verticalView((VerticalViewHolder) holder, position);
        } else if (holder.getItemViewType() == HORIZONTAL) {
            horizontalView((HorizontalViewHolder) holder, position);
        }else if (holder.getItemViewType() == GRID){
            gridView((GridViewHolder) holder, position);
        }else if (holder.getItemViewType() == PAGER){
            pagerView((PagerViewHolder) holder, position);
        }
    }

    private void verticalView(VerticalViewHolder holder, int position) {

        ObjectVertical objectVertical = (ObjectVertical) listObject.get(position);

        holder.txtSection.setText(objectVertical.getTime());
        holder.txtSectionAll.setText(objectVertical.getSection());

        AdapterVertical adapter1 = new AdapterVertical(objectVertical.getVertical());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter1);
    }

    private void horizontalView(HorizontalViewHolder holder, int position) {

        ObjectHorizontal objectHorizontal = (ObjectHorizontal) listObject.get(position);

        holder.txtSection.setText(objectHorizontal.getSection());

        AdapterHorizontal adapter = new AdapterHorizontal(objectHorizontal.getHorizontal());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void gridView(GridViewHolder holder, int position) {

        ObjectGrid objectGrid = (ObjectGrid) listObject.get(position);

        holder.txtSectionAll.setText(objectGrid.getSection());

        AdapterGrid adapter = new AdapterGrid(objectGrid.getGrid());
        holder.recyclerView.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void pagerView(PagerViewHolder holder, int position) {

        ObjectPager objectPager = (ObjectPager) listObject.get(position);

        holder.txtSection.setText(objectPager.getSection());

        AdapterPager adapter = new AdapterPager(context, objectPager.getPager());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder.recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return listObject.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listObject.get(position) instanceof ObjectVertical)
            return VERTICAL;
        if (listObject.get(position) instanceof ObjectHorizontal)
            return HORIZONTAL;
        if (listObject.get(position) instanceof ObjectGrid)
            return GRID;
        if (listObject.get(position) instanceof ObjectPager)
            return PAGER;
        return -1;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private TextView txtSection;

        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_horizontal);
            txtSection = itemView.findViewById(R.id.section_show_all_button);
        }
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView txtSection;
        private TextView txtSectionAll;

        VerticalViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_vertical);
            txtSection = itemView.findViewById(R.id.section_label);
            txtSectionAll = itemView.findViewById(R.id.section_show_all_button);
        }
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView txtSectionAll;

        GridViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_grid);
            txtSectionAll = itemView.findViewById(R.id.section_show_all_button);
        }
    }

    public class PagerViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView txtSection;

        PagerViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recycler_viewpager);
            txtSection = itemView.findViewById(R.id.section_viewpager);
        }
    }
}
