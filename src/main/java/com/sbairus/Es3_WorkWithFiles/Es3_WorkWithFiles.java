package com.sbairus.Es3_WorkWithFiles;

import java.nio.file.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Fabio.Anelli
 */
public class Es3_WorkWithFiles {

    public static void main(String[] args) {
        String filePath = "", risp = "", cogn = "";
        Scanner scan = new Scanner(System.in);
        //System.out.print("Inserisci il nome del file da leggere comprensivo del Path: ");
        //filePath = scan.next();
        System.out.print("Vuoi leggere(L) o scrivere(S) un file?: ");
        risp = scan.next().toUpperCase();

        switch (risp) {
            case "L":
                System.out.print("Inserisci il nome del file da leggere comprensivo di Path: ");
                filePath = scan.next();
                String fileCont[] = ReadFile(filePath);
                for (String rec : fileCont) {
                    System.out.println(rec);
                }
                break;
            case "S":
                System.out.print("Inserisci il nome del file da scrivere comprensivo di Path: ");
                filePath = scan.next();
                WriteFile(filePath);
                break;
            default:
                System.out.print("Digitare L(leggere) o S(scrivere)");
                break;
        }

        scan.close();
    }

    private static String[] ReadFile(String filename) {
        int i = 0;
        String contfile[] = {};
        try {
            List<String> lines = Files.readAllLines(Paths.get(filename)); //Arraylist
            contfile = new String[lines.size()]; //Assegnazione dinamica della dimensione dell'array
            for (String lin : lines) {
                contfile[i++] = lin;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contfile;
    }

    private static void WriteFile(String filename) {
        String cogn;
        boolean ko = false;
        Scanner scan_c = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            do {
                System.out.print("Inserisci un Cognome nel file ('stop' per uscire): ");
                cogn = scan_c.next();
                if (cogn.equals("stop")) {
                    ko = true;
                } else {
                    writer.write(cogn);
                    writer.newLine();
                }

            } while (ko == false);

            //writer.write = 
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
