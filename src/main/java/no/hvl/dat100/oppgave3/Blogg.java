package no.hvl.dat100.oppgave3;

import java.util.ArrayList;

import no.hvl.dat100.oppgave1.Innlegg;

public class Blogg {

    private Innlegg[] innleggtabell;
    private int nesteledig;

    public Blogg() {
        innleggtabell = new Innlegg[20];
        nesteledig = 0;
    }

    public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
        nesteledig = 0;
    }

    public int getAntall() {
        int total = 0;
        for (Innlegg i : innleggtabell) {
            if (i != null) {
                total++;
            }
        }
        return total;
    }

    public Innlegg[] getSamling() {
        return innleggtabell;

    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < innleggtabell.length; i++) {
            if (innleggtabell[i].erLik(innlegg)) {
                return i;
            }
        }

        return -1;
    }

    public boolean finnes(Innlegg innlegg) {
        for (Innlegg i : innleggtabell) {
            if (i.erLik(innlegg)) {
                return true;
            }
        }

        return false;
    }

    public boolean ledigPlass() {
        return nesteledig < innleggtabell.length;
    }

    public boolean leggTil(Innlegg innlegg) {
        if (!ledigPlass()) {
            return false;
        }
        if (finnes(innlegg)) {
            return false;
        }

        innleggtabell[nesteledig++] = innlegg;
        return true;
    }

    @Override
    public String toString() {
        String return_string = "Antall innlegg: " + innleggtabell.length + "\n";
        for (Innlegg i : innleggtabell) {
            return_string += i.toString();
        }
        return return_string;
    }

    // valgfrie oppgaver nedenfor
    public void utvid() {
        Innlegg[] temp_tabell = new Innlegg[innleggtabell.length * 2];
        nesteledig = 0;
        for (Innlegg i : innleggtabell) {
            if (i != null) {
                temp_tabell[nesteledig++] = i;
            }
        }
        innleggtabell = temp_tabell;
    }

    public boolean leggTilUtvid(Innlegg innlegg) {
        if (!ledigPlass()) {
            utvid();
        }
        if (finnes(innlegg)) {
            return false;
        }

        innleggtabell[nesteledig++] = innlegg;
        return true;

    }

    public boolean slett(Innlegg innlegg) {

        if (nesteledig < 1) {
            return false;
        }

        int plass = finnInnlegg(innlegg);
        innleggtabell[plass] = innleggtabell[nesteledig - 1];
        innleggtabell[nesteledig - 1] = null;
        nesteledig--;
        return true;
    }

    public int[] search(String keyword) {
        ArrayList<Integer> treff_id = new ArrayList<>();
        for (Innlegg i : innleggtabell) {
            if (i == null) {
                continue;
            }
            if (i.toString().contains(keyword)) {
                treff_id.add(i.getId());
            }
        }
        int[] return_tabell = new int[treff_id.size()];
        int index = 0;
        for (int id : treff_id) {
            return_tabell[index++] = id;
        }
        return return_tabell;
    }
}
