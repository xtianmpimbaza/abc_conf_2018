package org.africanblockchain.abc2018conference.Fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import org.africanblockchain.abc2018conference.Activities.HomeActivity;
import org.africanblockchain.abc2018conference.Activities.LoginActivity;
import org.africanblockchain.abc2018conference.R;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private WebView mWebview;
    public int counter;
//    public TextView tv_days = (Button) findViewById(R.id.tv_days);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.hide();

        Button login = (Button) v.findViewById(R.id.login);
        Button booking = (Button) v.findViewById(R.id.booking);
//        TextView tv_days = (Button) v.findViewById(R.id.tv_days);

        login.setOnClickListener(myhandler);

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new BookingFragment());
            }
        });

//        new CountDownTimer(30000, 1000){
//            public void onTick(long millisUntilFinished){
//                tv_days.setText(String.valueOf(counter));
//                counter++;
//            }
//            public  void onFinish(){
//                tv_days.setText("Done!!");
//            }
//        }.start();

        return v;
    }

    View.OnClickListener myhandler = new View.OnClickListener() {
        public void onClick(View view) {
//            startActivity(new Intent(getActivity(), HomeActivity.class));
            startActivity(new Intent(getActivity(), LoginActivity.class));

        }
    };

    private void openFragment(final Fragment fragment)   {
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
