package hugo_exercises1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class example {
    private static final String NEW_LINE_SEPARATOR = System.getProperty("line.separator");
    public static void main(String[] args) {
        //1. Print elements of an array

        // 1.1 Each element in one line
        System.out.println("------------------------");
        System.out.println("1 Element 1 line");
        System.out.println("------------------------");

        String[] fruits = {"Watermelon","Grape","Banana","Apple","Peach","Orange","Kiwi"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        // 1.2 Each element separated with commas
        System.out.println("------------------------");
        System.out.println("Separated with commas");
        System.out.println("------------------------");

        for (int i = 0; i < fruits.length; i++) {
            if (i == fruits.length-1){
                System.out.println(fruits[i]);
            }else {
                System.out.print(fruits[i]+",");
            }
        }

        //2. Print even and odd numbers from an array

        // 2.1 Odd numbers, we divide i by 2 and if the remainder is different than 0 then it is even
        System.out.println("------------------------");
        System.out.println("Odd numbers");
        System.out.println("------------------------");

        for (int i = 0; i < fruits.length; i++) {
            if(i%2!=0){
                System.out.println(fruits[i]);
            }
        }
        // 2.2 Even numbers, we divide i by 2 and if the remainder is 0 then it is even
        System.out.println("------------------------");
        System.out.println("Even numbers");
        System.out.println("------------------------");

        for (int i = 0; i < fruits.length; i++) {
            if(i%2==0){
                System.out.println(fruits[i]);
            }
        }

        int numbers[] = {34,53,21,5,342,23,654,65,36,32,98,54};
        // 3. Find the second largest element in a numeric array
        int temp;
        //Arrays.sort(numbers);
        /*
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i]>numbers[j]){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        */
        System.out.println("------------------------");
        System.out.println("The second largest number is: "+numbers[1]);
        System.out.println("The second largest number is: "+numbers[numbers.length-2]);
        System.out.println("------------------------");

        //4. Find the difference (pick report type) between two dates
        String join = "02-04-2020 06:45:13";
        String leave  = "25-05-2023 10:12:32";
        SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            Date date1 = obj.parse(join);
            Date date2 = obj.parse(leave);
            long ms_diff = date2.getTime() - date1.getTime();
            long years_diff = (ms_diff / (1000l*60*60*24*365));
            long days_diff = (ms_diff / (1000*60*60*24)) % 365;
            long hours_diff = (ms_diff / (1000*60*60)) % 24;
            long minutes_diff = (ms_diff / (1000*60)) % 60;
            long seconds_diff = (ms_diff / 1000)% 60;

            System.out.print("The difference between the two dates provided is: ");
            System.out.println(years_diff + " years, " + days_diff + " days, " + hours_diff + " hours, " + minutes_diff + " minutes, " + seconds_diff + " seconds");
        }
        // Catch parse exception
        catch (ParseException excep) {
            excep.printStackTrace();
        }

        // 5. Read a string from a file, reverse the string and save it in another file.
        try {
            //File file = new File(".");
            //for(String fileNames : file.list()) System.out.println(fileNames);

            FileReader input = new FileReader("input.txt");
            BufferedReader bufRead = new BufferedReader(input);

            StringBuffer rvsWords = new StringBuffer();
            String line;

            line = bufRead.readLine();

            while (line != null) {

                String lineReversed = "";
                char ch;


                for (int i=0; i<line.length(); i++)
                {
                    ch= line.charAt(i); //extracts each character
                    lineReversed= ch+lineReversed; //adds each character in front of the existing string
                }

                rvsWords.append(lineReversed);

                line = bufRead.readLine();

                if (line != null) {
                    rvsWords.append(NEW_LINE_SEPARATOR);
                }
            }
            bufRead.close();

            File outFile = new File("output.txt");
            FileWriter writer = new FileWriter(outFile);
            writer.write(rvsWords.toString());
            writer.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

        //6. Write a Java program that matches a string that has a p followed by zero or more q´s with regex
        System.out.println("------------------------");
        System.out.println("String regex 1");
        System.out.println("------------------------");

        String regex = "^pQ*";
        String input1 = "p";
        String input2 = "pQQ";
        String input3 = "pR";
        String input4 = "Q";

        System.out.println(Pattern.matches(regex,input1));
        System.out.println(Pattern.matches(regex,input2));
        System.out.println(Pattern.matches(regex,input3));
        System.out.println(Pattern.matches(regex,input4));

        //7. Use regex to replace <text to replace> from the string: "window["input"]" = function("a<3${<text to replace}");"

        System.out.println("------------------------");
        System.out.println("String regex 2");
        System.out.println("------------------------");

        String input = "\"window[\"input\"]\" = function(\"a<3${<text to replace}\");";
        String regex2 = "text to replace";

        String replaced = input.replaceAll(regex2,"test text");

        System.out.println("Original string: "+ input);
        System.out.println("Replaced string: "+ replaced);

    }

}

