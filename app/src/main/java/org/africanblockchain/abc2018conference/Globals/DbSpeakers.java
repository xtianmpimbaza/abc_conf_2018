package org.africanblockchain.abc2018conference.Globals;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by christian on 4/5/2018.
 */

public class DbSpeakers {

    private Context CONTEXT = null;

    public DbSpeakers(Context c) {
        CONTEXT = c;
    }


    public ArrayList<JsonObject> allSpeakers() throws Exception {

        ArrayList<JsonObject> sps = new ArrayList<>();

        JsonObject item = new JsonObject();
        item.addProperty("photo_url", "https://africanblockchain.org/wp-content/uploads/2018/04/Hon.-Bagiire-Vincent-Waiswa-e1521045819329-768x768-320x320.jpg");
        item.addProperty("name", "Hon. Bagiire Vincent Waiswa");
        item.addProperty("title", "Permanent Secretary, Ministry of ICT");
        item.addProperty("country", "Uganda");

        sps.add(item);

        return sps;
    }


}
