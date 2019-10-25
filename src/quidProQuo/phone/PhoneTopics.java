package quidProQuo.phone;

import quidProQuo.phone.PhoneResponse;
import quidProQuo.room.RoomView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneTopics {
    private ArrayList<String> topics;
    private Map<String, PhoneResponse[]> responseTopics;
    private int numTopics;

    public PhoneTopics(){
        topics = new ArrayList<String>();
        responseTopics = new HashMap<String, PhoneResponse[]>();

        topics.add("Boss... I think I found some dirt on your political opponent for next election, ya want it?");
        topics.add("your staff want to know when they will see the new draft of your tax plan?");
        topics.add("the people want to know what your response is to the shooting this past weekend?");
        topics.add("the press wants to know what your response is to the impeachment proceedings?");

        topics.add("how do you respond to the allegations that you sexually assaulted numerous women?");

        numTopics = topics.size();

        responseTopics.put(topics.get(0),
                new PhoneResponse[]{new PhoneResponse("Well don't leave me hanging, give me that information!", 100, 0, 0, 0, loadImage("RudyPixel.png"),"Personal Lawyer"),
                        new PhoneResponse("We should probably call the FBI about that", -5, 0, 0, 0,null,""),
                        new PhoneResponse("Huh? What? I can't hear you *hang up*", 0, 0, 0, 0,null,"")});
        responseTopics.put(topics.get(1),
                new PhoneResponse[]{new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,"")});
        responseTopics.put(topics.get(2),
                new PhoneResponse[]{new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,"")});
        responseTopics.put(topics.get(3),
                new PhoneResponse[]{new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,"")});
        responseTopics.put(topics.get(topics.size() - 1),
                new PhoneResponse[]{new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,""),
                        new PhoneResponse("", 0, 0, 0, 0,null,"")});

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
    public PhoneResponse[] getResponses(String key){
        return responseTopics.get(key);
    }

    private BufferedImage loadImage(String resourceName) {
        BufferedImage image;
        try {
            System.out.println("Loading " + resourceName);
            URL resource = PhoneTopics.class.getResource(resourceName);
            image = ImageIO.read(resource);
        } catch (Exception e) {
            throw new IllegalStateException("Could not load " + resourceName);
        }
        return image;
    }
}
