package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherMain {

    public static void main(String[] args) {


        Scanner entry = new Scanner(System.in);

        String line;

        System.out.println("Daj tekst: ");

        line = entry.nextLine();


        String patternText = "([A-Z][a-z]*) +([A-Z][a-z]*)";

        Pattern pattern = Pattern.compile(patternText);
        Matcher matcher = pattern.matcher(line);


        System.out.println(matcher.matches());

        if(matcher.matches()) {
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        } else {
            System.out.println("Nie pasuje - nie moze zrobić matcher.group - bo nie utworzylo zadnej grupy - nic nie dopasowalo.");
        }
    }
}
