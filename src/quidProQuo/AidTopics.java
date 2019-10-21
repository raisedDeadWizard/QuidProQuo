package quidProQuo;

import java.util.ArrayList;

public class AidTopics {
    private ArrayList<String> topics;
    private int numTopics;

    public AidTopics(){
        topics = new ArrayList<String>();

        topics.add("what you will do about the border crisis?");
        topics.add("when they will see the dividends of your tax plan?");
        topics.add("what your response is to the shooting this past weekend?");
        topics.add("what your response is to the impeachment proceedings?");

        numTopics = 4;

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
