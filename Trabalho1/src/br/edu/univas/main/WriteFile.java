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

    public static void createFile(String nameLocal,String local) {
        if (nameLocal != null) {
            try {
                Scanner leitura = new Scanner(System.in);
                FileWriter fileWriter = new FileWriter(local+nameLocal);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                String name;
                System.out.println("Write [exit] to stop application");
                do {
                    name = leitura.next();
                    if(name.equals("exit")){
                    	
                        System.out.println("the application stopped");
                    }else {
                        printWriter.println(name);
                    }
                }while(!name.contains("exit"));
                printWriter.close();
            } catch (IOException e) {
                System.out.println("this file could not be write");
            }

        }
    }

    public static String newLocal(String newLocal){
        int local = newLocal.lastIndexOf("\\");
        return newLocal.substring(0, local+1);
    }
}