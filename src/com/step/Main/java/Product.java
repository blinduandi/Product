package com.step.Main.java;

import java.time.LocalDate;

public class Product {

    int id;
    String nume;
    float pret_de_cumparare;
    float pret_de_vanzare;
    LocalDate data_de_expirare;
    String descriere;
    int stoc;
    int produse_vandute;

    Product(String nume ,float pret_de_cumparare, float pret_de_vanzare , LocalDate data_de_expirare , String descriere ,int stoc , int id){
        this.nume=nume;
        this.pret_de_cumparare=pret_de_cumparare;
        this.pret_de_vanzare=pret_de_vanzare;
        this.data_de_expirare=data_de_expirare;
        this.descriere=descriere;
        this.stoc=stoc;
        this.id=id;
    }

}
