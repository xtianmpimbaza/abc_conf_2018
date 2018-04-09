package org.africanblockchain.abc2018conference.Adapters;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.JsonObject;

import org.africanblockchain.abc2018conference.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {
    public Typeface tf;
    private Context mContext;
    private ArrayList<JsonObject> albumList;

    public ScheduleAdapter(Context mContext, ArrayList<JsonObject> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        try {
            JsonObject sl = albumList.get(position);
            holder.sc_time.setText(sl.get("time").getAsString());
            holder.sc_desc.setText(sl.has("agenda_item")?sl.get("agenda_item").getAsString():"");

        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView sc_time, sc_desc;

        public MyViewHolder(View view) {
            super(view);
            sc_time = (TextView) view.findViewById(R.id.sc_time);
            sc_desc = (TextView) view.findViewById(R.id.sc_desc);
        }
    }
}
