package com.step.Main.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\t\t\t\t ***MENU***");
        System.out.println("\t 1.Adauga produse");
        System.out.println("\t 2.Cauta produse");
        System.out.println("\t 3.Afisarea intregului stoc");
        System.out.println("\t 4.Vinde produse");
        System.out.println("\t 5.Statistici");
        System.out.println("\t 6.Sortare");

        Scanner sc = new Scanner(System.in);
        ProductDataManager pr = new ProductDataManager();
while (true){
            switch (sc.next().charAt(0)) {

                case 49: {
                    pr.addProd();
                }
                break;
                case 50: {
                    pr.cauta();
                }
                break;
                case 51: {
                    pr.show();
                }
                break;
                case 52: {
                    pr.vinde();
                }
                break;
                case 53: {
                    pr.statistici();
                }
                break;
                case 54: {
                }
                break;

            }

        }
    }
}
