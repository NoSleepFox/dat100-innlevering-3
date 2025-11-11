package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        try{
            String filsti = mappe +"/"+filnavn;

            PrintWriter printWriter = new PrintWriter(filsti);

            printWriter.print(samling.toString());

            printWriter.close();

            return true;
        }
        catch (FileNotFoundException e){
            System.out.println("Feil ved skriving til fil" + e.getMessage());
            return false;
        }

    }
}

