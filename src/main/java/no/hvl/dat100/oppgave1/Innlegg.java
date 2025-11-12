package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {

    protected int id;
    protected String bruker;
    protected String dato;
    protected int likes;

    public Innlegg() {

    }

    public Innlegg(int id, String bruker, String dato) {
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        likes = 0;
    }

    public Innlegg(int id, String bruker, String dato, int likes) {
        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;
    }

    public String getBruker() {
        return bruker;
    }

    public void setBruker(String bruker) {
        this.bruker = bruker;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void doLike() {
        likes++;
    }

    public int getLikes() {
        return likes;
    }

    public boolean erLik(Innlegg innlegg) {
        return id == innlegg.id;
    }

    @Override
    public String toString() {
        String return_string = "%s\n%s\n%s\n%s\n";
        return String.format(return_string, id, bruker, dato, likes);
    }

    // Metoden nedenfor er kun for valgfri oppgave 6
    public String toHTML() {

        throw new UnsupportedOperationException(TODO.method());

    }
}
