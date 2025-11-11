package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {

        Blogg blogg = null;

        try{
            String filsti = mappe + "/"+ filnavn;
            File fil = new File(filsti);
            Scanner scanner = new Scanner(fil);

            int antall = Integer.parseInt(scanner.nextLine());

            blogg= new Blogg(antall);
            while(scanner.hasNextLine()){
                String type = scanner.nextLine();

                int id = Integer.parseInt(scanner.nextLine());
                String bruker = scanner.nextLine();
                String dato = scanner.nextLine();
                int likes = Integer.parseInt(scanner.nextLine());

                Innlegg innlegg = null;

                if (type.equals(TEKST)) {
                    String tekst = scanner.nextLine();
                    innlegg = new Tekst(id, bruker, dato, likes, tekst);
                } else if (type.equals(BILDE)) {
                    String tekst = scanner.nextLine();
                    String url = scanner.nextLine();
                    innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                }
                if (innlegg != null) {
                    blogg.leggTil(innlegg);
                }

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Feil ved lesing av fil: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Generell feil ved lesing: " + e.getMessage());
        }

        return blogg;

    }
}
