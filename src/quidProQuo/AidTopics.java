package quidProQuo;

import java.util.ArrayList;

public class AidTopics {
    private ArrayList<String> topics;
    private int numTopics;

    public AidTopics(){
        topics = new ArrayList<String>();

        //TODO: Add the remaining topics, totalling 80
        topics.add("the people are wondering what you will do about the border crisis?");
        topics.add("your staff want to know when they will see the new draft of your tax plan?");
        topics.add("the people want to know what your response is to the shooting this past weekend?");
        topics.add("the press wants to know what your response is to the impeachment proceedings?");
        topics.add("how do you respond to the allegations that you sexually assaulted numerous women?");

        numTopics = topics.size();

    }

    public int getNumTopics() {
        return numTopics;
    }

    public String getTopic(int index) {
        String topic = topics.get(index);
        topics.remove(index);
        numTopics--;
        return topic;
    }
}
