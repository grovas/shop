package com.sda.shop;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean continueProgram = true;
        int option = -1;
        String fileIO = "//home/arczi/order.txt";
        Scanner in = new Scanner(System.in);
        LOGGER.addHandler(new FileHandler("OrderLOG.xml"));

        Position p1 = new Position(
                "Chleb",
                14,
                3.5,0.0);
        Position p2 = new Position(
                "Cukier",
                8,
                4, 0.0);
        Position p3 = new Position(
                "Wino",
                24,
                23.0,
                0.0);
        Order order = new Order(20);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        order.addPositionToOrder(p1);
        order.addPositionToOrder(p2);
        order.addPositionToOrder(p3);

        System.out.println(order);

        while (continueProgram) {

            GUI.guiMainMenu();
            boolean correct = true;
            while (correct) {
                try {
                    option = in.nextInt();
                    correct = false;
                }
                catch (InputMismatchException ex) {
                    System.out.println("Nie poprawny wybór");
                    LOGGER.log(Level.SEVERE, "Wyjątek powstał");
                    in.next();
                }

            }


            switch (option) {
                case 1:
                    order.orderPositionRemove(0);
                    System.out.println(order);
                    break;
                case 2:
                    GUI.guiEditMenu();
                    // edytuj pozycje
                    //order.orderPositionEdit(order.positionList.get(1));
                    System.out.println(order);
                    break;
                case 3:
                    try {
                        order.orderSave(order, fileIO);
                    } catch (IOException e) {
                        System.out.println("Nie ma takiego pliku!");
                    }
                    break;
                case 4:
                    Order o2 = new Order();
                    try {
                        o2.orderRead(fileIO);
                    } catch (IOException e) {
                        System.out.println("Nie ma takiego pliku!");
                    } catch (ClassNotFoundException e) {
                        System.out.println("Nie znaleziono klasy");
                    }
                    System.out.println("Order after read file: ");
                    //Order o2 = order;
                    System.out.println(o2);
                    break;
                default:
                    continueProgram = false;
            }
        }// end_while
    }

}
