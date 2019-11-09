package quidProQuo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Topics {


    private ArrayList<Decision> year1Major = new ArrayList<Decision>();
    private ArrayList<Decision> year1Minor = new ArrayList<Decision>();
    private ArrayList<Decision> year2Major = new ArrayList<Decision>();
    private ArrayList<Decision> year2Minor = new ArrayList<Decision>();
    private ArrayList<Decision> year3Major = new ArrayList<Decision>();
    private ArrayList<Decision> year3Minor = new ArrayList<Decision>();


    Topics(){

        try {
            Scanner scan = new Scanner(new File(Topics.class.getResource("topics.txt").getPath()));

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
                int n = rand.nextInt(Constants.majorNum);
                place.add(year1Major.remove(n));
            }
            else {
                int n = rand.nextInt(Constants.minorNum);
                place.add(year1Minor.remove(n));
            }
        }

        Collections.shuffle(place);
        //TODO: add inauguration event
        //place.add(0, new Decision());
        return place;
    }

    public ArrayList<Decision> getYear2(){
        ArrayList<Decision> place = new ArrayList<Decision>();
        Random rand = new Random();

        for (int i = 0; i < Constants.descNum; i++){
            if (i < 3){
                int n = rand.nextInt(Constants.majorNum);
                place.add(year2Major.remove(n));
            }
            else {
                int n = rand.nextInt(Constants.minorNum);
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
                int n = rand.nextInt(Constants.majorNum);
                place.add(year3Major.remove(n));
            }
            else {
                int n = rand.nextInt(Constants.minorNum);
                place.add(year3Minor.remove(n));
            }
        }

        Collections.shuffle(place);
        return place;
    }
}
