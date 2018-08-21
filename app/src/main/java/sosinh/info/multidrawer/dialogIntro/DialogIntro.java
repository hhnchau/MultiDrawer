package sosinh.info.multidrawer.dialogIntro;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import sosinh.info.multidrawer.R;
import sosinh.info.multidrawer.viewpager.AdapterViewPager;

/**
 * Created by Chau Huynh on 2/23/2018.
 */

public class DialogIntro {

    LinearLayout indicator;
    int dots_count;
    ImageView[] dots;

    private static DialogIntro Instance = null;

    public static DialogIntro getInstance() {
        if (Instance == null) {
            Instance = new DialogIntro();
        }
        return Instance;
    }

    public void show(final Context context) {
        final Dialog dialog = new Dialog(context, R.style.DialogIntro);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.item_dialog_intro);
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams wlp = window.getAttributes();
            wlp.gravity = Gravity.CENTER;
            window.setAttributes(wlp);
            dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

            dialog.show();


            ViewPager viewPager =  dialog.findViewById(R.id.viewPager_dialog_intro);

            indicator = dialog.findViewById(R.id.indicator_viewpager);



            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
            list.add("5");
            AdapterViewPager adapterViewPager = new AdapterViewPager(list);
            viewPager.setAdapter(adapterViewPager);

            dots_count = adapterViewPager.getCount();
            dots = new ImageView[dots_count];
            for (int i = 0; i < dots_count; i++){
                dots[i] = new ImageView(context);
                dots[i].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_non_active));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(8, 0, 8, 0);

                indicator.addView(dots[i], params);
            }
            dots[0].setImageDrawable(ContextCompat.getDrawable(context.getApplicationContext(), R.drawable.dot_active));

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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






//            CardFragmentPagerAdapter pagerAdapter = new CardFragmentPagerAdapter(((AppCompatActivity)context).getSupportFragmentManager(), dpToPixels(2, context));
//            ShadowTransformer fragmentCardShadowTransformer = new ShadowTransformer(viewPager, pagerAdapter);
//            fragmentCardShadowTransformer.enableScaling(true);
//
//            viewPager.setAdapter(pagerAdapter);
//            viewPager.setPageTransformer(false, fragmentCardShadowTransformer);
//            viewPager.setOffscreenPageLimit(3);




        }
    }

    private static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
