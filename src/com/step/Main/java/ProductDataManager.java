package com.step.Main.java;

import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.text.CollationElementIterator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductDataManager {

private ArrayList<Product> product = new ArrayList<>();

public void addProd(){


    String nume;
    float pret_de_cumparare;
    float pret_de_vanzare;
     int day;
     int month;
     int year;
    String descriere;
    int stoc;
    int id;

    Scanner sc = new Scanner(System.in);


    System.out.println("Introduceti id: ");
    id=sc.nextInt();

    for(int i=0;i<product.size();i++)
    {
        if(product.get(i).id==id){
            System.out.println("Acest id exista!");
            System.out.println("1. Pentru a aduga in stoc");
            System.out.println("2. Pentru a rescrie id-ul");
            switch (sc.next().charAt(0)){
                case 49 : {
                    System.out.println("Introduceti nr de produse noi: ");
                    product.get(i).stoc+=sc.nextInt();
                }break;
                case 50 : {
                    System.out.println("Introduceti un id nou: ");
                    id=sc.nextInt();
                }break;
            }

        }
    }

    System.out.println("Introduceti numele produsului: ");
    nume = sc.next();
    System.out.println("Introduceti pretul de cumparare al produsului:");
     pret_de_cumparare=sc.nextFloat();
    System.out.println("Introduceti pretul de vanzare al produsului:");
    pret_de_vanzare =sc.nextFloat();
    System.out.println("Introduceti ziua expirarii: ");
    day=sc.nextInt();
    System.out.println("Introduceti luna expirarii: ");
    month=sc.nextInt();
    System.out.println("Introduceti anul expirarii: ");
    year=sc.nextInt();
    System.out.println("Introduceti descrierea produsului: ");
    descriere=sc.next();
    System.out.println("Introduceti stocul: ");
    stoc=sc.nextInt();


    product.add(new Product(nume,pret_de_cumparare,pret_de_vanzare, LocalDate.of(year,month,day),descriere,stoc,id));


}
public void show(){
    for(int i=0;i<product.size();i++){


        System.out.println("*********************************************");
        System.out.println("Nume:["+(i+1)+"] = "+product.get(i).nume);
        System.out.println("Pret de cumparare:["+(i+1)+"] = "+product.get(i).pret_de_cumparare);
        System.out.println("Pret de vanzre:["+(i+1)+"] = "+product.get(i).pret_de_vanzare);
        System.out.println("Data expirarii["+(i+1)+"] = "+product.get(i).data_de_expirare);
        System.out.println("Descriere:["+(i+1)+"] = "+product.get(i).descriere);
        System.out.println("Stoc:["+(i+1)+"] = "+product.get(i).descriere);
        System.out.println("*********************************************");
    }


}

public void cauta(){
    System.out.println("1. Cauta dupa id");
    System.out.println("2. Cauta dupa nume");
    System.out.println("3. Cauta dupa data de expiare");

    Scanner sc = new Scanner(System.in);

    switch (sc.next().charAt(0)){
        case 49 : {cautaID();}break;
        case 50 : {cautaNume();}break;
        case 51: {cautaData();}break;

    }

}

public void cautaNume(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Introdu numele");
    for(int i = 0; i<product.size();i++)
    if(sc.next()==product.get(i).nume)
    {
        showOne(i);
    }

}



    public void cautaID(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdu ID-ul");
        for(int i = 0; i<product.size();i++) {
            if (sc.nextInt() == product.get(i).id) {
                showOne(i);
            }
        }
    }

    public void cautaData(){
        Scanner sc = new Scanner(System.in);
        int day;
        int month;
        int year;

        System.out.println("Introduceti ziua expirarii: ");
        day=sc.nextInt();
        System.out.println("Introduceti luna expirarii: ");
        month=sc.nextInt();
        System.out.println("Introduceti anul expirarii: ");
        year=sc.nextInt();
        for(int i = 0; i<product.size();i++)
            if(LocalDate.of(year,month,day)==product.get(i).data_de_expirare)
            {
                showOne(i);
            }

    }

    public void showOne(int i){

        System.out.println("*********************************************");
        System.out.println("Nume:["+(i+1)+"] = "+product.get(i).nume);
        System.out.println("Pret de cumparare:["+(i+1)+"] = "+product.get(i).pret_de_cumparare);
        System.out.println("Pret de vanzre:["+(i+1)+"] = "+product.get(i).pret_de_vanzare);
        System.out.println("Data expirarii["+(i+1)+"] = "+product.get(i).data_de_expirare);
        System.out.println("Descriere:["+(i+1)+"] = "+product.get(i).descriere);
        System.out.println("Stoc:["+(i+1)+"] = "+product.get(i).descriere);
        System.out.println("*********************************************");
    }

    public void vinde(){
    Scanner sc = new Scanner(System.in);
    int id,cantitate;
    boolean check=false;
    System.out.println("Introdu ID-ul:");
    id=sc.nextInt();
    System.out.println("Introdu cantitatea:");
    cantitate=sc.nextInt();

        for(int i = 0; i<product.size();i++) {
            if (sc.nextInt() == product.get(i).id) {
                product.get(i).stoc-=cantitate;
                product.get(i).produse_vandute+=cantitate;
                System.out.println("S-au vandut"+cantitate+" produse cu id-ul "+id);
           check=true;
            }
        }

        if(check==false){
            System.out.println("ERROR 404");
        }

    }

//4. Profit: calcularea veniturilor și afișarea profitului.
//5. Profit pe produs: calcularea profitului pentru fiecare produs individual (profit per produs = cantitatea x (pret de vanzare - pret de cumparare)).
    public void statistici(){
        System.out.println("1.Calcularea veniturilor și afișarea profitului");
        System.out.println("2.Calcularea profitului pentru fiecare produs individual");

        Scanner sc = new Scanner(System.in);
        switch (sc.next().charAt(0)){
            case 49 : {}break;
            case 50 : {venitInd();}break;
        }


    }


    public void venit(){
        float venit=0;

        for(int i = 0;i<product.size();i++){



            venit -=product.get(i).pret_de_cumparare*(product.get(i).stoc+product.get(i).produse_vandute);
            venit +=product.get(i).pret_de_vanzare*(product.get(i).stoc+product.get(i).produse_vandute);
            System.out.println("Venitul companiei["+(i+1)+"]:"+venit);

        }
    }




    public void venitInd(){
    float venit=0;

    for(int i = 0;i<product.size();i++){
venit = 0;
            showOne(i);

             venit -=product.get(i).pret_de_cumparare*(product.get(i).stoc+product.get(i).produse_vandute);
             venit +=product.get(i).pret_de_vanzare*(product.get(i).stoc+product.get(i).produse_vandute);
    System.out.println("Venitul produsului["+(i+1)+"]:"+venit);

    }
    }


//    1. După nume - în ordine alfabetică
//2. După data de expirare - în ordine inversă (produsele cu cea mai apropiata dată de expirare merg primele)
//3. După preț în ordine crescătoare.
//4. După preț în ordine descrescătoare.


    public void sortare(){
        System.out.println("1.După nume - în ordine alfabetică");
        System.out.println("2. După data de expirare - în ordine inversă");
        System.out.println("3. După preț în ordine crescătoare");
        System.out.println("4. După preț în ordine descrescătoare");


        Scanner sc = new Scanner(System.in);
        switch (sc.next().charAt(0)){
            case 49 : {

               
            }break;
            case 50 : {}break;
            case 51 : {}break;
            case 52 : {}break;

        }



    }


}