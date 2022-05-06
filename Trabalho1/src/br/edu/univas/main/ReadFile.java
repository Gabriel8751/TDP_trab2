package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;

public class ReadFile {

    static String CSV_FILE = System.getenv("CSV_FILE");

    public static String printSubjects(){
        int count = 1;
        String printMenu = ":::ATTENDENCE:::\n";
        try {
            FileReader fileReader = new FileReader(CSV_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line  = bufferedReader.readLine())!= null){
                if(!line.startsWith(";")) {
                    printMenu += count + " - " + line + "\n";
                    count++;
                }
            }
            bufferedReader.close();
            if(count < 9) {
                printMenu += "9 - Cancel";
            }
            return printMenu;
        } catch (FileNotFoundException e){
            System.out.println("File don't exist");
        } catch (IOException e) {
            System.out.println("this file could not be read");
        }
        return null;
    }

    public static int countLines(String CSV_FILE) {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(CSV_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                if(!line.startsWith(";")) {
                    count++;
                }            }
            bufferedReader.close();
            return count;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String selectSubjects(int select, int numberLines){
        String subjectsSelected = "";
        try {
            FileReader fileReader = new FileReader(CSV_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            if(select > 0 && select <= numberLines) {
                for (int i = 1; i <= select; i++) {
                    if(i == select) {
                        subjectsSelected += line;
                    }
                    line = bufferedReader.readLine();
                }
            } else if (select == 9) {
                System.out.println("You cancel this action");
            }else{
                System.out.println("This option not valid");
            }
            bufferedReader.close();
            return subjectsSelected;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String normalizeString(String subject) {
        if (subject != null){
            subject = Normalizer.normalize(subject, Normalizer.Form.NFD);
            subject = subject.replaceAll("[^\\p{ASCII}]", "");
        }
        return subject.replace(" ", "_").toLowerCase();
    }
}
