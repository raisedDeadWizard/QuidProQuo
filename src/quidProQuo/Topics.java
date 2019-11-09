package quidProQuo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Topics {


    public Decision[] year1Major = new Decision[Constants.majorNum];
    public Decision[] year1Minor = new Decision[Constants.minorNum];
    public Decision[] year2Major = new Decision[Constants.majorNum];
    public Decision[] year2Minor = new Decision[Constants.minorNum];
    public Decision[] year3Major = new Decision[Constants.majorNum];
    public Decision[] year3Minor = new Decision[Constants.minorNum];


    public Topics(){



        try {
            Scanner scan = new Scanner(new File(Topics.class.getResource("topics.txt").getPath()));

            for(int i = 0; i < 1; i++) { //for loop for year1Major

                year1Major[i] = new Decision(scan.nextLine(), new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()),
                        new Response(scan.nextLine(), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()),
                                Integer.parseInt(scan.nextLine()), scan.nextLine()), new Response(scan.nextLine(),
                        Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), Integer.parseInt(scan.nextLine()), scan.nextLine()));
            }
            System.out.println(year1Major[0].toString());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
