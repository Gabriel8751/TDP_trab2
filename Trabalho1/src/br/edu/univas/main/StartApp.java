package br.edu.univas.main;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StartApp {
	
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    	startApp();
    }
    
    public static int readInt() {
    	int choice = scanner.nextInt();
    	scanner.nextLine();
    	return choice;
    }
    
    public static void startApp() {
    	int choice = 0;
    	do {
        int countLines = ReadFile.countLines(ReadFile.CSV_FILE);
        String forNewLocal = WriteFile.newLocal(ReadFile.CSV_FILE);
        String data = Data.data.format(LocalDateTime.now());
        String menu = ReadFile.printSubjects();
        System.out.println(menu);
        choice = readInt();
        String subject = ReadFile.selectSubjects(choice, countLines);
        String normalize = ReadFile.normalizeString(subject);
        WriteFile.createFile(WriteFile.fileName(normalize, data), forNewLocal);
    	}while(choice != 9);
    }
}