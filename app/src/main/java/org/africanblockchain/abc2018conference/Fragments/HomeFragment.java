package org.africanblockchain.abc2018conference.Fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.africanblockchain.abc2018conference.Activities.HomeActivity;
import org.africanblockchain.abc2018conference.Activities.LoginActivity;
import org.africanblockchain.abc2018conference.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.txtDay)
    TextView txtDay;
    @BindView(R.id.txtHour)
    TextView txtHour;
    @BindView(R.id.txtMinute)
    TextView txtMinute;
    @BindView(R.id.txtSecond)
    TextView txtSecond;
    @BindView(R.id.tveventStart)
    TextView tvEventStart;
    @BindView(R.id.textViewheader1)
    TextView textViewheader1;

    @BindView(R.id.LinearLayout1)
    LinearLayout linearLayout1;
    @BindView(R.id.LinearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.LinearLayout3)
    LinearLayout linearLayout3;
    @BindView(R.id.LinearLayout4)
    LinearLayout linearLayout4;

    View.OnClickListener myhandler = new View.OnClickListener() {
        public void onClick(View view) {
//            startActivity(new Intent(getActivity(), HomeActivity.class));
            startActivity(new Intent(getActivity(), LoginActivity.class));

        }
    };
    private Handler handler;
    private Runnable runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, v);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
//        ActionBar actionBar = activity.getSupportActionBar();
//        actionBar.hide();


        Button login = (Button) v.findViewById(R.id.login);
        Button booking = (Button) v.findViewById(R.id.booking);

        login.setOnClickListener(myhandler);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new BookingFragment());
            }
        });
        countDownStart();
        return v;
    }

    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Setting the date//YYYY-MM-DD of event
                    Date futureDate = dateFormat.parse("2018-5-23");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtDay.setText("" + String.format("%02d", days));
                        txtHour.setText("" + String.format("%02d", hours));
                        txtMinute.setText(""
                                + String.format("%02d", minutes));
                        txtSecond.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        tvEventStart.setVisibility(View.VISIBLE);
                        tvEventStart.setText("The event started!");
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }

    public void textViewGone() {
        linearLayout1.setVisibility(View.GONE);
        linearLayout2.setVisibility(View.GONE);
        linearLayout3.setVisibility(View.GONE);
        linearLayout4.setVisibility(View.GONE);
        textViewheader1.setVisibility(View.GONE);
    }

    private void openFragment(final Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {

    }
}
