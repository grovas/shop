package com.sda.shop;

public class GUI {

    public static void guiMainMenu(){

        System.out.println("\nWitaj w systemie zamówień!\n" +
                "1. Usuń pozycję z zamówienia\n" +
                "2. Edytuj pozycję w zamówieniu\n" +
                "3. Zapisz zamówienie do pliku\n" +
                "4. Wczytaj zamówienie z pliku\n" +
                "0. Wyjscie z systemu."
        );
    }

    public static void guiEditMenu(){
        System.out.println("\nPodaj numer pozycji do edycji!\n" +
                "1. Usuń pozycję z zamówienia\n" +
                "2. Edytuj pozycję w zamówieniu\n" +
                "3. Zapisz zamówienie do pliku\n" +
                "4. Wczytaj zamówienie z pliku\n" +
                "0. Wyjscie z systemu."
        );
    }
}