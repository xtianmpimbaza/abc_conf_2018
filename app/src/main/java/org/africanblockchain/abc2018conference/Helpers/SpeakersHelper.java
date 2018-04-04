package org.africanblockchain.abc2018conference.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by christian on 4/2/2018.
 */

public class SpeakersHelper {


    /**
     * An array of sample (dummy) items.
     */
    public static final List<SpeakersHelper.SpeakersItem> ITEMS = new ArrayList<SpeakersHelper.SpeakersItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, SpeakersHelper.SpeakersItem> ITEM_MAP = new HashMap<String, SpeakersHelper.SpeakersItem>();

    private static final int COUNT = 20;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSpeakerItem(i));
        }
    }

    private static void addItem(SpeakersHelper.SpeakersItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static SpeakersHelper.SpeakersItem createSpeakerItem(int position) {
        return new SpeakersHelper.SpeakersItem(String.valueOf(position), "Speaker " + position, showSpeakers(position));
    }

    private static String showSpeakers(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * An item representing a piece of content.
     */
    public static class SpeakersItem {
        public final String id;
        public final String content;
        public final String details;

        public SpeakersItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
