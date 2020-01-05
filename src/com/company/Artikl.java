package com.company;

public class Artikl {
    private String naziv;
    private double cijena;
    private String kod;
    public Artikl(String naziv, int cijena, String kod) {
        this.naziv = naziv;
        this.cijena = cijena;
        this.kod = kod;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getCijena(){
        return cijena;
    }

    public String getKod(){
        return kod;
    }
}
