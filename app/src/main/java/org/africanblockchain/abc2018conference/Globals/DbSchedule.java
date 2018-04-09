package org.africanblockchain.abc2018conference.Globals;

import android.content.Context;

import com.google.gson.JsonObject;

import java.util.ArrayList;

public class DbSchedule {

    private Context CONTEXT = null;

    public DbSchedule(Context c) {
        CONTEXT = c;
    }


    public ArrayList<JsonObject> allPrograms(String days) throws Exception {

        ArrayList<JsonObject> sps = new ArrayList<>();

        if (days == "first"){
            JsonObject item = new JsonObject();
            item.addProperty("time", "9:30");
            item.addProperty("agenda_item", "Welcoming guests");
            sps.add(item);
        } else{
            JsonObject item = new JsonObject();
            item.addProperty("time", "9:30");
            item.addProperty("agenda_item", "Previous day review");
            sps.add(item);
        }

        return sps;
    }


}
