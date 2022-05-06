package br.edu.univas.main;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StartApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int countLines = ReadFile.countLines(ReadFile.CSV_FILE);
        String forNewLocal = WriteFile.newLocal(ReadFile.CSV_FILE);
        String data = Data.data.format(LocalDateTime.now());
        String menu = ReadFile.printSubjects();
        System.out.println(menu);
        int choice = scanInt();
        String subject = ReadFile.selectSubjects(choice, countLines);
        String normalize = ReadFile.Normalize(subject);
        WriteFile.createFile(WriteFile.fileName(normalize, data), forNewLocal);
    }

    public static int scanInt(){
        int scan = scanner.nextInt();
        scanner.nextLine();
        return scan;
    }
}
