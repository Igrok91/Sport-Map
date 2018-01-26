package com.map.sport.sportmap.view.controller.action.dummy;

import com.map.sport.sportmap.R;
import com.map.sport.sportmap.model.Playground;
import com.map.sport.sportmap.model.PlaygroundType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class NewsDummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Event> ITEMS = new ArrayList<Event>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Event> ITEM_MAP = new HashMap<String, Event>();

    private static final int COUNT = 1;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Event item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Event createDummyItem(int position) {
        return new Event(String.valueOf(position), "Го играть в 7 вечера? ", new Playground("Поле у школы № 29", PlaygroundType.BASKETBALL), R.mipmap.ic_news_foreground);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Event {
        public final String id;
        public final Integer photoid;
        private Playground playground;
        public final String namePoll;
        private Map<Integer, String> response = new HashMap<>();
        private Map<Integer, Integer> responseCount = new HashMap<>();


        public Event(String id, String namePoll, Playground playground, Integer photoid) {
            this.id = id;
            this.namePoll = namePoll;
            this.playground = playground;
            this.photoid = photoid;
        }

        public String getId() {
            return id;
        }

        public Playground getPlayground() {
            return playground;
        }

        public void setPlayground(Playground playground) {
            this.playground = playground;
        }

        public String getNamePoll() {
            return namePoll;
        }

        public Map<Integer, String> getResponse() {
            return response;
        }

        public void setResponse(Map<Integer, String> response) {
            this.response = response;
        }

        public Map<Integer, Integer> getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(Map<Integer, Integer> responseCount) {
            this.responseCount = responseCount;
        }

        @Override
        public String toString() {
            return namePoll;
        }
    }
}
