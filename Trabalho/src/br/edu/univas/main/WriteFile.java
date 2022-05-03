package br.edu.univas.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class WriteFile {


    public static String fileName(String nome, String data) {
        if (!nome.isEmpty()) {
            return nome + "_" + data + ".txt";
        }
        return null;
    }

    public static void createFile(String nameLocal) {
        if (nameLocal != null) {
            try {
                Scanner leitura = new Scanner(System.in);
                FileWriter fileWriter = new FileWriter("C:\\Users\\gs753\\IntelliJ\\Trabalho\\"+nameLocal);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String name = "start";
                System.out.println("Write [exit] to stop application");
                do {
                    name = leitura.nextLine();
                    printWriter.print(name+"\n");
                }while(!name.contains("exit"));
                printWriter.close();
                leitura.close();
            } catch (IOException e) {
                System.out.println("this file could not be write");;
            }

        }
    }
}

