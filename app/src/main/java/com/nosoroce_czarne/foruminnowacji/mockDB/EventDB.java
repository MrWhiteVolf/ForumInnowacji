package com.nosoroce_czarne.foruminnowacji.mockDB;

import com.nosoroce_czarne.foruminnowacji.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDB {

    private static List<Event> events = new ArrayList<>();

    static {
        events.add(new Event("eventImageURL", "1111111", "activityPlace", "activityTime"));
        events.add(new Event("eventImageURL", "2222222", "activityPlace", "activityTime"));
        events.add(new Event("eventImageURL", "3333333", "activityPlace", "activityTime"));
        events.add(new Event("eventImageURL", "4444444", "activityPlace", "activityTime"));
        events.add(new Event("eventImageURL", "5555555", "activityPlace", "activityTime"));
        events.add(new Event("eventImageURL", "666666", "activityPlace", "activityTime"));
        events.add(new Event("eventImageURL", "activityTitle", "activityPlace", "activityTime"));
    }

    public static List<Event> getEvents() {
        return events;
    }
}
