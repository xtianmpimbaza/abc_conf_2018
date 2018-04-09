package org.africanblockchain.abc2018conference.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.gson.JsonObject;

import org.africanblockchain.abc2018conference.Adapters.SpeakersAdapter;
import org.africanblockchain.abc2018conference.Globals.DbSpeakers;
import org.africanblockchain.abc2018conference.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpeakersActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @BindView(R.id.rv)
    RelativeLayout _RecyclerViewLayout;
    @BindView(R.id.rv_layout) RelativeLayout relativeLayout;
    @BindView(R.id.empty_rv)
    RelativeLayout _EmptyRecyclerViewLayout;
    @BindView(R.id.recycler_view_insurance)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    SpeakersAdapter adapter;
    ArrayList<JsonObject> ins = new ArrayList<>();

    DbSpeakers dbSpeakers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Speakers");


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new SpeakersAdapter(getApplicationContext(), ins);
        recyclerView.setAdapter(adapter);


        new LongOperation().execute();

    }

    private class LongOperation extends AsyncTask<String, Void, ArrayList<JsonObject>> {

        @Override
        protected void onPostExecute(ArrayList<JsonObject> result) {
            ins.addAll(result);
            adapter.notifyDataSetChanged();
            if (ins.isEmpty()) {
                _RecyclerViewLayout.setVisibility(View.GONE);
                _EmptyRecyclerViewLayout.setVisibility(View.VISIBLE);
            } else {
                _RecyclerViewLayout.setVisibility(View.VISIBLE);
                _EmptyRecyclerViewLayout.setVisibility(View.GONE);
            }
            relativeLayout.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        protected ArrayList<JsonObject> doInBackground(String... strings) {
            try {
                return dbSpeakers.allSpeakers();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            dbSpeakers = new DbSpeakers(SpeakersActivity.this);
            ins.clear();
        }

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}
