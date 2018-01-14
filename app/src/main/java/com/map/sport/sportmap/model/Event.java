package com.map.sport.sportmap.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Igor on 13.01.2018.
 */

public class Event {
    private Playground playground;
    private String namePoll;
    private Map<Integer, String> response = new HashMap<>();
    private Map<Integer, Integer> responseCount = new HashMap<>();

    public Event(Playground playground, String namePoll) {
        this.playground = playground;
        this.namePoll = namePoll;
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

    public void setNamePoll(String namePoll) {
        this.namePoll = namePoll;
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

    private List<Event> eventList;

    public void initializeData() {
        int idOne = 1;
        int idTwo = 2;
        eventList = new ArrayList<>();
        response.put(idOne, "Да, приду");
        response.put(idTwo, "Нет");
        responseCount.put(idOne, 10);
        responseCount.put(idTwo, 2);
        eventList.add(new Event(new Playground("Поле у школы № 29", PlaygroundType.BASKETBALL), "Го играть в 7 часов?"));
        eventList.add(new Event(new Playground("Поле у школы № 43", PlaygroundType.FOOTBALL), "Го играть в 9 часов?"));
        eventList.add(new Event(new Playground("Поле у школы № 56", PlaygroundType.VOLEYBALL), "Го играть в 10 часов?"));

    }

    public List<Event> getEventList() {
        return eventList;
    }


}
