package quidProQuo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Topics {


    public static ArrayList<Highlight> highlights = new ArrayList<Highlight>();
    private ArrayList<Decision> year1Major = new ArrayList<Decision>();
    private ArrayList<String> year1MajorLinks = new ArrayList<String>();
    private ArrayList<Decision> year1Minor = new ArrayList<Decision>();
    private ArrayList<Decision> year2Major = new ArrayList<Decision>();
    private ArrayList<String> year2MajorLinks = new ArrayList<String>();
    private ArrayList<Decision> year2Minor = new ArrayList<Decision>();
    private ArrayList<Decision> year3Major = new ArrayList<Decision>();
    private ArrayList<String> year3MajorLinks = new ArrayList<String>();
    private ArrayList<Decision> year3Minor = new ArrayList<Decision>();


    Topics(){

        try {
            Scanner scan = new Scanner(Topics.class.getResourceAsStream("topics.txt"));

            //Each for loop assigns the responses to each array from the text file
            for(int i = 0; i < Constants.majorNum; i++) {
                year1Major.add(new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()), true));
            }

            for(int i = 0; i < Constants.minorNum; i++) {
                year1Minor.add(new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()), false));
            }

            for(int i = 0; i < Constants.majorNum; i++) {
                year2Major.add(new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()), true));
            }

            for(int i = 0; i < Constants.minorNum; i++) {
                year2Minor.add(new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()), false));
            }

            for(int i = 0; i < Constants.majorNum; i++) {
                year3Major.add(new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()), true));
            }

            for(int i = 0; i < Constants.minorNum; i++) {
                year3Minor.add(new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()), false));
            }
            scan.close();

            try {
                Scanner high = new Scanner(new File(Topics.class.getResource("highlight.txt").getPath()));

                for(int i = 0; i < Constants.majorNum *9; i++){
                    highlights.add(new Highlight(high.nextLine(), high.nextLine(), high.nextLine()));
                }
            }
            catch (Exception e){

            }

            //scan major links information, add that to arraylists

            Scanner linkScan = new Scanner(new File(Topics.class.getResource("topiclinks.txt").getPath()));
            for(int i = 0; i < Constants.majorNum; i++) {
                year1MajorLinks.add(linkScan.nextLine());
            }
            for(int i = 0; i < Constants.majorNum; i++) {
                year2MajorLinks.add(linkScan.nextLine());
            }
            for(int i = 0; i < Constants.majorNum; i++) {
                year3MajorLinks.add(linkScan.nextLine());
            }
            linkScan.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }


    public ArrayList<Decision> getYear1(){
        ArrayList<Decision> place = new ArrayList<Decision>();
        Random rand = new Random();

        for (int i = 0; i < Constants.descNum; i++){
            if (i < 3){
                int n = rand.nextInt(Constants.majorNum - i);
                place.add(year1Major.remove(n));
            }
            else {
                int n = rand.nextInt(Constants.minorNum - i+3);
                place.add(year1Minor.remove(n));
            }
        }

        Collections.shuffle(place);
        place.add(0, new Decision("Mr. President, the writers for your inauguration speech would like to know what you’d like your speech to focus on."
                , new Response("Give an America first speech with a focus on nationalism.", -2, 2, 1, "Motivates conservatives while liberals are upset")
                , new Response("Give a speech encouraging bipartisan cooperation.", 1, 1, 1, "Most took this in a favorable way. Liberals liked this response.")
                , new Response("Give a speech thanking the American people and pledge to fulfill your campaign promises.", 0, 1, 1, "Most took this is in a favorable way."), false));
        return place;
    }

    public ArrayList<Decision> getYear2(){
        ArrayList<Decision> place = new ArrayList<Decision>();
        Random rand = new Random();

        for (int i = 0; i < Constants.descNum; i++){
            if (i < 3){
                int n = rand.nextInt(Constants.majorNum - i);
                place.add(year2Major.remove(n));
            }
            else {
                int n = rand.nextInt(Constants.minorNum - i+3);
                place.add(year2Minor.remove(n));
            }
        }

        Collections.shuffle(place);
        return place;
    }

    public ArrayList<Decision> getYear3(){
        ArrayList<Decision> place = new ArrayList<Decision>();
        Random rand = new Random();

        for (int i = 0; i < Constants.descNum; i++){
            if (i < 3){
                int n = rand.nextInt(Constants.majorNum - i);
                place.add(year3Major.remove(n));
            }
            else {
                int n = rand.nextInt(Constants.minorNum - i+3);
                place.add(year3Minor.remove(n));
            }
        }

        Collections.shuffle(place);
        return place;
    }

    public ArrayList<Decision> getAllResponses(){
        ArrayList<Decision> allResp = new ArrayList<Decision>();
        allResp.addAll(year1Major);
        allResp.addAll(year1Minor);
        allResp.addAll(year2Major);
        allResp.addAll(year2Minor);
        allResp.addAll(year3Major);
        allResp.addAll(year3Minor);
        return allResp;
    }
}
