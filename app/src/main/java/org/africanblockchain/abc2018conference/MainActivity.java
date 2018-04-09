package org.africanblockchain.abc2018conference;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.africanblockchain.abc2018conference.Activities.AtendantActivity;
import org.africanblockchain.abc2018conference.Activities.HomeActivity;
import org.africanblockchain.abc2018conference.Activities.LoginActivity;
import org.africanblockchain.abc2018conference.Activities.ScheduleActivity;
import org.africanblockchain.abc2018conference.Fragments.HomeFragment;
import org.africanblockchain.abc2018conference.Fragments.ScheduleFragment;
import org.africanblockchain.abc2018conference.Fragments.SpeakersFragment;
import org.africanblockchain.abc2018conference.Fragments.SponsorsFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
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

    @OnClick(R.id.login)
    public void goToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private Handler handler;
    private Runnable runnable;

    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    openFragment(new HomeFragment());
                    startActivity(new Intent(MainActivity.this, MainActivity.class));

                    return true;
                case R.id.navigation_schedule:
//                    openFragment(new ScheduleFragment());
                    startActivity(new Intent(MainActivity.this, ScheduleActivity.class));
                    return true;
                case R.id.navigation_speakers:
//                    openFragment(new SpeakersFragment());
                    startActivity(new Intent(MainActivity.this, AtendantActivity.class));
                    return true;
//                case R.id.navigation_sponsors:
//                    openFragment(new SponsorsFragment());
//                    return true;
            }
            return false;
        }
    };

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        openFragment(new HomeFragment());
        countDownStart();

//        Button login = (Button)findViewById(R.id.login);
//        Button booking = (Button)findViewById(R.id.booking);
//
//        login.setOnClickListener(myhandler);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
