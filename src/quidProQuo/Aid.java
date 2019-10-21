package quidProQuo;
import java.util.Random;

public class Aid {
    private int gender;
    private String line;
    private AidTopics topics;
    private Random rand = new Random();

    public Aid(int impeachPercent){
        topics = new AidTopics();
        this.gender = rand.nextInt(2);

        // choose a random topic from the first 20
        if (impeachPercent < 25){
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics()));
        }

        // choose a random topic from the second 20
        else if (impeachPercent < 50){
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics()));
        }

        // choose a random topic from the third 20
        else if (impeachPercent < 75){
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics()));
        }
        // choose a random topic from the last 20
        else {
            line = "Hello Mr. President, " + topics.getTopic(rand.nextInt(topics.getNumTopics()));
        }
    }


    // 0 for male, 1 for female
    public int getGender(){
        return gender;
    }

    public String getLine(){
        return line;
    }
}
