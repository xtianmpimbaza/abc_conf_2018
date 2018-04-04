package org.africanblockchain.abc2018conference.Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by christian on 4/2/2018.
 */

public class SponsorsHelper {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<SponsorsHelper.SponsorsItem> ITEMS = new ArrayList<SponsorsHelper.SponsorsItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, SponsorsHelper.SponsorsItem> ITEM_MAP = new HashMap<String, SponsorsHelper.SponsorsItem>();

    private static final int COUNT = 20;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSponsorItem(i));
        }
    }

    private static void addItem(SponsorsHelper.SponsorsItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static SponsorsHelper.SponsorsItem createSponsorItem(int position) {
        return new SponsorsHelper.SponsorsItem(String.valueOf(position), "Sponsor " + position, showSponsors(position));
    }

    private static String showSponsors(int position) {
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
    public static class SponsorsItem {
        public final String id;
        public final String content;
        public final String details;

        public SponsorsItem(String id, String content, String details) {
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
