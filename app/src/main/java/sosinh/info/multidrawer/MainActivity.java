package sosinh.info.multidrawer;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import sosinh.info.multidrawer.dialogIntro.CardFragmentPagerAdapter;
import sosinh.info.multidrawer.dialogIntro.DialogIntro;
import sosinh.info.multidrawer.dialogIntro.ShadowTransformer;
import sosinh.info.multidrawer.left.AdapterDrawerLeft;
import sosinh.info.multidrawer.multiRecyclerView.AdapterMain;
import sosinh.info.multidrawer.multiRecyclerView.Grid;
import sosinh.info.multidrawer.multiRecyclerView.Horizontal;
import sosinh.info.multidrawer.multiRecyclerView.ObjectGrid;
import sosinh.info.multidrawer.multiRecyclerView.ObjectHorizontal;
import sosinh.info.multidrawer.multiRecyclerView.ObjectPager;
import sosinh.info.multidrawer.multiRecyclerView.ObjectVertical;
import sosinh.info.multidrawer.multiRecyclerView.Pager;
import sosinh.info.multidrawer.multiRecyclerView.Vertical;
import sosinh.info.multidrawer.right.AdapterDrawerRight;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private LinearLayout drawerLeft, drawerRight;
    private ImageView iconMenu, iconShopping;

    private RecyclerView recyclerViewDrawerLeft, recyclerViewDrawerRight;
    private AdapterDrawerRight adapterDrawerRight;
    private AdapterDrawerLeft adapterDrawerLeft;
    private List<String> mListLeft, mListRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(ContextCompat.getColor(this, R.color.purple500w));
            }
        }

        setContentView(R.layout.activity_main);
        initView();

        //toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);


        onIconLeftClick();
        onIconRightClick();


    }

    private void initView() {
        drawerLayout = findViewById(R.id.drawer_layout);
        initDrawerLeft();
        initDrawerRight();
    }


    private void initDrawerLeft() {
        drawerLeft = findViewById(R.id.drawer_left);
        iconMenu = findViewById(R.id.ic_menu);
        recyclerViewDrawerLeft = findViewById(R.id.rcv_drawer_left);
        recyclerViewDrawerLeft.setHasFixedSize(true);
        recyclerViewDrawerLeft.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewDrawerLeft.setItemAnimator(new DefaultItemAnimator());

        mListLeft = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mListLeft.add("Test " + i);
        }

        adapterDrawerLeft = new AdapterDrawerLeft(mListLeft);
        recyclerViewDrawerLeft.setAdapter(adapterDrawerLeft);
    }

    private void initDrawerRight() {
        drawerRight = findViewById(R.id.drawer_right);
        iconShopping = findViewById(R.id.ic_shopping);
        recyclerViewDrawerRight = findViewById(R.id.rcv_drawer_right);
        recyclerViewDrawerRight.setHasFixedSize(true);
        recyclerViewDrawerRight.setLayoutManager(new LinearLayoutManager(this)); // Type: ListView
        //recyclerViewDrawerRight.setLayoutManager(new GridLayoutManager(this, 4));  // Type: GridView
        //DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, new LinearLayoutManager(this).getOrientation());
        //recyclerViewDrawerRight.addItemDecoration(dividerItemDecoration);
        recyclerViewDrawerRight.setItemAnimator(new DefaultItemAnimator());

        mListRight = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mListRight.add("Test " + i);
        }

        adapterDrawerRight = new AdapterDrawerRight(mListRight, new AdapterDrawerRight.OnItemClick() {
            @Override
            public void onClick(int p) {
                Toast.makeText(MainActivity.this, "" + p, Toast.LENGTH_SHORT).show();

                for (int i = 100; i < 101; i++) {
                    mListRight.add("Test " + i);
                }
                adapterDrawerRight.notifyDataSetChanged();

                mListRight.remove(0);
                adapterDrawerRight.notifyDataSetChanged();

            }
        });

        recyclerViewDrawerRight.setAdapter(adapterDrawerRight);

    }

    private void onIconLeftClick() {
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerLeft);
            }
        });
    }

    private void onIconRightClick() {
        iconShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerRight);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 100; i < 101; i++) {
            mListRight.add("Test " + i);
        }
        adapterDrawerRight.notifyDataSetChanged();

        mListRight.remove(0);
        adapterDrawerRight.notifyDataSetChanged();


        List<Object> list = new ArrayList<>();
        list.add(getDataPager());
        list.add(getDataHorizontal());
        list.add(getDataVertical());
        list.add(getDataVertical());
        list.add(getDataHorizontal());
        list.add(getDataVertical());
        list.add(getDataGrid());


        RecyclerView recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterMain adapter = new AdapterMain(this, list);
        recyclerView.setAdapter(adapter);


        //DialogIntro.getInstance().show(this);

//        ViewPager viewPager = findViewById(R.id.viewPager_dialog_intro);
//
//        CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));
//        ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
//        fragmentCardShadowTransformer.enableScaling(true);
//
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
//        viewPager.setOffscreenPageLimit(3);



        final CoordinatorLayout coordinatorLayout= findViewById(R.id.coordinator);
        RelativeLayout layoutBottomSheet = findViewById(R.id.layout_bottom_sheet);
        final BottomSheetBehavior bottomSheetBehavior= BottomSheetBehavior.from(layoutBottomSheet);

        coordinatorLayout.post(new Runnable() {
            @Override
            public void run() {
                coordinatorLayout.requestLayout();
                coordinatorLayout.invalidate();
                bottomSheetBehavior.setHideable(false);
                bottomSheetBehavior.setPeekHeight(50);

            }
        });


        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (bottomSheetBehavior.getPeekHeight() <= 50)
                    bottomSheetBehavior.setPeekHeight(900);
                else
                    bottomSheetBehavior.setPeekHeight(50);
                //Toast.makeText(MainActivity.this, "Change" + newState, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //Toast.makeText(MainActivity.this, "Slide" + (int)slideOffset, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    private Object getDataVertical() {
        List<Vertical> listVertical = new ArrayList<>();
        listVertical.add(new Vertical("San pham 1", "hinh", "Hang Giam Gia", "100.000", "1.000"));
        listVertical.add(new Vertical("San pham 1", "hinh", "Hang Giam Gia", "100.000", "1.000"));
        listVertical.add(new Vertical("San pham 1", "hinh", "Hang Giam Gia", "100.000", "1.000"));
        listVertical.add(new Vertical("San pham 1", "hinh", "Hang Giam Gia", "100.000", "1.000"));
        listVertical.add(new Vertical("San pham 1", "hinh", "Hang Giam Gia", "100.000", "1.000"));
        ObjectVertical objectVertical = new ObjectVertical();
        objectVertical.setSection("Vertical");
        objectVertical.setTime("20:59");
        objectVertical.setVertical(listVertical);

        return objectVertical;
    }

    private Object getDataHorizontal() {
        List<Horizontal> listHorizontal = new ArrayList<>();
        listHorizontal.add(new Horizontal("San pham 1", "hinh", "SP"));
        listHorizontal.add(new Horizontal("San pham 1", "hinh", "SP"));
        listHorizontal.add(new Horizontal("San pham 1", "hinh", "SP"));
        listHorizontal.add(new Horizontal("San pham 1", "hinh", "SP"));
        listHorizontal.add(new Horizontal("San pham 1", "hinh", "SP"));
        ObjectHorizontal objectHorizontal = new ObjectHorizontal();
        objectHorizontal.setSection("Horizontal");
        objectHorizontal.setHorizontal(listHorizontal);

        return objectHorizontal;
    }

    private Object getDataGrid() {
        List<Grid> listGrid = new ArrayList<>();
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));
        listGrid.add(new Grid("Grid", "Hinh"));

        ObjectGrid objectGrid = new ObjectGrid();
        objectGrid.setSection("Grid View");
        objectGrid.setGrid(listGrid);

        return objectGrid;
    }

    private Object getDataPager(){
        List<Pager> listPager = new ArrayList<>();
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));
        listPager.add(new Pager("ViewPager", "Test"));

        ObjectPager objectPager = new ObjectPager();
        objectPager.setSection("ViewPager");
        objectPager.setPager(listPager);

        return objectPager;
    }

}
