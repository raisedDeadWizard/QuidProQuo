package quidProQuo;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Highlight {
    private Topics topics;
    private HashMap<Integer, String> highMap = new HashMap<Integer, String>();

    public Highlight(){




        try {
            Scanner high = new Scanner(new File(Topics.class.getResource("highlight.txt").getPath()));

            while (high.hasNextLine()) {
                highMap.put(high.nextInt(), high.nextLine());
            }
        } catch (Exception e) {

        }
    }

    public String getBlurb(int key){
        return highMap.get(key);
    }




}
