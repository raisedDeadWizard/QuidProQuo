package quidProQuo.aid;
import java.util.Random;

public class Aid {
    private int gender;
    private String line;
    private AidResponse[] responses;
    private AidTopics topics;
    private Random rand;

    public Aid(int impeachPercent, AidTopics topics){
        rand = new Random();

        this.gender = rand.nextInt(2);

        // choose a random topic from the first 20
        if (impeachPercent < 25){
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics() / 4));
        }

        // choose a random topic from the second 20
        else if (impeachPercent < 50){
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics() / 4 + 25));
        }

        // choose a random topic from the third 20
        else if (impeachPercent < 75){
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics() / 4 + 50));
        }
        // choose a random topic from the last 20
        else {
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics() / 4 + 75));
        }

        responses = topics.getResponses(line);
    }

    public AidResponse getResponse(int id){
        return responses[id];
    }
    // 0 for male, 1 for female
    public int getGender(){
        return gender;
    }

    public String getLine(){
        return line;
    }
}
