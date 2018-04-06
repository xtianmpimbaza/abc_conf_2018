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

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.MyViewHolder> {
    public Typeface tf;
    private Context mContext;
    private ArrayList<JsonObject> albumList;

    public SponsorsAdapter(Context mContext, ArrayList<JsonObject> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
//            this.tf = Typeface.createFromAsset(mContext.getAssets(), "FiraSans-Light.ttf");
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.speakers_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        try {
            JsonObject sl = albumList.get(position);
            holder.sp_name.setText(sl.get("name").getAsString());
            holder.sp_title.setText(sl.has("title")?sl.get("title").getAsString():"");
            holder.sp_country.setText(sl.has("country")?sl.get("country").getAsString():"");
                Glide.with(mContext).load(sl.has("photo_url")?sl.get("photo_url").getAsString():"")
                        .thumbnail(0.5f)
                        .apply(new RequestOptions()
                                .diskCacheStrategy(DiskCacheStrategy.ALL)
                                .fallback(R.drawable.fallback)
                                .placeholder(R.drawable.progress_animation)
                                .error(R.drawable.fallback)
                        )
                        .into(holder.IMAGE);

//            holder.sp_country.setText(sl.get("country").getAsString());

            Log.e("JsonObject", sl.getAsString());
        } catch (Exception e) {
        }

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView sp_name, sp_title, sp_country;
        public ImageView IMAGE;

        public MyViewHolder(View view) {
            super(view);
            sp_name = (TextView) view.findViewById(R.id.sp_name);
            sp_title = (TextView) view.findViewById(R.id.sp_title);
            sp_country = (TextView) view.findViewById(R.id.sp_country);
            IMAGE = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }
}
