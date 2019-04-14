package com.nosoroce_czarne.foruminnowacji;

public class Event {
    private String eventImageURL;
    private String eventTitle;
    private String eventPlace;
    private String eventTime;

    public Event(String eventImageURL, String activityTitle, String activityPlace, String activityTime)
    {
        this.eventImageURL = eventImageURL;
        this.eventTitle = activityTitle;
        this.eventPlace = activityPlace;
        this.eventTime = activityTime;
    }

    public String getEventImageURL() {
        return eventImageURL;
    }

    public void setEventImageURL(String eventImageURL) {
        this.eventImageURL = eventImageURL;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
