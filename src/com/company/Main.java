package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Artikl> artikliSupermarket = new ArrayList<>();
        List<Artikl> artikliKorpa = new ArrayList<>();

        artikliSupermarket.add(new Artikl("Biciklo", 1000, "1"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "2"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "3"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "4"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "5"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "6"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "7"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "8"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "9"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "10"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "11"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "12"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "13"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "14"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "15"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "16"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "17"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "18"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "19"));
        artikliSupermarket.add(new Artikl("Biciklo", 1000, "20"));

        Scanner scanner = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerString1 = new Scanner(System.in);
        int odabirKupca1;
        int odabirKupca2;
        String kodIzbaci;
        Scanner unosNovca = new Scanner(System.in);
        List<String> kodKupca = new ArrayList<>();

        System.out.println("Izaberite opciju: 0 - odustani, 1 - dodaj u korpu, 2 - izbaci iz korpe, 3 - checkout");
        odabirKupca1 = scanner.nextInt();
        odabirKupca2 = 1;
        if(odabirKupca1 == 1) {
                while(odabirKupca2 == odabirKupca1) {
                    System.out.println("Koji proizvod birate (kod kao jedinstvena oznaka proizvoda): ");
                    String kodUnos = scannerString.nextLine();
                    kodKupca.add(kodUnos);
                    System.out.println("Ako zelite da nastavite kupovinu, unesite 1: ");
                    odabirKupca2=scanner.nextInt();
                }
            for(Artikl artikl : artikliSupermarket) {
                for(String kod : kodKupca) {
                    if (kod.equals(artikl.getKod()) && !artikliKorpa.contains(artikl)) {
                        artikliKorpa.add(artikl);
                    }} }

            for(int i=0; i<artikliSupermarket.size(); i++) {
                for(int j=0; j<artikliKorpa.size(); j++)
                if(artikliSupermarket.get(i).getKod().equals(artikliKorpa.get(j).getKod())) {
                   artikliSupermarket.remove(artikliSupermarket.get(i));
                } } }

        System.out.println("Izaberite opciju: 0 - odustani, 2 - izbaci iz korpe, 3 - checkout");
        odabirKupca1 = scanner.nextInt();

        if (odabirKupca1 == 2) {
            Artikl izbaceniArtikl;
            int odabirKupca3 = 2;
            while(odabirKupca3 == odabirKupca1) {
            System.out.println("Koji proizvod zelite da izbacite: ");
            kodIzbaci = scannerString1.nextLine();
                for(int j=0; j<artikliKorpa.size(); j++) {
                    if(artikliKorpa.get(j).getKod().equals(kodIzbaci)) {
                        izbaceniArtikl = artikliKorpa.get(j);
                        artikliKorpa.remove(artikliKorpa.get(j));
                        artikliSupermarket.add(izbaceniArtikl);
                    } }
                System.out.println("Ako zelite da nastavite izbacivanje proizvoda, unesite 2: ");
                odabirKupca3=scanner.nextInt();}
            System.out.println("Izaberite opciju: 0 - odustani, 3 - checkout");
            odabirKupca1 = scanner.nextInt();}

       if(odabirKupca1 == 3) {
           System.out.println("Idite na checkout.");
           double racun = 0;
           double novacKupca;
           for (int i=0; i<artikliKorpa.size(); i++) {
               racun += artikliKorpa.get(i).getCijena();
           }
           System.out.println("Vas racun iznosi: " +racun +" KM");
           if(racun == 0) System.out.println("Hvala Vam na posjeti.");
           System.out.println("Unesite novac");
           novacKupca = unosNovca.nextDouble();
           while(novacKupca < racun) {
               System.out.println("Nedovoljno novca! \nVas racun iznosi: " +racun +" KM");
               novacKupca = unosNovca.nextDouble();
           }
           if(novacKupca > racun) {
               System.out.println("Vas kusur iznosi: " +(novacKupca - racun) +" KM");
           }
           else {
               System.out.println("Hvala Vam na kupovini. Ugodan dan.");
           }
       }
       else if(odabirKupca1 == 0) {
           System.out.println("Odustali ste od kupovine");
           Artikl izbaceniArtikl;
           for(int j=0; j<artikliKorpa.size(); j++) {
                   izbaceniArtikl = artikliKorpa.get(j);
                   artikliSupermarket.add(izbaceniArtikl);
               }
           artikliKorpa.clear();
       }

        System.out.println("\nArtikli u korpi: ");
        for(Artikl artikl : artikliKorpa) {
            System.out.println("Naziv: " +artikl.getNaziv() + "  Cijena: " +artikl.getCijena() + "  Kod: " +artikl.getKod());
        }
        System.out.println("\nArtikli u supermarketu: ");

        for(Artikl artikl : artikliSupermarket) {
            System.out.println("Naziv: " +artikl.getNaziv() + "  Cijena: " +artikl.getCijena() + "  Kod:" +artikl.getKod());
        }}}





