package org.africanblockchain.abc2018conference.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.africanblockchain.abc2018conference.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.about) CardView about;
    @BindView(R.id.schedule) CardView schedule;
    @BindView(R.id.speakers) CardView speakers;
    @BindView(R.id.sponsors) CardView sponsors;
    @BindView(R.id.exhibitors) CardView exhibitors;
    @BindView(R.id.attendees) CardView attendees;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Main menu");

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(l);
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(l);
            }
        });

        speakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(HomeActivity.this, SpeakersActivity.class);
                startActivity(l);
            }
        });

        sponsors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(HomeActivity.this, SponsorActivity.class);
                startActivity(l);
            }
        });

        exhibitors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(HomeActivity.this, ExhibitorsActivity.class);
                startActivity(l);
            }
        });

        attendees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(HomeActivity.this, AttendeeActivity.class);
                startActivity(l);
            }
        });
    }
}
