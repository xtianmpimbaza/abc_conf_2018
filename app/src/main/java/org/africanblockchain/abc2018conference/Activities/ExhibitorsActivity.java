package org.africanblockchain.abc2018conference.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.africanblockchain.abc2018conference.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExhibitorsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @BindView(R.id.exhibitors)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibitors);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Exhibitors");

        ButterKnife.bind(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://africanblockchain.org/exhibit/get-involved/");
                Intent l = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(l);
            }
        });
    }
}
