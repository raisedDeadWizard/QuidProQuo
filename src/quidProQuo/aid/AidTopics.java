package quidProQuo.aid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AidTopics {
    private ArrayList<String> topics;
    private Map<String, AidResponse[]> responseTopics = new HashMap<String, AidResponse[]>();
    private int numTopics;

    public AidTopics(){

        topics.add("the people are wondering what you will do about the border crisis?");
        topics.add("your staff want to know when they will see the new draft of your tax plan?");
        topics.add("the people want to know what your response is to the shooting this past weekend?");
        topics.add("the press wants to know what your response is to the impeachment proceedings?");

        topics.add("how do you respond to the allegations that you sexually assaulted numerous women?");

        numTopics = topics.size();

        responseTopics.put(topics.get(0),
                new AidResponse[]{new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0)});
        responseTopics.put(topics.get(1),
                new AidResponse[]{new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0)});
        responseTopics.put(topics.get(2),
                new AidResponse[]{new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0)});
        responseTopics.put(topics.get(3),
                new AidResponse[]{new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0)});
        responseTopics.put(topics.get(topics.size() - 1),
                new AidResponse[]{new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0),
                        new AidResponse("", 0, 0, 0, 0)});

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
