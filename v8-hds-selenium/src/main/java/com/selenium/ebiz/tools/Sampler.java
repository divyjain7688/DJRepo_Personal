package com.selenium.ebiz.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Sampler {

    public Sampler(){}

    public List<String> sampler (int reservoirSize) throws FileNotFoundException {
        String currentLine=null;
        //reservoirList is where our selected lines stored
        List <String> reservoirList= new ArrayList<String>(reservoirSize);
        // we will use this counter to count the current line number while iterating
        int count=0;

        Random ra = new Random();
        int randomNumber = 0;
        Scanner sc = new Scanner(new File(System.getProperty("user.dir") + "/src/main/resources/Users.txt")).useDelimiter("\n");
        while (sc.hasNext())
        {
            currentLine = sc.next();
            count ++;
            if (count<=reservoirSize)
            {
                reservoirList.add(currentLine);
            }
            else if ((randomNumber = (int) ra.nextInt(count))<reservoirSize)
            {
                reservoirList.set(randomNumber, currentLine);
            }
        }

        return reservoirList;
    }
}
