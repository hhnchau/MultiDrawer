package sosinh.info.multidrawer.dialogIntro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import sosinh.info.multidrawer.R;

/**
 * Created by Chau Huynh on 2/23/2018.
 */

public class CardFragment extends Fragment {

    private CardView cardView;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_dialog_intro_viewpager, container, false);

        cardView = view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        TextView title = view.findViewById(R.id.title);
        Button button = view.findViewById(R.id.button);

        title.setText(String.format("Card %d", getArguments().getInt("position")));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button in Card " + getArguments().getInt("position")
                        + "Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
