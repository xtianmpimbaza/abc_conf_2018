package org.africanblockchain.abc2018conference.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import org.africanblockchain.abc2018conference.Adapters.SpeakersAdapter;
import org.africanblockchain.abc2018conference.Globals.DbSpeakers;
import org.africanblockchain.abc2018conference.R;


public class SpeakersFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speakers, container, false);
        ButterKnife.bind(this,view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new SpeakersAdapter(getActivity(), ins);
        recyclerView.setAdapter(adapter);


        new LongOperation().execute();

        return view;
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
            dbSpeakers = new DbSpeakers(getActivity());
            ins.clear();
        }

        @Override
        protected void onProgressUpdate(Void... values) {}
    }

}
